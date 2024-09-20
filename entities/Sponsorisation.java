/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author DELL
 */
public class Sponsorisation {
    private int ID;
    private Evenement evenement;
    private Sponsor sponsor;

    public Sponsorisation() {
    }

    public Sponsorisation(int ID, Evenement evenement, Sponsor sponsor) {
        this.ID = ID;
        this.evenement = evenement;
        this.sponsor = sponsor;
        
    }

    public int getID() {
        return ID;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    @Override
    public String toString() {
        return "Sponsoriser{" + "ID=" + ID + ", evenement=" + evenement + ", sponsor=" + sponsor + '}';
    }
    
    
    
    
}
