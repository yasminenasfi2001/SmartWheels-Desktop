/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class GestionDesVehiculesController implements Initializable {

    @FXML
    private TextField autoTextField;
    @FXML
    private Button cherchee;
    @FXML
    private TextField charge_max;
    @FXML
    private TableView<?> tab;
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> colmarque;
    @FXML
    private TableColumn<?, ?> colprix;
    @FXML
    private TableColumn<?, ?> colvitesse_max;
    @FXML
    private TableColumn<?, ?> colcharge_max;
    @FXML
    private TableColumn<?, ?> colauto_b;
    @FXML
    private TableColumn<?, ?> colcouleur;
    @FXML
    private TableColumn<?, ?> coltype;
    @FXML
    private Button ajouter;
    @FXML
    private TextField couleur;
    @FXML
    private Button supprimer;
    @FXML
    private TextField id;
    @FXML
    private ComboBox<?> type;
    @FXML
    private Button modifier;
    @FXML
    private TextField prix;
    @FXML
    private ComboBox<?> marque;
    @FXML
    private ComboBox<?> vitesse_max;
    @FXML
    private ComboBox<?> auto_b;
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
        // TODO
    }    

    @FXML
    private void cherchee(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void home(ActionEvent event) {
    }

    @FXML
    private void Utilisateur(ActionEvent event) {
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
    
}
