
package Controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static Controller.Utilisateur_gestionController.l_email;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Produit;
import entities.Utilisateur;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ProduitService;
import services.UtilisateurS;


/**
 * FXML Controller class
 *
 * @author snowy
 */
public class ProduitController implements Initializable {


 

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
    private TableColumn<Produit, ImageView> colimgprod;

    @FXML
    private Button modifbtn;

    @FXML
    private Button supprbtn;

    @FXML
    private Button ajoutbtn;

    @FXML
    private TextField lbquantprod;

    @FXML
    private TextField lbprixprod;

    @FXML
    private TextField lbtypeprod;

    @FXML
    private TextField lbnomprod;

    @FXML
    private TextField lbdescprod;

    @FXML
    private Button imgadd;

    @FXML
    private TextField URLImage;

    private ImageView imageView;
    
    
       ProduitService sp = new ProduitService();
     List<Produit> lp = sp.afficher();
     public String imagecomp; 
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
    private AnchorPane anchor2;
    @FXML
    private Pane left1;
    @FXML
    private VBox vboxid1;
    @FXML
    private Button Evenement1;
    @FXML
    private Button id_rec1;
    @FXML
    private AnchorPane anchor3;
    @FXML
    private Pane left2;
    @FXML
    private VBox vboxid2;
    @FXML
    private Button Evenement2;
    @FXML
    private Button id_rec2;
    @FXML
    private AnchorPane anchor4;
    @FXML
    private Pane left3;
    @FXML
    private Button Evenement3;
    @FXML
    private Button id_rec3;
    @FXML
    private AnchorPane anchor5;
    @FXML
    private Pane left4;
    @FXML
    private VBox vboxid4;
    @FXML
    private Button Evenement4;
    @FXML
    private Button id_rec4;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
@Override

public void initialize(URL url, ResourceBundle rb) {
       Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
        vboxid.setSpacing(18);
        
       
    this.afficher_produit();
    tabprod.setOnMouseClicked(event ->{
        if (event.getClickCount() == 2) {
            SetAllTextField();
        }
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
    URLImage.setText(P.getImage_url());
    
    try {
        File file = new File(P.getImage_url());
        if (file.exists()) {
            Image image = new Image(file.toURI().toURL().toExternalForm());
            imageView.setImage(image);
        } else {
            imageView.setImage(null);
        }
    } catch (MalformedURLException ex) {
        imageView.setImage(null);
    }
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
        String imgAjout = URLImage.getText();

         Produit p1 = new Produit(nomAjout,typeAjout,quantAjout,prixAjout,descAjout,imgAjout);
          
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
    void imageadd(ActionEvent event) throws FileNotFoundException, IOException {
           FileChooser f = new FileChooser();
        String img;
  String filename="";
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        File fc = f.showOpenDialog(null);
        if (f != null) {
            //System.out.println(fc.getName());
            img = fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            imageView.setImage(i);
            imagecomp = fc.toString();
            System.out.println(imagecomp);
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                 filename = imagecomp.substring(index + 1);
            }

            Produit.filename = "C:\\Users\\snowy\\Pictures" + filename;
            //se.sendphp(fc.getAbsolutePath());
        }
        imageView.setFitHeight(215);
        imageView.setFitWidth(265);
        //..\img\google.png

        //C:\Users\splin\Documents\NetBeansProjects\FanArt\\com\esprit\img
        Produit.pathfile = fc.getAbsolutePath();

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
        String imgAjout = URLImage.getText();

         
        
     
         
        
        Produit p = new Produit(nomAjout,typeAjout,quantAjout,prixAjout,descAjout,imgAjout);
        
        
            sp.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("produit ajouté!");
            alert.show();
            lbnomprod.setText("");
            lbprixprod.setText("");
            lbquantprod.setText("");
          
           
            lbdescprod.setText("");
            URLImage.setText("");

            
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
         colimgprod.setCellValueFactory(new PropertyValueFactory<>("image_url"));
         tabprod.setItems(util.afficher());
          
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
         Parent root = FXMLLoader.load(getClass().getResource("/gui/InterfaceAdminController.fxml"));  
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

 
   
}
