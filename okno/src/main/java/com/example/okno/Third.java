package com.example.okno;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Third {
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
    private Button btnaudaru;

    @FXML
    private Button btnback;

    @FXML
    private TextField tnom;

    @FXML
    private TextField tsum;

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
        btnaudaru.setOnAction(actionEvent -> {
            btnaudaru.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("okoshko2.fxml"));
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
    }

}
