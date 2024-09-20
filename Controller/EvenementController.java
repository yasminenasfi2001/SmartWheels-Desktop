/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import entities.Evenement;
import utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author DELL
 */

public class EvenementController implements Initializable {

    @FXML
    private TableColumn<Evenement, Integer> id_e;
    @FXML
    private TableColumn<Evenement, String> nom_e;
    @FXML
    private TableColumn<Evenement, LocalDate> datedeb_e;
    @FXML
    private TableColumn<Evenement, LocalDate> datefin_e;
    @FXML
    private TableColumn<Evenement, String> lieu_e;
    @FXML
    private TableColumn<Evenement, Integer> nbplaces_e;
    @FXML
    private TableColumn<Evenement, String> type_e;
        public ObservableList<Evenement> data1=FXCollections.observableArrayList();

    @FXML
    private Label IDSPONSOR;
    @FXML
    private Label NOMSPONSOR;
    @FXML
    private Label TELSPONSOR;
    @FXML
    private Label EMAILSPONSOR;
    private Label LIEUEVENT;
    @FXML
    private Button quitter;
    @FXML
    private TableView<Evenement> tableev1;
    @FXML
    private TableColumn<Evenement, Integer> nbvues_e;
    @FXML
    private Label MONTANT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
tableev1.setRowFactory(new Callback<TableView<Evenement>, TableRow<Evenement>>() {
    
    @Override
    public TableRow<Evenement> call(TableView<Evenement> tableView) {
        return new TableRow<Evenement>() {
            @Override
            protected void updateItem(Evenement evenement, boolean empty) {
               super.updateItem(evenement, empty);
                if (evenement == null) {
                    setStyle("");
                } else {
                    LocalDate finEvenement = evenement.getDate_fin();
                    LocalDate now = LocalDate.now();
                    if (finEvenement.isBefore(now)) {

                        setStyle("-fx-background-color: #C39BD3 ; -fx-text-fill: #FFFFFF  ;");

                    } else {
                        setStyle("-fx-background-color: #AF7AC5;");
                    }
                }
            }
        };
    }
});    }    

    public Label getIDSPONSOR() {
        return IDSPONSOR;
    }

    public Label getNOMSPONSOR() {
        return NOMSPONSOR;
    }

    public Label getTELSPONSOR() {
        return TELSPONSOR;
    }

    public Label getEMAILSPONSOR() {
        return EMAILSPONSOR;
    }

    public Label getMONTANT() {
        return MONTANT;
    }

    public void setIDSPONSOR(String IDSPONSOR) {
        this.IDSPONSOR.setText(IDSPONSOR); 
    }

    public void setNOMSPONSOR(String NOMSPONSOR) {
        this.NOMSPONSOR.setText(NOMSPONSOR);
    }

    public void setTELSPONSOR(String TELSPONSOR) {
        this.TELSPONSOR.setText(TELSPONSOR) ;
    }

    public void setEMAILSPONSOR(String EMAILSPONSOR) {
        this.EMAILSPONSOR.setText( EMAILSPONSOR) ;
    }

    public void setMONTANT(String MONTANT) {
        this.MONTANT.setText(MONTANT);
    }
 public void affichereventparsponsor(){
          try {
             
              int var1=Integer.parseInt(IDSPONSOR.getText());  
            String requete = "SELECT * FROM evenement  INNER JOIN evenement_sponsor ON evenement_sponsor.ID_event=evenement.ID_event INNER JOIN sponsor ON " +var1 + "=evenement_sponsor.ID_sponsor WHERE sponsor.ID_sponsor= "+var1;
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
      data1.add(new Evenement(rs.getInt(1),rs.getString(2), rs.getDate(3).toLocalDate(),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8)));

            }
            System.out.println(data1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
             id_e.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("ID_event")); 
                 nom_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Nom_event"));
                 datedeb_e.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("Date_debut"));
                 datefin_e.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("Date_fin"));
                lieu_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Lieu_event"));
                nbplaces_e.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("Nb_places"));
                type_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Type_event"));
                nbvues_e.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("Nb_vues"));

                
                
                 tableev1.setItems(data1);
          
       
                 
                 
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
 
    
      }

