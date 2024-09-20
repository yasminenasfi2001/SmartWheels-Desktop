/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import static Controller.GestionDesReservationsController.LOCAL_DATE;
import entities.Reservation;
import entities.Vehicule;
import interfaces.ReservationCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import utils.MyConnection;

/**
 *
 * @author user
 */
public class Reservation_Service {
    
    
    
    
    public float calculmontant(String dateD, String dateF)
    {
        
        
       int dd=Integer.parseInt(dateD.substring(8,10));
        int df=Integer.parseInt(dateF.substring(8,10));
        float montant=10;
        
          
    return (df-dd)*montant;
    
    }
    
public void ajouter_reservation(Reservation r)
        
{
         String requete = "insert into reservation values(?,?,?,?,?,?)";
                     try {
                      
             PreparedStatement ps= MyConnection.getInstance().getCnx().prepareStatement(requete);
   
          
            ps.setInt(1,0);
             ps.setString(2,r.getDate_debut()  );
             ps.setString(3,r.getDate_fin()  );
           
             ps.setFloat(4,calculmontant(r.getDate_debut(),r.getDate_fin()));
             ps.setInt(5,r.getId_v());
             ps.setInt(6, r.getId_client());
              
             ps.executeUpdate();          
           
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("cette vehicule a été déja réserver!");
        alert.showAndWait();
          
        }    


}






 public ObservableList<String> GetAllIdUser() {
        ObservableList<String> data=FXCollections.observableArrayList();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id_res from reservation");
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
 
      public Reservation GetUserById(int id) {
        Reservation r= new Reservation();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from reservation where id_res=?");
          ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
         while (rs.next())
         {
           r.setId_res(rs.getInt(1));
           r.setDate_debut(rs.getString(2));
           r.setDate_fin(rs.getString(3));
          
        
            
        }
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        ;
         return r;
    
    
        
      } 
      
      
              public ObservableList<Reservation> afficher_reservation() 
     {
        ObservableList<Reservation> data=FXCollections.observableArrayList();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from reservation");
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                //index de  column
            data.add(new Reservation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6)));
                
           }
            
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        
             return data;
     }
              
              
              
               public void modifier_reservation(Reservation r) {
        
         String requete = "update reservation set date_debut=? ,date_fin=?,montant=? where id_res=?";
                     try {
                      
             PreparedStatement ps= MyConnection.getInstance().getCnx().prepareStatement(requete);
             
            
             ps.setString(1,r.getDate_debut());
            
             ps.setString(2,r.getDate_fin());
            
              ps.setFloat(3,this.calculmontant(r.getDate_debut(), r.getDate_fin()));
              ps.setInt(4,r.getId_res());
              
             ps.executeUpdate();          
          
        } catch (Exception e) {
            System.out.println(e);
          
        }                     
    }
               
               
               
               
               public void Supprimer_reservation(int id_res) {
          try {
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("delete from reservation where id_res=?");
            ps.setInt(1,id_res);
            ps.executeUpdate();
        } catch (Exception ex) {
              System.out.println(ex);
        }
    }
               
               
               
               
                          public ObservableList<Reservation> GetInfoBasedOnYear(String date) 
     {
        ObservableList<Reservation> data=FXCollections.observableArrayList();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from reservation where date=TO_DATE(?, 'YYYY-MM-DD')");
        ps.setString(1, date);
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                //index de  column
            data.add(new Reservation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6)));
                
           }
            
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        
             return data;
     }
}
