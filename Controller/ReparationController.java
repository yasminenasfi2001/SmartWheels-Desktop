/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import static Controller.Utilisateur_gestionController.l_email;
import entities.Reparation;
import entities.Employee;
import entities.Utilisateur;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.EmployeeCRUD;
import services.ReparationCRUD;
import java.util.Date;
import javafx.scene.control.DatePicker;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.management.Notification;
import services.UtilisateurS;

/**
 * FXML Controller class
 *
 * @author yosra
 */
public class ReparationController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField identifiant;
    @FXML
    private TextField description;
    @FXML
    private TextField etat;
    @FXML
    private DatePicker date_reparation;
    @FXML
    private DatePicker date_manutention;
    @FXML
    private DatePicker date_defecation;
    @FXML
    private TabPane tab;
    
    @FXML
    private TableView<Reparation> affichage;
     @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> s_description;
    @FXML
    private TableColumn<?, ?> s_etat;
    @FXML
    private TableColumn<?, ?> s_datereparation;
    @FXML
    private TableColumn<?, ?> s_datemanutention;
    @FXML
    private TableColumn<?, ?> s_datedefecation;
    private Button suivAjout;
    @FXML
    private TableColumn<?, ?> t_idveh;
    @FXML
    private TextField id_veh;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private Label l_prenom;
    @FXML
    private Label l_nom;
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
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
        vboxid.setSpacing(18);
        try {
        Tab tab1 = new Tab();
        tab.getTabs().add(tab1);
        tab1.setContent((Node) FXMLLoader.load(this.getClass().getResource("/gui/Employee.fxml")));
        tab1.setText("Employee");
    } catch (IOException e) {
        e.printStackTrace();
    }
        identifiant.setVisible(false);
        
           affichage.setOnMouseClicked(event ->{
           if (event.getClickCount() == 2 && !affichage.getSelectionModel().isEmpty() )
           setTextField();
        });
           
           ReparationCRUD r=new ReparationCRUD();
          ObservableList<Reparation> l = r.afficher();
      
          for(int i=0;i<l.size();i++){
              
          LocalDate Date_rep = l.get(i).getDate_rep();
          ReparationCRUD c=new ReparationCRUD();
                         
            if (String.valueOf(Date_rep).equals(String.valueOf(java.time.LocalDate.now()))){
                c.setEtatReparable(l.get(   i));
                

            }
        
          }
          this.afficher();
        
    }  
    

     @FXML
     
    private void ajouter(ActionEvent event) {
        
        String emptyTxt="Les champs description et etat ne doivent pas etre nulls et ne doivent pas depasser 10 carateres";
        if(isInputValid(description) && isInputValid(etat)){
            
            Reparation r = new Reparation(description.getText(),etat.getText(),date_reparation.getValue(),date_manutention.getValue(),date_defecation.getValue());
       ReparationCRUD pcd = new ReparationCRUD();
       pcd.ajouterEntitee(r);
       System.out.println(pcd.listeDesEntites());
      
       this.afficher();
       return;
        }
              Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Erreur");
           alert.setHeaderText(null);
           alert.setContentText(emptyTxt);
 Optional<ButtonType> result = alert.showAndWait();
 if (result.get() == ButtonType.OK){
     
          
         
        }
                
  
// 
    
    }
    public void afficher()
   {
       
         ReparationCRUD rep=new ReparationCRUD();
         id.setCellValueFactory(new PropertyValueFactory<>("id"));  
         s_description.setCellValueFactory(new PropertyValueFactory<>("Description_panne"));    
         s_etat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
         s_datereparation.setCellValueFactory(new PropertyValueFactory<>("Date_rep"));
         s_datemanutention.setCellValueFactory(new PropertyValueFactory<>("Date_manu"));
         s_datedefecation.setCellValueFactory(new PropertyValueFactory<>("Date_defect"));
         t_idveh.setCellValueFactory(new PropertyValueFactory<>("id_v"));
         
    
         affichage.setItems(rep.afficher());
     
   } 

    @FXML
       private void Supprimer(ActionEvent event) {
       ReparationCRUD es=new ReparationCRUD();
           Alert alert = new Alert(Alert.AlertType.ERROR);
      Reparation r =affichage.getSelectionModel().getSelectedItem();
      alert.setTitle("Conffirmation de suppression");
           alert.setHeaderText("Etes vous sur de supprimer cet etat:");
           alert.setContentText(String.valueOf(r.getId()));
      Optional<ButtonType> result = alert.showAndWait();
       if (result.get() == ButtonType.OK){
          
            es.supprimer(r.getId());
            this.afficher();
        }
        
       
                
    }

    @FXML
    private void modifier(ActionEvent event) {
         ReparationCRUD es=new ReparationCRUD();
         Reparation r=new Reparation(Integer.valueOf(identifiant.getText()),description.getText(),etat.getText(),date_reparation.getValue(),date_manutention.getValue(),date_defecation.getValue());
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Conffirmation de modification");
           alert.setHeaderText("Etes vous sur de modifier cet etat:");
           alert.setContentText(String.valueOf(r.getEtat()));
 Optional<ButtonType> result = alert.showAndWait();
 if (result.get() == ButtonType.OK){
          es.modifier(r);
         this.afficher();
        }
 
 
        
      
    }
    public void setTextField()
    {           
 Reparation r = affichage.getSelectionModel().getSelectedItem();
 identifiant.setText(String.valueOf(r.getId()));
 description.setText(r.getDescription_panne());
 etat.setText(r.getEtat());
 date_reparation.setValue(r.getDate_rep());
 date_manutention.setValue(r.getDate_manu());
 date_defecation.setValue(r.getDate_defect());
 
    }
        private boolean isInputValid(TextField textFiled) {
    Boolean b= false;
    if (!(textFiled.getText() == null || textFiled.getText().length() == 0 || textFiled.getText().length()>10)) {
        b=true;

}
  return b;  
}
  private void LienVersListe(ActionEvent event){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/gui/Employee.fxml"));
            Parent root = loader.load();
            suivAjout.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Utilisateur(ActionEvent event) {
        try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/utilisateur_gestion.fxml"));  
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
    private void Reservation(ActionEvent event) {
        try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/GestionDesReservations.fxml"));  
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
    private void Produits(ActionEvent event) {
    }

    @FXML
    private void Vehicule(ActionEvent event) {
          try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/GestionDesVehicules.fxml"));  
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
    private void Evenement(ActionEvent event) {
         try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/InterfaceAdmin.fxml"));  
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
        try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/login.fxml"));  
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


    private void Front(ActionEvent event) {
                try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/frontReservation.fxml"));  
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
 
  


}
    

