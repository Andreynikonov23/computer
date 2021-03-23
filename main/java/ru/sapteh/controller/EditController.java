package ru.sapteh.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class EditController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Computer, Integer> computerIntegerDAO = new ComputerServ(factory);
    MainController controller = new MainController();

    private Stage stage;
    private Computer computer;
    private ObservableList<Computer> observableList = FXCollections.observableArrayList();


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;

        textFieldProcessor.setText(computer.getProcessor());
        textFieldMotherboard.setText(computer.getMotherboard());
        textFieldRAM.setText(computer.getRam());
        textFieldSSD.setText(computer.getRam());
        textFieldVideoCard.setText(computer.getVideoCard());
    }
    public void setObservableList(ObservableList<Computer> observableList){
        this.observableList = observableList;

    }

    @FXML
    private TextField textFieldId;

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
    private Button buttonExit;

    public void OnActionExit(ActionEvent actionEvent) throws IOException {
        buttonExit.getScene().getWindow();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/sample.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void OnActionEdit(ActionEvent actionEvent) {
        Computer selectedItem = controller.tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            
        }
    }

    @FXML
    void initialize() {

    }
}
