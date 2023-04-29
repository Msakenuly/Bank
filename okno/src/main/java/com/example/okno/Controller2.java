package com.example.okno;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class Controller2 {
    int ailyq;
    double summa, srok, perv, percent, vych;
    Image image;

    {
        try {
            image = new Image(new FileInputStream("src/786399.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    ImageView img = new ImageView(image);

    @FXML
    private Label labelkrsumma;
    @FXML
    private Label labelplatezh;

    @FXML
    private RadioButton jra;

    @FXML
    private RadioButton jrd;
    @FXML
    private Button download;
    @FXML
    private TextField labelbaga;

    @FXML
    private TextField labeljarna;

    @FXML
    private TextField labelmerzim;

    @FXML
    private Slider sliderbaga;
    @FXML
    private Button btnback;
    @FXML
    private Slider sliderjarna;

    @FXML
    private Slider slidermerzim;
    @FXML
    private Label labelson;
    double s;
    double[] op, Op, pp, a, os, Pl;
    String msg;
    FileReader Sa;
    Object[][] mo = new Object[60][5];
    int ko;
    double scale = Math.pow(10, 2);
    @FXML
    ArrayList<String> n;
    FileChooser fileChooser = new FileChooser();

    @FXML
    private TextField textfield;

    @FXML
    private Button button;


    @FXML
    void initialize() {

        img.setFitHeight(20);
        img.setFitWidth(20);
        btnback.setGraphic(img);
        btnback.setOnAction(actionEvent -> {
            btnback.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("glavnoe.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        download.setVisible(false);
        percent = 7;
        String style = "-fx-background-color: WHITE;";
        sliderbaga.valueProperty().addListener((observableValue, number, t1) -> {
            summa = t1.doubleValue();
            labelbaga.setText(t1.intValue() + " KZT");
            StackPane trackPane = (StackPane) sliderbaga.lookup(".track");
            trackPane.setStyle(style);
        });
        sliderjarna.valueProperty().addListener((observableValue, number, t1) -> {
            perv = t1.doubleValue();
            labeljarna.setText(t1.intValue() + " KZT");
            StackPane trackPane = (StackPane) sliderjarna.lookup(".track");
            trackPane.setStyle(style);
        });
        slidermerzim.valueProperty().addListener((observableValue, number, t1) -> {
            srok = t1.intValue();
            labelmerzim.setText(t1.intValue() + " ай");
            StackPane trackPane = (StackPane) slidermerzim.lookup(".track");
            trackPane.setStyle(style);
        });
        jra.setOnAction(actionEvent -> {
            vych = summa - perv;
            s = vych;
            Pl = new double[(int) srok + 1];
            Op = new double[(int) srok + 1];
            a = new double[Pl.length];
            op = new double[Op.length];
            pp = new double[op.length];
            os = new double[op.length];
            for (int i = 1; i <= srok; i++) {
                Pl[i] = (vych * percent / (12 * 100)) / (1 - Math.pow((1 + (percent) / (12 * 100)), -srok));
                a[i] = Pl[i];
                Op[i] = s * percent / (100 * 12);
                pp[i] = Op[i];
                op[i] = (Pl[i] - pp[i]);
                s = s - op[i];
                os[i] = s;
            }
            ko = (int) (Math.ceil(Pl[1] * scale) / scale);
            labelplatezh.setText(ko + " KZT");
            labelkrsumma.setText((int) vych + " KZT");
            mo = new Object[(int) srok + 1][5];
            for (int i = 1; i <= (int) srok; i++) {
                mo[0][0] = "1-Кезең";
                mo[0][1] = "2-Ай сайынғы төлем";
                mo[0][2] = "3-Негізгі қарыз";
                mo[0][3] = "4-Есептелген пайыз";
                mo[0][4] = "5-Негізгі қалған қарыз";
                mo[i][0] = i + " aй";
                mo[i][1] = (int) (Math.ceil(a[i] * scale) / scale);
                mo[i][2] = (int) (Math.ceil(op[i] * scale) / scale);
                mo[i][3] = (int) (Math.ceil(pp[i] * scale) / scale);
                mo[i][4] = (int) (Math.ceil(os[i] * scale) / scale);
            }

            PrintWriter Ha;
            try {
                Ha = new PrintWriter("src/main/java/com/example/okno/ss.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i <= srok; i++) {
                for (int j = 0; j < 5; j++) {
                    Ha.print(mo[i][j] + "\t");
                    System.out.print(mo[i][j] + "  ");
                }
                Ha.println();
                System.out.println();
            }
            Ha.close();
            try {
                Sa = new FileReader("src/main/java/com/example/okno/ss.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Scanner Fa = new Scanner(Sa);
            n = new ArrayList<>();
            while (Fa.hasNext()) {
                n.add(Fa.nextLine() + "\n");
            }
            msg = String.valueOf(n);
            download.setVisible(true);

        });
        jrd.setOnAction(actionEvent -> {
            vych = summa - perv;
            s = vych;
            Pl = new double[(int) srok + 1];
            Op = new double[(int) srok + 1];
            a = new double[Pl.length];
            op = new double[Op.length];
            pp = new double[op.length];
            os = new double[op.length];
            for (int i = 1; i <= srok; i++) {
                Op[i] = (vych / srok);
                Pl[i] = (vych / srok) + (vych - (vych / srok) * i) * (percent / (100 * 12));
                a[i] = Pl[i];
                op[i] = Op[i];
                pp[i] = a[i] - op[i];
                s = s - op[i];
                os[i] = s;
            }
            ko = (int) Pl[1];
            mo = new Object[(int) srok + 1][5];
            for (int i = 1; i <= (int) srok; i++) {
                mo[0][0] = "1-Кезең";
                mo[0][1] = "2-Ай сайынғы төлем";
                mo[0][2] = "3-Негізгі қарыз";
                mo[0][3] = "4-Есептелген пайыз";
                mo[0][4] = "5-Негізгі қалған қарыз";
                mo[i][0] = i + " aй";
                mo[i][1] = (int) (Math.ceil(a[i] * scale) / scale);
                mo[i][2] = (int) (Math.ceil(op[i] * scale) / scale);
                mo[i][3] = (int) (Math.ceil(pp[i] * scale) / scale);
                mo[i][4] = (int) (Math.ceil(os[i] * scale) / scale);
            }

            PrintWriter Ha;
            try {
                Ha = new PrintWriter("src/main/java/com/example/okno/ss.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i <= srok; i++) {
                for (int j = 0; j < 5; j++) {
                    Ha.print(mo[i][j] + "\t");
                }
                Ha.println();

            }
            Ha.close();
            labelplatezh.setText(ko + " KZT");
            labelkrsumma.setText((int) vych + " KZT");
            try {
                Sa = new FileReader("src/main/java/com/example/okno/ss.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Scanner Fa = new Scanner(Sa);
            n = new ArrayList<>();
            while (Fa.hasNext()) {
                n.add(Fa.nextLine() + "\n");
            }
            msg = String.valueOf(n);
            download.setVisible(true);

        });
        download.setOnAction(actionEvent -> {
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extensionFilter);

            File file = fileChooser.showSaveDialog(new Stage());
            if (file != null) {
                save(file, String.valueOf(msg));
            }
        });
        button.setOnAction(actionEvent -> {
              ailyq = Integer.parseInt(textfield.getText());
            if(ailyq>Pl[0]){
                labelson.setText("Otinish qabyldandy!");
            }else labelson.setText("Otinish qabyldanbady!");
        });

    }

    public void save(File file, String cont) {
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.write(cont);
            pw.format("txt");
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
