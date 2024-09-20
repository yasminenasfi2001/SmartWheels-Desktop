/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import static Controller.Utilisateur_gestionController.l_email;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import entities.Evenement;
import entities.Sponsor;
import entities.Utilisateur;
import services.EvenementCRUD;
import services.SponsorCRUD;
import utils.MyConnection;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.Cell;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.StringConverter;
import services.UtilisateurS;
//import jfxtras.scene.control.LocalDateTextField;

        /*
 * FXML Controller class
 *
 * @author DELL
 */
public class InterfaceAdminController implements Initializable {
    //public static final String ACCOUNT_SID ;
    //public static final String AUTH_TOKEN ;
    
    

    
    @FXML
    private TextField nom_sponsor;
    @FXML
    private TextField tel_sponsor;
    @FXML
    private TextField email_sponsor;
    @FXML
    private TextField montant;
    @FXML
    private Button supp;
    @FXML
    private TableColumn<Sponsor, Integer> id;
    @FXML
    private TableColumn<Sponsor, String> s_nom;
    @FXML
    private TableColumn<Sponsor, String> s_tel;
    @FXML
    private TableColumn<Sponsor, String> s_email;
    @FXML
    private TableColumn<Sponsor, Float> s_montant;
    @FXML
    private TableView<Sponsor> tablesp;
    public ObservableList<Evenement> data1=FXCollections.observableArrayList();
   
    public ObservableList<Sponsor> data=FXCollections.observableArrayList();

    @FXML
    private Button ajj;
    @FXML
    private Button modd;
    @FXML
    private TextField nom_event;
    @FXML
    private TextField lieu;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField nb_places;
    @FXML
    private TextField types_event;
     @FXML
    private TableView<Evenement> tableev;
    @FXML
    private TableColumn<Evenement, Integer> ide;
    @FXML
    private TableColumn<Evenement, String> e_nom;
    @FXML
    private TableColumn<Evenement, LocalDate> e_datedeb;
    @FXML
    private TableColumn<Evenement, LocalDate> e_datefin;
    @FXML
    private TableColumn<Evenement, String> e_lieu;
    @FXML
    private TableColumn<Evenement, Integer> e_nbplaces;
    @FXML
    private TableColumn<Evenement, String> e_type;
    @FXML
    private TableColumn<Evenement, Integer> e_nbvues;
    @FXML
    private Button ajjjj;
    @FXML
    private Button detsp;
    @FXML
    private Button detev;
    @FXML
    private Button suppp;
    @FXML
    private Button moddd;
   
    private Tab tab;
    @FXML
    private TabPane tabpane;
    @FXML
    private AnchorPane anchp;
    @FXML
    private TextField SearchField;
    @FXML
    private TextField SearchField2;
    @FXML
    private Tab tab_event;
    @FXML
    private Tab tab_sponsor;
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
    private AnchorPane anchor11;
    @FXML
    private Label l_prenom1;
    @FXML
    private Label l_nom1;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utilisateur admin=new UtilisateurS().getUserByEmail(l_email);
      l_nom.setText(admin.getNom());
      l_prenom.setText(admin.getPrenom());
        vboxid.setSpacing(18);
        
