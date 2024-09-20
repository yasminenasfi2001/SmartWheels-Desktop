/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

<<<<<<< HEAD:Controller/FXMLDocumentController.java
import static Controller.Utilisateur_gestionController.l_email;
import entities.Commentaire;
import entities.Reclamation;
import entities.Utilisateur;
=======
import entities.Commentaire;
import entities.Reclamation;
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
import services.CommentaireCrud;
import services.ReclamationCrud;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD:Controller/FXMLDocumentController.java
import java.util.Optional;
import java.util.stream.Collectors;
=======
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javafx.application.Platform;
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
<<<<<<< HEAD:Controller/FXMLDocumentController.java
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
=======
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
<<<<<<< HEAD:Controller/FXMLDocumentController.java
import services.UtilisateurS;
=======
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfcontenu;
    @FXML
    private TableView<Reclamation> tvreclamation;
    @FXML
    private TableColumn<Reclamation,?> colid;
    @FXML
    private TableColumn<Reclamation, String> colnom;
    @FXML
    private TableColumn<Reclamation, String> colprenom;
    @FXML
    private TableColumn<Reclamation, String> coladresse;
    @FXML
    private TableColumn<Reclamation, String> colcontenu;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    ReclamationCrud rc=new ReclamationCrud();
    CommentaireCrud cmntr =new CommentaireCrud();
    private List<Reclamation> listeDesReclamations;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane left;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private TextArea tfCmntr;
<<<<<<< HEAD:Controller/FXMLDocumentController.java
=======
    @FXML
    private Button btnInsertCmntr;
    @FXML
    private Button btnUpdateCmntr;
    @FXML
    private Button btnDeleteCmntr;
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
     @FXML
    private Button btnExportExcel;
    @FXML
    private TableView<Commentaire> tvcommentaire;
    @FXML
    private TableColumn<Commentaire,?> colpseudo;
    @FXML
    private TableColumn<Commentaire, String> colcommentaire;
    @FXML
<<<<<<< HEAD:Controller/FXMLDocumentController.java
    private TableColumn<Reclamation, Date> cdate;
    @FXML
    private TextField tfrecherche;
    @FXML
    private Button btnInsertCmntr;
    @FXML
    private Button btnUpdateCmntr;
    @FXML
    private Button btnDeleteCmntr;
    @FXML
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
    private TextField tfidcom;
    @FXML
    private Button btn_vehicule;
    @FXML
    private TextField NomTextField;
    @FXML
    private TextField ContenuTextField;
    @FXML
    private TextField MailTextField;
    @FXML
    private TableColumn<Reclamation, Date> cdate;
    @FXML
    private TextField tfrecherche;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
     recherche_avance();
        //showReclamation();
        showCommentaire();
    }
   
    


    
        
  
public ObservableList<Reclamation>getReclamationList(){
    this.listeDesReclamations=rc.listeDesReclamations();
ObservableList<Reclamation> ReclamationList = FXCollections.observableArrayList();
ReclamationList.addAll(rc.listeDesReclamations());
return ReclamationList; 

}  
public void showReclamation(){

ObservableList<Reclamation> List =getReclamationList();
colid.setCellValueFactory(new PropertyValueFactory<>("Id"));
colnom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
colprenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
coladresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
colcontenu.setCellValueFactory(new PropertyValueFactory<>("Contenu"));
cdate.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
tvreclamation.setItems(List);
}

