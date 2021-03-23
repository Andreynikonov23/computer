package ru.sapteh.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Computer;
import ru.sapteh.service.ComputerServ;

public class MainController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Computer> computerObservableList = FXCollections.observableArrayList();
    DAO<Computer, Integer> computerIntegerDAO = new ComputerServ(factory);
    Computer computer = new Computer();

    @FXML
    public TableView<Computer> tableView;

    @FXML
    private TableColumn<Computer, Integer> columnId;

    @FXML
    private TableColumn<Computer, String> columnProcessor;

    @FXML
    private TableColumn<Computer, String> columnMotherboard;

    @FXML
    private TableColumn<Computer, String> columnRam;

    @FXML
    private TableColumn<Computer, String> columnVideoCard;

    @FXML
    private TableColumn<Computer, String> columnSsd;

    @FXML
    private Button buttonNew;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonDelete;

    public void OnActionNew(javafx.event.ActionEvent actionEvent) throws IOException {
        buttonNew.getScene().getWindow();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddNew.fxml"));
        stage.setTitle("Добавить данные");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void OnActionEdit(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/AddEdit.fxml"));
        AnchorPane pane = (AnchorPane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Измените данные");
        stage.setScene(new Scene(pane));


        EditController editController = loader.getController();
        editController.setStage(stage);
        editController.setComputer(computer);
        editController.setObservableList(computerObservableList);

        stage.show();
    }


    @FXML
    void initialize() {
        tableView.setItems(computerObservableList);
        columnId.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        columnProcessor.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getProcessor()));
        columnMotherboard.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getMotherboard()));
        columnRam.setCellValueFactory(d -> new SimpleObjectProperty<>(d.getValue().getRam()));
        columnVideoCard.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getVideoCard()));
        columnSsd.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue().getSsd()));
        DAO<Computer, Integer> computerIntegerDAO = new ComputerServ(factory);
        computerObservableList.addAll(computerIntegerDAO.findByAll());

    }
    public void onActionDelete(ActionEvent actionEvent) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        Computer computer = tableView.getItems().remove(selectedIndex);
        computerIntegerDAO.delete(computer);
    }
}
