/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:services/UtilisateurS.java
package services;
=======
<<<<<<< HEAD
package services;
=======
package projet_transport.services;
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
<<<<<<< HEAD:services/UtilisateurS.java
import Controller.Utilisateur_gestionController;
import entities.Carte_fidelite;
import interfaces.interfaceClient;
import entities.Utilisateur;
import utils.MyConnection;
=======
<<<<<<< HEAD
import Controller.Gestion_UtilisateurController;
import interfaces.interfaceClient;
import entities.Utilisateur;
import utils.MyConnection;
=======
import projet_transport.controler.Gestion_UtilisateurController;
import projet_transport.interfaces.interfaceClient;
import projet_transport.model.Utilisateur;
import projet_transport.utils.MyConnexion;
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
/**
 *
 * @author aziz
 */
public class UtilisateurS implements interfaceClient<Utilisateur>{
    @FXML private TableView<Utilisateur> affichage;
    @FXML private TableColumn<Utilisateur,String>nom;
    public void inscription(Utilisateur c)
    {
         try {
            String sql="insert into utilisateur (nom,prenom,email,date_naissance,telephone,region,genre,mot_passe) values (?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?,?,?,?)";
<<<<<<< HEAD:services/UtilisateurS.java
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
<<<<<<< HEAD
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
            PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement(sql);
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
            ps.setString(1,c.getNom());
            ps.setString(2,c.getPrenom());
            ps.setString(3,c.getEmail());
            ps.setString(4,c.getDate());
            ps.setInt(5,c.getTelephone());
            ps.setString(6,c.getRegion());
            ps.setString(7,c.getGenre());
            ps.setString(8,c.getMot_passe());
         ps.execute(); 
        } 
        catch (Exception ex) 
        {
        System.out.println(ex);
        }
    }
     public void ajouter(Utilisateur c)
    {
        try {      
        String sql="insert into utilisateur (nom,prenom,email,date_naissance,telephone,region,genre,mot_passe,type) values (?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?,?,?,?,?)";
<<<<<<< HEAD:services/UtilisateurS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement(sql);
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
        ps.setString(1,c.getNom());
        ps.setString(2,c.getPrenom());
        ps.setString(3,c.getEmail());
        ps.setString(4,c.getDate());
        ps.setInt(5,c.getTelephone());
        ps.setString(6,c.getRegion());
        ps.setString(7,c.getGenre());
        ps.setString(8,c.getMot_passe());
        ps.setString(9,c.getType());
        ps.execute();       
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
     public ObservableList<Utilisateur> afficher() 
     {
        ObservableList<Utilisateur> data=FXCollections.observableArrayList();
        try
        {
<<<<<<< HEAD:services/UtilisateurS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur");
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur");
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select * from utilisateur");
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
            data.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
            }
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        ;
             return data;
     }
     public void modifier(Utilisateur c)
    {
       try {
        String sql="update utilisateur set nom=?,prenom=?,email=?,date_naissance=?,telephone=?,region=?,genre=?,mot_passe=?,type=? where id=?;";
<<<<<<< HEAD:services/UtilisateurS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement(sql);
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
        ps.setString(1,c.getNom());
        ps.setString(2,c.getPrenom());
        ps.setString(3,c.getEmail());
        ps.setString(4,c.getDate());
        ps.setInt(5,c.getTelephone());
        ps.setString(6,c.getRegion());
        ps.setString(7,c.getGenre());
        ps.setString(8,c.getMot_passe());
        ps.setString(9,c.getType());
        ps.setInt(10,c.getId());
        ps.execute();
        }
        catch (Exception ex) {
        System.out.println(ex);
        }
    }
     
  
 @Override
    public void Supprimer(int id) {
          try {
<<<<<<< HEAD:services/UtilisateurS.java
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("delete from utilisateur where id=?");
=======
<<<<<<< HEAD
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("delete from utilisateur where id=?");
=======
            PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("delete from utilisateur where id=?");
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Utilisateur_gestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Utilisateur getUserById(String id) {
        
          Utilisateur u=new Utilisateur();
         try{
             
<<<<<<< HEAD:services/UtilisateurS.java
          PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur where id=?");
=======
<<<<<<< HEAD
          PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur where id=?");
=======
          PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select * from utilisateur where id=?");
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
          ps.setString(1, id);
          ResultSet rs=ps.executeQuery();
          while (rs.next())
          {
              u.setNom(rs.getString(2));
              u.setPrenom(rs.getString(3));
              u.setEmail(rs.getString(4));
              u.setDate(rs.getString(5));
              u.setTelephone(rs.getInt(6));
              u.setRegion(rs.getString(7));
              u.setGenre(rs.getString(8));
              u.setMot_passe(rs.getString(9));
             u.setType(rs.getString(10));   
          }
         
         }
         catch(Exception ex)
         {
             System.out.println(ex);
         }
         ;
         return u;
    }

   
    @Override
    public boolean CheckUserByEmail(String email) {
try{
             
<<<<<<< HEAD:services/UtilisateurS.java
          PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur where email=?");
=======
<<<<<<< HEAD
          PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur where email=?");
=======
          PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select * from utilisateur where email=?");
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
          ps.setString(1, email);
          ResultSet rs=ps.executeQuery();
          if (rs.next())
          {
          return true; 
          }
         }
         catch(Exception ex)
         {
             System.out.println(ex);
         }
           return false; 
           }
    
    public boolean CheckUserAdmin(String email) {
        try{       
<<<<<<< HEAD:services/UtilisateurS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select type from utilisateur where email=?");
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select type from utilisateur where email=?");
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select type from utilisateur where email=?");
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
          ps.setString(1, email);
          ResultSet rs=ps.executeQuery();
          if (rs.next())
          {
          return rs.getString(1).equals("Admin"); 
          }
         }
         catch(Exception ex)
         {
             System.out.println(ex);
         }
         return false; 
    
    }
    public boolean CheckAccount(String email,String password) {
        try{       
<<<<<<< HEAD:services/UtilisateurS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur where email=? and mot_passe=?");
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur where email=? and mot_passe=?");
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select * from utilisateur where email=? and mot_passe=?");
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
          ps.setString(1, email);
           ps.setString(2, password);
          ResultSet rs=ps.executeQuery();
          if (rs.next())
          {
          return true; 
          }
         }
         catch(Exception ex)
         {
             System.out.println(ex);
         }
         return false; 
        
    }
    public Utilisateur getUserByEmail(String email) {
        Utilisateur u=new Utilisateur();
         try{       
<<<<<<< HEAD:services/UtilisateurS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur where email=?");
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from utilisateur where email=?");
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select * from utilisateur where email=?");
>>>>>>> master
>>>>>>> master:src/services/UtilisateurS.java
          ps.setString(1, email);
          ResultSet rs=ps.executeQuery();
          rs.next();
          u.setId(rs.getInt(1));
          u.setNom(rs.getString(2));
          u.setPrenom(rs.getString(3));
          u.setEmail(rs.getString(4));
          u.setDate(rs.getString(5));
          u.setTelephone(rs.getInt(6));
          u.setRegion(rs.getString(7));
          u.setGenre(rs.getString(8));
          u.setMot_passe(rs.getString(9));
          u.setType(rs.getString(10));   

         }
         catch(Exception ex)
         {
             System.out.println(ex);
         }
         return u;
        
    }
}
