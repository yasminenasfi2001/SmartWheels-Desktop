/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import static Controller.Utilisateur_gestionController.l_email;
import entities.Sponsor;
import entities.Utilisateur;
import utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.UtilisateurS;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class SponsorController implements Initializable {

    @FXML
    private Button quitter;
    @FXML
    private TableColumn<Sponsor, Integer> id_s;
    @FXML
    private TableColumn<Sponsor, String> nom_s;
    @FXML
    private TableColumn<Sponsor, String> tel_s;
    @FXML
    private TableColumn<Sponsor, String> email_s;
    @FXML
    private TableColumn<Sponsor, Float> montant_s;
    @FXML
    private ComboBox<Sponsor> c1;
    @FXML
    private Label IDEVENT;
    @FXML
    private Label DATEDEBUT;
    @FXML
    private Label DATEFIN;
    @FXML
    private Label LIEUEVENT;
    @FXML
    private Label TYPES;
    @FXML
    private Label nbvues;
    @FXML
    private Label NBPLACES;
    @FXML
    private Label NOMEVENT;
    public ObservableList<Sponsor> data=FXCollections.observableArrayList();
    public ObservableList<Sponsor> data1=FXCollections.observableArrayList();
    @FXML
    private TableView<Sponsor> tablo;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane left;
    @FXML
    private VBox vboxid;
    @FXML
    private Button Evenement;
    @FXML
    private Button id_rec;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private Label l_prenom;
    @FXML
    private Label l_nom;
    /**
     * Initializes the controller class.
     */
   
    public void SetTable()
    {
        
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
        vboxid.setSpacing(18);
       listesp();
       tablo.setRowFactory(new Callback<TableView<Sponsor>, TableRow<Sponsor>>() {
    
    @Override
    public TableRow<Sponsor> call(TableView<Sponsor> tableView) {
        return new TableRow<Sponsor>() {
            @Override
            protected void updateItem(Sponsor sponsor, boolean empty) {
               super.updateItem(sponsor, empty);
               /* if (sponsor == null) {*/
                    setStyle("-fx-background-color: #C39BD3 ;");
                }
                
        };               
        }
        }  );
    }   
     public void affichersponsorparevent(){
          try {
             
              int var1=Integer.parseInt(IDEVENT.getText());  
            String requete = "SELECT * FROM sponsor  INNER JOIN evenement_sponsor ON evenement_sponsor.ID_sponsor=sponsor.ID_sponsor INNER JOIN evenement ON " +var1 + "=evenement_sponsor.ID_event WHERE evenement.ID_event= "+var1;
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
      data.add(new Sponsor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5)));

            }
            System.out.println(data);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
             id_s.setCellValueFactory(new PropertyValueFactory<Sponsor,Integer>("ID_sponsor")); 
             nom_s.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Nom_sponsor"));
                 tel_s.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Tel_sponsor"));
               email_s.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Email_sponsor"));
                montant_s.setCellValueFactory(new PropertyValueFactory<Sponsor,Float>("Montant"));
                 tablo.setItems(data);
          
          
      }
     public Label getIDEVENT() {
        return IDEVENT;
    }

    public Label getNOMEVENT() {
        return NOMEVENT;
    }

    public Label getDATEDEBUT() {
        return DATEDEBUT;
    }

    public Label getDATEFIN() {
        return DATEFIN;
    }

    public Label getLIEUEVENT() {
        return LIEUEVENT;
    }

    public Label getNBPLACES() {
        return NBPLACES;
    }

    public Label getTYPES() {
        return TYPES;
    }

    public Label getNbvues() {
        return nbvues;
    }

    public void setIDEVENT(String IDEVENT) {
        this.IDEVENT.setText(IDEVENT);
    }

    public void setNOMEVENT(String NOMEVENT) {
        this.NOMEVENT.setText(NOMEVENT);
    }

    public void setDATEDEBUT(String DATEDEBUT) {
        this.DATEDEBUT.setText(DATEDEBUT);
    }

    public void setDATEFIN(String DATEFIN) {
        this.DATEFIN.setText(DATEFIN);
    }

    public void setLIEUEVENT(String LIEUEVENT) {
        this.LIEUEVENT.setText(LIEUEVENT);
    }

    public void setNBPLACES(String NBPLACES) {
        this.NBPLACES.setText(NBPLACES);
    }

    public void setTYPES(String TYPES) {
        this.TYPES.setText(TYPES);
    }

    public void setNbvues(String nbvues) {
        this.nbvues.setText(nbvues);
    }
    @FXML
    private void retour(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/gui/InterfaceAdmin.fxml"));
            Parent root = loader.load();
            quitter.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ajoutersponsoraevent(ActionEvent event) {
         try{
        Sponsor s;
        s= c1.getSelectionModel().getSelectedItem();
        int var1=Integer.parseInt(IDEVENT.getText());
        String requte="INSERT INTO evenement_sponsor(ID_event,ID_sponsor)"
                + "VALUES (?,?)";
        PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requte);
        pst.setInt(1,var1);
        pst.setInt(2,s.getID_sponsor());

        pst.executeUpdate();

        System.out.println("Done");
        tablo.getItems().clear();
        affichersponsorparevent();
        c1.getSelectionModel().clearSelection();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void listesp(){
          try {
            String requete="SELECT * FROM sponsor"; 
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
         data1.add(new Sponsor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5)));
            }
            System.out.println(data1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
            
    c1.setItems(data1);
    
  
}

    @FXML
    private void Utilisateur(ActionEvent event) {
    }

    @FXML
    private void Reservation(ActionEvent event) {
    }

    @FXML
    private void Produits(ActionEvent event) {
    }

    @FXML
    private void Vehicule(ActionEvent event) {
    }

    @FXML
    private void Evenement(ActionEvent event) {
    }

    @FXML
    private void Reparation(ActionEvent event) {
          try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/Reparation.fxml"));  
         Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
        {
            System.out.println("Probleme:"+e);
        }
    }

    @FXML
    private void Reclamation(ActionEvent event) {
         try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLDocument.fxml"));  
         Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
        {
            System.out.println("Probleme:"+e);
        }
    }

    @FXML
    private void dexonnexion(ActionEvent event) {
    }
    
}
