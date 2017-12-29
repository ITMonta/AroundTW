/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.controller;

import atw.project.voyage.entities.ReservationVoyage;
import atw.project.voyage.entities.Voyage;
import atw.project.voyage.services.ControlSaisie;
import atw.project.voyage.services.Creditcard;
import atw.project.voyage.services.CrudReservationVoyage;
import atw.project.voyage.services.CrudVoy;
import atw.project.voyage.services.MyAlert;
import atw.project.voyage.technique.BConnection;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddReservationController {

    @FXML
    private TableColumn<Voyage, Float> AdultPrices;

    @FXML
    private TableColumn<Voyage, Float> KidPrices;


    @FXML
    private TableColumn<Voyage, String> Destinations;


    @FXML
    private AnchorPane Booktravel;

    @FXML
    private TableColumn<Voyage, String> Date;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private Text booktravel1;
    @FXML
    private JFXTextField Cardnumber;
    @FXML
    private JFXTextField cvv;
    @FXML
    private DatePicker exDate;
    @FXML
    private JFXButton pay;
    @FXML
    private JFXTextField Cin;
    
    @FXML
    private TableView<Voyage> tableau1;
    private ObservableList<Voyage> tableauV;
    @FXML
    private JFXButton display;
    @FXML
    private TableColumn<Voyage, Integer> id;
   
    @FXML
    private JFXTextField ANbr;
    @FXML
    private JFXTextField KidNbr;
    @FXML
    private JFXTextField CNbr;
    @FXML
    private Button pay1;
    @FXML
    private JFXButton bookt;
        CrudVoy vc = new CrudVoy();
        CrudReservationVoyage rv =new CrudReservationVoyage();
        int cin0=0;
    @FXML
    private AnchorPane anchor2;

    public void initialize(URL url, ResourceBundle rb) {

// TODO
    }

    public void showVoyage(List<Voyage> list) {

        List<Voyage> myResult = vc.displayAll();

        ObservableList<Voyage> data = FXCollections.observableArrayList(myResult);
        Date.setCellValueFactory(
                new PropertyValueFactory<>("TravelDate")
        );

        Destinations.setCellValueFactory(
                new PropertyValueFactory<>("DCountry")
        );

        KidPrices.setCellValueFactory(
                new PropertyValueFactory<>("KidPrice")
        );
        AdultPrices.setCellValueFactory(
                new PropertyValueFactory<>("AdultPrice")
        );
         id.setCellValueFactory(
                new PropertyValueFactory<>("idVoy")
         );
        tableau1.setItems(data);
    }

    private void GoToBookTravel(MouseEvent event) throws IOException {
        Stage stage;
        stage = (Stage) Booktravel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AddReservation.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Upcredit(ActionEvent event) {
        anchor2.setVisible(true);

    }

    @FXML
    private void gotobooktravet(MouseEvent event) {
        anchor2.setVisible(false);
        anchor1.setVisible(false);
    }

    @FXML
    private void payer(ActionEvent event) throws SQLException {
        ControlSaisie cs = new ControlSaisie();
        Creditcard c;
        c = new Creditcard();
        
        if ( Integer.parseInt(Cin.getText()) != cin0) {
            MyAlert.ErrorBox("Your cin is Invalid");
        } else {
            c.setCardNumb(Long.parseLong(Cardnumber.getText()));
            c.setCVV(Integer.parseInt(cvv.getText()));
            c.setExpirationDate(java.sql.Date.valueOf(exDate.getValue()));
            if(c.isValid(c))
            {MyAlert.ErrorBox("card invalid");
            }
            else
MyAlert.infoBox("Reservation ,Payed!!", "Valid card");
            

        }

    }

    @FXML
    private void displayy(ActionEvent event) {
        List<Voyage> listForm = new ArrayList<>();
        listForm = vc.displayAll();
        showVoyage(listForm);
    }

    @FXML
    private void pay1(ActionEvent event) {
        anchor1.setVisible(true);
        anchor2.setVisible(false);
        
        Voyage vo = (Voyage) tableau1.getSelectionModel().getSelectedItem();
        ReservationVoyage rv1=new ReservationVoyage();
        rv1.setANbr(Integer.parseInt(ANbr.getText()));
        rv1.setKNbr(Integer.parseInt(KidNbr.getText()));
        rv1.setCNbr(Integer.parseInt(CNbr.getText()));
        rv1.setFk_idVoy(vo.getIdVoy());
        rv1.setFk_cin(cin0);
        rv.ajouterresVoy(rv1);
    }

    @FXML
    private void ok(MouseDragEvent event) {
    }

    @FXML
    private void ok(MouseEvent event) {
    }
}
