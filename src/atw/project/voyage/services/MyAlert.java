/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.services;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 *
 * @author Monta
 */
public class MyAlert {


    public static void infoBox(String infoMessage, String titleBar)
    {
      
        infoBox(infoMessage, titleBar, null);
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
    public static void ErrorBox(String msg){
          Alert alert=new Alert( AlertType.ERROR);
          alert.setTitle("Error");
          alert.setHeaderText(null);
          alert.setContentText(msg);
          alert.showAndWait();
}
public static void WarningBox(String msg){
          Alert alert=new Alert( AlertType.WARNING);
          alert.setTitle("Warning");
          alert.setHeaderText(null);
          alert.setContentText(msg);
          alert.showAndWait();
}
}

