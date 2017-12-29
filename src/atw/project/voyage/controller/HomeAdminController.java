/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Monta
 */
public class HomeAdminController implements Initializable {

    @FXML
    private JFXButton Hotel;
    @FXML
    private JFXButton Guides;
    @FXML
    private JFXButton Cars;
    @FXML
    private JFXButton User;
    @FXML
    private JFXButton Voyage;
    @FXML
    private JFXButton HomeA;
    @FXML
    private JFXButton LogoutA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
       


    @FXML
    private void GotoHotel(ActionEvent event) {
    }

    @FXML
    private void GotoGuides(ActionEvent event) {
    }

    @FXML
    private void GotoCars(ActionEvent event) {
    }

    @FXML
    private void GotoUser(ActionEvent event) {
    }

    @FXML
    private void GotoVoyage(ActionEvent event) {
        try {
            Stage stage;
            stage = (Stage) Voyage.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atw/Addvoyage.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();//40065501
        } catch (IOException ex) {
            Logger.getLogger(AddvoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoHomeA(ActionEvent event) {
    }

    @FXML
    private void Logout(ActionEvent event) {
    }

    @FXML
    private void GoHomeA(MouseEvent event) {
    }
}
