package ru.sapteh.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.sapteh.models.Computer;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Computer computer = new Computer();
    List<Computer> computers = new ArrayList<>();

    @FXML
    private ImageView imageView;

    @FXML
    private Label labelProcessor;

    @FXML
    void initialize(){

        URL path = getClass().getResource("/image/4444.jpg");
        Image image = new Image(String.valueOf(path));
        imageView.setImage(image);
        for (Computer computer : computers) {
            labelProcessor.setText(computer.getProcessor());
        }
        }
    }
