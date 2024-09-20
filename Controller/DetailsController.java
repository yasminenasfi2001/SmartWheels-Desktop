/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import entities.Evenement;
import entities.Sponsor;
import utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class DetailsController implements Initializable {

    @FXML
    private TableView<Sponsor> TABSP;
    @FXML
    private TableColumn<Sponsor, String> NSP;
    @FXML
    private TableColumn<Sponsor, String> TELSP;
    @FXML
    private TableColumn<Sponsor, String> EMAILSP;
    @FXML
    private Label NBVUES;
    @FXML
    public ImageView vueimage;
    @FXML
    private Label LABELID;
    @FXML
    public Label DUREE;
    @FXML
    private Button retourID;
    public ObservableList<Sponsor> data1=FXCollections.observableArrayList();
        /*public ObservableList<Utilisateur> data=FXCollections.observableArrayList();
*/
    @FXML
    private Label labeldatedeb;
    @FXML
    private Label labeldatefin;
    @FXML
    private TableColumn<?, ?> np;
    @FXML
    private TableColumn<?, ?> pp;

    
    public Label getNBVUES() {
        return NBVUES;
        // TODO
    }    

    public Label getLABELID() {
        return LABELID;
    }

    /**
     * Initializes the controller class.
     */
    public Label getDUREE() {    
        return DUREE;
    }

    public void setNBVUES(String NBVUES) {
        this.NBVUES.setText(NBVUES);
    }

    public void setLABELID(String LABELID) {
        this.LABELID.setText(LABELID);
    }

    public void setDUREE(String DUREE) {
        this.DUREE.setText( DUREE);
    }

    public void setNBVUES(Label NBVUES) {
        this.NBVUES = NBVUES;
    }

    public void setLABELID(Label LABELID) {
        this.LABELID = LABELID;
    }

    public void setLabeldatedeb(String labeldatedeb) {
        this.labeldatedeb.setText(labeldatedeb);
    }

    public void setLabeldatefin(String labeldatefin) {
        this.labeldatefin.setText(labeldatefin);
    }

    public void miaaw(){
         
        LocalDate aa=LocalDate.parse(labeldatedeb.getText());
        LocalDate to =LocalDate.parse(labeldatefin.getText());
        Period period = Period.between(aa, to);
        DUREE.setText(period.getYears() + " année(s),"+period.getMonths() + " moi(s),"+period.getDays() + " jour(s)");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retourclient(ActionEvent event) {
        
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/edu/TransportYasmine/gui/InterfaceClient.fxml"));
            Parent root = loader.load();
            retourID.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
        
          public void affichersponsorparevent(){
          try {
             
              int var1=Integer.parseInt(LABELID.getText());  
            String requete = "SELECT * FROM sponsor  INNER JOIN evenement_sponsor ON evenement_sponsor.ID_sponsor=sponsor.ID_sponsor INNER JOIN evenement ON " +var1 + "=evenement_sponsor.ID_event WHERE evenement.ID_event= "+var1;
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
      data1.add(new Sponsor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5)));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
             NSP.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Nom_sponsor"));
                 TELSP.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Tel_sponsor"));
               EMAILSP.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Email_sponsor"));
               
                 TABSP.setItems(data1);
          
          
      }
          
          
        /*   public void afficherparticipants(){
          try {
             
              int var1=Integer.parseInt(LABELID.getText());  
            String requete = "SELECT * FROM utilisateur  INNER JOIN use_event ON user_event.id=utilisateur.id INNER JOIN evenement ON " +var1 + "=user_event.ID_event WHERE evenement.ID_event= "+var1;
            Statement st = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
      data.(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
            }

            
            System.out.println(data);

          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
             
             np.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("nom"));
             pp.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("prenom"));
               
                 tablepar.setItems(data);
          
          
      }
          /* public void ajouterParticipant(int idEvent, int idUtilisateur) {
    try {
        Connection conn = Myconnection.getInstance().getCnx();
        
        PreparedStatement stCheck = conn.prepareStatement("SELECT nb_places FROM evenement WHERE id = ?");
        stCheck.setInt(1, idEvent);
        ResultSet rsCheck = stCheck.executeQuery();
        if (rsCheck.next() && rsCheck.getInt("nb_places") <= 0) {
            System.out.println("L'événement n'a plus de places disponibles.");
            
        
        
        PreparedStatement stInsert = conn.prepareStatement("INSERT INTO user_event (id, ID_event) VALUES (?, ?)");
        stInsert.setInt(1, idUtilisateur);
        stInsert.setInt(2, idEvent);
        stInsert.executeUpdate();
          }
        PreparedStatement stUpdate = conn.prepareStatement("UPDATE evenement SET nb_places = nb_places - 1 WHERE ID_event= ?");
        stUpdate.setInt(1, idEvent);
        stUpdate.executeUpdate();
        
        System.out.println("Le participant a été ajouté avec succès !");
    } catch (SQLException ex) {
        System.out.println("Erreur lors de l'ajout du participant : " + ex.getMessage());
    }
}
          */
         
    }
    

