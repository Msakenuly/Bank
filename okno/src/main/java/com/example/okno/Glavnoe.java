package com.example.okno;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Glavnoe {
    @FXML
    private Button btnshygu;
    public Button btnkredit1;
    public Button btnkredit11;
    @FXML
    private Button btnkredit;
    Image image, image1, image2, image3, image4;

    {
        try {
            image = new Image(new FileInputStream("src/atm-machine-unscreen.gif"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    {
        try {
            image1 = new Image(new FileInputStream("src/safe-box-1--unscreen.gif"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    {
        try {
            image2 = new Image(new FileInputStream("src/credit-card-unscreen.gif"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    {
        try {
            image3 = new Image(new FileInputStream("src/tickets.gif"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    {
        try {
            image4 = new Image(new FileInputStream("src/free-animated-icon-online-shopping-7994364.gif"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Button btnmoibank;
    @FXML
    private Button btncard;


    @FXML
    ImageView img, img2, img3, img4, img5;

    @FXML
    void initialize() {
        img = new ImageView(image);
        img.setFitWidth(120);
        img.setFitHeight(120);
        btnkredit.setGraphic(img);
        img2 = new ImageView(image1);
        img2.setFitWidth(120);
        img2.setFitHeight(120);
        img3 = new ImageView(image2);
        img3.setFitWidth(120);
        img3.setFitHeight(120);
        img4 = new ImageView(image3);
        img4.setFitHeight(210);
        img4.setFitWidth(210);
        img5 = new ImageView(image4);
        img5.setFitWidth(210);
        img5.setFitHeight(210);
        btnmoibank.setGraphic(img2);
        btncard.setGraphic(img3);
        btnkredit1.setGraphic(img4);
        btnkredit11.setGraphic(img5);
        btnkredit.setOnAction(actionEvent -> {
            btnkredit.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("second.fxml"));
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
        btnmoibank.setOnAction(actionEvent -> {
            btnmoibank.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("moibank.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        btnshygu.setOnAction(actionEvent -> {
            btnshygu.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("hello-view.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        btncard.setOnAction(actionEvent -> {
            btncard.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("third.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
