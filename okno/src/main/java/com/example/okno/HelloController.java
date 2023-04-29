package com.example.okno;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.okno.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private TextField Logtf;
    @FXML
    private Button authBt;
    @FXML
    private PasswordField passwordtf;
    @FXML
    private Button signBt;
    @FXML
    private Label labelqate;
    @FXML
    void initialize() {
        signBt.setOnAction(actionEvent -> {
            String loginText = Logtf.getText().trim();
            String loginPassword = passwordtf.getText().trim();
            if (!Logtf.equals("") && !passwordtf.equals("")) {
                loginUser(loginText, loginPassword);
            } else System.out.println("Error!");
        });
        authBt.setOnAction(actionEvent -> {
            authBt.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("signUp.fxml"));
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

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        dbHandler.getUser(user);
        ResultSet result = dbHandler.getUser(user);
        int count = 0;
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
        if (count >= 1) {
            System.out.println("Succes!");
            signBt.getScene().getWindow().hide();
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
            stage.showAndWait();
        } else {
            Shake userlogAnim = new Shake(Logtf);
            Shake userPassAnim = new Shake(passwordtf);
            userlogAnim.playA();
            userPassAnim.playA();
            labelqate.setText("Логин немесе пароль қате!");
        }
    }

}
