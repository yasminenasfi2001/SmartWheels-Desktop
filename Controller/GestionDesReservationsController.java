/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Utilisateur_gestionController.l_email;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Reservation;
import entities.Utilisateur;
import entities.Vehicule;

import java.awt.Desktop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import services.Reservation_Service;
import services.UtilisateurS;
import services.vehicule_Service;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GestionDesReservationsController implements Initializable {

    @FXML
    private Pane left;

    @FXML
    private TableView<Reservation> tab;
    @FXML
    private Button supprimer_reservation;
    @FXML
    private Button modifier_reservation;
    @FXML
    private Button ajouter_reservation;
    @FXML
    private TableColumn<?, ?> colid_res;
    @FXML
    private TableColumn<?, ?> coldd_r;
    @FXML
    private TableColumn<?, ?> coldf_r;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TableColumn<?, ?> colm;
    @FXML
    private Button statistique;
    @FXML
    private Button impressionpdf;
    private TextField autoTextField;
    @FXML
    private Button recherche_Reservation;
    @FXML
    private Button refreshTableView;
    @FXML
    private ChoiceBox<String> choiceBoxMois;
    @FXML
    private TableColumn<?, ?> colid_v;
    @FXML
    private TableColumn<?, ?> colid_c;
    @FXML
    private ComboBox<String> id_client;
    @FXML
    private ComboBox<String> id_veh;
    @FXML
    private AnchorPane anchor;
    @FXML
    private VBox vboxid;
    @FXML
    private Button Evenement;
    @FXML
    private Button id_rec;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private Label l_prenom;
    @FXML
    private Label l_nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vboxid.setSpacing(18);
        tab.setOnMouseClicked(event ->{
           if (event.getClickCount() == 2 && !tab.getSelectionModel().isEmpty() )

        SetAllTextField();
        });
        this.afficher();
          Controller.Utilisateur_gestionController c=new Controller.Utilisateur_gestionController();
          
      Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
        
 
        
        //liste deroulante mois reservation bar recherche
ObservableList<String> moisList = FXCollections.observableArrayList("Janvier                                                              ","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre");


choiceBoxMois.setItems(moisList);

this.combo_boxs();
        UtilisateurS us=new UtilisateurS();
        ObservableList<Utilisateur>u=us.afficher();
       ObservableList<String> list = FXCollections.observableArrayList();
        for (int i=0;i<u.size();i++)
        {
            list.add(String.valueOf(u.get(i).getId())); 
        }
        id_client.setItems(list);
    

    }
