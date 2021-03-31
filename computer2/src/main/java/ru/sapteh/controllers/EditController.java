package ru.sapteh.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Implements.ComputerImpl;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Computer;

public class EditController {
    private Computer computer;
    ObservableList<Computer> observableList = FXCollections.observableArrayList();
    public void setData(Computer computer){
        this.computer = computer;
        textFieldProcessor.setText(computer.getProcessor());
        textFieldVideoCard.setText(computer.getVideoCard());
        textFieldRAM.setText(computer.getRam());
        textFieldMotherboard.setText(computer.getMotherboard());
        textFieldCooler.setText(computer.getCooler());
        textFieldSSD_M2.setText(computer.getSsd_m2());
        textFieldSSD.setText(computer.getSsd());
        textFieldCorpus.setText(computer.getCorpus());
        textFieldPowerSupply.setText(computer.getPowerSupply());
        textFieldMonitor.setText(computer.getMonitor());
        textFieldKeyboard.setText(computer.getKeyboard());
        textFieldMouse.setText(computer.getMouse());
        textFieldOther.setText(computer.getOther());
    }
    public void setDataList(ObservableList observableList){
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
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Computer, Integer> computerIntegerDAO = new ComputerImpl(factory);
        Computer computer = new Computer();
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
        computerIntegerDAO.update(computer);
        factory.close();
    }

}
