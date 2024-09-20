/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:Controller/loginController.java
package Controller;
=======
<<<<<<< HEAD
package Controller;
=======
package projet_transport.controler;
>>>>>>> master
>>>>>>> master:src/Controller/loginController.java

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
<<<<<<< HEAD:Controller/loginController.java
import Controller.FrontClientController;
import Controller.FrontController;
import Controller.Utilisateur_gestionController;
import entities.Utilisateur;
import services.UtilisateurS;
=======
<<<<<<< HEAD
import Controller.FrontClientController;
import Controller.FrontController;
import Controller.Gestion_UtilisateurController;
import entities.Utilisateur;
import services.UtilisateurS;
=======
import projet_transport.controler.FrontClientController;
import projet_transport.controler.FrontController;
import projet_transport.controler.Gestion_UtilisateurController;
import projet_transport.model.Utilisateur;
import projet_transport.services.UtilisateurS;
>>>>>>> master
>>>>>>> master:src/Controller/loginController.java
import java.util.Properties;
import java.util.Random;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
<<<<<<< HEAD:Controller/loginController.java
import services.Carte_fideliteS;
import utils.IPAddress;
=======
<<<<<<< HEAD
import utils.IPAddress;
=======
import projet_transport.utils.IPAddress;
>>>>>>> master
>>>>>>> master:src/Controller/loginController.java

/**
 *
 * @author aziz
 */
public class loginController implements Initializable {
    
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane left;
    @FXML
    private Label layout2_label1;
    @FXML
    private Label layout2_label2;
    @FXML
    private Label layout2_inscrit;
    @FXML
    private Button layout2_sign_up;
    @FXML
    private Pane right;
    @FXML
    private Label layout2_label11;
    @FXML
    private Label layout2_label21;
    @FXML
    private Label layout2_inscrit2;
    @FXML
    private Pane layout1;
    @FXML
    private Label layout1_label1;
    @FXML
    private Button layout1_sign_in;
    private TextField c_nom;
    @FXML
    private TextField c_passe;
    @FXML
    private Pane layout2;
    @FXML
    private Label layout1_label11;
    @FXML
    private TextField i_nom;
    @FXML
    private TextField i_prenom;
    @FXML
    private TextField i_email;
    @FXML
    private DatePicker i_date;
    @FXML
    private TextField i_telephone;
    @FXML
    private TextField i_region;
    @FXML
    private TextField i_passe;
    @FXML
    private TextField i_passec;
    @FXML
    private RadioButton i_h;
    @FXML
    private ToggleGroup i_grenre;
    @FXML
    private RadioButton i_f;
    @FXML
    private RadioButton i_a;
    @FXML
    private Button layout2_sign_in;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label lb_vide;
    @FXML
    private Label lb_ajout;
    @FXML
    private Label lb_nom;
    @FXML
    private Label lb_prenom;
    @FXML
    private Label lb_region;
    @FXML
    private Label lb_email;
    @FXML
    private Label lb_tell;
    @FXML
    private Label lb_passe;
    @FXML
    private Label f_nom;
    @FXML
    private Label f_prenom;
    @FXML
    private Label f_region;
    @FXML
    private Label f_tel;
    @FXML
    private Label f_email;
    @FXML
    private Label f_passec;
    @FXML
    private Label f_passe;
    @FXML
    private Label lb_email1;
    @FXML
    private TextField c_email;
    @FXML
    private Label u_incorrect;
    @FXML
    private Label u_introuvable;
    @FXML
    private Label mop;
    @FXML
    private CheckBox affpass;
    @FXML
    private TextField textpasse;
    @FXML
    private TextField textpasse2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
      
            lb_ajout.setVisible(false);
            lb_vide.setVisible(false);
            right.setVisible(false);
            layout2.setVisible(false);
<<<<<<< HEAD:Controller/loginController.java
             
=======
<<<<<<< HEAD
            
=======
             try { 
                 System.out.println(InetAddress.getLocalHost().getHostAddress());
            System.out.println(IPAddress.checkIpAdress(InetAddress.getLocalHost().getHostAddress()));
        } catch (UnknownHostException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
>>>>>>> master
>>>>>>> master:src/Controller/loginController.java
    }    

    @FXML
    private void swip_right_btn(MouseEvent event) throws InterruptedException {
        TranslateTransition slide =new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(anchor);
        slide.setToX(680);
        slide.play();
        PauseTransition pp = new PauseTransition(Duration.millis(360));
         pp.setOnFinished(e->{
        layout1.setVisible(false);
        left.setVisible(false);
        right.setVisible(true);
        layout2.setVisible(true);         
         });
         pp.play();

   
   
    }

