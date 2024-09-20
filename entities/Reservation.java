/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import oracle.sql.DATE;

/**
 *
 * @author user
 */
public class Reservation {
     private  int id_res;
     private  String date_debut;
      private  String date_fin;
       private float montant;
       private int id_v;
      private int id_client;
          public  Reservation() {
    
      this.id_res=0;
      this.date_debut=null;
       this.date_fin=null;

        this.montant=0;
      
    }

    public Reservation(int id_res, String date_debut, String date_fin) {
        this.id_res = id_res;
        this.date_debut = date_debut;
        this.date_fin = date_fin;

    }
    
        public Reservation(int id_res, String date_debut, String date_fin,float montant,int id_v,int id_client) {
        this.id_res = id_res;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.montant = montant;
        this.id_v= id_v;
        this.id_client=id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_client() {
        return id_client;
    }
        

    public int getId_v() {
        return id_v;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }


     
    
}
