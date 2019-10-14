package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.Database.DatabaseHandler;
import sample.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField singUpFirstName;

    @FXML
    private JFXTextField singUpLastName;

    @FXML
    private JFXTextField singUpUsername;

    @FXML
    private JFXPasswordField singUpPassword;

    @FXML
    private JFXCheckBox singUpCheckBoxMale;

    @FXML
    private JFXCheckBox singUpCheckBoxFemale;

    @FXML
    private JFXButton singUpButton;


    @FXML
    void initialize() {


        singUpButton.setOnAction(event ->{
            createUser();

        });
    }
    private void createUser(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        String name = singUpFirstName.getText();
        String lastName = singUpLastName.getText();
        String userName = singUpUsername.getText();
        String password = singUpPassword.getText();


        String gender = "";
        if(singUpCheckBoxFemale.isSelected()){
            gender="Female";
        }
        else {gender ="Male";}
        User user = new User(name, lastName,userName,password,gender);

        databaseHandler.signUpUser(user);


    }
}
