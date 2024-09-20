/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

<<<<<<< HEAD:Controller/ReclamationFrontController.java
import static Controller.Utilisateur_gestionController.l_email;
import entities.Commentaire;
import entities.Reclamation;
import entities.Utilisateur;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
=======
import entities.Commentaire;
import entities.Reclamation;
import services.CommentaireCrud;
import services.ReclamationCrud;
import java.net.URL;
>>>>>>> master:src/Controller/FXMLDocumentController.java
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
<<<<<<< HEAD:Controller/ReclamationFrontController.java
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
=======
import javafx.scene.control.Label;
>>>>>>> master:src/Controller/FXMLDocumentController.java
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
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
<<<<<<< HEAD:Controller/ReclamationFrontController.java
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.CommentaireCrud;
import services.ReclamationCrud;
import services.UtilisateurS;
=======
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
>>>>>>> master:src/Controller/FXMLDocumentController.java

/**
 * FXML Controller class
 *
 * @author user
 */
<<<<<<< HEAD:Controller/ReclamationFrontController.java
public class ReclamationFrontController implements Initializable {

    private TextField toField;
    private TextField subjectField;
    private TextArea messageArea;
=======
public class FXMLDocumentController implements Initializable {
    
    private Label label;
>>>>>>> master:src/Controller/FXMLDocumentController.java
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfcontenu;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;

   private Label label;
 
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
  
    ReclamationCrud rc=new ReclamationCrud();
    CommentaireCrud cmntr =new CommentaireCrud();
    private List<Reclamation> listeDesReclamations;
<<<<<<< HEAD:Controller/ReclamationFrontController.java
=======
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
    private Button btnExportExcel;
    @FXML
>>>>>>> master:src/Controller/FXMLDocumentController.java
    private TableView<Commentaire> tvcommentaire;
    private TableColumn<Commentaire,?> colpseudo;
    private TableColumn<Commentaire, String> colcommentaire;
    @FXML
    private TableColumn<Reclamation, Date> cdate;
    @FXML
<<<<<<< HEAD:Controller/ReclamationFrontController.java
    private Button retour;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
     
      showReclamation();

=======
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
     recherche_avance();
        //showReclamation();
        showCommentaire();
>>>>>>> master:src/Controller/FXMLDocumentController.java
    }
   
    


    
        
  
public ObservableList<Reclamation>getReclamationList(){
<<<<<<< HEAD:Controller/ReclamationFrontController.java
    
     Utilisateur utilisateur=new UtilisateurS().getUserByEmail(l_email);
ObservableList<Reclamation> ReclamationList2 = FXCollections.observableArrayList();
    this.listeDesReclamations=rc.listeDesReclamations(utilisateur.getId());
=======
    this.listeDesReclamations=rc.listeDesReclamations();
>>>>>>> master:src/Controller/FXMLDocumentController.java
ObservableList<Reclamation> ReclamationList = FXCollections.observableArrayList();

//ReclamationList.addAll(rc.listeDesReclamations());
ReclamationList.addAll(rc.listeDesReclamations(utilisateur.getId()));
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
<<<<<<< HEAD:Controller/ReclamationFrontController.java
    System.out.println(List);
=======
>>>>>>> master:src/Controller/FXMLDocumentController.java
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
<<<<<<< HEAD:Controller/ReclamationFrontController.java
  
=======
        showReclamation();
>>>>>>> master:src/Controller/FXMLDocumentController.java
        }
        }


    }
    @FXML
    private void update(ActionEvent event) {
<<<<<<< HEAD:Controller/ReclamationFrontController.java
             Utilisateur utilisateur=new UtilisateurS().getUserByEmail(l_email);
     
=======
>>>>>>> master:src/Controller/FXMLDocumentController.java
         
         Reclamation r =new Reclamation();
         Reclamation amodifier=tvreclamation.getSelectionModel().getSelectedItem();
         Date today=new Date();
        if(today.getDate()-amodifier.getDateCreation().getDate()>1){
            Alert alert2 =new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Erreur modification");
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
<<<<<<< HEAD:Controller/ReclamationFrontController.java
=======
        showReclamation();
>>>>>>> master:src/Controller/FXMLDocumentController.java
        }
        }


        }
         

    }

    private void Delete(ActionEvent event) {
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
<<<<<<< HEAD:Controller/ReclamationFrontController.java
=======
        showReclamation();
>>>>>>> master:src/Controller/FXMLDocumentController.java
    } else {
        alert.close();
    }
}
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

<<<<<<< HEAD:Controller/ReclamationFrontController.java
    @FXML
    private void retour(ActionEvent event) {
        try{
         Parent root = FXMLLoader.load(getClass().getResource("/gui/frontReservation.fxml"));  
=======
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
         int idModifier=tvcommentaire.getSelectionModel().getSelectedItem().getId_com();
        r.setContenu(tfCmntr.getText());
       
        cmntr.updateCommentaire(idModifier, r);
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

    private String ControleCmntr(){

    String erreur="";
if(tfCmntr.getText().trim().isEmpty()){
erreur+="nom vide \n";}

return erreur;

}

    @FXML
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
>>>>>>> master:src/Controller/FXMLDocumentController.java
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
<<<<<<< HEAD:Controller/ReclamationFrontController.java
=======
 
>>>>>>> master:src/Controller/FXMLDocumentController.java
}
