/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author DELL
 */
public class Sponsor {
    private int ID_sponsor;
    private String Nom_sponsor;
    private String Tel_sponsor;
    private String Email_sponsor;
    private float Montant;

    public Sponsor() {
    }

    public Sponsor(int ID_sponsor) {
        this.ID_sponsor = ID_sponsor;
    }

    public Sponsor(int ID_sponsor, String Nom_sponsor, String Tel_sponsor, String Email_sponsor, float Montant) {
        this.ID_sponsor = ID_sponsor;
        this.Nom_sponsor = Nom_sponsor;
        this.Tel_sponsor = Tel_sponsor;
        this.Email_sponsor = Email_sponsor;
        this.Montant = Montant;
    }

    public int getID_sponsor() {
        return ID_sponsor;
    }

    public String getNom_sponsor() {
        return Nom_sponsor;
    }

    public String getTel_sponsor() {
        return Tel_sponsor;
    }

    public String getEmail_sponsor() {
        return Email_sponsor;
    }

    public float getMontant() {
        return Montant;
    }

    public void setID_sponsor(int ID_sponsor) {
        this.ID_sponsor = ID_sponsor;
    }

    public void setNom_sponsor(String Nom_sponsor) {
        this.Nom_sponsor = Nom_sponsor;
    }

    public void setTel_sponsor(String Tel_sponsor) {
        this.Tel_sponsor = Tel_sponsor;
    }

    public void setEmail_sponsor(String Email_sponsor) {
        this.Email_sponsor = Email_sponsor;
    }

    public void setMontant(float Montant) {
        this.Montant = Montant;
    }

    @Override
    public String toString() {
        return "Sponsor{" + "ID_sponsor=" + ID_sponsor + ", Nom_sponsor=" + Nom_sponsor + ", Tel_sponsor=" + Tel_sponsor + ", Email_sponsor=" + Email_sponsor + ", Montant=" + Montant + '}';
    }


    
    
       
}