/*ajout modifier et supprimer pour la reclamation */


    @FXML
    private void insert(ActionEvent event) {
        if (ControleSaisie().length()>0){
         Alert alert =new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ajout Reclamation");
        alert.setContentText(ControleSaisie());
        alert.showAndWait();}
        else {
            
        Reclamation r =new Reclamation();
        r.setNom(tfnom.getText());
        r.setPrenom(tfprenom.getText());
        r.setAdresse(tfadresse.getText());
        r.setContenu(tfcontenu.getText());
        if(rc.contentExist(r)){
            Alert alert =new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ajout Reclamation");
        alert.setContentText("Reclamation existe deja!!");
        alert.showAndWait();
        }
        else{
            rc.ajouterEntitee(r);
            //sendMail();
        showReclamation();
        }
        }


    }
    @FXML
    private void update(ActionEvent event) {
         
         Reclamation r =new Reclamation();
         Reclamation amodifier=tvreclamation.getSelectionModel().getSelectedItem();
         Date today=new Date();
        if(today.getDate()-amodifier.getDateCreation().getDate()>1){
            Alert alert2 =new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Erreur modification");
<<<<<<< HEAD:Controller/FXMLDocumentController.java
            alert2.setContentText("vous ne pouvez pas modifier au dela de 24h!");
            alert2.showAndWait();
        }
        else{
           if (ControleSaisie().length()>0){
         Alert alert =new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Modifier Reclamation");
        alert.setContentText(ControleSaisie());
        alert.showAndWait();}
        else {
        int idModifier=amodifier.getId();

       // Reclamation r =new Reclamation();
        r.setNom(tfnom.getText());
        r.setPrenom(tfprenom.getText());
        r.setAdresse(tfadresse.getText());
        r.setContenu(tfcontenu.getText());
        if(rc.contentExist(r)){
            Alert alert =new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Modifier Reclamation");
        alert.setContentText("Reclamation existe deja!!");
        alert.showAndWait();
        }
        else{
            rc.updateReclamation(idModifier, r);
        showReclamation();
        }
        }


=======
            alert2.setContentText("voulez vous vraiment modifier");
            alert2.showAndWait();
        }
        else{
            int idModifier=amodifier.getId();
         
            r.setNom(tfnom.getText());
            r.setPrenom(tfprenom.getText());
            r.setAdresse(tfadresse.getText());
            r.setContenu(tfcontenu.getText());
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setTitle("confirmer la modification");
            alert.setContentText("voulez vous vraiment modifier");
            alert.showAndWait();
            rc.updateReclamation(idModifier, r);
            
            showReclamation();
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
        }
         

    }

    @FXML
    private void Delete(ActionEvent event) {
<<<<<<< HEAD:Controller/FXMLDocumentController.java
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Confirm Deletion");
    alert.setContentText("Are you sure you want to delete the selected item?");

    ButtonType deleteButtonType = new ButtonType("Delete");
    ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(deleteButtonType, cancelButtonType);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == deleteButtonType) {
        int idSup=tvreclamation.getSelectionModel().getSelectedItem().getId();
        rc.supprimerReclamation(idSup);
        showReclamation();
    } else {
        alert.close();
    }
}
=======
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("confirmer la suppression");
        alert.setContentText("voulez vous vraiment supprimer la ligne");
        alert.showAndWait();
        int idSup=tvreclamation.getSelectionModel().getSelectedItem().getId();
        rc.supprimerReclamation(idSup);
        showReclamation();
    }
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
private String ControleSaisie(){
String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
    String erreur="";
if(tfnom.getText().trim().isEmpty()){
erreur+="nom vide \n";}
if(tfprenom.getText().trim().isEmpty()){
erreur+="prenom vide \n";}
if(tfadresse.getText().trim().isEmpty()){
erreur+="adresse vide \n";}
if(tfcontenu.getText().trim().isEmpty()){
erreur+="contenu vide \n";}
if (!pattern.matcher(tfadresse.getText().trim()).matches()) {
            erreur+="-Inserer correct email\n";
        }

return erreur;

}
/*Partie commentaire */
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
        alert.setContentText(ControleSaisie());
        alert.showAndWait();}
<<<<<<< HEAD:Controller/FXMLDocumentController.java
         else if(detectBadWords()){
         }
         else{
=======
        else {
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
        Commentaire r =new Commentaire();
        r.setContenu(tfCmntr.getText());
        
        cmntr.ajouterCommentaire(r);
        showCommentaire();}
         
    }

    @FXML
<<<<<<< HEAD:Controller/FXMLDocumentController.java
      private void UpdateCmntr(ActionEvent event) {
        if (ControleCmntr().length()>0){
         Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("confirmer la modification");
        alert.setContentText("voulez vous vraiment modifier");
        alert.showAndWait();}
        else if(detectBadWords()){
         }
         else{
=======
    private void UpdateCmntr(ActionEvent event) {
         Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("confirmer la modification");
        alert.setContentText("voulez vous vraiment modifier");
        alert.showAndWait();
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
         Commentaire r =new Commentaire();
         int idModifier=tvcommentaire.getSelectionModel().getSelectedItem().getId_com();
        r.setContenu(tfCmntr.getText());
       
        cmntr.updateCommentaire(idModifier, r);
<<<<<<< HEAD:Controller/FXMLDocumentController.java
        showCommentaire();}
         
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
   
    
    

    @FXML
  private void DeleteCmntr(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Confirm Deletion");
    alert.setContentText("Are you sure you want to delete the selected item?");

    ButtonType deleteButtonType = new ButtonType("Delete");
    ButtonType cancelButtonType = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(deleteButtonType, cancelButtonType);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == deleteButtonType) {
        int idSup = tvcommentaire.getSelectionModel().getSelectedItem().getId_com();
        cmntr.supprimerCommentaire(idSup);
        showCommentaire();
    } else {
        alert.close();
    }
}

=======
        showCommentaire();
         // Get the index of the newly added row
    int index = tvreclamation.getItems().size() - 1;

    // Get the new row in the table view
    ObservableList<Node> rows = tvreclamation.getChildrenUnmodifiable();
    TableRow<Reclamation> newRow = (TableRow<Reclamation>) rows.get(index);

    // Disable the new row
   // newRow.setDisable(true);

    // Schedule a task to enable the row after 5 minutes
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.schedule(() -> {
        Platform.runLater(() -> newRow.setDisable(true));
    }, 2, TimeUnit.MINUTES);
}
    

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
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
    private String ControleCmntr(){

    String erreur="";
if(tfCmntr.getText().trim().isEmpty()){
erreur+="nom vide \n";}

return erreur;

}

