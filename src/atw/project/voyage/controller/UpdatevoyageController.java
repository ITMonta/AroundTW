/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.controller;

import atw.project.voyage.entities.Voyage;
import atw.project.voyage.services.CrudVoy;
import atw.project.voyage.technique.BConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Monta
 */
public class UpdatevoyageController implements Initializable {

    @FXML
    private JFXButton UpdateVoy;
    @FXML
    private JFXButton DeleteVoy;
    @FXML
    private JFXButton rechV;
    @FXML
    private Text IDVoyage;
    @FXML
    private JFXComboBox<Integer> IDVoy;
    @FXML
    private JFXButton Update;
    @FXML
    private JFXRadioButton Duration;
    @FXML
    private Text IDVoyage1;
    @FXML
    private JFXButton LogoutA;
    @FXML
    private JFXButton HomeA;

    @FXML
    private JFXButton AddVoy;
    @FXML
    private JFXComboBox<String> IDtr;
    @FXML
    private JFXRadioButton DCountry;
    @FXML
    private JFXRadioButton Home;
    @FXML
    private JFXRadioButton KPrice;
    @FXML
    private JFXRadioButton APrice;
    @FXML
    private JFXRadioButton TDate;
    @FXML
    private JFXTextField txthome;
    @FXML
    private JFXTextField txtdes;
    @FXML
    private JFXTextField txtkp;
    @FXML
    private JFXTextField txtap;
    @FXML
    private JFXTextField txttd;
    @FXML
    private JFXTextField txtdr;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // TODO
            String req = "SELECT idVoy FROM voyage WHERE 1";
            Connection connect = BConnection.getInstance().getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(req);
            int a;
            while (rs.next()) {
                a = rs.getInt(1);
                IDVoy.getItems().add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserchVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String req
                    = "SELECT idTr FROM transport WHERE 1";
            Connection connect = BConnection.getInstance().getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(req);
            String a;
            while (rs.next()) {
                a = rs.getString(1);
                IDtr.getItems().add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddvoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoToUpdateV(ActionEvent event) {

    }

    @FXML
    private void GoToDELETEV(ActionEvent event) {
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

    @FXML
    private void GoToAdd(ActionEvent event) {
        try {
            Stage stage;
            stage = (Stage) AddVoy.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atw/Addvoyage.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReserchVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void IDvoyage(ActionEvent event) {
          if (IDVoy.getValue() != null) {
        try {
              
                int i = IDVoy.getValue();
                String req = "SELECT * FROM voyage  WHERE idVoy=" + i;
                Connection connect = BConnection.getInstance().getConnection();
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(req);
                while (rs.next()) {
                    IDtr.setValue(rs.getString(2));
                    txthome.setText(rs.getString(3));
                    txtdes.setText(rs.getString(4));
                    txtkp.setText(Float.toString(rs.getFloat(5)));
                    txtap.setText(Float.toString(rs.getFloat(6)));
                    txttd.setText(rs.getString(7));
                    txtdr.setText(Integer.toString(rs.getInt(8)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UpdatevoyageController.class.getName()).log(Level.SEVERE, null, ex);
            }}
    }

    @FXML
    private void UpdateVoy(ActionEvent event) {
       
        if (IDVoy.getValue() != null && txthome.getText() != null && txtdes != null && txtkp != null && txtap != null && txttd != null && txtdr != null) {

            Voyage v = new Voyage(IDVoy.getValue(), IDtr.getValue(), txthome.getText(), txtdes.getText(), Float.parseFloat(txtkp.getText()), Float.parseFloat(txtap.getText()), txttd.getText(), Integer.parseInt(txtdr.getText()));
            CrudVoy cr = new CrudVoy();
            cr.modifierVoy(v);
        }
        

    }

    @FXML
    private void Logout(ActionEvent event) {
    }

    @FXML
    private void GoHomeA(ActionEvent event) throws IOException {
    
            Stage stage;
            stage = (Stage) HomeA.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atw/HomeAdmin.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();//40065501
       
        }
   

    @FXML
    private void GoHomeA(MouseEvent event) {
    }

    @FXML
    private void UpDCountry(ActionEvent event) {
        txtdes.setEditable(true);
    }

    @FXML
    private void UpHome(ActionEvent event) {
        txthome.setEditable(true);
       

    }

    @FXML
    private void UpKPrice(ActionEvent event) {
        txtkp.setEditable(true);
       
    }

    @FXML
    private void UpAPrice(ActionEvent event) {
        txtap.setEditable(true);
    }

    @FXML
    private void UpTDate(ActionEvent event) {
        txttd.setEditable(true);
    }

    @FXML
    private void UpDuration(ActionEvent event) {
        txtdr.setEditable(true);
    }
}
