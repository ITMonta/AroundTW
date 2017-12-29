/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.controller;

import atw.project.voyage.entities.Voyage;
import atw.project.voyage.services.MyAlert;
import atw.project.voyage.technique.BConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.fxml.FXML;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Monta
 */
public class ReserchVoyageController implements Initializable {

    @FXML
    private ImageView RechIcon;

    @FXML
    private JFXComboBox<Integer> IDVoy;
    @FXML
    private Hyperlink Dpdf;
    @FXML
    private JFXButton Search;
    @FXML
    private JFXTextField SCountry;
    @FXML
    private JFXButton LogoutA;
    @FXML
    private JFXButton UpdateVoy;
    @FXML
    private JFXButton DeleteVoy;
    @FXML
    private JFXTextField TravelDate;
    @FXML
    private JFXButton HomeA;
    @FXML
    private JFXButton AddVoyage;
    @FXML
    private JFXTextField DCountry;
    @FXML
    private Text IDVoyage;
    @FXML
    private JFXButton rechV;
    @FXML
    private JFXButton MInfo;
    @FXML
    private ImageView Iicon;

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
    }

    /**
     *
     */
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
    void Logout(ActionEvent event) {

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
    void AddVoyage(ActionEvent event) {

        try {
            Stage stage;
            stage = (Stage) AddVoyage.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atw/Addvoyage.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReserchVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Downloadpdf(ActionEvent event) {

    }

    @FXML
    void SearchVoyage(ActionEvent event) {
        RotateTransition transition1 = new RotateTransition(Duration.seconds(5), RechIcon);
        transition1.setByAngle(360);
        transition1.play();
         if(IDVoy.getValue()!=null){
        try {
            int i=IDVoy.getValue();
            String req = "SELECT Dcountry,SCountry,TravelDate FROM voyage  WHERE idVoy="+i;
            Connection connect = BConnection.getInstance().getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
            DCountry.setText(rs.getString("DCountry"));
            SCountry.setText(rs.getString("SCountry"));
            TravelDate.setText(rs.getString("TravelDate"));
            MInfo.setDisable(false);
            MInfo.setStyle(" -fx-background-color:\n" +
"        linear-gradient(#f0ff35, #a9ff00),\n" +
"        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
"    -fx-background-radius: 6, 5;\n" +
"    -fx-background-insets: 0, 1;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
"    -fx-text-fill: #395306;");
            Dpdf.setDisable(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserchVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else MyAlert.ErrorBox("you need to Select a travel ID");
    }

    @FXML
    void IDvoyage(ActionEvent event) {

    }

   
    @FXML
    private void GoHomeA(MouseEvent event) {
    }

    @FXML
    private void animationR(MouseEvent event) {
       /*   RotateTransition transition1 = new RotateTransition(Duration.seconds(5), RechIcon);
        transition1.setByAngle(360);
        transition1.play(); */
    }

    @FXML
    private void gotoSearch(ActionEvent event) {
        MyAlert.WarningBox("you are already in Search Menu");
       // MyAlert.infoBox("error", "info");
       // MyAlert.ErrorBox("error");
    }

    @FXML
    private void moreinfo(ActionEvent event) {
        try {
            int i=IDVoy.getValue();
            String req = "SELECT * FROM voyage  WHERE idVoy="+i;
            Connection connect = BConnection.getInstance().getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               int id=(rs.getInt(1));
               String Tr=(rs.getString(2));
               String sc=(rs.getString(3));
                String dc=(rs.getString(4));
                float kp=(rs.getFloat(5));
                float ap=(rs.getFloat(6));
                String T=(rs.getString(7));
                int dr=rs.getInt(8);
      
                MyAlert.infoBox("Transport id :  "+Tr+"\n\n Home country :  "+sc+"\n\n Destination country :  "+dc+"\n\n Kid Price :  "+kp+"\n\n Adult Price :  "+ap+"\n\n Travel Date :  "+T+"\n\n Duration :  "+dr, "information","All the information about The Travel with the Id : "+id); //, 
            }   } catch (SQLException ex) {
            Logger.getLogger(ReserchVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
}}
