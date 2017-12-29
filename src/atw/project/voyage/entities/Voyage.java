/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.entities;
import java.util.Date;

/**
 *
 * @author Monta
 */
public class Voyage {
    private int idVoy;
    private String fk_idTr;
    private String SCountry;
    private String DCountry;
    private float KidPrice;
    private float AdultPrice;
    private String TravelDate;
    private float Duration;

    public Voyage(String fk_idTr, String SCountry, String DCountry, float KidPrice, float AdultPrice, String TravelDate, float Duration) {
        
        this.fk_idTr = fk_idTr;
        this.SCountry = SCountry;
        this.DCountry = DCountry;
        this.KidPrice = KidPrice;
        this.AdultPrice = AdultPrice;
        this.TravelDate = TravelDate;
        this.Duration = Duration;
    }

    public Voyage() {
    }

    public Voyage(int idVoy, String fk_idTr, String SCountry, String DCountry, float KidPrice, float AdultPrice, String TravelDate, float Duration) {
        this.idVoy = idVoy;
        this.fk_idTr = fk_idTr;
        this.SCountry = SCountry;
        this.DCountry = DCountry;
        this.KidPrice = KidPrice;
        this.AdultPrice = AdultPrice;
        this.TravelDate = TravelDate;
        this.Duration = Duration;
    }

   // public Voyage(String tr201X, String tunis, String paris, int i, int i0, java.sql.Date sqlDate, int i1) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }

    public int getIdVoy() {
        return idVoy;
    }

    public void setIdVoy(int idVoy) {
        this.idVoy = idVoy;
    }

    public String getFk_idTr() {
        return fk_idTr;
    }

    public void setFk_idTr(String fk_idTr) {
        this.fk_idTr = fk_idTr;
    }

   

    public String getSCountry() {
        return SCountry;
    }

    public void setSCountry(String SCountry) {
        this.SCountry = SCountry;
    }

    public String getDCountry() {
        return DCountry;
    }

    public void setDCountry(String DCountry) {
        this.DCountry = DCountry;
    }

    public float getKidPrice() {
        return KidPrice;
    }

    public void setKidPrice(float KidPrice) {
        this.KidPrice = KidPrice;
    }

    public float getAdultPrice() {
        return AdultPrice;
    }

    public void setAdultPrice(float AdultPrice) {
        this.AdultPrice = AdultPrice;
    }

    public String getTravelDate() {
        return TravelDate;
    }

    public void setTravelDate(String TravelDate) {
        this.TravelDate = TravelDate;
    }

 

  

  

    public float getDuration() {
        return Duration;
    }

    public void setDuration(float Duration) {
        this.Duration = Duration;
    }

    @Override
    public String toString() {
        return " \n Voyage:{" + "idVoy=" + idVoy + ", fk_idTr=" + fk_idTr + ", SCountry=" + SCountry + ", DCountry=" + DCountry + ", KidPrice=" + KidPrice + ", AdultPrice=" + AdultPrice + ", TravelDate=" + TravelDate + ", Duration=" + Duration + '}';
    }

   
}