public void SetAllTextField()
   {
      Reservation_Service rs= new Reservation_Service(); 
     Reservation r=tab.getSelectionModel().getSelectedItem();
      
      
      date_debut.setValue(LOCAL_DATE(r.getDate_debut()));
      date_fin.setValue(LOCAL_DATE(r.getDate_fin()));

      
   }    



    private void btn_vehicule(ActionEvent event) throws IOException {
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
    private void supprimer_reservation(ActionEvent event) {
        
                Reservation r= tab.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        Reservation_Service rs= new Reservation_Service();   
       
        if (r!=null){
        
        alert.setTitle("Confirmation de suppression");
         alert.setHeaderText("Confiramation de suppression");
         alert.setContentText("Voulez-vous vraiment supprimer le véhicule N°" +r.getId_res());
    
        Optional<ButtonType> result = alert.showAndWait();
         // ... user chose OK
       if (result.get() == ButtonType.OK){

            rs.Supprimer_reservation(r.getId_res());
            this.afficher();
       }
    }
  else
    {
           Alert al = new Alert(AlertType.ERROR);

           al.setTitle("Error alert");
           al.setHeaderText("Vous devez selectionner au moin un id pour suprrimer");
   
            al.showAndWait();
    }
    }
    

    @FXML
    private void modifier_reservation(ActionEvent event) {
                      if(!(id_veh.getValue().toString().equals("") || date_debut.getValue().equals("")  || date_fin.getValue().equals("")))
                {
                
       Reservation_Service resS=new Reservation_Service();
        
        Reservation r_enregistre=resS.GetUserById(Integer.parseInt(id_veh.getValue().toString()));
        
        Reservation r= new Reservation(0,date_debut.getValue().toString(),date_fin.getValue().toString());
           
                 
         if (!(r.getId_res()==(r_enregistre.getId_res()) 
               && r.getDate_debut().equals(r_enregistre.getDate_debut()) 
               && r.getDate_fin().equals(r_enregistre.getDate_fin()) 
             
              
               )
             
            )
          
         {
       Reservation_Service rs= new Reservation_Service();
        
        resS.modifier_reservation(r);   
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Modification avec succées pour la reservation N° "+r.getId_res());
        alert.showAndWait();
        this.afficher();     
         }
         else
         {
              Alert al = new Alert(AlertType.ERROR);
           al.setTitle("Error alert");
           al.setHeaderText("Vous devez Changer au moin un attribut");
            al.showAndWait();
         }
                }
                else
                {
                     Alert al = new Alert(AlertType.ERROR);
           al.setTitle("Error alert");
           al.setHeaderText("Vous devez selectionner au moin une reservation pour modifier!");
            al.showAndWait();
                }  
    }

    @FXML
    private void ajouter_reservation(ActionEvent event) {
        
             
        //if different ll vide ->ajouter 
       if(!(date_debut.getValue().equals("")  || date_fin.getValue().equals("")))
                {
          
try {
    LocalDate dateDebut = LocalDate.parse(date_debut.getValue().toString());
    LocalDate dateFin = LocalDate.parse(date_fin.getValue().toString());
    
    if (dateDebut.isAfter(dateFin)) {
        Alert alertDate = new Alert(Alert.AlertType.ERROR);
        alertDate.setTitle("Erreur de saisie");
        alertDate.setHeaderText(null);
        alertDate.setContentText("La date de début doit être antérieure à la date de fin");
        alertDate.showAndWait();
       
    }
    
    else {
        Reservation_Service s=new Reservation_Service();
        Reservation r = new Reservation(0, dateDebut.toString(), dateFin.toString(),s.calculmontant(dateDebut.toString(), dateFin.toString()),Integer.parseInt(id_veh.getValue().toString()),Integer.parseInt(id_client.getValue().toString()));
    Reservation_Service a = new Reservation_Service();
    a.ajouter_reservation(r);
     a.afficher_reservation();
    Alert al = new Alert(Alert.AlertType.INFORMATION);
    al.setTitle("Réservation effectuée");
    al.setHeaderText(null);
    al.setContentText("Votre réservation a été faite.");
    al.showAndWait();
    this.afficher();
   
    }
    
    // Les dates sont valides, vous pouvez créer votre objet Reservation

} catch (DateTimeParseException e) {

}       
                }
       
       
       else 
        {
Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Error alert");
alert.setHeaderText("Les champs de texte d'un formulaire ne doivent pas être null/vide"); 
alert.showAndWait();
        }
       
      
                }    
    
    
     public void afficher(){
 
Reservation_Service vs= new Reservation_Service(); 
         
         colid_res.setCellValueFactory(new PropertyValueFactory<>("id_res"));
         coldd_r.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         coldf_r.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        
         colm.setCellValueFactory(new PropertyValueFactory<>("montant"));
         colid_v.setCellValueFactory(new PropertyValueFactory<>("id_v"));
         colid_c.setCellValueFactory(new PropertyValueFactory<>("id_client"));
         tab.setItems(vs.afficher_reservation());  

 }   
    
    
    
    
    public static final LocalDate LOCAL_DATE (String dateString){
        
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
        
    }

    private void front(ActionEvent event) throws IOException {
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

    @FXML
    private void statistique(ActionEvent event) {
        
                try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/statistique_Reservation.fxml"));  
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

private void impressionpdf(ActionEvent event) {
    colid_res.setCellValueFactory(new PropertyValueFactory<>("id_res"));
    coldd_r.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
    coldf_r.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
    colm.setCellValueFactory(new PropertyValueFactory<>("montant"));

    // Configurez le comportement du bouton lorsqu'il est cliqué
    impressionpdf.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {

                // Afficher une boîte de dialogue de sauvegarde pour spécifier le nom et l'emplacement du fichier PDF
             FileChooser fileChooser = new FileChooser();
fileChooser.setInitialDirectory(new File("C:/Users/aziz/Desktop")); // définir le répertoire initial ici
fileChooser.setTitle("Enregistrer le fichier PDF");
fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier PDF (*.pdf)", "*.pdf"));
File file = fileChooser.showSaveDialog(null);


                if (file != null) {
                    Document document = new Document();
                    document.setMargins(20, 20, 20, 20);
                    // Configurez la destination du fichier PDF
                    FileOutputStream fos = new FileOutputStream(file);
                    PdfWriter writer = PdfWriter.getInstance(document, fos);

                    // Ouvrez le document pour écrire le contenu
                    document.open();

                    document.addTitle("Rapport de réservations");

// Ajoutez le logo de l'entreprise

                Image logo = Image.getInstance("C:/Users/aziz/Desktop/clone/smartWheels/src/images/a.png");
                logo.scaleAbsolute(100, 100);
                document.add(logo);
// Ajoutez les informations de l'entreprise
                    Paragraph infos = new Paragraph();
                    Font headerFont1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                    headerFont1.setColor(new BaseColor(82, 67, 143));
                    infos.add(new Phrase("SMART WHEELS\n", headerFont1));
                    document.add(infos);


                    // Ajoutez une table PDF pour afficher les données de la tableView
                    PdfPTable table = new PdfPTable(4);
                    table.setWidthPercentage(100);
                    table.setSpacingBefore(20f);
                    table.setSpacingAfter(20f);
                    

                    // Configurez les largeurs de colonne de la table PDF
                    float[] columnWidths = {1f,2f, 2f, 1f};
                    table.setWidths(columnWidths);

                    // Créez une cellule PDF pour l'en-tête de chaque colonne
Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);



 PdfPCell cell = new PdfPCell(new Phrase("ID", headerFont));
                cell.setBackgroundColor(new BaseColor(82, 67, 143)); // couleur hexadécimale #52438F
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderColor(BaseColor.WHITE); // pour rendre les bordures blanches
                table.addCell(cell);
                
                
cell = new PdfPCell(new Phrase("Date de Debut", headerFont));
cell.setBackgroundColor(new BaseColor(82, 67, 143)); // couleur hexadécimale #52438F
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
cell.setBorderColor(BaseColor.WHITE); // pour rendre les bordures blanches
table.addCell(cell);

cell = new PdfPCell(new Phrase("Date de fin", headerFont));
cell.setBackgroundColor(new BaseColor(82, 67, 143)); // couleur hexadécimale #52438F
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
cell.setBorderColor(BaseColor.WHITE); // pour rendre les bordures blanches
table.addCell(cell);

cell = new PdfPCell(new Phrase("Montant", headerFont));
cell.setBackgroundColor(new BaseColor(82, 67, 143)); // couleur hexadécimale #52438F
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
cell.setBorderColor(BaseColor.WHITE); // pour rendre les bordures blanches
table.addCell(cell);


                    // Ajoutez les données de chaque ligne à la table PDF
                    List<Reservation> items = tab.getItems();
for (Reservation item : items) {
    cell = new PdfPCell(new Phrase(Integer.valueOf(item.getId_res()).toString()));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase(item.getDate_debut().toString()));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase(item.getDate_fin().toString()));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase(Double.toString(item.getMontant())));
    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    table.addCell(cell);
}

                    // Ajoutez la table PDF au document
                    document.add(table);

                    // Fermez le document
                    document.close();

                    // Ouvrir le fichier PDF dans une application de lecture de PDF
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(file);
                    }


                   /*
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setTitle("Impression PDF");
                    al.setHeaderText(null);
                    al.setContentText("Le fichier PDF a été créé");
                    al.showAndWait();
*/
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la création du fichier PDF : " + e.getMessage());
            }
        }
    });
}

    @FXML
