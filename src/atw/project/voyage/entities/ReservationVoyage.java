/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.entities;

/**
 *
 * @author Monta
 */
public class ReservationVoyage {
    
    private int idRVoyage;
    private int fk_cin;
    private int fk_idVoy;
    private int KNbr;
    private int ANbr;
    private int CNbr;
    public ReservationVoyage() {
    }

    public ReservationVoyage(int idRVoyage, int fk_cin, int fk_idVoy, int KNbr, int ANbr, int CNbr) {
        this.idRVoyage = idRVoyage;
        this.fk_cin = fk_cin;
        this.fk_idVoy = fk_idVoy;
        this.KNbr = KNbr;
        this.ANbr = ANbr;
        this.CNbr = CNbr;
    }

    public int getIdRVoyage() {
        return idRVoyage;
    }

    public void setIdRVoyage(int idRVoyage) {
        this.idRVoyage = idRVoyage;
    }

    public int getFk_cin() {
        return fk_cin;
    }

    public void setFk_cin(int fk_cin) {
        this.fk_cin = fk_cin;
    }

    public int getFk_idVoy() {
        return fk_idVoy;
    }

    public void setFk_idVoy(int fk_idVoy) {
        this.fk_idVoy = fk_idVoy;
    }

    public int getKNbr() {
        return KNbr;
    }

    public void setKNbr(int KNbr) {
        this.KNbr = KNbr;
    }

    public int getANbr() {
        return ANbr;
    }

    public void setANbr(int ANbr) {
        this.ANbr = ANbr;
    }

    public int getCNbr() {
        return CNbr;
    }

    public void setCNbr(int CNbr) {
        this.CNbr = CNbr;
    }

    public void AjouterReservation() {
    
    }
    
}
