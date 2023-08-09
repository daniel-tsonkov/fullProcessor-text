package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

//https://www.tutorialspoint.com/javafx-example-to-set-action-to-the-exit-menuitem
public class Controller {
    @FXML
    void exitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void run(ActionEvent event) {

    }

    @FXML
    void runLoop(ActionEvent event) {

    }

    @FXML
    void runProcess(ActionEvent event) {

    }

    @FXML
    void runProcess(String text) {
        //runProcess();
    }

}