package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;
import sample.User;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton loginSignupButton;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXTextField loginUsername;

    private DatabaseHandler databaseHandler;


    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    void initialize() {
            databaseHandler = new DatabaseHandler();


                loginButton.setOnAction(event -> {
                    String loginText = loginUsername.getText().trim(); //trim bez mezer
                    String loginPwd = loginPassword.getText().trim();
                    User user = new User();
                    user.setUserName(loginText);
                    user.setPassword(loginPwd);

                    ResultSet userRow = databaseHandler.getUser(user);
                    int counter =0;

                        try {
                            while (userRow.next()){
                            counter++;
                            String name = userRow.getString("firstname");
                                System.out.println(name);

                            }
                            if (counter==1) {
                                System.out.println("Login is done");
                            }
                            }catch (SQLException e) {
                            e.printStackTrace();
                        }




                    });

            loginSignupButton.setOnAction(event -> {
                loginSignupButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/view/signup.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();


            } );



    }


}
