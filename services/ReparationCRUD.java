/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entities.Employee;
import entities.Reparation;
import interfaces.InterfaceCRUD;
import interfaces.InterfaceCRUDY;
import utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author yosra
 */

    public class ReparationCRUD implements InterfaceCRUDY<Reparation>{

    /*@Override
    public void ajouterEntitee(Personne t) {
        try{
        String requte="INSERT INTO personne(nom,prenom)"
                + "VALUES ('"+t.getNom()+"','"+t.getPrenom()+"')";
        Statement st=new MyConnection().getCnx().createStatement();
        st.executeUpdate(requte);
        System.out.println("done");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }*/
    @Override
    public void ajouterEntitee(Reparation r) {
        try{
        String requte="INSERT INTO Reparation(Description_panne,Etat,Date_rep,Date_manu,Date_defect)"
                + "VALUES (?,?,?,?,?)";
        PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requte); 
        
        pst.setString(1,r.getDescription_panne());
        pst.setString(2,r.getEtat());
        pst.setDate(3,java.sql.Date.valueOf(r.getDate_rep()));
        pst.setDate(4,java.sql.Date.valueOf(r.getDate_manu()));
        pst.setDate(5,java.sql.Date.valueOf(r.getDate_defect()));
        
        pst.executeUpdate();
        System.out.println("Done");
        }
        catch(SQLException ex){
           
        
}
    }
    @Override
    public List<Reparation> listeDesEntites() {
     List<Reparation> myList= new ArrayList<>();
        try{
     
     String requete = "SELECT * FROM Reparation";
     Statement st = MyConnection.getInstance().getCnx().createStatement();
     ResultSet rs = st.executeQuery(requete);
     while(rs.next()){
         Reparation r = new Reparation();
         r.setId_v(rs.getInt("1"));
         r.setDescription_panne(rs.getString("Description_panne"));
         r.setEtat(rs.getString("Etat"));
         r.setDate_rep(rs.getDate("Date_rep").toLocalDate());
         r.setDate_manu(rs.getDate("Date_manu").toLocalDate());
         r.setDate_defect(rs.getDate("Datedefect").toLocalDate());
         r.setId_employee(rs.getInt("Id_employee")); 
         myList.add(r);
     }
    }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return myList;
        
    }
    public void supprimer(int id ) {
        String query = "DELETE FROM Reparation WHERE Reparation.id = " + id + "";
        try{
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(query);
            System.out.println("Article Deleted Successfully");
        }
        catch (SQLException r){
            System.out.println(r.getMessage());
        }
    }

    public ObservableList<Reparation> afficher() 
     {
        ObservableList<Reparation> data=FXCollections.observableArrayList();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from Reparation");
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                Reparation r = new Reparation();
         r.setId(rs.getInt("id"));
         r.setDescription_panne(rs.getString("Description_panne"));
         r.setEtat(rs.getString("Etat"));
         r.setDate_rep(rs.getDate("Date_rep").toLocalDate());
         r.setDate_manu(rs.getDate("Date_manu").toLocalDate());
         r.setDate_defect(rs.getDate("Date_defect").toLocalDate());
         r.setId_employee(rs.getInt("id_employe")); 
         r.setId_v(rs.getInt("id_v")); 
            data.add(r);
            }
        }
        catch(Exception ex)
        {
        System.out.println(ex);
        }
        ;
             return data;
     }
    public void modifier(Reparation r)
    {
      
       try {
        String sql="update Reparation set Description_panne=?,Etat=?,Date_rep=?,Date_manu=?,Date_defect=? where id=?;";
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
        ps.setString(1,r.getDescription_panne());
        ps.setString(2,r.getEtat());
        ps.setDate(3,java.sql.Date.valueOf(r.getDate_rep()));
        ps.setDate(4,java.sql.Date.valueOf(r.getDate_manu()));
        ps.setDate(5,java.sql.Date.valueOf(r.getDate_defect()));
        ps.setInt(6,(r.getId()));
        ps.execute();
        }
        catch (Exception ex) {
        System.out.println(ex);
        }
    }
    
    public void setEtatReparable(Reparation e){
         try {
        String sql="update Reparation set Etat='Repare' where id=?;";
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql); 
       ps.setInt(1,(e.getId()));
        ps.execute();
        }
        catch (Exception ex) {
        System.out.println(ex);
        
         
    }
 }
    }