<<<<<<< HEAD:Controller/FXMLDocumentController.java
=======
    @FXML
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
    private void btn_vehicule(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/GestionCommentaire.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.show();
        
    }
    @FXML

private void exportToExcel(ActionEvent event) {
    // Get the current stage
    Stage stage = (Stage) anchor.getScene().getWindow();

    // Create a new file chooser
    FileChooser fileChooser = new FileChooser();

    // Set the file extension filter to only allow Excel files
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
    fileChooser.getExtensionFilters().add(extFilter);

    // Show the file chooser dialog to the user
    File file = fileChooser.showSaveDialog(stage);

    if (file != null) {
        // Get the data from the table
        ObservableList<Reclamation> data = tvreclamation.getItems();

        // Create a new workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Reclamation Data");

        // Create the header row
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Nom");
        headerRow.createCell(2).setCellValue("Prenom");
        headerRow.createCell(3).setCellValue("Adresse");
        headerRow.createCell(4).setCellValue("Contenu");
        headerRow.createCell(5).setCellValue("dateCreation");

        // Add the data rows to the sheet
        int rowNum = 1;
        for (Reclamation reclamation : data) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(reclamation.getId());
            row.createCell(1).setCellValue(reclamation.getNom());
            row.createCell(2).setCellValue(reclamation.getPrenom());
            row.createCell(3).setCellValue(reclamation.getAdresse());
            row.createCell(4).setCellValue(reclamation.getContenu());
            // create a Calendar instance and set it to the current date and time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reclamation.getDateCreation());

        // get the last two digits of the year
        int year = calendar.get(Calendar.YEAR) % 100;

        // extract the month and day values from the Calendar instance
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

 
        // print the date in the format "yyyy-MM-dd"
        String date=String.format("%02d-%02d-%02d", day, month, year);
        
            row.createCell(5).setCellValue(date);
        }

        // Write the workbook to the file
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            workbook.write(outputStream);
            // Show a confirmation dialog to the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Export Successful");
            alert.setHeaderText(null);
            alert.setContentText("The data was successfully exported to Excel.");
            alert.showAndWait();
        } catch (IOException e) {
            // Show an error dialog to the user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Export Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while exporting the data to Excel.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }
    
    
}
public void recherche_avance(){
    showReclamation();
    FilteredList<Reclamation> filtreddata=new FilteredList<>(getReclamationList(),r->true);
    tfrecherche.textProperty().addListener((observable,oldValue,newValue)->{
        filtreddata.setPredicate(rec->{
            if(newValue==null || newValue.isEmpty()){
                return true;
            }
            if(rec.getAdresse().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                return true;
            }
            else if(rec.getContenu().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                return true;
            }
            else if(rec.getNom().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                return true;
            }
            else if(rec.getPrenom().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                return true;
            }
            else if(rec.getDateCreation().toString().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                return true;
            }
            else{
                return false;
            }
        });
        tvreclamation.setItems(filtreddata);
    });
}

    @FXML
    private void tri(ActionEvent event) {
        List<Reclamation> triParDate=rc.listeDesReclamations()
                .stream().sorted(Comparator.comparing(Reclamation::getDateCreation)).collect(Collectors.toList());
        ObservableList<Reclamation> triDate=FXCollections.observableArrayList(triParDate);
        tvreclamation.setItems(triDate);
    }

    @FXML
    private void mail(ActionEvent event) {
          try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/mail.fxml"));  
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
<<<<<<< HEAD:Controller/FXMLDocumentController.java

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

    @FXML
    private void ajouter(MouseEvent event) {
    }

    @FXML
    private void Front(ActionEvent event) {
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
=======
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/FXMLDocumentController.java
 
}
