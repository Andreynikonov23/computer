package ru.sapteh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Computer;
import ru.sapteh.service.ComputerServ;

import java.io.IOException;

public class NewController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Computer, Integer> computerIntegerDAO = new ComputerServ(factory);
    Computer computer = new Computer();

    @FXML
    private TextField textFieldProcessor;

    @FXML
    private TextField textFieldMotherboard;

    @FXML
    private TextField textFieldRAM;

    @FXML
    private TextField textFieldVideoCard;

    @FXML
    private TextField textFieldSSD;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonExit;


    public void OnActionAdd(ActionEvent actionEvent) throws IOException {
        computer.setProcessor(textFieldProcessor.getText());
        computer.setMotherboard(textFieldMotherboard.getText());
        computer.setRam(textFieldRAM.getText());
        computer.setVideoCard(textFieldVideoCard.getText());
        computer.setSsd(textFieldSSD.getText());
        computerIntegerDAO.create(computer);

        if(buttonAdd.isArmed()){
            textFieldProcessor.clear();
            textFieldMotherboard.clear();
            textFieldRAM.clear();
            textFieldVideoCard.clear();
            textFieldSSD.clear();
        }
    }

    public void OnActionExit(ActionEvent actionEvent) throws IOException {
        buttonExit.getScene().getWindow().hide();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/sample.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void initialize() {
    }
}
