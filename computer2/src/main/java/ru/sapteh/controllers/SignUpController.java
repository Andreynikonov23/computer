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
import org.hibernate.cfg.Configuration;
import ru.sapteh.Implements.UsersImpl;
import ru.sapteh.dao.DAO;
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
    private Button buttonRegistration;


    @FXML
    void initialize() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Users, Integer> dao = new UsersImpl(factory);
        users = dao.findByAll();

    }

    public void actionEntrance(ActionEvent actionEvent) throws IOException {
        String login = loginField.getText();
        String password = Fieldpassword.getText();
        for (Users user : users){
            if (login.equalsIgnoreCase(user.getLogin()) && password.equals(user.getPassword())) {
                buttonEntrance.getScene().getWindow().hide();
                initStage();
            } else
                labelDefault.setText("Неверный логин или пароль");
        }
        }


    public void actionRegistration(ActionEvent actionEvent) throws IOException {
        buttonRegistration.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/view/buttons/registration.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void initStage() {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/mainWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Autoservice_Client");
        assert root != null;
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    public void scen (){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/signUp.fxml"));
            Scene scene = new Scene(root);
            scene.getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


