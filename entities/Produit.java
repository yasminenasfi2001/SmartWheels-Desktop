<<<<<<< HEAD:entities/Produit.java
package entities;

=======
>>>>>>> master:src/entities/Produit.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:entities/Produit.java
=======
package gestionventee;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
>>>>>>> master:src/entities/Produit.java

/**
 *
 * @author snowy
 */
public class Produit {
<<<<<<< HEAD:entities/Produit.java
        public static String pathfile; 
    public static String filename="";
=======
>>>>>>> master:src/entities/Produit.java
     private int id_prod;
    private String nom_prod;
    private String type_prod;
    private int quant_prod;
    private float prix_prod;
    private String desc_prod;
<<<<<<< HEAD:entities/Produit.java
    private String image_url;
    
=======
  
>>>>>>> master:src/entities/Produit.java

    public Produit() {
    }

    public Produit(int id_prod, String nom_prod, String type_prod, int quant_prod, float prix_prod, String desc_prod) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.type_prod = type_prod;
        this.quant_prod = quant_prod;
        this.prix_prod = prix_prod;
        this.desc_prod = desc_prod;
    }
<<<<<<< HEAD:entities/Produit.java
        public Produit(String nom_prod, String type_prod, int quant_prod, float prix_prod, String desc_prod) {
     
=======

    public Produit(String nom_prod, String type_prod, int quant_prod, float prix_prod, String desc_prod) {
>>>>>>> master:src/entities/Produit.java
        this.nom_prod = nom_prod;
        this.type_prod = type_prod;
        this.quant_prod = quant_prod;
        this.prix_prod = prix_prod;
        this.desc_prod = desc_prod;
    }

<<<<<<< HEAD:entities/Produit.java
    public Produit(int id_prod, String nom_prod, String type_prod, int quant_prod, float prix_prod, String desc_prod, String image_url) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.type_prod = type_prod;
        this.quant_prod = quant_prod;
        this.prix_prod = prix_prod;
        this.desc_prod = desc_prod;
        this.image_url = image_url;
    }

    public Produit(String nom_prod, String type_prod, int quant_prod, float prix_prod, String desc_prod, String image_url) {
        this.nom_prod = nom_prod;
        this.type_prod = type_prod;
        this.quant_prod = quant_prod;
        this.prix_prod = prix_prod;
        this.desc_prod = desc_prod;
        this.image_url = image_url;
    }



=======
>>>>>>> master:src/entities/Produit.java
    public int getId_prod() {
        return id_prod;
    }

<<<<<<< HEAD:entities/Produit.java
    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

=======
>>>>>>> master:src/entities/Produit.java
    public String getNom_prod() {
        return nom_prod;
    }

<<<<<<< HEAD:entities/Produit.java
    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

=======
>>>>>>> master:src/entities/Produit.java
    public String getType_prod() {
        return type_prod;
    }

<<<<<<< HEAD:entities/Produit.java
    public void setType_prod(String type_prod) {
        this.type_prod = type_prod;
    }

=======
>>>>>>> master:src/entities/Produit.java
    public int getQuant_prod() {
        return quant_prod;
    }

<<<<<<< HEAD:entities/Produit.java
    public void setQuant_prod(int quant_prod) {
        this.quant_prod = quant_prod;
    }

=======
>>>>>>> master:src/entities/Produit.java
    public float getPrix_prod() {
        return prix_prod;
    }

<<<<<<< HEAD:entities/Produit.java
=======
    public String getDesc_prod() {
        return desc_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public void setType_prod(String type_prod) {
        this.type_prod = type_prod;
    }

    public void setQuant_prod(int quant_prod) {
        this.quant_prod = quant_prod;
    }

>>>>>>> master:src/entities/Produit.java
    public void setPrix_prod(float prix_prod) {
        this.prix_prod = prix_prod;
    }

<<<<<<< HEAD:entities/Produit.java

    public String getDesc_prod() {
        return desc_prod;
    }

    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
    }
        public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_prod=" + id_prod + ", nom_prod=" + nom_prod + ", type_prod=" + type_prod + ", quant_prod=" + quant_prod + ", prix_prod=" + prix_prod + ", desc_prod=" + desc_prod + ", image_url=" + image_url + '}';
    }

  

}
=======
    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_prod=" + id_prod + ", nom_prod=" + nom_prod + ", type_prod=" + type_prod + ", quant_prod=" + quant_prod + ", prix_prod=" + prix_prod + ", desc_prod=" + desc_prod + '}';
    }

   

   
    
    
    
}
>>>>>>> master:src/entities/Produit.java
