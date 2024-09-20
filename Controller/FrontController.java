/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Insets;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
<<<<<<< HEAD:Controller/FrontController.java
import static Controller.Utilisateur_gestionController.l_email;
=======
import static Controller.Gestion_UtilisateurController.l_email;
>>>>>>> master:src/Controller/FrontController.java
import entities.Utilisateur;
import services.UtilisateurS;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class FrontController implements Initializable {

    @FXML
    private AnchorPane anchor1;
    @FXML
    private Button Front;
    @FXML
    private Button Front1;
    @FXML
    private Label l_prenom;
    @FXML
    private Label l_nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
    }    

    @FXML
    private void Go_to_Back(ActionEvent event) {
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
    private void Go_to_Login(ActionEvent event) {
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
     public static void SetLoginData(String Email,String mot_passe)
    {
        Controller.Utilisateur_gestionController.l_email=Email;
        Controller.Utilisateur_gestionController.l_motPasse=mot_passe;
    }
    
}
