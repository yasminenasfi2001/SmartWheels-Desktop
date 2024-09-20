/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.Date;
import javafx.scene.control.RadioButton;

/**
 *
 * @author aziz
 */
public class Utilisateur {
    private int id ;
    private String nom;
    private String prenom;
    private String email;  
    private String date;
    private int telephone;
    private String region;
    private String genre;
    private String motpasse;
    private String type;
    
//Contructors
    public Utilisateur(int id, String nom, String prenom, String email, String date, int telephone, String region, String genre,String mot_passe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date = date;
        this.telephone = telephone;
        this.region = region;
        this.genre = genre;
        this.motpasse=mot_passe;
        
    }
 public Utilisateur(int id, String nom, String prenom, String email, String date, int telephone, String region,String mot_passe,RadioButton Rhomme,RadioButton Rfemme) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date = date;
        this.telephone = telephone;
        this.region = region;
        this.motpasse=mot_passe;
        if (Rhomme.isSelected())
            this.genre="Homme";
        else if (Rfemme.isSelected())
            this.genre="Femme";
        else 
             this.genre="Autre";
        
    }
  public Utilisateur(int id, String nom, String prenom, String email, String date, int telephone, String region,String mot_passe,RadioButton Rhomme,RadioButton Rfemme,String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date = date;
        this.telephone = telephone;
        this.region = region;
        this.motpasse=mot_passe;
        if (Rhomme.isSelected())
            this.genre="Homme";
        else if (Rfemme.isSelected())
            this.genre="Femme";
        else 
             this.genre="Autre";
        this.type=type;
        
    }
    public Utilisateur(String nom, String prenom, String email, String date, int telephone, String region,String mot_passe,RadioButton Rhomme,RadioButton Rfemme,String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date = date;
        this.telephone = telephone;
        this.region = region;
        this.motpasse=mot_passe;
        if (Rhomme.isSelected())
            this.genre="Homme";
        else if (Rfemme.isSelected())
            this.genre="Femme";
        else 
             this.genre="Autre";
        this.type=type;
        
    }
    public Utilisateur() {
        this.id = 0;
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.date = "";
        this.telephone = 0;
        this.region = "";
        this.genre="";
        this.type="";
    }
   
      public Utilisateur(int id, String nom, String prenom, String email, String date, int telephone, String region,String genre,String mot_passe,String type) {
         this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date = date;
        this.telephone = telephone;
        this.region = region;
        this.motpasse=mot_passe;
        this.genre=genre;
        this.type=type;
    }

   

   
    
    
    //getters
    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRegion() {
        return region;
    }
      public int getTelephone() {
        return telephone;
    }
       public String getMot_passe() {
        return motpasse;
    }
          public String getType() {
        return type;
    }
       
       
       
    //setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setTelephone(int tellephone) {
        this.telephone = tellephone;
    }
      public void setMot_passe(String motpasse) {
        this.motpasse = motpasse;
    }
       public void setType(String type) {
        this.type = type;
    }
  
  
    
    //tostring
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
      
    
}
