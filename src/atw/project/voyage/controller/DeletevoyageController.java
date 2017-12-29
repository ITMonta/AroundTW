/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.controller;

import atw.project.voyage.services.CrudVoy;

import atw.project.voyage.technique.BConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;

import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Monta
 */
public class DeletevoyageController implements Initializable {

    @FXML
    private JFXButton HomeA;
    @FXML
    private JFXButton LogoutA;
    @FXML
    private Text IDVoyage;
    @FXML
    private JFXComboBox<Integer> IDVoy;
    @FXML
    private JFXButton Delete;
    @FXML
    private ImageView TrashB;
    @FXML
    private JFXButton rechV;
    @FXML
    private JFXButton DeleteVoy;
    @FXML
    private JFXButton UpdateVoy;
    @FXML
    private JFXButton AddVoyage;
    @FXML
    private JFXRadioButton DoT;
    @FXML
    private JFXRadioButton warningmail;
    @FXML
    private JFXRadioButton Dat;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ToggleGroup toggleGroup = new ToggleGroup();
     DoT.setToggleGroup(toggleGroup);
     Dat.setToggleGroup(toggleGroup);

        // TODO
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
    private void Logout(ActionEvent event) {
    }

    @FXML
    private void IDvoyage(ActionEvent event) {
    }

