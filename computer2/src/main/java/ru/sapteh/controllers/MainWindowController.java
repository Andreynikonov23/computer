package ru.sapteh.controllers;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Implements.ComputerImpl;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Computer;

import java.io.IOException;

public class MainWindowController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Computer, Integer> computerIntegerDAO = new ComputerImpl(factory);
    ObservableList<Computer> observableList = FXCollections.observableArrayList();
    Stage stage = new Stage();
    private Computer selectedItems;
    private AnchorPane pane;

    @FXML
    private TableView<Computer> tableView;

    @FXML
    private TableColumn<Computer, Integer> columnID;

    @FXML
    private TableColumn<Computer, String> columnProcessor;

    @FXML
    private TableColumn<Computer, String> columnVideoCard;

    @FXML
    private TableColumn<Computer, String> columnRAM;

    @FXML
    private TableColumn<Computer, String> columnMotherboard;

    @FXML
    private TableColumn<Computer, String> columnCooler;

    @FXML
    private TableColumn<Computer, String> columnSSD_M2;

    @FXML
    private TableColumn<Computer, String> columnSSD;

    @FXML
    private TableColumn<Computer, String> columnCorpus;

    @FXML
    private TableColumn<Computer, String> columnPowerSupply;

    @FXML
    private TableColumn<Computer, String> columnMonitor;

    @FXML
    private TableColumn<Computer, String> columnKeyboard;

    @FXML
    private TableColumn<Computer, String> columnMouse;

    @FXML
    private TableColumn<Computer, String> columnOther;

    @FXML
    void actionAdd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/buttons/create.fxml"));
        pane = loader.load();
        CreateController createController = loader.getController();
        stage.setTitle("Добавьте данные");
        stage.setScene(new Scene(pane));
        stage.show();

        createController.setData(observableList);
    }

    @FXML
    void actionDelete(ActionEvent event) {
        Computer computer = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(computer);

        computerIntegerDAO.delete(computer);
    }

    @FXML
    void actionEdit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/buttons/edit.fxml"));
        pane = loader.load();
        EditController editController = loader.getController();
        stage.setTitle("Измените данные");
        stage.setScene(new Scene(pane));
        stage.show();

        editController.setData(selectedItems);
        editController.setDataList(observableList);
    }

    @FXML
    void initialize(){
        tableView.setItems(observableList);
        columnID.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        columnProcessor.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getProcessor()));
        columnVideoCard.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getVideoCard()));
        columnRAM.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getRam()));
        columnMotherboard.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getMotherboard()));
        columnCooler.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getCooler()));
        columnSSD_M2.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getSsd_m2()));
        columnSSD.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getSsd()));
        columnCorpus.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getCorpus()));
        columnPowerSupply.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPowerSupply()));
        columnMonitor.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getMonitor()));
        columnKeyboard.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getKeyboard()));
        columnMouse.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getMouse()));
        columnOther.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getOther()));
        observableList.addAll(computerIntegerDAO.findByAll());
        tableView.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) ->{
            selectedItems = newValue;
        });
    }

}
