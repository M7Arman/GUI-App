package com.arman.guiApp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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
    @FXML
    private PieChart pieChart;
    @FXML
    private LineChart<String,Number> lineChart;

    private final static ObservableList<String> ITEMS = FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3", "Item 4");
    private final static ObservableList<PieChart.Data> PIE_CHART_DATA
            = FXCollections.observableArrayList(
                    new PieChart.Data("10 - 19", 33),
                    new PieChart.Data("20 - 29", 50),
                    new PieChart.Data("30 - 39", 17));

    /**
     * Initializes the controller class.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initPieChart();
        initLineChart();
    }

    private void initTable() {
        itemsList.setItems(ITEMS);
        idCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        fullNameCol.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        ageCol.setCellValueFactory(new PropertyValueFactory("age"));
        emailCol.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        ObservableList<User> users = User.dummyUser();
        table.setItems(users);
    }

    private void initPieChart() {
        pieChart.setData(PIE_CHART_DATA);
        pieChart.setLabelsVisible(true);
    }

    private void initLineChart() {
        XYChart.Series series = new XYChart.Series();
        series.setName("Monthly close");
        
        series.getData().add(new XYChart.Data("Jan", 23));
        series.getData().add(new XYChart.Data("Feb", 14));
        series.getData().add(new XYChart.Data("Mar", 15));
        series.getData().add(new XYChart.Data("Apr", 24));
        series.getData().add(new XYChart.Data("May", 34));
        series.getData().add(new XYChart.Data("Jun", 36));
        series.getData().add(new XYChart.Data("Jul", 22));
        series.getData().add(new XYChart.Data("Aug", 45));
        series.getData().add(new XYChart.Data("Sep", 43));
        series.getData().add(new XYChart.Data("Oct", 17));
        series.getData().add(new XYChart.Data("Nov", 29));
        series.getData().add(new XYChart.Data("Dec", 25));
        
        lineChart.getData().add(series);
    }

}