    @FXML
    private void swip_left_btn(MouseEvent event)   {
        TranslateTransition slide =new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(anchor);
        slide.setToX(0);
        slide.play();
        PauseTransition pp = new PauseTransition(Duration.millis(300));
        pp.setOnFinished(e->{
                      left.setVisible(true);
        right.setVisible(false);
        layout1.setVisible(true);
         layout2.setVisible(false);
                });
        pp.play();
       
    }
    @FXML
    private void inscription(MouseEvent event) {
        this.label_initialisation();
        UtilisateurS util=new UtilisateurS();  
       
                
            if (!(i_telephone.getText().equals("") || i_nom.getText().equals("") ||  i_email.getText().equals("") || i_prenom.getText().equals("") || i_region.getText().equals("") ||  i_passe.getText().equals("") || i_passec.getText().equals("")))
            {
                if (containsOnlyLetters(i_nom.getText())){
                    lb_nom.setVisible(true);
                    f_nom.setVisible(true);
                 }
                else if (containsOnlyLetters(i_prenom.getText()))
                {
                    lb_prenom.setVisible(true);
                    f_prenom.setVisible(true);
                }
                else   if (util.CheckUserByEmail(i_email.getText()) )
                {
                    lb_email.setVisible(true);
                    f_email.setVisible(true);
                }
                else if ( !isEmailValid(i_email.getText()))
                 {
                       f_email.setVisible(true);
                      lb_email1.setVisible(true);
                 }
                else  if (containsOnlyNumber(i_telephone.getText()) || i_telephone.getText().length() != 8 )
                {
                    lb_tell.setVisible(true);
                    f_tel.setVisible(true);
                }
                else if (containsOnlyLetters(i_region.getText()))
                {
                    lb_region.setVisible(true);
                    f_region.setVisible(true);
                }
                else if (!i_passe.getText().equals(i_passec.getText()))
                {
                    lb_passe.setVisible(true);
                    f_passe.setVisible(true);
                    f_passec.setVisible(true);
                }
                else
                  {
                  Utilisateur utilisateur=new Utilisateur(0,i_nom.getText(),i_prenom.getText(), i_email.getText(), i_date.getValue().toString(),Integer.parseInt(i_telephone.getText()),i_region.getText() , i_passe.getText(),i_h,i_f);
                  util.inscription(utilisateur);
                  lb_ajout.setVisible(true);
                  System.out.println("ajout avec succes");
                  }
            }
             else
            {
            lb_vide.setVisible(true);
            }
          
    }