private void recherche_Reservation(ActionEvent event) {
    String mois = choiceBoxMois.getSelectionModel().getSelectedItem();
    ObservableList<Reservation> result = FXCollections.observableArrayList();

    //condition sur  le bouton chercher Si aucun mois n'est sélectionné
    if(mois == null || mois.isEmpty()) { 
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Veuillez sélectionner un mois avant de lancer la recherche");
        alert.showAndWait();
        return;
    }

    try {
        DateFormat inputFormat = new SimpleDateFormat("MMMM", Locale.FRANCE);
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = inputFormat.parse(mois);
        String dateDebutStr = outputFormat.format(dateDebut);
        PreparedStatement ps=MyConnection.getInstance().getCnx().prepareStatement("select * from reservation where MONTH(date_debut) = MONTH(?)");
        ps.setString(1, dateDebutStr);
        ResultSet rs=ps.executeQuery();
        
        if (!rs.isBeforeFirst() ) { // Si le ResultSet est vide
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Aucune réservation trouvée pour ce mois");
            alert.showAndWait();
        } else {
            while (rs.next()) {
                result.add(new Reservation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6)));
            }
            tab.setItems(result);
        }
        
    } catch(Exception ex) {
        System.out.println(ex);
    }
}





    @FXML
    private void refreshTableView(ActionEvent event) {
        
this.afficher();
    }


    
    public  void combo_boxs()
    {
        Vehicule v=new Vehicule();
        vehicule_Service vs=new vehicule_Service();
       
         ObservableList<String> options =  vs.GetAllIdUser();
       
      id_veh.setItems(options);
      id_veh.setPromptText("Entrer votre vehicule");
    }

   

    @FXML
    private void home(ActionEvent event) {
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
    private void Produits(ActionEvent event) {
        try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/Produit.fxml"));  
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
    private void deconexion(ActionEvent event) {
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

    
          

