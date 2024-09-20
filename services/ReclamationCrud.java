/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ReclamationCrud {
    Connection cnx;
    public ReclamationCrud() {
        cnx =MyConnection.getInstance().getCnx();
    }
     public void ajouterEntitee(Reclamation t) {
        try {
            String requete = "INSERT INTO reclamation(Nom, Prenom,Adresse,Contenu, `dateCreation`)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx
                                    .prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
             pst.setString(3, t.getAdresse());
            pst.setString(4, t.getContenu());
            pst.setDate(5, new Date(System.currentTimeMillis()));
            pst.executeUpdate();
            System.out.println("Done!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
public void supprimerReclamation(int id){
        try {
            String query ="DELETE FROM `reclamation` WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void updateReclamation(int id,Reclamation R){
    try {
            String query ="UPDATE `reclamation` SET `Nom`='"+R.getNom()+"',`Prenom`='"+R.getPrenom()+"',`Adresse`='"+R.getAdresse()+"',`Contenu`='"+R.getContenu()+"',`dateCreation`='"+new Date(System.currentTimeMillis())+"' WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    

    public List<Reclamation> listeDesReclamations() {
         List<Reclamation> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reclamation";
            Statement st = cnx
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Reclamation p = new Reclamation();
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("Nom"));
                p.setPrenom(rs.getString("Prenom"));
                p.setAdresse(rs.getString("Adresse"));
                p.setContenu(rs.getString("Contenu"));
                p.setDateCreation(rs.getDate("dateCreation"));
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    
<<<<<<< HEAD:services/ReclamationCrud.java
<<<<<<< HEAD:services/ReclamationCrud.java
    public List<Reclamation> listeDesReclamations(int id) {
         List<Reclamation> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reclamation where id_c=?;";
            
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(requete);
            ps.setInt(1,id);          
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Reclamation p = new Reclamation();
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("Nom"));
                p.setPrenom(rs.getString("Prenom"));
                p.setAdresse(rs.getString("Adresse"));
                p.setContenu(rs.getString("Contenu"));
                p.setDateCreation(rs.getDate("dateCreation"));
                myList.add(p);
            }
         
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    
=======
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/services/ReclamationCrud.java
=======
>>>>>>> master:src/services/ReclamationCrud.java
    public boolean contentExist(Reclamation r){
        for(Reclamation rr:listeDesReclamations()){
            if(rr.getAdresse().equals(r.getAdresse())&& rr.getContenu().equals(r.getContenu())&& rr.getNom().equals(r.getNom())&&rr.getPrenom().equals(r.getPrenom())){
                return true;
            }
        }
        return false;
    }
    
}