       vboxid1.setSpacing(18);
       this.afficherevent();
        /*
        tableev.setRowFactory(new Callback<TableView<Evenement>, TableRow<Evenement>>() {
   
    @Override
    
    public TableRow<Evenement> call(TableView<Evenement> tableView) {
        return new TableRow<Evenement>() {
            @Override
            protected void updateItem(Evenement evenement, boolean empty) {
               super.updateItem(evenement, empty);
                if (evenement == null) {
                    setStyle("");
                } else {
                    LocalDate finEvenement = evenement.getDate_fin();
                    LocalDate now = LocalDate.now();
                    if (finEvenement.isBefore(now)) {

                        setStyle("-fx-background-color: #C39BD3 ; -fx-text-fill: #FFFFFF  ;");

                    } else {
                        setStyle("-fx-background-color: #AF7AC5;");
                    }
                }
            }
        };
    }
});
  */
    }
    
   





    @FXML
     public void btn2(ActionEvent event)   {
                  Sponsor s;
        s=tablesp.getSelectionModel().getSelectedItem();
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Evenement.fxml"));
          
      
    
       
        try{
        tab_sponsor.setContent(loader.load());
        EvenementController evc = loader.getController();
        
        evc.setIDSPONSOR(String.valueOf(s.getID_sponsor()));
      
        evc.setNOMSPONSOR(s.getNom_sponsor());
        
        evc.setTELSPONSOR(s.getTel_sponsor());
        
        evc.setMONTANT(String.valueOf(s.getMontant()));
       
       evc.affichereventparsponsor();
        
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
        
       
      
 
     
     }
    
    
    
    @FXML
            public void btn(ActionEvent event)   {
        try {
              
              Evenement e;
            e=tableev.getSelectionModel().getSelectedItem();
           
  FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Sponsor.fxml"));   
            tab_event.setContent(loader.load());  
            SponsorController spc = loader.getController();
            spc.setIDEVENT(String.valueOf(e.getID_event()));
            spc.setNOMEVENT(e.getNom_event());
            spc.setDATEDEBUT(e.getDate_debut().toString());
            spc.setDATEFIN(e.getDate_fin().toString());
            spc.setLIEUEVENT(e.getLieu_event());
            spc.setNBPLACES(String.valueOf(e.getNb_places()));
            spc.setTYPES(e.getType_event());
            spc.setNbvues(String.valueOf(e.getNb_vues()));
            spc.affichersponsorparevent();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
            
            
       /* catch(IOException ex)
        {
            System.out.println(ex);
        }*/
        
       
      
 
     

    
    
    
//Sponsorcontroller
    
    //Rechercheavancéesponsor
    @FXML
    public void rechercheavesp(ActionEvent event) {
    // Création d'une nouvelle liste pour stocker les sponsors filtrés
    ObservableList<Sponsor> filteredSponsorData = FXCollections.observableArrayList();

    // Si la barre de recherche est vide, afficher tous les sponsors
    if (SearchField.getText() == null || SearchField.getText().isEmpty()) {
       tablesp.setItems(data);
        return;
    }

    // Parcourir tous les sponsors et ajouter ceux qui correspondent à la recherche
    for (Sponsor sponsor : data) {
        if (
          String.valueOf(sponsor.getID_sponsor()).contains(SearchField.getText().toLowerCase()) ||
           sponsor.getNom_sponsor().toLowerCase().contains(SearchField.getText().toLowerCase()) ||
                
            sponsor.getEmail_sponsor().toLowerCase().contains(SearchField.getText().toLowerCase()) ||
            sponsor.getTel_sponsor().toLowerCase().contains(SearchField.getText().toLowerCase()) ||
            String.valueOf(sponsor.getMontant()).toLowerCase().contains(SearchField.getText().toLowerCase())) {
            filteredSponsorData.add(sponsor);
        }
    }

    // Mettre à jour le TableView avec la liste filtrée de sponsors
    tablesp.setItems(filteredSponsorData);
    
    System.out.println(filteredSponsorData);
    
}
        //Rechercheavancéeecent

    @FXML
    public void rechercheavevent(ActionEvent event) {
    // Création d'une nouvelle liste pour stocker les sponsors filtrés
    ObservableList<Evenement> filteredEventData = FXCollections.observableArrayList();

    // Si la barre de recherche est vide, afficher tous les sponsors
    if (SearchField2.getText() == null || SearchField2.getText().isEmpty()) {
       tableev.setItems(data1);
        return;
    }

    // Parcourir tous les sponsors et ajouter ceux qui correspondent à la recherche
    for (Evenement ev : data1) {
        if (
          String.valueOf(ev.getID_event()).contains(SearchField2.getText().toLowerCase()) ||
           ev.getNom_event().toLowerCase().contains(SearchField2.getText().toLowerCase()) ||
           ev.getDate_debut().toString().toLowerCase().contains(SearchField2.getText().toLowerCase())||
           ev.getDate_fin().toString().toLowerCase().contains(SearchField2.getText().toLowerCase())||
           ev.getLieu_event().toLowerCase().contains(SearchField2.getText().toLowerCase()) ||
           String.valueOf(ev.getNb_places()).contains(SearchField2.getText().toLowerCase()) ||
           ev.getType_event().toLowerCase().contains(SearchField2.getText().toLowerCase()) ||
           String.valueOf(ev.getNb_vues()).contains(SearchField2.getText().toLowerCase()))
        {
                
            filteredEventData.add(ev);
        }
    }

    // Mettre à jour le TableView avec la liste filtrée de sponsors
    tableev.setItems(filteredEventData);
    
    System.out.println(filteredEventData);
    
}





    //affichersponsor

public void affichersponsor(){
          try {
            String requete="SELECT * FROM sponsor"; 
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
      data.add(new Sponsor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

                 id.setCellValueFactory(new PropertyValueFactory<Sponsor,Integer>("ID_sponsor")); 
                 s_nom.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Nom_sponsor"));
                 s_tel.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Tel_sponsor"));
                 s_email.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("Email_sponsor"));
                s_montant.setCellValueFactory(new PropertyValueFactory<Sponsor,Float>("Montant"));
                 tablesp.setItems(data);
      }
  


      //ajoutersponsor



          @FXML
    private void ajoutersponsor(ActionEvent event) {
        try{
      if (nom_sponsor.getText().isEmpty() || email_sponsor.getText().isEmpty() || tel_sponsor.getText().isEmpty()|| montant.getText().isEmpty()){
        Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Attention ");
        alert1.setHeaderText(null);
        alert1.setContentText("Vérifiez qu'il n'ya aucun champ manquant !");
        alert1.showAndWait();} 
      else {
      if (!ValidationTel()){
          Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention ");
        alert.setHeaderText(null);
        alert.setContentText("Tel Invalide !");
        alert.showAndWait();}
      if (!ValidationEmail()){
       Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention ");
        alert.setHeaderText(null);
        alert.setContentText("Email Invalide !");
        alert.showAndWait();}
      if(SponsorIdentique()){
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Attention");
    alert.setHeaderText(null);
    alert.setContentText("Cet événement déjà existe !");
    alert.showAndWait();
            }
        
     else if (ValidationEmail()&& ValidationTel()&& !SponsorIdentique() )
         {
              SponsorCRUD sp = new SponsorCRUD();
              Sponsor s =new Sponsor();
              s.setID_sponsor(1);
              s.setNom_sponsor(nom_sponsor.getText());
              s.setTel_sponsor(tel_sponsor.getText());
              s.setEmail_sponsor(email_sponsor.getText());
              s.setMontant(Float.parseFloat(montant.getText()));
              System.out.println(s);
              sp.ajouterSponsor(s);
              System.out.println("sponsor ajouté ");
              this.test2();
              Refresh();
              Envoitexto();          
              viderleschamps();             
                          

         }}
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
      
    }
    public boolean SponsorIdentique() {
    String nom = nom_sponsor.getText();
    String email = email_sponsor.getText();
   
    float mont = Float.parseFloat(montant.getText());
    String tel = tel_sponsor.getText();
    boolean Sponsorexists = false;
    for (Sponsor sponsor : tablesp.getItems()) {
        if (sponsor.getMontant() == mont && sponsor.getNom_sponsor().equals(nom)
                && sponsor.getEmail_sponsor().equals(email) && sponsor.getTel_sponsor().equals(tel))
                 {
            Sponsorexists = true;
            break;
        }
    }
    return Sponsorexists;
}
    //modifiersponsor
    
   
    @FXML
    private void modifiersponsor(ActionEvent event) {      
tablesp.setEditable(true);

tablesp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 2) { // Double click
                        TablePosition<?, ?> position = tablesp.getSelectionModel().getSelectedCells().get(0);
                        int row = position.getRow();
                        TableColumn<?, ?> column = position.getTableColumn();
                        tablesp.edit(row, (TableColumn<Sponsor, ?>) column);
                    }
                }
            });
        s_nom.setCellFactory(TextFieldTableCell.forTableColumn());
        s_nom.setOnEditCommit((TableColumn.CellEditEvent<Sponsor, String> event1) -> {
        TablePosition<Sponsor, String> pos = event1.getTablePosition();
        String newNom = event1.getNewValue();
        int row = pos.getRow();
        Sponsor sponsor = event1.getTableView().getItems().get(row);
        sponsor.setNom_sponsor(newNom);
        SponsorCRUD sp1 = new SponsorCRUD();
        sp1.modifierSponsor(sponsor, newNom, sponsor.getTel_sponsor(), sponsor.getEmail_sponsor(), sponsor.getMontant());
        Refresh();
          tablesp.setEditable(false);

        });
        s_email.setCellFactory(TextFieldTableCell.forTableColumn());
        s_email.setOnEditCommit((TableColumn.CellEditEvent<Sponsor, String> event2) -> {
        TablePosition<Sponsor, String> pos = event2.getTablePosition();
        String newEmail = event2.getNewValue();
        if (!newEmail.matches("^[\\w!#$%&amp;'+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
        Alert alert = new Alert(AlertType.WARNING, "Email invalide !");
        alert.showAndWait();
         tablesp.getItems().clear();
        affichersponsor();
         }
        else if (newEmail.matches("^[\\w!#$%&amp;'+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){ 
        int row = pos.getRow();
        Sponsor sponsor = event2.getTableView().getItems().get(row);
        sponsor.setEmail_sponsor(newEmail);
        SponsorCRUD sp1 = new SponsorCRUD();
        sp1.modifierSponsor(sponsor, sponsor.getNom_sponsor(), sponsor.getTel_sponsor(), newEmail, sponsor.getMontant());
        Refresh();
        tablesp.setEditable(false);
        }
    });
 s_tel.setCellFactory(TextFieldTableCell.forTableColumn());
        s_tel.setOnEditCommit((TableColumn.CellEditEvent<Sponsor, String> event3) -> {
        TablePosition<Sponsor, String> pos = event3.getTablePosition();
        String newTel = event3.getNewValue();
        if (!newTel.matches("^(\\+216|00216|0)?[2-5-7-9-3]\\d{7}$")){
        Alert alert = new Alert(AlertType.WARNING, "Numéro téléphone invalide !");
        alert.showAndWait();
         tablesp.getItems().clear();
        affichersponsor();
         }
     else if (newTel.matches("^(\\+216|00216|0)?[2-5-7-9-3]\\d{7}$")){ 

        int row = pos.getRow();
        Sponsor sponsor = event3.getTableView().getItems().get(row);
        sponsor.setEmail_sponsor(newTel);
        SponsorCRUD sp1 = new SponsorCRUD();
        sp1.modifierSponsor(sponsor, sponsor.getNom_sponsor(), newTel, sponsor.getEmail_sponsor(), sponsor.getMontant());
        Refresh();
          tablesp.setEditable(false);

             }});  
s_montant.setCellFactory(TextFieldTableCell.<Sponsor, Float>forTableColumn(new FloatStringConverter()));
        s_montant.setOnEditCommit((TableColumn.CellEditEvent<Sponsor, Float> event3) -> {
        TablePosition<Sponsor, Float> pos = event3.getTablePosition();
        float newMontant = event3.getNewValue();
        int row = pos.getRow();
        Sponsor sponsor = event3.getTableView().getItems().get(row);
        sponsor.setMontant(newMontant);
        SponsorCRUD sp1 = new SponsorCRUD();
        sp1.modifierSponsor(sponsor, sponsor.getNom_sponsor(), sponsor.getTel_sponsor(), sponsor.getEmail_sponsor(),newMontant);
        Refresh();
          tablesp.setEditable(false);

    }); 
 }
    
//supprimersponsor
    
    
    @FXML
      private void supprimersponsor(ActionEvent event) {
        
           SponsorCRUD  spn = new  SponsorCRUD ();
           Alert alert = new Alert(AlertType.ERROR);
             Sponsor s1= new Sponsor();
              s1= tablesp.getSelectionModel().getSelectedItem();
 alert.setTitle("Conffirmation de suppression");
           alert.setHeaderText("Etes vous sur de supprimer cette id:");
           alert.setContentText(String.valueOf(s1.getID_sponsor()));
           ButtonType buttonTypeCancel = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
           ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.CANCEL_CLOSE);
           
    alert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);
 Optional<ButtonType> result = alert.showAndWait();
 if (result.isPresent() && result.get() == buttonTypeOk){

              spn.SupprimerSponsor(s1);
Refresh();
 }
      }
      
      //refresh

public void Refresh() {
    List <Sponsor> Sponsor;
           SponsorCRUD  sp1 = new  SponsorCRUD ();
            Sponsor=sp1.AfficherlisteDesSponsors();
        tablesp.getItems().setAll(Sponsor);
    }

      //viderleschamps

    private void viderleschamps() {
      
       nom_sponsor.clear();
       tel_sponsor.clear();
       email_sponsor.clear();
       montant.clear();
      

    }

   //ValidationEmailsponsor
    
    
public boolean ValidationEmail(){ 
        Pattern pattern = Pattern.compile("^[\\w!#$%&amp;'+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher match = pattern.matcher(email_sponsor.getText());
        
        if(match.find() && match.group().equals(email_sponsor.getText()))
        { 
            return true;
        }
        else {
            return false;
        }
    }

 //ValidationTelsponsor


public boolean ValidationTel() {
    Pattern pattern;
        pattern = Pattern.compile("^(\\+216|00216|0)?[2-5-7-9-3]\\d{7}$");
        Matcher match; 
        match = pattern.matcher((tel_sponsor.getText()));
        if(match.find() && match.group().equals(tel_sponsor.getText()))
        { 
            return true;
        }
        else {
            return false;
        }
}


 //API SMS
  public void Envoitexto() 
  {
        String numdestination = tel_sponsor.getText();
        System.out.println(numdestination);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message sms = Message.creator(
                new PhoneNumber(numdestination),
                new PhoneNumber("+12764009234"),
                "Cher Sponsor ,Nous vous informons que vous êtes ajouté dans notre base de données en tant que sponsor des événments, suite à la signature de notre contrat. La somme donnée est de " + montant.getText()+ " DT ").create();

    }
  
  
  //evenementcontroller
  
 
   public void afficherevent(){
          try { 
            String requete="SELECT * FROM evenement"; 
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            
            while(rs.next()){
      data1.add(new Evenement(rs.getInt(1),rs.getString(2), rs.getDate(3).toLocalDate(),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


                 ide.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("ID_event")); 
                 e_nom.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Nom_event"));
                 e_datedeb.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("Date_debut"));
                 e_datefin.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("Date_fin"));
                e_lieu.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Lieu_event"));
                e_nbplaces.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("Nb_places"));
                e_type.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Type_event"));
                e_nbvues.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("Nb_vues"));

                 tableev.setItems( data1);
      }
    public boolean eventIdentique() {
    String nom = nom_event.getText();
    String ieu = lieu.getText();
    LocalDate dated = date_deb.getValue();
    LocalDate datef = date_fin.getValue();
    int nbpl = Integer.parseInt(nb_places.getText());
    String type = types_event.getText();
    boolean eventExists = false;
    for (Evenement evenement : tableev.getItems()) {
        if (evenement.getNb_places() == nbpl && evenement.getType_event().equals(type)
                && evenement.getLieu_event().equals(ieu) && evenement.getNom_event().equals(nom)
                && evenement.getDate_debut().equals(dated) && evenement.getDate_fin().equals(datef)) {
            eventExists = true;
            break;
        }
    }
    return eventExists;
}
    @FXML
    private void ajouterevenement(ActionEvent event) {
        if ((nom_event.getText().isEmpty()  || date_deb.getValue() == null || date_fin.getValue() == null || lieu.getText().isEmpty()) || nb_places.getText().isEmpty()|| types_event.getText().isEmpty()) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Attention");
    alert.setHeaderText(null);
    alert.setContentText("Veuillez remplir tous les champs obligatoires!");
    alert.showAndWait();
}else{
            if(eventIdentique()){
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Attention");
    alert.setHeaderText(null);
    alert.setContentText("Cet événement déjà existe !");
    alert.showAndWait();
            }
            else if(!eventIdentique()){
                EvenementCRUD ev = new EvenementCRUD();
      Evenement e =new Evenement();
      e.setID_event(1);
      e.setNom_event(nom_event.getText());
      e.setDate_debut(date_deb.getValue());
      e.setDate_fin(date_fin.getValue());
      e.setLieu_event(lieu.getText());
      e.setNb_places(parseInt(nb_places.getText()));
      e.setType_event(types_event.getText());
      e.setNb_vues(0);
      System.out.println(e);
      ev.ajouterEvenement(e);
    
        
      System.out.println("event ajouté ");
     
      Refreshev();
        viderleschampsev();
            }
        }
       
      
      
    }
   
 
    @FXML
       private void modifierevenement(ActionEvent event) {
           
           tableev.setEditable(true);

tableev.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 2) { // Double click
                        TablePosition<?, ?> position = tableev.getSelectionModel().getSelectedCells().get(0);
                        int row = position.getRow();
                        TableColumn<?, ?> column = position.getTableColumn();
                        tableev.edit(row, (TableColumn<Evenement, ?>) column);
                    }
                }
            });
        e_nom.setCellFactory(TextFieldTableCell.forTableColumn());
        e_nom.setOnEditCommit((TableColumn.CellEditEvent<Evenement, String> event1) -> {
        TablePosition<Evenement, String> pos = event1.getTablePosition();
        String newNom = event1.getNewValue();
        int row = pos.getRow();
        Evenement ev = event1.getTableView().getItems().get(row);
        ev.setNom_event(newNom);
        EvenementCRUD ev1 = new EvenementCRUD();
        ev1.modifierEvenement(ev, newNom, ev.getDate_debut(), ev.getDate_fin(), ev.getLieu_event(), ev.getNb_places(), ev.getType_event(), ev.getNb_vues());
        Refreshev();
          tableev.setEditable(false);
 e_datefin.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
 e_datedeb.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        });
               
 
      
        e_datedeb.setCellFactory ((column -> new DatePickerTableCell<>(column)));
        e_datedeb.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Evenement, LocalDate>>() {
               @Override
               public void handle(TableColumn.CellEditEvent<Evenement, LocalDate> event2) {
                   TablePosition<Evenement, LocalDate> pos = event2.getTablePosition();
                   LocalDate newDatedeb = event2.getNewValue();
                   int row = pos.getRow();
                   Evenement ev = event2.getTableView().getItems().get(row);
                   ev.setDate_debut(newDatedeb);
                   EvenementCRUD ev1 = new EvenementCRUD();
                   ev1.modifierEvenement(ev, ev.getNom_event(), newDatedeb , ev.getDate_fin(), ev.getLieu_event(), ev.getNb_places(), ev.getType_event(), ev.getNb_vues());
                   Refreshev();
                   tableev.setEditable(false);
                    e_datedeb.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
          e_datefin.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));


                       }
                

                       
           });
           
        
          e_datefin.setCellFactory ((column -> new DatePickerTableCell<>(column)));
        e_datefin.setOnEditCommit( (TableColumn.CellEditEvent<Evenement, LocalDate> event3) -> {
        TablePosition<Evenement, LocalDate> pos = event3.getTablePosition();
        LocalDate newDatefin = event3.getNewValue();
        int row = pos.getRow();
        Evenement ev = event3.getTableView().getItems().get(row);
        ev.setDate_fin(newDatefin);
        EvenementCRUD ev1 = new EvenementCRUD();
        ev1.modifierEvenement(ev, ev.getNom_event() , ev.getDate_debut(),newDatefin, ev.getLieu_event(), ev.getNb_places(), ev.getType_event(), ev.getNb_vues());
        Refreshev();
          tableev.setEditable(false);
          e_datefin.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    e_datedeb.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        });
        
         
        e_lieu.setCellFactory(TextFieldTableCell.forTableColumn());
        e_lieu.setOnEditCommit((TableColumn.CellEditEvent<Evenement, String> event4) -> {
        TablePosition<Evenement, String> pos = event4.getTablePosition();
        String newLieu = event4.getNewValue();
        int row = pos.getRow();
        Evenement ev = event4.getTableView().getItems().get(row);
        ev.setLieu_event(newLieu);
        EvenementCRUD ev1 = new EvenementCRUD();
        ev1.modifierEvenement(ev, ev.getNom_event(), ev.getDate_debut(), ev.getDate_fin(), newLieu , ev.getNb_places(), ev.getType_event(), ev.getNb_vues());
        Refreshev();
          tableev.setEditable(false);
 e_datefin.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    e_datedeb.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        });
        
        e_nbplaces.setCellFactory(TextFieldTableCell.<Evenement, Integer>forTableColumn(new IntegerStringConverter()));
        e_nbplaces.setOnEditCommit((TableColumn.CellEditEvent<Evenement, Integer> event5) -> {
        TablePosition<Evenement, Integer> pos = event5.getTablePosition();
        int newNbplaces = event5.getNewValue();
        int row = pos.getRow();
        Evenement ev = event5.getTableView().getItems().get(row);
        ev.setNb_places(newNbplaces);
        EvenementCRUD ev1 = new EvenementCRUD();
        ev1.modifierEvenement(ev, ev.getNom_event(), ev.getDate_debut(), ev.getDate_fin(), ev.getLieu_event() , newNbplaces, ev.getType_event(), ev.getNb_vues());
        Refreshev();
          tableev.setEditable(false);
           e_datefin.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    e_datedeb.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        });
         e_type.setCellFactory(TextFieldTableCell.forTableColumn());
        e_type.setOnEditCommit((TableColumn.CellEditEvent<Evenement, String> event6) -> {
        TablePosition<Evenement, String> pos = event6.getTablePosition();
        String newType = event6.getNewValue();
        int row = pos.getRow();
        Evenement ev = event6.getTableView().getItems().get(row);
        ev.setType_event(newType);
        EvenementCRUD ev1 = new EvenementCRUD();
        ev1.modifierEvenement(ev, ev.getNom_event(), ev.getDate_debut(), ev.getDate_fin(), ev.getLieu_event() , ev.getNb_places(), newType, ev.getNb_vues());
        Refreshev();
          tableev.setEditable(false);
 e_datefin.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
 e_datedeb.setCellFactory(column -> new DateCellEvent(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        });
        
       }
    @FXML
    private void supprimerevenement(ActionEvent event) 
{
    EvenementCRUD  eve = new  EvenementCRUD ();
           Alert alert = new Alert(AlertType.ERROR);
             Evenement e= new Evenement();
              e= tableev.getSelectionModel().getSelectedItem();
 alert.setTitle("Conffirmation de suppression");
           alert.setHeaderText("Etes vous sur de supprimer cette id:");
           alert.setContentText(String.valueOf(e.getID_event()));
           ButtonType buttonTypeCancel = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
           ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);
           
           
 Optional<ButtonType> result = alert.showAndWait();
 if  (result.isPresent() && result.get() == buttonTypeOk){
              eve.SupprimerEvenement(e);
          
              Refreshev();
 }}
 
 public void Refreshev(){
           List<Evenement> Evenement;
           EvenementCRUD  e2 = new  EvenementCRUD ();
            Evenement=e2.AfficherlisteDesEvenements();
        tableev.getItems().setAll(Evenement);
    }

    private void viderleschampsev() {
      
       nom_event.clear();
       date_deb.setValue(null);
       date_fin.setValue(null);
       lieu.clear();
       nb_places.clear();
       types_event.clear();


    }

    public void test2()
    {
        if (!tab_sponsor.isSelected())
        {
        Evenement e;
        e=tableev.getSelectionModel().getSelectedItem();
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Sponsor.fxml"));
       
      
    
       
        try{
        tab_event.setContent(loader.load());
        SponsorController spc = loader.getController();
        spc.setIDEVENT(String.valueOf(e.getID_event()));
        spc.setNOMEVENT(e.getNom_event());
        spc.setDATEDEBUT(e.getDate_debut().toString());
        spc.setDATEFIN(e.getDate_fin().toString());
        spc.setLIEUEVENT(e.getLieu_event());
        spc.setNBPLACES(String.valueOf(e.getNb_places()));
        spc.setTYPES(e.getType_event());
        spc.setNbvues(String.valueOf(e.getNb_vues()));
        spc.affichersponsorparevent();
        
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
        }
        
        
        
    }

    @FXML
    private void home(ActionEvent event) {
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






      