/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Evenement;
import entities.Sponsor;
import utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SponsorCRUD {
     public void ajouterSponsor(Sponsor t) {
        try {
            String requete = "INSERT INTO sponsor(Nom_sponsor,Tel_sponsor, Email_sponsor, Montant )"
                    + "VALUES (?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                                    .prepareStatement(requete);
            pst.setString(1, t.getNom_sponsor());
            pst.setString(2,  t.getTel_sponsor());
            pst.setString(3, t.getEmail_sponsor());
            pst.setFloat(4, t.getMontant());
            pst.executeUpdate();
            System.out.println("Done!");
            } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            }
    }
     public List<Sponsor> AfficherlisteDesSponsors() {
         List<Sponsor> Listsponsor = new ArrayList<>();
        try {
            String requete = "SELECT * FROM sponsor";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Sponsor s = new Sponsor();
                s.setID_sponsor(rs.getInt(1));
                s.setNom_sponsor(rs.getString(2));
                s.setTel_sponsor(rs.getString(3));
                 s.setEmail_sponsor(rs.getString(4));
                s.setMontant(rs.getFloat(5));
      
                Listsponsor.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Listsponsor;
    }
    
public void modifierSponsor(Sponsor spn, String x, String y, String z, float w )
    {

       try {
        String requete="update sponsor set Nom_sponsor=?,Tel_sponsor=?,Email_sponsor=? ,Montant=? where ID_sponsor="+spn.getID_sponsor()+"";
        PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
        pst.setString(1,spn.getNom_sponsor());
        pst.setString(2,spn.getTel_sponsor());
        pst.setString(3,spn.getEmail_sponsor());
        pst.setFloat(4,spn.getMontant());
        
         
         
        pst.executeUpdate();
        }
        catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
    }

   
    public void SupprimerSponsor(Sponsor sp) {
    try {
        String requete = "DELETE FROM sponsor WHERE sponsor.ID_sponsor ="+sp.getID_sponsor()+"";
        Statement st = MyConnection.getInstance().getCnx().createStatement();
        st.executeUpdate(requete);
        System.out.println("suppression du sponsor effectuée");
    } 
catch (SQLException ex) {
    System.out.println(ex.getMessage());
    }
}}
