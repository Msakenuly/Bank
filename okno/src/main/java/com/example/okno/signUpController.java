package com.example.okno;


import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signUpController {



    @FXML
    public Button authBt;

    @FXML
    public CheckBox erchbx;

    @FXML
    public TextField signUpLogtf;

    @FXML
    public PasswordField signUpLpasswordtf;

    @FXML
    public TextField signUpfullname;

    @FXML
    public TextField signUpname;


    @FXML
    void initialize() {
        authBt.setOnAction(actionEvent -> {
         signUpNewUser();
     authBt.getScene().getWindow().hide();
     FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("okoshko.fxml"));
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
    private void signUpNewUser(){
        String firstname=signUpname.getText();
        String fullname=signUpfullname.getText();
        String username=signUpLogtf.getText();
        String password=signUpLpasswordtf.getText();
        String gender;
        if(erchbx.isSelected()){
            gender="ер";
        }else gender="әйел";
        User user=new User(firstname,fullname,username,password,gender);
          DatabaseHandler dbHandler = new DatabaseHandler();
            try {
                dbHandler.signUpUser(user);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

    }

}
