/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Reclamation {
   private int Id;
   private String Nom;
   private String Prenom;
   private String Adresse;
   private String Contenu;
   private Date dateCreation;
    public Reclamation(int Id, String Nom, String Prenom, String Adresse, String Contenu) {
        this.Id = Id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Contenu = Contenu;
    }

    public Reclamation(String Nom, String Prenom, String Adresse, String Contenu, Date dateCreation) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Contenu = Contenu;
        this.dateCreation = dateCreation;
    }

    public Reclamation() {
    }

    public int getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    

    public String getContenu() {
        return Contenu;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

 

    @Override
    public String toString() {
        return "Reclamation{" + "Id=" + Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse + ", Contenu=" + Contenu + ", dateCreation=" + dateCreation + '}';
    }

   
    
     
}
