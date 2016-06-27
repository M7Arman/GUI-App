package com.arman.guiApp.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

public class FirstPageController implements Initializable {

    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";
    private final ValidationSupport validationSupport = new ValidationSupport();

    @FXML
    private TextField signInUsernameField;
    @FXML
    private TextField signInPasswordField;
    @FXML
    private CheckBox signInRememberCheckBox;
    @FXML
    private Button signInBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validationSupport.registerValidator(signInUsernameField, Validator.createEmptyValidator("Username is required"));
        validationSupport.registerValidator(signInPasswordField, Validator.createEmptyValidator("password is required"));
        signInBtn.setOnAction((ActionEvent event) -> signIn());
    }

    /**
     * Clicks on "Sign In" button
     *
     */
    public void signIn() {

        String userName = signInUsernameField.getText();
        String password = signInPasswordField.getText();
        boolean isRemeber = signInRememberCheckBox.isSelected();

        if (!validationSupport.isInvalid()
                && userName.equalsIgnoreCase(USER_NAME)
                && password.equals(PASSWORD)) {
            Notifications.create()
                    .text("successfully logged in!")
                    .showInformation();
            startHomePage();
        }

    }

    /**
     * Clicks on "Sign Up" button
     */
    public void signUp() {
    }

    private void startHomePage() {
        String fxmlFile = "/fxml/home.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
            Stage stage = new Stage();
            stage.setTitle("Home page");
            stage.setScene(new Scene(rootNode, 600, 400));
            stage.show();
            Stage currentWindow = (Stage) signInBtn.getScene().getWindow();
            currentWindow.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
