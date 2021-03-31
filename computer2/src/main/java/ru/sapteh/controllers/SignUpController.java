package ru.sapteh.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import ru.sapteh.models.Users;

import java.io.IOException;
import java.util.List;

public class SignUpController {
    private List<Users> users;

    @FXML
    private TextField loginField;
    @FXML
    private Label labelDefault;
    @FXML
    private PasswordField Fieldpassword;
    @FXML
    private Button buttonEntrance;


    @FXML
    void initialize() {

    }

    public void actionEntrance(ActionEvent actionEvent) throws IOException {
        String login = loginField.getText();
        String password = Fieldpassword.getText();

        for(Users users : users){
            if(login.equalsIgnoreCase(users.getLogin() && password.equals(users.getPassword())){
                buttonEntrance.getScene().getWindow().hide();
            }
        }
    }

    public void actionRegistration(ActionEvent actionEvent) {
    }
}


