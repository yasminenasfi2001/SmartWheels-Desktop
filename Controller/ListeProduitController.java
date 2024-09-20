package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entities.Produit;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import services.ProduitService;

public class ListeProduitController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox prodcard;

    @FXML
    private Label lbnomprod;

    @FXML
    private Label lbprixprod;

    @FXML
    private ImageView prodimg;

    @FXML
    private JFXComboBox<?> lbquantprod;

    @FXML
    private JFXTextField lbtypeprod;

    @FXML
    private JFXTextField lbdescprod;

    @FXML
    private JFXComboBox<?> lbquantprod1;

    @FXML
    private ScrollPane scroll;

    @FXML
    private ListView<Produit> listView;

    ProduitService sp = new ProduitService();
    List<Produit> lp = sp.afficher();

    /**
     * Initializes the controller class.
     * @param url
     * @param resourceBundle
     */
public void initialize(URL url, ResourceBundle resourceBundle) {

    ProduitService util = new ProduitService();
    ObservableList<Produit> Items = util.afficher();
    listView.setItems(Items);

    // Customize the appearance of the list view
    listView.setCellFactory(param -> new ProductListCell());

    // Handle user interaction with the list view
    listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            // Update the product card with the selected product's information
            lbnomprod.setText(newValue.getNom_prod());
            lbprixprod.setText(String.valueOf(newValue.getPrix_prod()));
            
           
            lbtypeprod.setText(newValue.getType_prod());
            lbdescprod.setText(newValue.getDesc_prod());
        }
    });

}

    private static class ProductListCell extends ListCell<Produit> {

        @Override
        protected void updateItem(Produit item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
            } else {
                setText(item.getNom_prod() + " - " + item.getType_prod() + " - " + item.getPrix_prod());
            }
        }
    }

    @FXML
    private void ajoutpanier(ActionEvent event) {
  
    }

}
