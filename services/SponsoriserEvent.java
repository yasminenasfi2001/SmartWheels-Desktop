/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entities.Sponsorisation;
import entities.Evenement;
import entities.Sponsor;
import utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class SponsoriserEvent {
   
    
    
    // Insert a new sponsor for an event
    public void ajouterSponsorpourevent(Sponsorisation spn) {
        try {
            String requete = "INSERT INTO evenement_sponsor (ID_event, ID_sponsor) VALUES (?, ?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, spn.getEvenement().getID_event());
            pst.setInt(2,  spn.getSponsor().getID_sponsor());
            pst.executeUpdate();
            System.out.println("Done!");
            } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            }
    }
    
    public ObservableList affichersponsorsparevent() 
        {
            ObservableList<Evenement> eventsparsponsor = FXCollections.observableArrayList();
            try {
    String requete = "SELECT * FROM evenement  INNER JOIN evenement_sponsor ON evenement_sponsor.ID_event=evenement.ID_event INNER JOIN sponsor ON sponsor.ID_sponsor=evenement_sponsor.ID_sponsor WHERE sponsor.ID_sponsor=138";
        Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
    
        while (rs.next()) {
            Evenement ev= new  Evenement();
                ev.setID_event(rs.getInt(1));
                ev.setNom_event(rs.getString(2));
                ev.setDate_debut(rs.getDate(3).toLocalDate());
                ev.setDate_fin(rs.getDate(4).toLocalDate());
                ev.setLieu_event(rs.getString(5));
                ev.setNb_places(rs.getInt(6));
                ev.setType_event(rs.getString(7));
                ev.setNb_vues(rs.getInt(8));
                eventsparsponsor.add(ev);
         
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return eventsparsponsor;
}
    
         public ObservableList affichereventparsponsor() {
        {
            ObservableList<Sponsor> sponsorparevent = FXCollections.observableArrayList();
            try {
    String requete = "SELECT * FROM sponsor  INNER JOIN evenement_sponsor ON evenement_sponsor.ID_sponsor=sponsor.ID_sponsor INNER JOIN evenement ON evenement.ID_evenement=evenement_sponsor.ID_evenement WHERE evenement.ID_evenement=36";
        Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
    
        while (rs.next()) {
        Sponsor sponsor = new Sponsor();
            sponsor.setID_sponsor(rs.getInt(1));
            sponsor.setNom_sponsor(rs.getString(2));
            sponsor.setTel_sponsor(rs.getString(3));
            sponsor.setEmail_sponsor(rs.getString(4));
            sponsor.setMontant(rs.getFloat(5));

            sponsorparevent.add(sponsor);
        }
        
       } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return sponsorparevent;
} 
        
        
        
    }
    






}
    


