/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Evenement;
import utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
/**
 *
 * @author DELL
 */
public class EvenementCRUD {
    
    
     public void ajouterEvenement(Evenement t) {
        try {           
            String requete = "INSERT INTO evenement(Nom_event,Date_debut,Date_fin, Lieu_event, Nb_places, Type_event, Nb_vues)"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, t.getNom_event());
            pst.setObject(2,java.sql.Date.valueOf(t.getDate_debut()));
            pst.setObject(3,java.sql.Date.valueOf(t.getDate_fin()));
            pst.setString(4, t.getLieu_event());
            pst.setInt(5, t.getNb_places());
            pst.setString(6,t.getType_event());
            pst.setInt(7, t.getNb_vues());
            pst.executeUpdate();
            System.out.println("Done!");
            } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            }
    }
    
     
    public List<Evenement> AfficherlisteDesEvenements() {
         List<Evenement> ListEvent = new ArrayList<>();
        try {
            String requete = "SELECT * FROM evenement";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Evenement e = new Evenement();
                e.setID_event(rs.getInt(1));
                e.setNom_event(rs.getString(2));
                e.setDate_debut(rs.getDate(3).toLocalDate());
                e.setDate_fin(rs.getDate(4).toLocalDate());
                e.setLieu_event(rs.getString(5));
                e.setNb_places(rs.getInt(6));
                e.setType_event(rs.getString(7));
                e.setNb_vues(rs.getInt(8));
                ListEvent.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ListEvent;
    }
    public void modifierEvenement (Evenement eve, String x, LocalDate y, LocalDate z, String w, int a, String b, int c ) {
         try{
  String requete="update evenement set Nom_event=?, Date_debut=?,Date_fin=?, Lieu_event=?, Nb_places=?, Type_event=?, Nb_vues=? where ID_event="+eve.getID_event()+"";
       
          PreparedStatement pst = MyConnection.getInstance().getCnx()
                                    .prepareStatement(requete);
        pst.setString(1,eve.getNom_event());
        pst.setObject(2,eve.getDate_debut());
        pst.setObject(3,eve.getDate_fin());
        pst.setString(4,eve.getLieu_event());
        pst.setInt(5,eve.getNb_places());
        pst.setString(6, eve.getType_event());
        pst.setInt(7,eve.getNb_vues());

        pst.executeUpdate();
        System.out.println("Modification faite avec succés !");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void SupprimerEvenement(Evenement ev) {
    try {
        String requete = "DELETE FROM evenement WHERE evenement.ID_event ="+ev.getID_event()+"";
        Statement st = MyConnection.getInstance().getCnx().createStatement();
        st.executeUpdate(requete);
        System.out.println("suppression de l'evenement effectuée !");
    } catch (SQLException e) {
    System.out.println(e.getMessage());
    }
} 
}
