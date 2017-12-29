/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.services;

import atw.project.voyage.entities.ReservationVoyage;
import atw.project.voyage.technique.BConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monta
 */
public class CrudReservationVoyage {
    

   

    Connection connect = BConnection.getInstance().getConnection();

    public void ajouterresVoy(ReservationVoyage rv) {
        try {
            String req;
            req = "INSERT INTO reservationv" + "(fk_cin,fk_idVoy,KNbr,ANbr,CNbr) VALUES" + "('" + rv.getFk_cin() + "','" + rv.getFk_idVoy() + "','" + rv.getKNbr() + "','" +rv.getANbr() + "','" + rv.getCNbr()  + "')";
            Statement st = connect.createStatement();
            st.executeUpdate(req);
          
            System.out.println("Reservation Voyage Ajoutee");

        } catch (SQLException ex) {
            Logger.getLogger(CrudVoy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierresVoy(ReservationVoyage rv) {

        try {
            System.out.println(rv);
            String req = "UPDATE reservationv SET  fk_cin'" + rv.getFk_cin() + "',fk_idVoy='" + rv.getFk_idVoy() + "',KNbr='" + rv.getKNbr() + "',ANbr='" + rv.getANbr() + "',CNbr='" + rv.getCNbr() + "' WHERE idRVoyage='" + rv.getIdRVoyage();
            Statement st = connect.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CrudVoy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteresVoy(int id) {
        try {
            String req = "DELETE FROM reservationv WHERE idRVoyage=" + id;
            Statement st = connect.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation voyage supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(CrudVoy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<ReservationVoyage> displayAll() {
        List<ReservationVoyage> maListe = new ArrayList<>();
        try {

            String requete = "SELECT * FROM reservationv";
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(requete);
            ReservationVoyage rv = new ReservationVoyage();
            while (rs.next()) {
                rv.setIdRVoyage(1);
                rv.setFk_cin(2);
                rv.setFk_idVoy(3);
                rv.setKNbr(4);
                rv.setANbr(5);
                rv.setCNbr(6);
                maListe.add(rv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudVoy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maListe;
    }

}
