package ru.sapteh.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Implements.ComputerImpl;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Computer;

public class CreateController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Computer, Integer> dao = new ComputerImpl(factory);
    Computer computer = new Computer();
    ObservableList<Computer> observableList = FXCollections.observableArrayList();

    public void setData (ObservableList observableList){
        this.observableList = observableList;
    }

    @FXML
    private TextField textFieldProcessor;

    @FXML
    private TextField textFieldVideoCard;

    @FXML
    private TextField textFieldRAM;

    @FXML
    private TextField textFieldMotherboard;

    @FXML
    private TextField textFieldCooler;

    @FXML
    private TextField textFieldSSD_M2;

    @FXML
    private TextField textFieldSSD;

    @FXML
    private TextField textFieldCorpus;

    @FXML
    private TextField textFieldPowerSupply;

    @FXML
    private TextField textFieldMonitor;

    @FXML
    private TextField textFieldKeyboard;

    @FXML
    private TextField textFieldMouse;

    @FXML
    private TextField textFieldOther;

    @FXML
    void actionOK(ActionEvent event) {
        computer.setProcessor(textFieldProcessor.getText());
        computer.setVideoCard(textFieldVideoCard.getText());
        computer.setRam(textFieldRAM.getText());
        computer.setMotherboard(textFieldMotherboard.getText());
        computer.setCooler(textFieldCooler.getText());
        computer.setSsd_m2(textFieldSSD_M2.getText());
        computer.setSsd(textFieldSSD.getText());
        computer.setCorpus(textFieldCorpus.getText());
        computer.setPowerSupply(textFieldPowerSupply.getText());
        computer.setMonitor(textFieldMonitor.getText());
        computer.setKeyboard(textFieldKeyboard.getText());
        computer.setMouse(textFieldMouse.getText());
        computer.setOther(textFieldOther.getText());
        observableList.addAll(computer);
        dao.create(computer);
    }

}
