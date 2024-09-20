/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:services/Carte_fideliteS.java
package services;
=======
<<<<<<< HEAD
package services;
=======
package projet_transport.services;
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.print.DocFlavor;
<<<<<<< HEAD:services/Carte_fideliteS.java
=======
<<<<<<< HEAD
import Controller.Gestion_UtilisateurController;
>>>>>>> master:src/services/Carte_fideliteS.java
import interfaces.interfaceCarte;
import entities.Carte_fidelite;
import entities.Utilisateur;
import utils.MyConnection;
<<<<<<< HEAD:services/Carte_fideliteS.java
=======
=======
import projet_transport.controler.Gestion_UtilisateurController;
import projet_transport.interfaces.interfaceCarte;
import projet_transport.model.Carte_fidelite;
import projet_transport.model.Utilisateur;
import projet_transport.utils.MyConnexion;
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java

/**
 *
 * @author aziz
 */
public class Carte_fideliteS implements interfaceCarte<Carte_fidelite>{
     public void ajouter(Carte_fidelite c)
    {
        try {      
        String sql="insert into carte_fidelite (id,points) values (?,?)";
<<<<<<< HEAD:services/Carte_fideliteS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement(sql);
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java
        ps.setInt(1,c.getId());
        ps.setInt(2,c.getPoints());
        ps.execute();       
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
     
      public void modifier(Carte_fidelite c)
    {
       try {
        String sql="update carte_fidelite set points=? where id=?;";
<<<<<<< HEAD:services/Carte_fideliteS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement(sql);
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java
        ps.setInt(1,c.getPoints());
        ps.setInt(2,c.getId());
        ps.execute();
        }
        catch (Exception ex) {
        System.out.println(ex);
        }
        }
    public void Supprimer(int id) {
          try {
<<<<<<< HEAD:services/Carte_fideliteS.java
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("delete from carte_fidelite where id=?");
=======
<<<<<<< HEAD
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("delete from carte_fidelite where id=?");
=======
            PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("delete from carte_fidelite where id=?");
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Utilisateur_gestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<Carte_fidelite> afficher() {
     
        ObservableList<Carte_fidelite> data=FXCollections.observableArrayList();
        try
        {
<<<<<<< HEAD:services/Carte_fideliteS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from carte_fidelite");
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from carte_fidelite");
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select * from carte_fidelite");
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
            data.add(new Carte_fidelite(rs.getInt(1),rs.getInt(2)));
            }
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        ;
         return data;
     }    

    @Override
    public ObservableList<String> GetAllIdUser() {
        ObservableList<String> data=FXCollections.observableArrayList();
        try
        {
<<<<<<< HEAD:services/Carte_fideliteS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id from utilisateur");
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id from utilisateur");
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select id from utilisateur");
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java
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
    
    
    public ObservableList<String> GetAllIdCarte() {
        ObservableList<String> data=FXCollections.observableArrayList();
        try
        {
<<<<<<< HEAD:services/Carte_fideliteS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id from carte_fidelite");
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id from carte_fidelite");
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select id from carte_fidelite");
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java
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
    
    public boolean CheckCarteById(int id) {
        ObservableList<String> data=FXCollections.observableArrayList();
        try
        {
<<<<<<< HEAD:services/Carte_fideliteS.java
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id from carte_fidelite where id=?");
=======
<<<<<<< HEAD
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id from carte_fidelite where id=?");
=======
        PreparedStatement ps=MyConnexion.getInstance().getCnx().prepareStatement("select id from carte_fidelite where id=?");
>>>>>>> master
>>>>>>> master:src/services/Carte_fideliteS.java
        ps.setInt(1, id);
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
         return data.contains(String.valueOf(id));
    }
        public  Carte_fidelite getCarteById(int id) {
        ObservableList<Carte_fidelite> data=FXCollections.observableArrayList();
        try
        {
      
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from carte_fidelite where id=?");
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
            if (rs.next())
            {
            
           return new Carte_fidelite(rs.getInt(1),rs.getInt(2));
            }
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        ;
         return new Carte_fidelite();
    }
        public void ajoutClientToCarte()
   {
       int id_client=0;
       int id_commentaire=0;
       Carte_fidelite c=new Carte_fidelite();
       Carte_fideliteS cartes=new Carte_fideliteS();
       Utilisateur client=new Utilisateur();
       UtilisateurS cs=new UtilisateurS();
         try{
             
          PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("SELECT id_c, COUNT(*) as nb_lignes FROM commentaire GROUP BY id_c;");
          ResultSet rs=ps.executeQuery();
          while (rs.next())
          {
              id_client=rs.getInt(1);
              id_commentaire=rs.getInt(2);
              
              c=cartes.getCarteById(id_client);
           
              System.out.println(c.getId()+"|"+id_commentaire);
              if (c.getId()==-1 &&  id_commentaire%2==0)
              {
                   System.out.println("id"+id_client);
                  c.setId(id_client);
                  c.setPoints(10);
                  cartes.ajouter(c);
                    
                 
              }
              else 
                   {
                  c.setId(id_client);
                  c.setPoints(c.getPoints()+10);
                  cartes.modifier(c);
                   }
     
          }
         
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
       
   }

}
