/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author user
 */




import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import entities.Commentaire;
import entities.Reservation;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
import services.CommentaireCrud;
import services.Reservation_Service;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author user
 */

public class FrontCommentaireController implements Initializable {

    CommentaireCrud cmntr = new CommentaireCrud();

    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane left;
    @FXML
    private AnchorPane anchor1;
    @FXML
   // private TextArea tfCmntr;
 
   
    private Button btnInsertCmntr;
    @FXML
    private Button btnUpdateCmntr;
    @FXML
    private Button btnDeleteCmntr;
    @FXML
    private ListView<Commentaire> lvCommentaire;
    @FXML
    private TextArea tfCmntr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCommentaire();
    }

    public ObservableList<Commentaire> getCommentaireList() {
        ObservableList<Commentaire> CommentaireList = FXCollections.observableArrayList();
        CommentaireList.addAll(cmntr.listeDesCommentaires());
        return CommentaireList;
    }

    public void showCommentaire() {
        ObservableList<Commentaire> List = getCommentaireList();
        lvCommentaire.setItems(List);
        lvCommentaire.setCellFactory(commentaireListView -> new ListCell<Commentaire>() {
            @Override
            protected void updateItem(Commentaire commentaire, boolean empty) {
                super.updateItem(commentaire, empty);
                if (empty || commentaire == null) {
                    setText(null);
                } else {
                    setText(commentaire.getContenu());
                }
            }
        });
    }

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
         int idModifier=lvCommentaire.getSelectionModel().getSelectedItem().getId_com();
        r.setContenu(tfCmntr.getText());
       
        cmntr.updateCommentaire(idModifier, r);
        showCommentaire();
    }}

    @FXML
    private void DeleteCmntr(ActionEvent event) {
 Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Confirm Deletion");
    alert.setContentText("Are you sure you want to delete the selected item?");

    ButtonType deleteButtonType = new ButtonType("Delete");
    ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(deleteButtonType, cancelButtonType);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == deleteButtonType) {
        int idSup=lvCommentaire.getSelectionModel().getSelectedItem().getId_com();
        cmntr.supprimerCommentaire(idSup);
        showCommentaire();
    } else {
        alert.close();
    }}
    private String ControleCmntr(){

    String erreur="";
if(tfCmntr.getText().trim().isEmpty()){
erreur+="nom vide \n";}

return erreur;

}

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

   
}

