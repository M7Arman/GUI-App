package com.arman.guiApp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.User;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class HomeController implements Initializable {

    @FXML
    private TableView<User> table;
    @FXML
    private ListView<String> itemsList;
    @FXML
    private TableColumn<User, String> idCol;
    @FXML
    private TableColumn<User, String> fullNameCol;
    @FXML
    private TableColumn<User, Integer> ageCol;
    @FXML
    private TableColumn<User, String> emailCol;

    private final ObservableList<String> items = FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3", "Item 4");

    /**
     * Initializes the controller class.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemsList.setItems(items);
        idCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        fullNameCol.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        ageCol.setCellValueFactory(new PropertyValueFactory("age"));
        emailCol.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        
        ObservableList<User> users = User.dummyUser();
        table.setItems(users);
    }

}
