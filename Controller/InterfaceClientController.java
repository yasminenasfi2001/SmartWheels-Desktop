/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.Evenement;
import entities.Sponsor;
import services.EvenementCRUD;
import utils.MyConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class InterfaceClientController implements Initializable {

    @FXML
    private Label WEATHERAPI;
    @FXML
    private ImageView IMAGEAPI;
    @FXML
    private TextField recherche;
    @FXML
    private Button afficherprev;
    @FXML
    private TableColumn<Evenement,  String> n_e;
    @FXML
    private TableColumn<Evenement, LocalDate> dd_e;
    @FXML
    private TableColumn<Evenement, LocalDate> df_e;
    @FXML
    private TableColumn<Evenement, String> l_e;
    @FXML
    private TableColumn<Evenement, Integer> nbp_e;
    @FXML
    private TableView<Evenement> tableclient;
    public ObservableList<Evenement> data1=FXCollections.observableArrayList();
    @FXML
    private Button det;
    @FXML
    private TableColumn<Evenement, String> type_e;
    @FXML
    private TableColumn<Evenement, Integer> NBVUES1;
    @FXML
    private TableColumn<Evenement, Integer> ID1;
    @FXML
    private Button btnpart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherevent();
        tableclient.setRowFactory(new Callback<TableView<Evenement>, TableRow<Evenement>>() {
    
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
    }    
    List<Evenement> Evenement;
    EvenementCRUD ecd= new EvenementCRUD();
  public void Refresh(){
        Evenement=ecd.AfficherlisteDesEvenements();
        tableclient.getItems().setAll(Evenement);
    }
   
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
                          ID1.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("ID_event"));

                 n_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Nom_event"));
                 dd_e.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("Date_debut"));
                 df_e.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("Date_fin"));
                l_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Lieu_event"));
                nbp_e.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("Nb_places"));
      type_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("Type_event"));
                NBVUES1.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("Nb_vues"));

                 tableclient.setItems( data1);
      }
   
    public static Map<String, Object> jsonToMap(String str){
        Map<String, Object> map=new Gson().fromJson(
        str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
   return map;
    }
    public void calculnbvue (Evenement eve) {
         try{
  String requete="update evenement set  Nb_vues=Nb_vues + 1 where ID_event="+eve.getID_event()+"";
       
          PreparedStatement pst = MyConnection.getInstance().getCnx()
                                    .prepareStatement(requete);
        pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void partciper (Evenement eve) {
         try{
  String requete="update evenement set  Nb_places=Nb_places - 1 where ID_event="+eve.getID_event()+"";
       
          PreparedStatement pst = MyConnection.getInstance().getCnx()
                                    .prepareStatement(requete);
        pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
   @FXML
    public void meteo(ActionEvent event){
        String API_KEY="5b491eb9b69dd529d5cb765278c52609";
        String LOCATION=recherche.getText();
        String urlString="https://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY+"&units=metric";
        try{
            StringBuilder result =new StringBuilder();
            URL url=new URL(urlString);
            URLConnection conn=url.openConnection();
            BufferedReader rd=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine())!=null){
                result.append(line);
            }
            rd.close();
            Map<String, Object> respMap= jsonToMap(result.toString());
            Map<String, Object> mainMap= jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap= jsonToMap(respMap.get("wind").toString());  
            List<Map<String, Object>> weatherList = (List<Map<String, Object>>) respMap.get("weather");
            Map<String, Object> weatherMap = weatherList.get(0);
            String icon = (String) weatherMap.get("icon");
            WEATHERAPI.setText("Temperature: "+mainMap.get("temp")+ "°C Humidité: "+mainMap.get("humidity")+" Vitesse: "+windMap.get("speed"));
            String iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
            URL url1 = new URL(iconUrl);
            InputStream in = url1.openStream();
            Image image = new Image(in);
            IMAGEAPI.setImage(image);
        }catch(IOException e){
            System.out.println(e);
        }
}


    @FXML
    private void btdetail(ActionEvent event) {
        
        try{  
        Evenement e;
        e =tableclient.getSelectionModel().getSelectedItem();   
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/TransportYasmine/gui/Details.fxml"));
        EvenementCRUD ec = new EvenementCRUD();
        Parent root = loader.load();
        calculnbvue(e);
        tableclient.getScene().setRoot(root);
        DetailsController dc = loader.getController();
        dc.setLABELID(String.valueOf(e.getID_event()));
        dc.setNBVUES(String.valueOf(e.getNb_vues()+1));
        dc.setLabeldatedeb(e.getDate_debut().toString());
        dc.setLabeldatefin(e.getDate_fin().toString());
        String imagePath = "C:\\Users\\DELL\\Documents\\NetBeansProjects\\TransportYasmine\\src\\edu\\TransportYasmine\\image.png"; 
        Image image = new Image(new File(imagePath).toURI().toString());
        dc.vueimage.setImage(image);  
        dc.affichersponsorparevent();
        dc.miaaw();
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        } }

    
    
  
}

    
    
    

