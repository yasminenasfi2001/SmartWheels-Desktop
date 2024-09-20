
package entities;

public class Vehicule
{
    private  int id;
    private  String marque;
  
    
     private  String vitesse_max;
      private  float charge_max;
       private  String auto_batterie;
        private  String couleur;
         private  String type_vehicule;
          private float prix;

    public Vehicule() {
        id=0;
        this.marque = "";
      
        this.vitesse_max = "";
        this.charge_max = 0;
        this.auto_batterie = "";
        this.couleur = "";
        this.type_vehicule = "";
         this.prix=0;
    }
         
         
         


    public Vehicule(int id, String marque, String vitesse_max, float charge_max, String auto_batterie, String couleur, String type_vehicule,float prix) {
        this.id = id;
        this.marque = marque;
      
        this.vitesse_max = vitesse_max;
        this.charge_max = charge_max;
        this.auto_batterie = auto_batterie;
        this.couleur = couleur;
        this.type_vehicule = type_vehicule;
         this.prix=prix;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }



    public String getVitesse_max() {
        return vitesse_max;
    }

    public float getCharge_max() {
        return charge_max;
    }

    public String getAuto_batterie() {
        return auto_batterie;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getType_vehicule() {
        return type_vehicule;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }



    public void setVitesse_max(String vitesse_max) {
        this.vitesse_max = vitesse_max;
    }

    public void setCharge_max(float charge_max) {
        this.charge_max = charge_max;
    }

    public void setAuto_batterie(String auto_batterie) {
        this.auto_batterie = auto_batterie;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setType_vehicule(String type_vehicule) {
        this.type_vehicule = type_vehicule;
    }
         
}