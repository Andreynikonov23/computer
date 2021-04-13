package ru.sapteh.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Implements.UsersImpl;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Users;

import java.io.IOException;

public class RegistrationController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Users users = new Users();
    DAO<Users, Integer> usersIntegerDAO = new UsersImpl(factory);

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button buttonRegistration;

    @FXML
    private Button buttonExit;

    @FXML
    void actionExit(ActionEvent event) {
        buttonExit.getScene().getWindow().hide();
        Return();
    }

    @FXML
    void onActionRegistration(ActionEvent event) {
        users.setLogin(textFieldLogin.getText());
        users.setPassword(passwordField.getText());
        usersIntegerDAO.create(users);
        buttonRegistration.getScene().getWindow().hide();
        Return();
    }
    public void Return(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/signUp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    }
