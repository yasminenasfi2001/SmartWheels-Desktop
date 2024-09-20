/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
<<<<<<< HEAD:Controller/FrontClientController.java
import static Controller.Utilisateur_gestionController.l_email;
=======
import static Controller.Gestion_UtilisateurController.l_email;
>>>>>>> master:src/Controller/FrontClientController.java
import entities.Utilisateur;
import services.UtilisateurS;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class FrontClientController implements Initializable {

    @FXML
    private AnchorPane anchor1;
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
