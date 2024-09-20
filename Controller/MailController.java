package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
<<<<<<< HEAD:Controller/MailController.java
<<<<<<< HEAD:Controller/MailController.java
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MailController {
=======
=======
>>>>>>> master:src/Controller/MailController.java
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

public class MailController {
<<<<<<< HEAD:Controller/MailController.java


>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/MailController.java
=======
>>>>>>> master:src/Controller/MailController.java
    @FXML
    private TextField toField;

    @FXML
    private TextField subjectField;

    @FXML
    private TextArea messageArea;

    @FXML
    private AnchorPane rootPane;
<<<<<<< HEAD:Controller/MailController.java
<<<<<<< HEAD:Controller/MailController.java
=======
    @FXML
    private TextField fromField;
    @FXML
    private PasswordField passwordField;
>>>>>>> master:src/Controller/MailController.java

    @FXML
  void sendMail() {
    //smartwheels0@gmail.com
    //sivxbctdmnybwtli
<<<<<<< HEAD:Controller/MailController.java
     String fromEmail="smartwheels00@gmail.com";
     String password="vmlhtoxrirgxyamh";
=======
    String fromEmail = "smartwheels0@gmail.com";
    String password = "sivxbctdmnybwtli";
>>>>>>> master:src/Controller/MailController.java
    String toEmail = toField.getText();
    String subject = subjectField.getText();
    String message = "<html><body>"
            + "<h1 style=\"color:blue;\">SmartWheels Support</h1>"
            + "<p>Dear Customer,</p>"
            + "<p>Thank you for contacting SmartWheels Support. We have received your message and will get back to you as soon as possible.</p>"
            + "<p>Here's a summary of your message:</p>"
            + "<ul>"
            + "<li>Subject: " + subject + "</li>"
            + "<li>Message: " + messageArea.getText() + "</li>"
            + "</ul>"
            + "<p>Best regards,</p>"
            + "<p>SmartWheels Support Team</p>"
            + "</body></html>";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(fromEmail, password);
        }
    });

    try {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(fromEmail));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        msg.setSubject(subject);
        msg.setContent(message, "text/html");
        Transport.send(msg);
        System.out.println("Mail sent to " + toEmail);
    } catch (MessagingException e) {
        e.printStackTrace();
    }
<<<<<<< HEAD:Controller/MailController.java
  }

    @FXML
    private void retour(ActionEvent event) {
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
}

=======
    @FXML
    private TextField fromField;
    @FXML
    private PasswordField passwordField;

    @FXML
    void sendMail() {
        //smartwheels0@gmail.com
        //sivxbctdmnybwtli
        String fromEmail = "smartwheels0@gmail.com";
        String password = "sivxbctdmnybwtli";
        String toEmail = toField.getText();
        String subject = subjectField.getText();
        String message = messageArea.getText();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
            System.out.println("Mail sent to " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> 1fc856547d52209282a287afc9b651ac05906907:src/Controller/MailController.java
=======
  }}

>>>>>>> master:src/Controller/MailController.java
