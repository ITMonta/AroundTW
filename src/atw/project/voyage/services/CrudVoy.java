/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.services;

import atw.project.voyage.entities.Voyage;
import atw.project.voyage.technique.BConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class CrudVoy {

    Connection connect = BConnection.getInstance().getConnection();

    public void ajouterVoy(Voyage v) {
        try {
            String req;
            req = "INSERT INTO voyage" + "(fk_idTr,SCountry,DCountry,KidPrice,AdultPrice,TravelDate,Duration) VALUES" + "('" + v.getFk_idTr() + "','" + v.getSCountry() + "','" + v.getDCountry() + "','" + v.getKidPrice() + "','" + v.getAdultPrice() + "','" + v.getTravelDate() + "','" + v.getDuration() + "')";
            //  PreparedStatement pstm = connect.prepareStatement(req);
            Statement st = connect.createStatement();
            st.executeUpdate(req);
            /*   pstm.setString(1, v.getSCountry());
            pstm.setString(2, v.getDCountry());
            pstm.setFloat(3, v.getKidPrice());
            pstm.setFloat(4, v.getAdultPrice());
            pstm.setInt(5, v.getKNbr());
            pstm.setInt(6, v.getANbr());
            pstm.setInt(7, v.getCNbr());
            pstm.setDate(8, (java.sql.Date) v.getTravelDate());
            pstm.setFloat(9, v.getDuration());
            pstm.executeUpdate(req); */
            System.out.println("Voyage Ajoutee");

        } catch (SQLException ex) {
            Logger.getLogger(CrudVoy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierVoy(Voyage v) {
        PreparedStatement pstm;
        try {
            System.out.println(v);
            String req="UPDATE voyage SET  fk_idTr='"+v.getFk_idTr()+"',SCountry='"+v.getSCountry()+"',DCountry='"+v.getDCountry()+"',KidPrice='"+v.getKidPrice()+"',AdultPrice='"+v.getAdultPrice()+"',TravelDate='"+v.getTravelDate()+"',Duration='"+v.getDuration()+"' WHERE idVoy="+v.getIdVoy();
           Statement st = connect.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CrudVoy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteVoy(int id) {
        try {
            String req = "DELETE FROM voyage WHERE idVoy="+id;
          Statement st =connect.createStatement();
           st.executeUpdate(req);
            System.out.println("voyage supprimé");
            

        } catch (SQLException ex) {
            Logger.getLogger(CrudVoy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Voyage> displayAll() {
        List<Voyage> maListe = new ArrayList<>();
        try {

            String requete = "SELECT * FROM voyage";
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                Voyage v = new Voyage();
                v.setIdVoy(rs.getInt(1));
                v.setFk_idTr(rs.getString(2));
                v.setSCountry(rs.getString(3));
                v.setDCountry(rs.getString(4));
                v.setKidPrice(rs.getFloat(5));
                v.setAdultPrice(rs.getFloat(6));
                v.setTravelDate(rs.getString(7));
                v.setDuration(rs.getFloat(8));
                maListe.add(v);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudVoy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maListe;
    }

}
