/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//adem
package Controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import entities.Reservation;
<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
=======
import java.io.IOException;
>>>>>>> master
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
<<<<<<< HEAD
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
=======
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
>>>>>>> master
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.Reservation_Service;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FrontReservationController implements Initializable {
  public static final String ACCOUNT_SID = "AC577d98d4a3529117634d2665ff71cb4d";
  public static final String AUTH_TOKEN = "bf8dc2397230c108b876eb25a3c46b4e";
    @FXML
    private AnchorPane contentArea;
    @FXML
    private Pane left;
    @FXML
    private Button back;
    @FXML
<<<<<<< HEAD
    private GridPane gridpane;
    private Button resev;
=======
    private Label marquelabel1;
    @FXML
    private Label marquelabel2;
    @FXML
    private Label marquelabel3;
    @FXML
    private Label couleurlabel1;
    @FXML
    private Label couleurlabel2;
    @FXML
    private Label couleurlabel3;
    @FXML
    private Label vitesselabel1;
    @FXML
    private Label vitesselabel2;
    @FXML
    private Label vitesselabel3;
    @FXML
    private Label id_vehicule;
    @FXML
    private Label id_vehicule1;
    @FXML
    private Label id_vehicule2;
>>>>>>> master
 

    /**
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {

<<<<<<< HEAD
        this.setPane();
=======
//Affichage des donneés de la base  sur  le front
           String selectQuery = "SELECT id, marque ,couleur,vitesse_max FROM vehicule WHERE id = ?";
        try {
           PreparedStatement ps= MyConnexion.getIstance().getCnx().prepareStatement(selectQuery);
            for (int i = 1; i <= 6; i++) {
                ps.setInt(1, i); // id du véhicule à récupérer
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    int id_vehicule = resultSet.getInt("id");
                    String marque = resultSet.getString("marque");
                    String couleur = resultSet.getString("couleur");
                    String vitesse_max = resultSet.getString("vitesse_max");
                    if (i == 1) {
                        this.id_vehicule.setText("id_v: " + id_vehicule);
                        marquelabel1.setText("Marque : " + marque);
                        couleurlabel1.setText("couleur : " + couleur);
                        vitesselabel1.setText("vitesseMax: " + vitesse_max);
                        
                    } else if (i == 2) {
                        this.id_vehicule1.setText("id_v: " + id_vehicule);
                        marquelabel2.setText("Marque : " + marque);
                         couleurlabel2.setText("couleur : " + couleur);
                         vitesselabel2.setText("vitesseMax : " + vitesse_max);
                    } else if (i == 3) {
                        this.id_vehicule2.setText("id_v: " + id_vehicule);
                        marquelabel3.setText("Marque : " + marque);
                        couleurlabel3.setText("couleur : " + couleur);
                        vitesselabel3.setText("vitesseMax: " + vitesse_max);
                    }
                }
                
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    
          
>>>>>>> master

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

    private void ajouter(ActionEvent event) {
     
  
     // Création de l'alerte
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Saisie de plusieurs champs");
alert.setHeaderText(null);
alert.setContentText("Veuillez saisir les informations :");

// Création des champs de saisie
TextField champId = new TextField();
DatePicker champDateDebut = new DatePicker();
champDateDebut.setPromptText("YYYY-MM-DD");
DatePicker champDateFin = new DatePicker();
champDateFin.setPromptText("YYYY-MM-DD");

<<<<<<< HEAD
=======

// Création du GridPane pour les champs de saisie
GridPane grid = new GridPane();
grid.setPrefSize(300, 300);
grid.setStyle("-fx-background-color: #6F5CC2;");
grid.setHgap(10);
grid.setVgap(10);

grid.add(new Label("Identifiant:"), 0, 0);
grid.add(champId, 1, 0);
grid.add(new Label("Date de début:"), 0, 1);
grid.add(champDateDebut, 1, 1);
grid.add(new Label("Date de fin:"), 0, 2);
grid.add(champDateFin, 1, 2);

// Ajout du GridPane à l'alerte
alert.getDialogPane().setContent(grid);

>>>>>>> master
// Affichage de l'alerte et récupération des valeurs saisies
Optional<ButtonType> result = alert.showAndWait();
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
    
    Reservation r = new Reservation(Integer.parseInt(champId.getText()), dateDebut.toString(), dateFin.toString());
    Reservation_Service a = new Reservation_Service();
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
      "Votre réservation a été faite de "+champDateDebut.getValue()+ " jusqu à "+champDateFin.getValue())

    .create();

    System.out.println(message.getSid());
    
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
         stream = new FileInputStream("C:/Users/aziz/Desktop/clone/smartWheels/src/images/Xiaomi.png");
        }
        else if(marque.equals("NIU"))
        {
          stream = new FileInputStream("C:/Users/aziz/Desktop/clone/smartWheels/src/images/NIU.png");   
        }
        else if(marque.equals("IsinWheel"))
        {
             stream = new FileInputStream("C:/Users/aziz/Desktop/clone/smartWheels/src/images/IsinWheel.png");   
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
     private Button crateButton()
     {
       Button bt=new Button("Valider"); 
       bt.setTranslateY(200);
       bt.setTranslateX(100);
       return bt;
     }
   private Pane createPane(String marque,String couleur,String vitesse) {
    Pane pane = new Pane();
    pane.setPrefHeight(250);
    pane.setPrefWidth(250);
    pane.setStyle("-fx-background-color: #6F5CC2;");
    pane.getChildren().add(this.createImageView(marque));
    pane.getChildren().add(this.createLabel(0,0,"Marque:"+marque));
    pane.getChildren().add(this.createLabel(0,100,"Couleur:"+couleur));
    pane.getChildren().add(this.createLabel(100,100,"Vitesse:"+vitesse));
    pane.getChildren().add(this.crateButton());
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
                    String marque = resultSet.getString("marque");
                    String couleur = resultSet.getString("couleur");
                    String vitesse_max = resultSet.getString("vitesse_max");
                   
                      gridpane.add(this.createPane(marque,couleur,vitesse_max),j,i);
                        
                }
                        
                        //test.getChildren().add(resev);
                        //test2.getChildren().add(resev);
                       
                       
                       
                        
                   
                
                }
                
               
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    

// Copy the children of the original pane to the copied pane



    }

   
    
    


}
