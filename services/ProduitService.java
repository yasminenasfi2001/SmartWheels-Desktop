package services;


import entities.Produit;
import utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.TableView;

/**
 *
 * @author aziz
 */
public class ProduitService implements IService<Produit>{
    @FXML private TableView<Produit> tabprod;


 
    
     public void ajouter(Produit c)
    {
        try {      
        String sql="insert into produits (id_prod,nom_prod,type_prod,quant_prod,prix_prod,desc_prod,image_url) values (?,?,?,?,?,?,?)";
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
        ps.setInt(1,c.getId_prod());
        ps.setString(2,c.getNom_prod());
        ps.setString(3,c.getType_prod());
        ps.setInt(4,c.getQuant_prod());
        ps.setFloat(5,c.getPrix_prod());
        ps.setString(6,c.getDesc_prod());
        ps.setString(7,c.getImage_url());
     
        ps.execute();       
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

   
     public ObservableList<Produit> afficher() 
     {
        ObservableList<Produit> data=FXCollections.observableArrayList();
        try
        {
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from produits");
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
            data.add(new Produit(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getString(6),rs.getString(7)));
            }
        }
        catch(SQLException ex)
        {
        System.out.println(ex);
        }
        ;
             return data;
     }
   
     public void modifier(Produit c,int id)
    {
       try {
        String sql="update produits set nom_prod=?,type_prod=?,quant_prod=?,prix_prod=?,desc_prod=?,image_url=? where id_prod=?;";
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement(sql);
   
        ps.setString(1,c.getNom_prod());
        ps.setString(2,c.getType_prod());
        ps.setInt(3,c.getQuant_prod());
        ps.setFloat(4,c.getPrix_prod());
        ps.setString(5,c.getDesc_prod());
        ps.setString(6,c.getImage_url());
         ps.setInt(7,id);
        ps.execute();
        }
        catch (SQLException ex) {
        System.out.println(ex);
        }
    }
     
    public ArrayList getAllId() {
        ArrayList data=new ArrayList();      
        try{
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select id_prod from produits");
        ResultSet rs=ps.executeQuery();
            while (rs.next())
            {   
            data.add(rs.getInt(1));
            }
        }
        catch(SQLException ex)
        {
        System.out.println(ex);
        }
        return data;
    }

    @SuppressWarnings("empty-statement")
    public Map<String, String> getUserById(String id) {
        
          Map <String,String> data =new HashMap<>();
         try{
          PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from produits where id_prod=?");
          ps.setString(1, id);
          ResultSet rs=ps.executeQuery();
          while (rs.next())
          {
              data.put("nom_prod",rs.getString(2));
              data.put("type_prod",rs.getString(3));
              data.put("quant_prod",rs.getString(4));
              data.put("prix_prod",rs.getString(5));
              data.put("desc_prod",rs.getString(6));
              data.put("image_url",rs.getString(7));
       
           
          }
         }
         catch(SQLException ex)
         {
             System.out.println(ex);
         }
         ;
         return data;
    }

    public void Supprimer(int id) {
         
        try {
            PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("delete from produits where id_prod=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    public void supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
