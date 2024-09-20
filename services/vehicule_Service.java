/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Vehicule;
import interfaces.VehiculeCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




/**
 *
 * @author user
 */


public class vehicule_Service implements VehiculeCRUD<Vehicule> {
    
      Connection con;  
   PreparedStatement pst;
    int myIndex;
    
    public void ajouter_vehicule(Vehicule v) {
        
         String requete = "insert into vehicule values(?,?,?,?,?,?,?,?)";
                     try {
                      
             PreparedStatement ps= MyConnection.getInstance().getCnx().prepareStatement(requete);
             
             ps.setInt(1,v.getId());
             ps.setString(2,v.getMarque());
           
             ps.setString(3,v.getVitesse_max());
             ps.setFloat(4,v.getCharge_max());
             ps.setString(5,v.getAuto_batterie());
             ps.setString(6,v.getCouleur());
              ps.setString(7,v.getType_vehicule());
              ps.setFloat(8,v.getPrix());
              
             ps.executeUpdate();          
           
        } catch (Exception e) {
            System.out.println(e);
          
        }                     
    }
    

        public void Supprimer_Vehicule(int id) {
          try {
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("delete from vehicule where id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception ex) {
              System.out.println(ex);
        }
    }
    
   
        public ObservableList<Vehicule> afficher_vehicule() 
     {
        ObservableList<Vehicule> data=FXCollections.observableArrayList();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from vehicule");
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                //index de  column
            data.add(new Vehicule(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getFloat(8)));
            }
            
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        ;
             return data;
     }
        
            public void modifier_vehicule(Vehicule v) {
        
         String requete = "update vehicule set marque=? ,vitesse_max=?,charge_maxsupp=?,auto_batterie=?,couleur=?,type_vehicule=?, prix=? where id=?";
                     try {
                      
             PreparedStatement ps= MyConnection.getInstance().getCnx().prepareStatement(requete);
             
            
             ps.setString(1,v.getMarque());
            
             ps.setString(2,v.getVitesse_max());
             ps.setFloat(3,v.getCharge_max());
             ps.setString(4,v.getAuto_batterie());
             ps.setString(5,v.getCouleur());
              ps.setString(6,v.getType_vehicule());
               ps.setFloat(7,v.getPrix());
               ps.setInt(8,v.getId());
             ps.executeUpdate();          
           
        } catch (Exception e) {
            System.out.println(e);
          
        }                     
    }
        public ObservableList<String> GetAllIdUser() {
        ObservableList<String> data=FXCollections.observableArrayList();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id from vehicule");
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
            data.add(rs.getString(1));
            }
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        ;
         return data;
    }

        
     public Vehicule GetUserById(int id) {
        Vehicule v=new Vehicule();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from vehicule where id=?");
          ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
         while (rs.next())
         {
           v.setId(rs.getInt(1));
           v.setMarque(rs.getString(2));
           v.setVitesse_max(rs.getString(3));
           v.setCharge_max(rs.getFloat(4));
           v.setAuto_batterie(rs.getString(5));
           v.setCouleur(rs.getString(6));
           v.setType_vehicule(rs.getString(7));
           v.setPrix(rs.getFloat(8));
         }
            
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        ;
         return v;
    }
     
     


}



