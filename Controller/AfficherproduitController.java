/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package gestionventee;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 * FXML Controller class
 *
 * @author snowy
 */
public class AfficherproduitController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Pane pn;
    @FXML
    private JFXButton afp;
    @FXML
    private TableView<Produit> tabprod;
    @FXML
    private TableColumn<?, ?> colidprod;
    @FXML
    private TableColumn<?, ?> colnomprod;
    @FXML
    private TableColumn<?, ?> coltypeprod;
    @FXML
    private TableColumn<?, ?> colquantprod;
    @FXML
    private TableColumn<?, ?> colprixprod;
    @FXML
    private TableColumn<?, ?> colddescprod;
    @FXML
    private JFXButton modifbtn;
    @FXML
    private JFXButton supprbtn;
    @FXML
    private JFXButton ajoutbtn;
    @FXML
    private JFXTextField lbquantprod;
    @FXML
    private JFXTextField lbprixprod;
    @FXML
    private JFXTextField lbtypeprod;
    @FXML
    private JFXTextField lbnomprod;
    @FXML
    private JFXTextField lbdescprod;
    
    
       ProduitService sp = new ProduitService();
     List<Produit> lp = sp.afficher();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       this.afficher_produit();
       tabprod.setOnMouseClicked(event ->{
           if (event.getClickCount() == 2  )
           SetAllTextField();
        });
     
       
    }    
    public void SetAllTextField(){
        Produit P=new Produit();
        P=tabprod.getSelectionModel().getSelectedItem();
        lbnomprod.setText(P.getNom_prod());
        lbprixprod.setText(String.valueOf(P.getPrix_prod()));
        lbtypeprod.setText(P.getType_prod());
        lbdescprod.setText(P.getDesc_prod());
        lbquantprod.setText(String.valueOf(P.getQuant_prod()));
    }
    @FXML
    private void afp2(ActionEvent event) {
    }

    @FXML
    private void modifprodbtn(ActionEvent event) {
        ProduitService ps=new ProduitService();

       
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de Modification");
        alert.setHeaderText("Voulais vous modifier ce produit:");    
       
  
        // ... user chose OK
      
          
            {
         Optional<ButtonType> result = alert.showAndWait();
         if (result.get() == ButtonType.OK){
        String nomAjout = lbnomprod.getText();
        String typeAjout = lbtypeprod.getText(); 
        int quantAjout = Integer.parseInt(lbquantprod.getText());
        Float prixAjout = Float.parseFloat(lbprixprod.getText());   
        String descAjout = lbdescprod.getText();
            
         Produit p1 = new Produit(nomAjout,typeAjout,quantAjout,prixAjout,descAjout);
          
         ps.modifier(p1,tabprod.getSelectionModel().getSelectedItem().getId_prod());
         System.out.println("modifier avec succes");
         this.afficher_produit();
          
            }
         
         else
            {
           Alert al = new Alert(Alert.AlertType.ERROR);
           al.setTitle("Error alert");
           al.setHeaderText("Vous devez Changer au moin un attribut");
            al.showAndWait();    
            }
        }
    
}


    @FXML
    private void supprprodbtn(ActionEvent event) {
               
       ProduitService utils=new ProduitService();
       Produit produit =new Produit();
       
        produit =tabprod.getSelectionModel().getSelectedItem();
       
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppresion");
        alert.setHeaderText("Voulais vous supprimer ces ou cette id:");
      
            // ... user chose OK
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
           utils.Supprimer(produit.getId_prod());
           this.afficher_produit();
            }
            else{
            Alert al = new Alert(Alert.AlertType.ERROR);

           al.setTitle("Error alert");
           al.setHeaderText("Vous devez selectionner au moin un id pour suprrimer");
   
            al.showAndWait();
                
            }
        
    }

    @FXML
    private void ajoutprod(ActionEvent event) {
        
         if ((lbnomprod.getText().equals(""))||(lbprixprod.getText().equals(""))||(lbquantprod.getText().equals(""))||(lbdescprod.getText().equals("")))
       {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("champs manquants !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Il faut taper le nom !");
       }
       
       else if(!( Pattern.matches("[a-z,A-Z]*",lbnomprod.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Nom  doit etre de type caractére !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
        else if(!( Pattern.matches("[0-9]*",lbprixprod.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("prix du produit doit etre de type numérique !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
         else if(!( Pattern.matches("[0-9]*",lbquantprod.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("quantité du produit doit etre de type numérique !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
    
      
        else {
        ProduitService sp= new ProduitService();
        String nomAjout = lbnomprod.getText();
        String typeAjout = lbtypeprod.getText();
        
        int quantAjout = Integer.parseInt(lbquantprod.getText());
        Float prixAjout = Float.parseFloat(lbprixprod.getText());
        
        
        
        String descAjout = lbdescprod.getText();

         
        
     
         
        
        Produit p = new Produit(nomAjout,typeAjout,quantAjout,prixAjout,descAjout);
        
        
            sp.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("produit ajouté!");
            alert.show();
            lbnomprod.setText("");
            lbprixprod.setText("");
            lbquantprod.setText("");
          
           
            lbdescprod.setText("");

            
            ProduitService spp = new ProduitService();
             List<Produit> lp = spp.afficher();
             tabprod.getItems().clear();
          afficher_produit( );
                    

        

         
    }
    }
        public void afficher_produit()  {
            
         ProduitService util=new ProduitService();
         tabprod.setEditable(true);
         colidprod.setCellValueFactory(new PropertyValueFactory<>("id_prod"));
         colnomprod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
         coltypeprod.setCellValueFactory(new PropertyValueFactory<>("type_prod"));
         colprixprod.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));
         colquantprod.setCellValueFactory(new PropertyValueFactory<>("quant_prod"));
         colddescprod.setCellValueFactory(new PropertyValueFactory<>("desc_prod"));
         tabprod.setItems(util.afficher());
          
    }
        

   
}
