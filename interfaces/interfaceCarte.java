/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:interfaces/interfaceCarte.java
package interfaces;

import javafx.collections.ObservableList;
import entities.Carte_fidelite;
import entities.Utilisateur;
=======
<<<<<<< HEAD
package interfaces;

import javafx.collections.ObservableList;
import entities.Carte_fidelite;
import entities.Utilisateur;
=======
package projet_transport.interfaces;

import javafx.collections.ObservableList;
import projet_transport.model.Carte_fidelite;
import projet_transport.model.Utilisateur;
>>>>>>> master
>>>>>>> master:src/interfaces/interfaceCarte.java

/**
 *
 * @author aziz
 */
public interface interfaceCarte <T> {
     public void ajouter(T c);
     public void modifier(T c);
     public void Supprimer(int id);
     public ObservableList<String> GetAllIdUser();
     public ObservableList<Carte_fidelite> afficher();
     public boolean CheckCarteById(int id) ;
    
}
