/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
package Controller;
=======
<<<<<<< HEAD
package Controller;
=======
package projet_transport.controler;
>>>>>>> master
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
=======
<<<<<<< HEAD
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java
import static Controller.loginController.containsOnlyLetters;
import static Controller.loginController.containsOnlyNumber;
import static Controller.loginController.isEmailValid;
import entities.Carte_fidelite;
import entities.Utilisateur;
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
import javafx.scene.layout.VBox;
import services.Carte_fideliteS;
import services.UtilisateurS;

=======
import services.Carte_fideliteS;
import services.UtilisateurS;

=======
import static projet_transport.controler.loginController.containsOnlyLetters;
import static projet_transport.controler.loginController.containsOnlyNumber;
import static projet_transport.controler.loginController.isEmailValid;
import projet_transport.model.Carte_fidelite;
import projet_transport.model.Utilisateur;
import projet_transport.services.Carte_fideliteS;
import projet_transport.services.UtilisateurS;
import projet_transport.utils.MyConnexion;
>>>>>>> master
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class Utilisateur_gestionController implements Initializable {

   
    static String l_email;
    static String l_motPasse;

    @FXML
    private AnchorPane aze;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane left;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private TabPane tabpane;
    @FXML
    private TableView<Utilisateur> affichage;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> prenom;
    @FXML
    private TableColumn<?, ?> genre;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> date_naissance;
    @FXML
    private TableColumn<?, ?> mot_passe;
    @FXML
    private TableColumn<?, ?> typee;
    @FXML
    private TableColumn<?, ?> telephone;
    @FXML
    private TableColumn<?, ?> region;
    @FXML
    private Pane layout22;
    @FXML
    private TextField u_choix;
    @FXML
    private Button supprimer;
    @FXML
    private Button ajouter;
    @FXML
    private TextField u_nom;
    @FXML
    private TextField u_prenom;
    @FXML
    private TextField u_email;
    @FXML
    private DatePicker u_date;
    @FXML
    private TextField u_region;
    @FXML
    private TextField u_passe;
    @FXML
    private RadioButton u_h;
    @FXML
    private RadioButton u_f;
    @FXML
    private RadioButton u_a;
    @FXML
    private ComboBox<String> u_type;
    @FXML
    private TextField u_telephone;
    @FXML
    private ToggleGroup genre2;
    @FXML
    private Pane layout221;
    @FXML
    private Button ajouter1;
    @FXML
    private TextField c_points;
    @FXML
    private TableColumn<?, ?> t_id;
    @FXML
    private TableColumn<?, ?> t_points;
    @FXML
    private TableView<Carte_fidelite> t_affichage;
    @FXML
    private ComboBox<String> c_idd;
    @FXML
    private Button annuler;
    @FXML
    private Button modifier;
    @FXML
    private Button ajouter12;
    @FXML
    private Button ajouter11;
    @FXML
    private Label l_prenom;
    @FXML
    private Label l_nom;
    @FXML
    private PieChart piechart;
    @FXML
    private BarChart<String, Number> barchart;
    @FXML
    private Button id_rec;
    @FXML
    private VBox vboxid;
    @FXML
    private Button Evenement;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       vboxid.setSpacing(18);
        //init
        u_choix.setVisible(false);
        
        //set options admin ou user
        ObservableList<String> options =  FXCollections.observableArrayList("Admin","User");
        u_type.setItems(options);
        //affichage tableau 
        this.afficher(affichage);
        //selection multiple sur tableview 
         affichage.getSelectionModel().setSelectionMode(
         SelectionMode.MULTIPLE
         );
          t_affichage.getSelectionModel().setSelectionMode(
         SelectionMode.MULTIPLE
         );
        //Modifier utilisateur en cliquant sur table view
        affichage.setOnMouseClicked(event ->{
           if (event.getClickCount() == 2  )
           SetAllTextField();
        });
        //Gestion carte
        this.afficher_carte();
         t_affichage.setOnMouseClicked(event ->{
           if (event.getClickCount() == 2  )
           SetAllTextField_carte();
        });
         this.GetAllIdUser();
      Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
      this.statistique();
    }
    //go to Login
    private void home(ActionEvent event) {
        
         try{
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
         Parent root = FXMLLoader.load(getClass().getResource("/gui/frontReservation.fxml"));  
=======
<<<<<<< HEAD
         Parent root = FXMLLoader.load(getClass().getResource("/gui/login.fxml"));  
=======
         Parent root = FXMLLoader.load(getClass().getResource("/projet_transport/views/login.fxml"));  
>>>>>>> master
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java
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
    
//Afficher Utilisateur Tableview
 public void afficher(TableView<Utilisateur> affichage)
   {
       
         UtilisateurS util=new UtilisateurS();
         id.setCellValueFactory(new PropertyValueFactory<>("id"));      
         nom.setCellValueFactory(new PropertyValueFactory<>("nom"));    
         prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         email.setCellValueFactory(new PropertyValueFactory<>("email"));
         typee.setCellValueFactory(new PropertyValueFactory<>("type"));
         email.setCellValueFactory(new PropertyValueFactory<>("email"));
         date_naissance.setCellValueFactory(new PropertyValueFactory<>("date"));
         region.setCellValueFactory(new PropertyValueFactory<>("region"));
         mot_passe.setCellValueFactory(new PropertyValueFactory<>("mot_passe"));
         telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
         genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
    
         affichage.setItems(util.afficher());
     
   }    

  
//Ajouter Utlisateur
    @FXML
    private void ajouter(MouseEvent event) {
        Alert al = new Alert(AlertType.ERROR);
        UtilisateurS util=new UtilisateurS();
         if (!(u_telephone.getText().equals("") || u_nom.getText().equals("") ||  u_email.getText().equals("") || u_prenom.getText().equals("") || u_region.getText().equals("") ||  u_passe.getText().equals("") || u_type.getValue()==null))
            {
                if (containsOnlyLetters(u_nom.getText())){
                
                al.setTitle("Erreur ");
                al.setHeaderText("nom est alphabetique ");
                al.showAndWait(); 
                u_nom.setText("");
                  
                 }
                else if (containsOnlyLetters(u_prenom.getText()))
                {
               
                al.setTitle("Erreur ");
                al.setHeaderText("Prenom est alphabetique ");
                al.showAndWait(); 
                u_prenom.setText("");
                }
                else   if (util.CheckUserByEmail(u_email.getText()) )
                {
              
                al.setTitle("Erreur ");
                al.setHeaderText("Email deja exisistant");
                al.showAndWait(); 
                u_email.setText("");
                    
                }
                else if ( !isEmailValid(u_email.getText()))
                 {
     
                al.setTitle("Erreur ");
                al.setHeaderText("Le format de l'Email est invalide");
                al.showAndWait();  
                u_email.setText("");
                 }
                else  if (containsOnlyNumber(u_telephone.getText()) || u_telephone.getText().length() != 8 )
                {
               
                al.setTitle("Erreur ");
                al.setHeaderText("Telephone est composer de 8 chiffres ");
                al.showAndWait();  
                u_telephone.setText("");
                }
                else if (containsOnlyLetters(u_region.getText()))
                {
               
                al.setTitle("Erreur ");
                al.setHeaderText("Region contient que des lettres alphabetique");
                al.showAndWait();  
                u_region.setText("");
                }
              
                else
                  {
                   Utilisateur utilisateur=new Utilisateur(u_nom.getText(),u_prenom.getText(),u_email.getText(),u_date.getValue().toString(),Integer.parseInt(u_telephone.getText()),u_region.getText() , u_passe.getText(),u_h,u_f,u_type.getValue());
                   util.ajouter(utilisateur);
                  
                   //Initialisation tableau affichage et choix id
                   this.afficher(affichage); 
                   this.GetAllIdUser();
                    Alert a2 = new Alert(AlertType.CONFIRMATION);
                     a2.setTitle("Information ");
                     a2.setHeaderText("Ajout avec succes");
                     a2.showAndWait();  
                    
                  }
            }
             else
            {
            
            al.setTitle("Erreur ");
            al.setHeaderText("Vous devez Remplir tout le formulaire");
            al.showAndWait();  
            }
        
             
    
    }
  //modifer utilisateur par id
    @FXML
    private void update(MouseEvent event) {
        UtilisateurS us=new UtilisateurS();
        Utilisateur utilisateur2 =us.getUserById(u_choix.getText());     
         Alert al = new Alert(AlertType.ERROR);
        if (!u_choix.getText().equals(""))
        {
         Utilisateur utilisateur=new Utilisateur(Integer.parseInt(u_choix.getText()),u_nom.getText(),u_prenom.getText(), u_email.getText(), u_date.getValue().toString(),Integer.parseInt(u_telephone.getText()),u_region.getText() ,u_passe.getText(),u_h,u_f,u_type.getValue()); 
         Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de modification");
        alert.setHeaderText("Voulais vous modifier cette Utilisateur:");
        alert.setContentText("id:"+u_choix.getText());
        // ... user chose OK
       if (!(utilisateur2.getNom().equals(utilisateur.getNom()) 
               && utilisateur2.getPrenom().equals(utilisateur.getPrenom()) 
               && utilisateur2.getEmail().equals(utilisateur.getEmail()) 
               && utilisateur2.getDate().equals(utilisateur.getDate()) 
               && utilisateur2.getTelephone() == utilisateur.getTelephone()
               && utilisateur2.getRegion().equals(utilisateur.getRegion())
               && utilisateur2.getMot_passe().equals(utilisateur.getMot_passe())
               && utilisateur2.getGenre().equals(utilisateur.getGenre())
               && utilisateur2.getType().equals(utilisateur.getType())
               )
          )
            {
                //____________________________________________________//
                 if (!(u_telephone.getText().equals("") || u_nom.getText().equals("") ||  u_email.getText().equals("") || u_prenom.getText().equals("") || u_region.getText().equals("") ||  u_passe.getText().equals("") || u_type.getValue()==null))
            {
               
                if (containsOnlyLetters(u_nom.getText())){
                
                al.setTitle("Erreur ");
                al.setHeaderText("nom est alphabetique ");
                al.showAndWait(); 
                u_nom.setText("");
                  
                 }
                else if (containsOnlyLetters(u_prenom.getText()))
                {
               
                al.setTitle("Erreur ");
                al.setHeaderText("Prenom est alphabetique ");
                al.showAndWait(); 
                u_prenom.setText("");
                }
              
                else if ( !isEmailValid(u_email.getText()))
                 {
     
                al.setTitle("Erreur ");
                al.setHeaderText("Le format de l'Email est invalide");
                al.showAndWait();  
                u_email.setText("");
                 }
                else  if (containsOnlyNumber(u_telephone.getText()) || u_telephone.getText().length() != 8 )
                {
               
                al.setTitle("Erreur ");
                al.setHeaderText("Telephone est composer de 8 chiffres ");
                al.showAndWait();  
                u_telephone.setText("");
                }
                else if (containsOnlyLetters(u_region.getText()))
                {
               
                al.setTitle("Erreur ");
                al.setHeaderText("Region contient que des lettres alphabetique");
                al.showAndWait();  
                u_region.setText("");
                }
              
                else
                  {
                     Optional<ButtonType> result = alert.showAndWait();
                   if (result.get() == ButtonType.OK){
                      UtilisateurS util=new UtilisateurS();
                      util.modifier(utilisateur);
                       System.out.println("modifier avec succes");
                       this.afficher(affichage);
                       u_choix.setText("");
                       u_choix.setVisible(false);
                       this.setVisibleLabel();
                      }
                    
                  }
            }
             else
            {
            
            al.setTitle("Erreur ");
            al.setHeaderText("Vous devez Remplir tout le formulaire");
            al.showAndWait();  
            }
        
          //________________________________________________________//
         }
         else
            {
              
           al.setTitle("Erreur alert");
           al.setHeaderText("Vous devez Changer au moin un attribut");
            al.showAndWait();    
            }
        }
        else 
        {
           al.setTitle("Erreur alert");
           al.setHeaderText("Vous devez selectionner un utilisateur");
           al.showAndWait();  
        }
    }
    //Supprimer utilisateur
    @FXML
    private void Supprimer(MouseEvent event) throws IOException  {
              
       UtilisateurS utils=new UtilisateurS();
       ObservableList <Utilisateur> utilisateur =affichage.getSelectionModel().getSelectedItems();
       
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppresion");
        alert.setHeaderText("Voulais vous supprimer ces ou cette id:");
        String id = "";
          
         for(Utilisateur c : utilisateur)
            {
             id=id+" "+c.getId();
            }
         if (!id.trim().equals("")){
             
            alert.setContentText("id:"+id);
            // ... user chose OK
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
              //ajouter les id suppriemr dans le fichier
              File file = new File("C:\\Users\\aziz\\Desktop\\zeinebadem\\src\\Logs\\Client.txt");
              FileWriter fr = new FileWriter(file, true);
              BufferedWriter br = new BufferedWriter(fr);
            for(Utilisateur s : utilisateur){
            br.write(Integer.toString(s.getId())+" ");
            utils.Supprimer(s.getId());                           
            }
             br.close();
             fr.close();
          this.afficher(affichage);
          this.GetAllIdUser();
          this.afficher_carte();
            }
           
         }
            else{
            Alert al = new Alert(AlertType.ERROR);

           al.setTitle("Erreur alert");
           al.setHeaderText("Vous devez selectionner au moins un id pour supprimer");
   
            al.showAndWait();
                
            }
         
    }
  
//----------------------------------------------------------------------------------------------------------------------------------//

    
//Gestion carte
    //afficher carte dans Tableview
     public void afficher_carte()
    {
         Carte_fideliteS cartes=new Carte_fideliteS();
         t_id.setCellValueFactory(new PropertyValueFactory<>("id"));      
         t_points.setCellValueFactory(new PropertyValueFactory<>("points"));
         t_affichage.setItems(cartes.afficher());

    }
     //ajouter carte
    @FXML
    private void ajouter_carte(ActionEvent event) {
        if (!(c_idd.getValue()==null) && !(c_points.getText().equals("")))
        {
        Carte_fidelite carte=new Carte_fidelite(Integer.parseInt(c_idd.getValue()),Integer.parseInt(c_points.getText()));
        Carte_fideliteS carteS=new Carte_fideliteS();
        
        if (!new Carte_fideliteS().CheckCarteById(carte.getId()))
                {
                     Alert al = new Alert(AlertType.CONFIRMATION);
                     al.setTitle("Ajout avec succes"); 
                     al.setHeaderText("Utilisateur a ete bien enregister"); 
                     al.showAndWait();  
                     carteS.ajouter(carte);
                     this.afficher_carte();
                }
        else
        {
           Alert al = new Alert(AlertType.ERROR);
           al.setTitle("Erreur"); 
           al.setHeaderText("Id deja existant !!"); 
           al.showAndWait();    
        }
        }
        else
        {
        Alert al = new Alert(AlertType.ERROR);
        al.setTitle("Erreur"); 
        al.setHeaderText("vous devez remplir le formulaire "); 
        al.showAndWait(); 
        }
    }
   
    @FXML
    private void supprimer_carte(ActionEvent event) throws IOException {
      Carte_fideliteS carteS=new Carte_fideliteS();
       Carte_fidelite carte=new Carte_fidelite();
       ObservableList <Carte_fidelite> Listcarte =t_affichage.getSelectionModel().getSelectedItems();
       
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppresion");
        alert.setHeaderText("Voulais vous supprimer ces ou cette id:");
        String id = "";
          
         for(Carte_fidelite c : Listcarte)
            {
             id=id+" "+c.getId();
            }
         if (!id.trim().equals("")){
             
            alert.setContentText("id:"+id);
            // ... user chose OK
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
              //ajouter les id suppriemr dans le fichier
              File file = new File("C:\\Users\\aziz\\Desktop\\zeinebadem\\src\\Logs\\Carte.txt");
              FileWriter fr = new FileWriter(file, true);
              BufferedWriter br = new BufferedWriter(fr);
            for(Carte_fidelite s : Listcarte){
            br.write(Integer.toString(s.getId())+" ");
            carteS.Supprimer(s.getId());                           
            }
             br.close();
             fr.close();
          this.afficher(affichage);
          this.GetAllIdUser();
          this.afficher_carte();
            }
           
         }
            else{
            Alert al = new Alert(AlertType.ERROR);

           al.setTitle("Erreur alert");
           al.setHeaderText("Vous devez selectionner au moins un id pour supprimer");
   
            al.showAndWait();
                
            }
    }

    @FXML
    private void modifier_carte(ActionEvent event) {
        if (!c_points.getText().equals("") )
        {
            if (checkint(c_points.getText()))
             {
              Carte_fideliteS carte_s =new Carte_fideliteS();
            Carte_fidelite carte=new Carte_fidelite(Integer.parseInt(c_idd.getValue()),Integer.parseInt(c_points.getText()));
                if (carte_s.GetAllIdCarte().contains(String.valueOf(carte.getId())))
                {
                   Alert al = new Alert(AlertType.CONFIRMATION);
                   al.setTitle("Confirmation");
                   al.setHeaderText("Etes vous sur de modifer l'utilisateur Id:"+String.valueOf(carte.getId())+" avec Points:"+String.valueOf(carte.getPoints()));   
                   Optional<ButtonType> result = al.showAndWait();
                   if (result.get() == ButtonType.OK){
                   carte_s.modifier(carte);
                   this.afficher_carte();
                   }
                }
                else
                {
                Alert al = new Alert(AlertType.ERROR);
                al.setTitle("Erreur"); 
                al.setHeaderText("Il faut ajouter l'id :"+carte.getId()+" pour le modifier"); 
                al.showAndWait();       
                }
                    }
            else
            {
           Alert al = new Alert(AlertType.ERROR);
           al.setTitle("Erreur"); 
           al.setHeaderText("Points doit etres numerique (eviter les caractere speciaux)"); 
           al.showAndWait();   
            }
        }
        else
        {
         
           Alert al = new Alert(AlertType.ERROR);
           al.setTitle("Erreur"); 
           al.setHeaderText("Le champ points non vide"); 
           al.showAndWait();
        }
    }
    
    //Annuler la mofidification
     @FXML
    private void annuler(ActionEvent event) {
      this.setVisibleLabel();
    }
  
    
    
 //Des fonction utiliseés a l'appel    
     //set all Text field from id utilisateur(utilisateur)
    public void SetAllTextField()
   {
    
       UtilisateurS util=new UtilisateurS();
       Utilisateur u=new Utilisateur();
       u=affichage.getSelectionModel().getSelectedItem();
       u_choix.setText(Integer.toString(u.getId()));
       u_nom.setText(u.getNom());
       u_prenom.setText(u.getPrenom());
       u_email.setText(u.getEmail());
       u_telephone.setText(Integer.toString(u.getTelephone()));
       u_region.setText(u.getRegion());
       u_date.setValue(LOCAL_DATE(u.getDate()));
       u_passe.setText(u.getMot_passe());
        switch (u.getGenre()) {
            case "Homme":
                u_h.setSelected(true);
                break;
            case "Femme":
                u_f.setSelected(true);
                break;
            default:
                u_a.setSelected(true);
                break;
        }
        if (u.getType().equals("User")){
       ObservableList<String> options =  FXCollections.observableArrayList( "Admin");
       
       u_type.setItems(options);
       u_type.setValue("User");
       }
       else 
       {
          ObservableList<String> options =  FXCollections.observableArrayList( "User");
          u_type.setItems(options);
          u_type.setValue("Admin");
       }
     
       
        ajouter.setVisible(false);
        supprimer.setVisible(false);
        annuler.setVisible(true);
        u_choix.setVisible(true);
   }
    
    //set all Text field from id utilisateur(Carte_fidelite)
      public void SetAllTextField_carte()
    {
        Carte_fidelite carte=new Carte_fidelite();
        carte=t_affichage.getSelectionModel().getSelectedItem();
        c_idd.setValue(String.valueOf(carte.getId()));
        c_points.setText(String.valueOf(carte.getPoints()));    
    }
      
      //Label controle leurs visibilité
        public void setVisibleLabel()
    {
          ajouter.setVisible(true);
        supprimer.setVisible(true);
        annuler.setVisible(false);
        u_choix.setVisible(false);
    }
        
      //Stocker tous les id de l'utilisateur
        public void GetAllIdUser()
    {
        Carte_fideliteS carteS=new Carte_fideliteS();
        c_idd.setItems(carteS.GetAllIdUser());
      
    }
    //Verifier si champ comporte que des chiffres    
    public static boolean checkint(String email) {
    Pattern pattern = Pattern.compile("[0-9]+");
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
}
    
    // LocalDate format pour type date 'yyyy-MM-dd'
    public static final LocalDate LOCAL_DATE (String dateString){
        
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
        
    }
    //aller au Front
    private void Go_to_front(ActionEvent event) {
          try{
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
         Parent root = FXMLLoader.load(getClass().getResource("/gui/Front.fxml"));  
=======
<<<<<<< HEAD
         Parent root = FXMLLoader.load(getClass().getResource("/gui/Front.fxml"));  
=======
         Parent root = FXMLLoader.load(getClass().getResource("/projet_transport/views/Front.fxml"));  
>>>>>>> master
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java
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
    //GET information from Login
    public static void SetLoginData(String Email,String mot_passe)
    {
        Controller.Utilisateur_gestionController.l_email=Email;
        Controller.Utilisateur_gestionController.l_motPasse=mot_passe;
    }

    private void Deconnexion(ActionEvent event) {
        try{
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
         Parent root = FXMLLoader.load(getClass().getResource("/gui/login.fxml"));  
=======
<<<<<<< HEAD
         Parent root = FXMLLoader.load(getClass().getResource("/gui/login.fxml"));  
=======
         Parent root = FXMLLoader.load(getClass().getResource("/projet_transport/views/login.fxml"));  
>>>>>>> master
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java
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
    public void statistique()
    {
       //barchart
       Utilisateur u=new  Utilisateur();
       UtilisateurS us=new  UtilisateurS();
       ObservableList<Utilisateur> list=us.afficher();
       Carte_fidelite carte=new Carte_fidelite();
       Carte_fideliteS cartes=new Carte_fideliteS();
       
       ObservableList<Carte_fidelite> listcarte=cartes.afficher();
       XYChart.Series<String, Number> series1 = new XYChart.Series<>();
       barchart.setLegendVisible(false);
         Collections.sort(listcarte, new Comparator<Carte_fidelite>() {
           @Override
           public int compare(Carte_fidelite o1, Carte_fidelite o2) {
               return Integer.compare(o2.getPoints(),o1.getPoints());
           }
       });
        
        
       for (int i=0;i<3;i++)
       {
        
           u=us.getUserById(String.valueOf(listcarte.get(i).getId()));
             series1.getData().add(new XYChart.Data<>(String.valueOf(u.getNom()), listcarte.get(i).getPoints()));
       }
        barchart.setOnMouseClicked(event -> {
            
          
        });

        // Add the data to the chart
        
        barchart.getData().add(series1);
        
        
        
        //piechart
        
      
       
       int homme=0;
       int femme=0;
       int autres=0;
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getGenre().equals("Homme"))
                homme++;
            else if (list.get(i).getGenre().equals("Femme"))
                femme++;
            else 
                autres++;
        }
        piechart.setTitle("Genre statistique");
        
        piechart.getData().add(new PieChart.Data("Homme",homme));
        piechart.getData().add(new PieChart.Data("Femme", femme));
        piechart.getData().add(new PieChart.Data("Autres", autres));
        
         for (PieChart.Data data : piechart.getData()) {
            data.getNode().setOnMouseEntered(e -> data.getNode().setScaleX(1.1));
            data.getNode().setOnMouseExited(e -> data.getNode().setScaleX(1.0));
        }
       
        piechart.getData().forEach(data->
                {
                    
                 String valeur=String.format("%.0f", (data.getPieValue()));
                    Tooltip tooltip=new Tooltip(valeur+"("+data.getName()+")");
                    Tooltip.install(data.getNode(), tooltip);
                       TooltipTiming(tooltip);
                }) ;
     
    }
    
    public static void TooltipTiming(Tooltip tooltip) {
    try {
        Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
        fieldBehavior.setAccessible(true);
        Object objBehavior = fieldBehavior.get(tooltip);

        Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
        fieldTimer.setAccessible(true);
        Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

        objTimer.getKeyFrames().clear();
        objTimer.getKeyFrames().add(new KeyFrame(new Duration(200)));
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @FXML
    private void stat(Event event) {
        barchart.getData().clear();
       
        piechart.getData().clear();
         piechart.setLabelsVisible(false);
        this.statistique();
    }
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
=======
<<<<<<< HEAD
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java

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
    private void Reclamation(ActionEvent event) {
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
          try{
=======
         try{
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/Gestion_UtilisateurController.java
=======
         try{
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java
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
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java
<<<<<<< HEAD:Controller/Utilisateur_gestionController.java

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
    private void Produits(ActionEvent event) {
         try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/Produit.fxml"));  
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

    @FXML
    private void front(ActionEvent event) {
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
=======
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/Gestion_UtilisateurController.java
=======
=======
>>>>>>> master
>>>>>>> master:src/Controller/Gestion_UtilisateurController.java
}
