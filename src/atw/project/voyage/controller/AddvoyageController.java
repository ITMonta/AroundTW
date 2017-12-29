/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.controller;

import atw.project.voyage.services.MyAlert;
import atw.project.voyage.entities.Voyage;
import atw.project.voyage.services.ControlSaisie;
import atw.project.voyage.services.CrudVoy;
import atw.project.voyage.technique.BConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Monta
 */
public class AddvoyageController implements Initializable {

    @FXML
    private JFXButton submitAV;
    @FXML
    private JFXComboBox Idtr;

    @FXML
    private JFXTextField SCountry;
    @FXML
    private JFXTextField DCountry;
    @FXML
    private DatePicker TravelDate;
    @FXML
    private JFXTextField KPrice;
    @FXML
    private JFXTextField APrice;
    @FXML
    private JFXTextField Duration;
    @FXML
    private JFXButton DeleteVoy;
    @FXML
    private JFXButton UpdateVoy;
    @FXML
    private JFXButton HomeA;
    @FXML
    private JFXButton LogoutA;
    @FXML
    private JFXButton AddVoyage;
    @FXML
    private JFXButton rechV;

    void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            String req = "SELECT idTr FROM transport WHERE 1";
            Connection connect = BConnection.getInstance().getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(req);
            String a;
            while (rs.next()) {
                a = rs.getString(1);
                Idtr.getItems().add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddvoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Idtr.getItems().addAll();
        // Idtr.getItems().addAll();
    }
    ControlSaisie c = new ControlSaisie();

    @FXML
    void AddVoyage(ActionEvent event) {

        String idtr, home, des, trd;
        float ap, kp;
        int dur;
        if (SCountry.getText().isEmpty()) {
            MyAlert.WarningBox("you need to type a Home address!!");
        } else if (c.isAlpha(SCountry.getText()) != true) {
            MyAlert.ErrorBox("you need to type a valid Home address");
        } else if (DCountry.getText().isEmpty()) {
            MyAlert.WarningBox("you need to type a Destination address!!");
        } else if (c.isAlpha(DCountry.getText()) != true) {
            MyAlert.ErrorBox("you need to type a valid  Destination address");
        } else if (c.isfloat(APrice.getText()) != true) {
            MyAlert.ErrorBox("you need to trype a valid Price for Adult");
        } else if (c.isfloat(KPrice.getText()) != true) {
            MyAlert.ErrorBox("you need to trype a valid Price For Kids");
        } else if (c.isint(Duration.getText()) != true) {
            MyAlert.ErrorBox("you need to type a valid Duration");
        } else {
            idtr = Idtr.getSelectionModel().getSelectedItem().toString();
            home = SCountry.getText();
            des = DCountry.getText();
            trd = TravelDate.getValue().toString();
            ap = Float.parseFloat(APrice.getText());
            kp = Float.parseFloat(KPrice.getText());
            dur = Integer.parseInt(Duration.getText());
            Voyage v = new Voyage(idtr, home, des, kp, ap, trd, dur);
            CrudVoy tools = new CrudVoy();
            tools.ajouterVoy(v);
            MyAlert.infoBox("Travel Added With the Id :" + idtr, "Added successfully");
        }

    }

    @FXML
    void GoToDELETEV(ActionEvent event) {
        try {
            Stage stage;
            stage = (Stage) DeleteVoy.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atw/Deletevoyage.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();//40065501
        } catch (IOException ex) {
            Logger.getLogger(AddvoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void GoToUpdateV(ActionEvent event) {
        try {
            Stage stage;
            stage = (Stage) UpdateVoy.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atw/Updatevoyage.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReserchVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Logout(ActionEvent event) {
    }

    @FXML
    void GoHomeA(ActionEvent event) throws IOException {
        Stage stage;
        stage = (Stage) HomeA.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/atw/HomeAdmin.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();//40065501

    }

    @FXML
    private void gotoSearch(ActionEvent event) {
        try {
            Stage stage;
            stage = (Stage) rechV.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atw/Reserchvoyage.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();//40065501
        } catch (IOException ex) {
            Logger.getLogger(AddvoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