    @FXML
    private void DeleteVoy(ActionEvent event) throws MessagingException {
        if (IDVoy.getValue() != null && (DoT.isSelected() == true) && warningmail.isSelected() == false) {
            int id = Integer.valueOf(IDVoy.getValue().toString());
            CrudVoy cr;
            cr = new CrudVoy();
            cr.DeleteVoy(id);

        } else if (IDVoy.getValue() == null &&warningmail.isSelected()==false&&Dat.isSelected()==false) {//MyAlert.WarningBox("Select Travel Id");
            TranslateTransition translate = new TranslateTransition();
            translate.setDuration(Duration.seconds(4));
            translate.setNode(TrashB);
            translate.setToX(+150);
            translate.setToY(-200);
            translate.setAutoReverse(true);
            translate.setCycleCount(2);
            translate.play();
         
        } else if (DoT.isSelected() == false && IDVoy.getValue() != null&&Dat.isSelected()==false) {
            TranslateTransition translate = new TranslateTransition();
            translate.setDuration(Duration.seconds(4));

            translate.setNode(TrashB);
            translate.setToX(-50);
            translate.setToY(-115);
            ScaleTransition translate1 = new ScaleTransition(Duration.seconds(4), TrashB);
            translate1.setToY(0.5);
            translate1.setToX(0.5);

            translate1.setAutoReverse(true);
            translate1.setCycleCount(2);
            translate.setCycleCount(2);
            translate.setAutoReverse(true);
            translate.play();
            translate1.play();

        }
        else   if (IDVoy.getValue() != null && (DoT.isSelected() == true) && warningmail.isSelected() == true) {
            int id = Integer.valueOf(IDVoy.getValue().toString());
            CrudVoy cr;
            cr = new CrudVoy();
            
            try {
                Connection connect = BConnection.getInstance().getConnection();
                 Statement stb = connect.createStatement();
                  String req1="SELECT * FROM reservationv WHERE fk_idVoy="+id ;
                  ResultSet rs1 = stb.executeQuery(req1); 
                  int cin;
                  int idvoy;
                  while (rs1.next()){
                      cin=rs1.getInt(2);
                      idvoy=rs1.getInt(3);
                
                  String req = "SELECT * FROM user WHERE cin="+cin;
               
                
                Statement sta = connect.createStatement();
                ResultSet rs = sta.executeQuery(req);
                String a;
                while (rs.next()) {
                     
                  
                    a = rs.getString(9);
                  
                     
                    Properties props = new Properties(); //MessagingException
                    props.put("mail.transport.protocol", "smtp");
                    props.put("mail.smtps.host", "smtp.gmail.com");
                    props.put("mail.smtps.auth", "true");
                       Session session = Session.getInstance(props, null);
                      MimeMessage msg = new MimeMessage(session);
                    
                        
                              msg.setFrom(new InternetAddress("Travel Cancel <my_email@myDomain.com>"));
                         
                      msg.setRecipients(Message.RecipientType.TO, a);
                      msg.setSubject("Around The World ( Travel Canceling : " +idvoy+ (")"));
                    msg.setSentDate(new Date(System.currentTimeMillis()));
                    
                    String txt = " Dear client, \n Unfortunately we are sorry to announce you that the travel is Canceled because of technical issue sor for your safety we canceled the travel \n Sincerely,   ";
                      msg.setText(txt);
                       SMTPTransport st = (SMTPTransport) session.getTransport("smtps");
                       st.connect("smtp.gmail.com", "montassar.bouagina@esprit.tn", "Monta34533453");
                       st.sendMessage(msg, msg.getAllRecipients());
                    System.out.println("ServerResponse : " + st.getLastServerResponse());
                    RotateTransition transition1 = new RotateTransition(Duration.seconds(1), TrashB);
                    transition1.setByAngle(360);
                    transition1.play();
                }}
            } catch (SQLException ex) {
                Logger.getLogger(ReserchVoyageController.class.getName()).log(Level.SEVERE, null, ex);

            }
            
            RotateTransition transition1 = new RotateTransition(Duration.seconds(5), TrashB);
            transition1.setByAngle(360);
            transition1.play();
            cr.DeleteVoy(id);
        }
        if (warningmail.isSelected() == true && Dat.isSelected() == true) {
            CrudVoy cr;
             cr = new CrudVoy();
          
            try {
                Connection connect = BConnection.getInstance().getConnection();
                 Statement stb = connect.createStatement();
                  String req1="SELECT * FROM reservationv WHERE 1" ;
                  ResultSet rs1 = stb.executeQuery(req1); 
                  int cin;
                  int idvoy;
                  while (rs1.next()){
                      cin=rs1.getInt(2);
                      idvoy=rs1.getInt(3);
                
                  String req = "SELECT * FROM user WHERE cin="+cin;
               
                
                Statement sta = connect.createStatement();
                ResultSet rs = sta.executeQuery(req);
                String a;
                while (rs.next()) {
                     
                  
                    a = rs.getString(9);
                  
                     
                    Properties props = new Properties();
                    props.put("mail.transport.protocol", "smtp");
                    props.put("mail.smtps.host", "smtp.gmail.com");
                    props.put("mail.smtps.auth", "true");
                         Session session = Session.getInstance(props, null);
                       MimeMessage msg = new MimeMessage(session);
                    
                       msg.setFrom(new InternetAddress("Travel Cancel <my_email@myDomain.com>"));
                       msg.setRecipients(Message.RecipientType.TO, a);
                       msg.setSubject("Around The World ( Travel Canceling : " +idvoy+ (")"));
                       msg.setSentDate(new Date(System.currentTimeMillis()));
                    
                    String txt = " Dear client, \n Unfortunately we are sorry to announce you that the travel is Canceled because of technical issue sor for your safety we canceled the travel \n Sincerely,   ";
                       msg.setText(txt);
                      SMTPTransport st = (SMTPTransport) session.getTransport("smtps");
                     st.connect("smtp.gmail.com", "montassar.bouagina@esprit.tn", "Monta34533453");
                     st.sendMessage(msg, msg.getAllRecipients());
                     System.out.println("ServerResponse : " + st.getLastServerResponse());
                    RotateTransition transition1 = new RotateTransition(Duration.seconds(1), TrashB);
                    transition1.setByAngle(360);
                    transition1.play();
                }             cr.DeleteVoy(idvoy);  //delete lenaaaaaaa
                  }
            } catch (SQLException ex) {
                Logger.getLogger(ReserchVoyageController.class.getName()).log(Level.SEVERE, null, ex);

            }
            RotateTransition transition1 = new RotateTransition(Duration.seconds(5), TrashB);
            transition1.setByAngle(360);
            transition1.play();
        }
        else if(warningmail.isSelected() == false && Dat.isSelected() == true)
        {
            try {
                CrudVoy cr;
                cr = new CrudVoy();
                
                
                Connection connect = BConnection.getInstance().getConnection();
                Statement stb = connect.createStatement();
                String req1="SELECT * FROM reservationv WHERE 1" ;
                ResultSet rs1 = stb.executeQuery(req1);
                int idvoy;
                while (rs1.next()){
                    idvoy=rs1.getInt(3);
                    cr.DeleteVoy(idvoy);
                     RotateTransition transition1 = new RotateTransition(Duration.seconds(5), TrashB);
            transition1.setByAngle(360);
            transition1.play();
                    
                }
                   } catch (SQLException ex) {
                Logger.getLogger(DeletevoyageController.class.getName()).log(Level.SEVERE, null, ex);
            }}
    }
    

    @FXML
    private void MoveTB(MouseEvent event) {

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
    private void GoToDELETEV(ActionEvent event) {
    }

    @FXML
    private void GoToUpdateV(ActionEvent event) {
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
    private void AddVoyage(ActionEvent event) {
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
    private void GoHomeA(MouseEvent event) {
    }

    @FXML
    private void mailto(ActionEvent event) {

    }
}
