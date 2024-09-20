/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//adem
package Controller;

import static Controller.Utilisateur_gestionController.l_email;
import com.jfoenix.controls.JFXButton;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import entities.Reservation;
import entities.Utilisateur;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.Reservation_Service;
import services.UtilisateurS;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FrontReservationController implements Initializable {
    
  //public static final String ACCOUNT_SID ;
 // public static final String AUTH_TOKEN;
    @FXML
    private AnchorPane contentArea;
    @FXML
    private Pane left;
    @FXML
    private Button back;
    @FXML
    private GridPane gridpane;
    private Button resev;
    @FXML
    private JFXButton d;
    @FXML
    private JFXButton p;
    @FXML
    private Label lnom;
    @FXML
    private Label lprenom;
    @FXML
    private ImageView admin;
    @FXML
    private Button back1;
 

    /**
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.setPane();
        Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      lnom.setText(admin.getNom());
      lprenom.setText(admin.getPrenom());
      if (admin.getType().equals("Admin"))
      {
          this.admin.setVisible(true);
          back.setVisible(true);
      }
      else 
      {
           this.admin.setVisible(false);
           back.setVisible(false);
      }
      

    }    

    //bouton go back to gestion des reservations
    @FXML
    private void back(ActionEvent event) throws IOException {
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

   
    
    
    private ImageView createImageView(String marque)
    {
          ImageView iamageView = new ImageView();
        try{
        // create an input stream from a file path
        InputStream stream = null;
        if (marque.equals("Xiaomi"))
        {
         stream = new FileInputStream("C:/Users/aziz/Desktop/zeinebadem/src/images/Xiaomi.png");
        }
        else if(marque.equals("NIU"))
        {
          stream = new FileInputStream("C:/Users/aziz/Desktop/zeinebadem/src/images/NIU.png");   
        }
        else if(marque.equals("IsinWheel"))
        {
             stream = new FileInputStream("C:/Users/aziz/Desktop/zeinebadem/src/images/IsinWheel.png");   
        }

// create an Image object from the input stream
Image image = new Image(stream);

// create an ImageView to display the image
ImageView imageView = new ImageView(image);

        // set the position and size of the ImageView
        imageView.setX(50);
        imageView.setY(10);
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        return imageView;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
         return  iamageView;
    }
     private Label createLabel(int posx,int posy,String content) {
         Label label=new Label();
         label.setTranslateX(posx);
         label.setTranslateY(posy);
         label.setText(content);
         return  label;       
     }
     
   public void Reserver(int id) {
 
     // Création de l'alerte
// Création des champs de saisie

Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Saisie de plusieurs champs");
alert.setHeaderText(null);
alert.setContentText("Veuillez saisir les informations :");

TextField champId = new TextField();

DatePicker champDateDebut = new DatePicker();
champDateDebut.setPromptText("YYYY-MM-DD");

DatePicker champDateFin = new DatePicker();
champDateFin.setPromptText("YYYY-MM-DD");

TextField champmontant = new TextField();

// Création du label pour afficher le montant
Label labelMontant = new Label();

// Ajout d'un ChangeListener aux date pickers
champDateDebut.valueProperty().addListener((observable, oldValue, newValue) -> {
    // Ne rien faire si la date de fin n'est pas encore sélectionnée
    if (champDateFin.getValue() == null) {
        return;
    }

    // Calcul de la différence de jours entre les deux dates
    long diffDays = ChronoUnit.DAYS.between(newValue, champDateFin.getValue());
    // Mise à jour du champ du montant
    champmontant.setText(String.valueOf(diffDays));
});

champDateFin.setOnAction(e -> {
    LocalDate dateDebut = champDateDebut.getValue();
    LocalDate dateFin = champDateFin.getValue();
    if (dateDebut != null && dateFin != null) {
        long jours = ChronoUnit.DAYS.between(dateDebut, dateFin);
        double montant = jours * 10;
        champmontant.setText(String.valueOf(montant));
    }
});

GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);

grid.add(new Label("Date de début:"), 0, 1);
grid.add(champDateDebut, 1, 1);
grid.add(new Label("Date de fin:"), 0, 2);
grid.add(champDateFin, 1, 2);

grid.add(new Label("Montant:"), 0, 3);
grid.add(champmontant, 1, 3);

// Ajout du GridPane à l'alerte
alert.getDialogPane().setContent(grid);

// Ajout du label pour afficher le montant
alert.getDialogPane().setContent(grid);
alert.getDialogPane().getChildren().add(labelMontant);
GridPane.setConstraints(labelMontant, 1, 4);

// Affichage de l'alerte et attente de la réponse de l'utilisateur
Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK) {
    // Traitement des champs saisis par l'utilisateur
    // ...
}


if (result.isPresent() && result.get() == ButtonType.OK) {
    // Vérification de la validité des dates
    LocalDate dateDebut = champDateDebut.getValue();
    LocalDate dateFin = champDateFin.getValue();
    if (dateDebut == null || dateFin == null || dateDebut.isAfter(dateFin)) {
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setTitle("Erreur de saisie");
        al.setHeaderText(null);
        al.setContentText("Les dates saisies sont invalides!");
        al.showAndWait();
        return;
        
    }
    Utilisateur u=new Utilisateur();
    UtilisateurS us=new UtilisateurS();
    
     Reservation_Service a = new Reservation_Service();
     System.out.println(l_email); 
   u=us.getUserByEmail(l_email);
    Reservation r = new Reservation(0, dateDebut.toString(), dateFin.toString(),a.calculmontant(dateDebut.toString(),dateFin.toString()),id,u.getId());
  
    a.ajouter_reservation(r);

    Alert al = new Alert(Alert.AlertType.INFORMATION);
    al.setTitle("Réservation effectuée");
    al.setHeaderText(null);
    al.setContentText("Votre réservation a été faite");
    al.showAndWait();
    
    
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
      new com.twilio.type.PhoneNumber("+21652510089"),
      new com.twilio.type.PhoneNumber("+12708195429"),
      "Votre réservation a été faite de "+champDateDebut.getValue()+ " jusqu à "+champDateFin.getValue()+" le montant est "+champmontant.getText()+"dt")

    .create();

    System.out.println(message.getSid());
    
}

   }
     
     
private Button crateButton(int id) {
    Button bt = new Button("Réserver");
    bt.getStyleClass().add("my-button"); // add the CSS class to the button
    bt.setTranslateY(200);
    bt.setTranslateX(150);
    
    bt.setOnAction(action->{
       this.Reserver(id); 
   });
    return bt;

}




private Pane createPane(int id,String marque, String couleur, String vitesse) {
    Pane pane = new Pane();
    pane.setPrefHeight(250);
    pane.setPrefWidth(250);
    pane.setStyle("-fx-background-color: #95b0b7; -fx-background-radius: 10px;");
    pane.getChildren().add(this.createImageView(marque));
    pane.getChildren().add(this.createLabel(20, 180, "Marque:" + marque));
    pane.getChildren().add(this.createLabel(20, 200, "Couleur:" + couleur));
    pane.getChildren().add(this.createLabel(20, 220, "Vitesse:" + vitesse));
    pane.getChildren().add(this.crateButton(id));
    return pane;
}

    public void setPane()
    {
      //Affichage des donneés de la base  sur  le front
          for (ColumnConstraints column : gridpane.getColumnConstraints()) {
    column.setFillWidth(false);
}

// désactiver le remplissage automatique des lignes
for (RowConstraints row : gridpane.getRowConstraints()) {
    row.setFillHeight(false);
}
        try {
            String selectQuery = "SELECT id, marque ,couleur,vitesse_max FROM vehicule ";
         
           PreparedStatement ps= MyConnection.getInstance().getCnx().prepareStatement(selectQuery);
           ResultSet resultSet = ps.executeQuery();
            for (int i = 0; i <4; i++) {
                 for (int j = 0; j <3; j++) {
                 
              
               
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String marque = resultSet.getString("marque");
                    String couleur = resultSet.getString("couleur");
                    String vitesse_max = resultSet.getString("vitesse_max");
                      gridpane.add(this.createPane(id,marque,couleur,vitesse_max),j,i);
                        
                }                      
                 }   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    

    }

    @FXML
    private void btn_commentaire(ActionEvent event) {
                  try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/frontCommentaire.fxml"));  
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
    private void btn_reclamation(ActionEvent event) {
                  try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/ReclamationFront.fxml"));  
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
    private void evenement(ActionEvent event) {
        try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/InterfaceClient.fxml"));  
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
    private void deconnexion(ActionEvent event) {
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

}
