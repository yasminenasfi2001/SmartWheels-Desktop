package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import static Controller.Utilisateur_gestionController.l_email;
import javax.mail.PasswordAuthentication;
import entities.Employee;
import entities.Reparation;
import entities.Utilisateur;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.EmployeeCRUD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;
import services.UtilisateurS;



/**
 * FXML Controller class
 *
 * @author yosra
 */
public class EmployeeController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField nom;
    @FXML
    private TextField type;
    @FXML
    private TextField prenom;
    @FXML
    private TableView<Employee> affichage;
    @FXML
    private TableColumn<Employee, Integer> id;
    @FXML
    private TableColumn<Employee, String> t_nom;
    @FXML
    private TableColumn<Employee, String> t_prenom;
    @FXML
    private TableColumn<Employee, String> t_type;
    @FXML
    private TextField idd;
    @FXML
    private TableColumn<Employee, String> t_email;
    @FXML
    private TextField email;
    @FXML
    private TableColumn<Employee, String> t_dispo;
    @FXML
    private ComboBox<String> dispo;
    @FXML
    private Button btnNotif;
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
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
        vboxid.setSpacing(18);
        this.afficher();
           affichage.setOnMouseClicked(event ->{
           if (event.getClickCount() == 2 && !affichage.getSelectionModel().isEmpty() )
           setTextField();
        });
           ObservableList<String> listInstance = FXCollections.observableArrayList();
           listInstance.add("Disponible");
           listInstance.add("Non Disponible");
           dispo.setItems(listInstance);
           dispo.setPromptText("Entrer Etat employee");
    }    

    @FXML
    private void ajouter(ActionEvent event) { 
        String emptyTxt="Les champs nom, prenom et type ne doivent pas etre nulls et ne doivent pas depasser 10 carateres";
        if(isInputValid(nom) && isInputValid(prenom) && isInputValid(type)){
            
// MyConnection mc= new MyConnection();
       Employee e = new Employee(nom.getText(),prenom.getText(),type.getText(),email.getText(),dispo.getValue());
       EmployeeCRUD pcd = new EmployeeCRUD();
       pcd.ajouterEntitee(e);
       Employee e1= new Employee();
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
    }
    public void afficher()
   {
       
         EmployeeCRUD emp=new EmployeeCRUD();
         id.setCellValueFactory(new PropertyValueFactory<>("id"));      
         t_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));    
         t_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         t_type.setCellValueFactory(new PropertyValueFactory<>("typee"));
         t_email.setCellValueFactory(new PropertyValueFactory<>("email"));
         t_dispo.setCellValueFactory(new PropertyValueFactory<>("dispo"));
         affichage.setItems(emp.afficher());
     
   } 

    @FXML
    private void Supprimer(ActionEvent event) {
        EmployeeCRUD es=new EmployeeCRUD();
           Alert alert = new Alert(AlertType.ERROR);
 Employee e=affichage.getSelectionModel().getSelectedItem();
  alert.setTitle("Conffirmation de suppression");
           alert.setHeaderText("Etes vous sur de supprimer cette id:");
           alert.setContentText(String.valueOf(e.getId()));
 Optional<ButtonType> result = alert.showAndWait();
 if (result.get() == ButtonType.OK){
          
            es.Supprimer(e.getId());
            this.afficher();
        }
        
       
                
    }

    @FXML
    private void modifier(ActionEvent event) {
         EmployeeCRUD es=new EmployeeCRUD();
         Employee e=new Employee(Integer.parseInt(idd.getText()),nom.getText(),prenom.getText(),type.getText(),email.getText(),dispo.getValue());
           Alert alert = new Alert(AlertType.CONFIRMATION);
          alert.setTitle("Conffirmation de modification");
           alert.setHeaderText("Etes vous sur de modifier cet employe:");
           alert.setContentText(String.valueOf(e.getNom()));
 Optional<ButtonType> result = alert.showAndWait();
 if (result.get() == ButtonType.OK){
          es.modifier(e);
         this.afficher();
        }
        
      
    }
    public void setTextField()
    {           
 Employee e=affichage.getSelectionModel().getSelectedItem();
 idd.setText(String.valueOf(e.getId()));
 nom.setText(e.getNom());
 prenom.setText(e.getPrenom());
 type.setText(e.getTypee());
 email.setText(e.getEmail());
 e=affichage.getSelectionModel().getSelectedItem();
  if (e.getDispo().equals("Disponible")){
       ObservableList<String> options =  FXCollections.observableArrayList( "Non Disponible");
       
       dispo.setItems(options);
       dispo.setValue("Disponible");
       }
       else 
       {
       ObservableList<String> options =  FXCollections.observableArrayList( "Disponible");
       
       dispo.setItems(options);
       dispo.setValue("Non Disponible");
       }
    }
          private boolean isInputValid(TextField textFiled) {
    Boolean b= false;
    if (!(textFiled.getText() == null || textFiled.getText().length() == 0 || textFiled.getText().length()>10)) {
        b=true;

}
  return b;  
}

    @FXML
    private void mail(ActionEvent event) {
        String emailprop="azizjazz887@gmail.com";
        String pass="wdkglasolgpgwrrk";
Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailprop, pass);
            }
        });

       
EmployeeCRUD emps=new EmployeeCRUD();
List<Employee> myList= new ArrayList<>();
myList=emps.listeEmployeDispo();
String emaildisffusion="";
for (int i=0;i<myList.size();i++)
{
   emaildisffusion+=","+myList.get(i).getEmail();
}

        
            try { 
         Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(emailprop));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emaildisffusion));
            emailMessage.setSubject("Information réparation SmartWheels");
            emailMessage.setText("Bonjour on a des véhicules à réparer, veuillez consulter notre application ! ");
            Transport.send(emailMessage);
             Alert al = new Alert(AlertType.CONFIRMATION);

           al.setTitle("Email envoyer");
           al.setHeaderText("veuillez vérifier votre boite mail");

            al.showAndWait();

        } catch (MessagingException e) {
            e.printStackTrace();
        } 

    }
    @FXML
     private void btnNotif(ActionEvent event) {
         try{
         Image image = new Image("file:///C:/Users/yosra/Documents/NetBeansProjects/Projet_transport/src/images/b.png");
ImageView imageView = new ImageView(image);
imageView.setFitWidth(50); // Définit la largeur de l'image à 50 pixels
Notifications notifications = Notifications.create()
    .graphic(imageView)
    .title("Notification")
    .text("Le véhicule est réparé !")
    .hideAfter(Duration.seconds(4))
    .position(Pos.BOTTOM_RIGHT);

notifications.show();

        
         }
         catch (Exception e)
         {
         
             System.out.println(e);
         }
    }

    @FXML
    private void Utilisateur(ActionEvent event) {
         try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/gestion_utilisateur.fxml"));  
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


    