    @FXML
    private void connexion(ActionEvent event) throws IOException {
<<<<<<< HEAD:Controller/loginController.java
=======
<<<<<<< HEAD
>>>>>>> master:src/Controller/loginController.java
        boolean ip=true;
         try { 
                
         ip=IPAddress.checkIpAdress(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
<<<<<<< HEAD:Controller/loginController.java
=======
=======
>>>>>>> master
>>>>>>> master:src/Controller/loginController.java
        UtilisateurS userS=new UtilisateurS();
        if (!(c_email.getText().equals("") || c_passe.getText().equals("")))
        {
            if (userS.CheckAccount(c_email.getText(),c_passe.getText()))
            {
             
               if (userS.CheckUserAdmin(c_email.getText()) )
               {
<<<<<<< HEAD:Controller/loginController.java
                   if (ip)
                   
                   {
               try
               {
              Controller.Utilisateur_gestionController.SetLoginData(c_email.getText(),c_passe.getText());     
               Parent root = FXMLLoader.load(getClass().getResource("/gui/utilisateur_gestion.fxml"));  
=======
<<<<<<< HEAD
                   if (ip)
                   
                   {
               try
               {
               Gestion_UtilisateurController.SetLoginData(c_email.getText(),c_passe.getText());     
               Parent root = FXMLLoader.load(getClass().getResource("/gui/gestion_utilisateur.fxml"));  
=======
               try
               {
               Gestion_UtilisateurController.SetLoginData(c_email.getText(),c_passe.getText());     
               Parent root = FXMLLoader.load(getClass().getResource("/projet_transport/views/gestion_utilisateur.fxml"));  
>>>>>>> master
>>>>>>> master:src/Controller/loginController.java
               Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.show();
              
               }
               catch(Exception e)
               {
               System.out.println("Probleme:"+e);
               }
<<<<<<< HEAD:Controller/loginController.java
=======
<<<<<<< HEAD
>>>>>>> master:src/Controller/loginController.java
                   }
                   else 
                   {
                    Alert al = new Alert(AlertType.ERROR);
                    al.setTitle("Connexion impossible");
                    al.setHeaderText("Notre application n'est pas disponible dans votre region");
                    al.showAndWait();
                   }
<<<<<<< HEAD:Controller/loginController.java
=======
=======
>>>>>>> master
>>>>>>> master:src/Controller/loginController.java
               }
               else 
               {
               FrontClientController.SetLoginData(c_email.getText(),c_passe.getText());
<<<<<<< HEAD:Controller/loginController.java
               Parent root = FXMLLoader.load(getClass().getResource("/gui/frontReservation.fxml"));  
=======
<<<<<<< HEAD
               Parent root = FXMLLoader.load(getClass().getResource("/gui/FrontClient.fxml"));  
=======
               Parent root = FXMLLoader.load(getClass().getResource("/projet_transport/views/FrontClient.fxml"));  
>>>>>>> master
>>>>>>> master:src/Controller/loginController.java
               Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.show();
               }
            }
         else 
         {
             u_incorrect.setVisible(true);
             u_introuvable.setVisible(false);
         }
        }
        else
        {
        u_incorrect.setVisible(false);
         u_introuvable.setVisible(true);
        }
    }
    public static boolean containsOnlyLetters(String str) {
    return !str.matches("[a-zA-Z]+"); 
    }
    public static boolean containsOnlyNumber(String str) {
    return !str.matches("[0-9]+"); 
    }

   
    public void label_initialisation()
    {
        //controle en haut
        lb_vide.setVisible(false);
        lb_ajout.setVisible(false);
        lb_nom.setVisible(false);
        lb_prenom.setVisible(false);
       lb_region.setVisible(false);
       lb_tell.setVisible(false);
       lb_passe.setVisible(false);
       lb_email.setVisible(false);
       //fleche a droite
        f_nom.setVisible(false);
        f_prenom.setVisible(false);
        f_region.setVisible(false);
        f_tel.setVisible(false);
        f_passe.setVisible(false);
        f_passec.setVisible(false);
        f_email.setVisible(false);
        lb_email1.setVisible(false);
        
    }
   public static boolean isEmailValid(String email) {
    Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
}

    @FXML
    private void motPasseOublier(MouseEvent event) {
                  
        String email="smartwheels00@gmail.com";
        String pass="vmlhtoxrirgxyamh";
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Adresse e-mail");
        dialog.setHeaderText("Entrez votre adresse e-mail:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(emaill -> {
       Utilisateur u=new Utilisateur();
       UtilisateurS us=new UtilisateurS();
       if (us.CheckUserByEmail(emaill))
       {
           u=us.getUserByEmail(emaill);
      Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, pass);
            }
        });

        try {
         
         Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(email));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(u.getEmail()));
            emailMessage.setSubject("Mot_passe oublier Smart wheels");
            emailMessage.setText("Bonjour "+u.getNom()+" "+u.getPrenom()
            +"\rVoici le code  dont vous avez besoin pour vous connecter au compte :\r"
            +u.getMot_passe()
            +"\r\r\r Si vous n'êtes pas à l'origine de cette demande, veuillez modifier votre mot de passe ici:\r"
            +"http://127.0.0.1/smart_wheels/Reset_password.php?email="+u.getEmail());
            Transport.send(emailMessage);
             Alert al = new Alert(AlertType.CONFIRMATION);

           al.setTitle("Email envoyer");
           al.setHeaderText("veuillez vérifier votre boite mail");
   
            al.showAndWait();
        
        } catch (MessagingException e) {
            e.printStackTrace();
        }
       }
       else
       {
            Alert al = new Alert(AlertType.ERROR);

           al.setTitle("Email inexsistant");
           al.setHeaderText("Vous devez saisir correctement votre email ");
   
            al.showAndWait();
       }
        });
           
        
          
      

    }

    @FXML
    private void afficherMotPasse(ActionEvent event) {
        
   
                
                    if (affpass.isSelected())
                    {
                        textpasse.setText(i_passe.getText());
                        i_passe.setVisible(false);
                        textpasse.setVisible(true);
                        textpasse2.setText(i_passec.getText());
                        i_passec.setVisible(false);
                        textpasse2.setVisible(true);
                        
                        return;
                    }
                    i_passe.setText(textpasse.getText());
                    i_passe.setVisible(true);
                    textpasse.setVisible(false);
                     //pour passe 2
                    i_passec.setText(textpasse2.getText());
                    i_passec.setVisible(true);
                    textpasse2.setVisible(false);
             
    }


    @FXML
    private void GenerePasse(ActionEvent event) {
        if (!(i_nom.getText().equals("") || i_prenom.getText().equals("")))
        {
            String p=generateRandomPassword(i_nom.getText(),i_prenom.getText());
            i_passec.setText(p);
            i_passe.setText(p);
            textpasse.setText(p);
            textpasse2.setText(p);
            
        }
        
    }

    public String generateRandomPassword(String firstName, String lastName) {
    String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
    String numericChars = "0123456789";
    String specialChars = "!@#$%&_?./-";
    
    String allChars = uppercaseChars + lowercaseChars + numericChars + specialChars;
    
    Random rand = new Random();
    StringBuilder password = new StringBuilder();
    
    // Ajouter une partie du nom et du prénom à la chaîne
    password.append(firstName.substring(0, 1).toUpperCase());
    password.append(firstName.substring(1, firstName.length()).toLowerCase());
    password.append(lastName.toLowerCase());
    
    // Générer une chaîne aléatoire supplémentaire
    for (int i = 0; i < 2; i++) {
        int index = rand.nextInt(allChars.length());
        password.append(allChars.charAt(index));
    }
    
    // Générer une chaîne aléatoire de 4 chiffres
    for (int i = 0; i < 2; i++) {
        int index = rand.nextInt(numericChars.length());
        password.append(numericChars.charAt(index));
    }
    
    return password.toString();
}
}


 
    

