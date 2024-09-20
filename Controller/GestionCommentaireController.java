/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

<<<<<<< HEAD:Controller/GestionCommentaireController.java
<<<<<<< HEAD:Controller/GestionCommentaireController.java
import static Controller.Utilisateur_gestionController.l_email;
import entities.Commentaire;
import entities.Utilisateur;
=======
import entities.Commentaire;
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/GestionCommentaireController.java
=======
import entities.Commentaire;
>>>>>>> master:src/Controller/GestionCommentaireController.java
import services.CommentaireCrud;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
<<<<<<< HEAD:Controller/GestionCommentaireController.java
import javafx.scene.Node;
=======
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/GestionCommentaireController.java
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
<<<<<<< HEAD:Controller/GestionCommentaireController.java
import javafx.scene.control.Label;
=======
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/GestionCommentaireController.java
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
<<<<<<< HEAD:Controller/GestionCommentaireController.java
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.Carte_fideliteS;
import services.UtilisateurS;
=======
import javafx.stage.Stage;
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/GestionCommentaireController.java


public class GestionCommentaireController implements Initializable {

   CommentaireCrud cmntr =new CommentaireCrud();

    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane left;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private TextArea tfCmntr;
    @FXML
    private Button btnInsertCmntr;
    @FXML
    private Button btnUpdateCmntr;
    @FXML
    private Button btnDeleteCmntr;
    @FXML
    private TableView<Commentaire> tvcommentaire;
    @FXML
    private TableColumn<Commentaire,?> colpseudo;
    @FXML
    private TableColumn<Commentaire, String> colcommentaire;
    @FXML
    private TextField tfidcom;
    @FXML
<<<<<<< HEAD:Controller/GestionCommentaireController.java
    private Label l_prenom;
    @FXML
    private Label l_nom;
    @FXML
    private VBox vboxid;
    @FXML
    private Button Evenement;
    @FXML
    private Button id_rec;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
        vboxid.setSpacing(18);
=======
    private Button btn_vehicule;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/GestionCommentaireController.java
         showCommentaire();
    }    
    public ObservableList<Commentaire>getCommentaireList(){
ObservableList<Commentaire> CommentaireList= FXCollections.observableArrayList();
CommentaireList.addAll(cmntr.listeDesCommentaires());
return CommentaireList; 

}  
public void showCommentaire(){

ObservableList<Commentaire> List =getCommentaireList();
colpseudo.setCellValueFactory(new PropertyValueFactory<>("id_com"));

colcommentaire.setCellValueFactory(new PropertyValueFactory<>("contenu"));
   
tvcommentaire.setItems(List);
}
/*ajout modifier et supprimer pour les commentaires */


    @FXML
    private void InsertCmntr(ActionEvent event) {
         if (ControleCmntr().length()>0){
         Alert alert =new Alert(Alert.AlertType.ERROR);
        alert.setTitle("done");
        alert.setContentText("commentaire ajoutée");
        alert.showAndWait();}
         else if(detectBadWords()){
         }
         else{
        Commentaire r =new Commentaire();
        r.setContenu(tfCmntr.getText());
        
        cmntr.ajouterCommentaire(r);
        showCommentaire();}
<<<<<<< HEAD:Controller/GestionCommentaireController.java
         //add client to carte
      
=======
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/GestionCommentaireController.java
    }

    @FXML
    private void UpdateCmntr(ActionEvent event) {
         if (ControleCmntr().length()>0){
         Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("confirmer la modification");
        alert.setContentText("voulez vous vraiment modifier");
        alert.showAndWait();}
          else if(detectBadWords()){
         }
         else{
         Commentaire r =new Commentaire();
         int idModifier=tvcommentaire.getSelectionModel().getSelectedItem().getId_com();
        r.setContenu(tfCmntr.getText());
       
        cmntr.updateCommentaire(idModifier, r);
        showCommentaire();
    }}

    @FXML
    private void DeleteCmntr(ActionEvent event) {
         Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("confirmer la suppression");
        alert.setContentText("voulez vous vraiment supprimer ?");
        alert.showAndWait();
        int idSup=tvcommentaire.getSelectionModel().getSelectedItem().getId_com();
        cmntr.supprimerCommentaire(idSup);
        showCommentaire();
    }
    private String ControleCmntr(){

    String erreur="";
if(tfCmntr.getText().trim().isEmpty()){
erreur+="nom vide \n";}

return erreur;

}

<<<<<<< HEAD:Controller/GestionCommentaireController.java
=======
    @FXML
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/GestionCommentaireController.java
    private void btn_vehicule(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/GestionCommentaire.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.show();
        
    }
     public boolean detectBadWords() {
        String[] badWords = { "bad", "ugly", "nasty" }; // replace with your own list of bad words
        String comment = tfCmntr.getText().toLowerCase();
        boolean hasBadWord = false;
        for (String word : badWords) {
            if (comment.contains(word)) {
                hasBadWord = true;
                break;
            }
        }
        if (hasBadWord) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Your comment contains a bad word.");
            alert.showAndWait();
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Your comment is good.");
            alert.showAndWait();
            return false ;
        }
    }

<<<<<<< HEAD:Controller/GestionCommentaireController.java
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
    }

    @FXML
    private void Reclamation(ActionEvent event) {
    }

    @FXML
    private void dexonnexion(ActionEvent event) {
    }

=======
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/GestionCommentaireController.java
   
}
