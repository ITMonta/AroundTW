/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monta
 */
public class BConnection {

    private  String url = "jdbc:mysql://localhost/atw";
    private  String user = "root";
    private  String passwd = "";
    private static  Connection connect;
    public static BConnection mcnx;


    private BConnection() {
        try {

            connect = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
          public static BConnection getInstance() {
        if (mcnx == null) {
            mcnx = new BConnection();
        }
        return mcnx;
    }

    
      public Connection getConnection() {
        return connect;
    }
}


