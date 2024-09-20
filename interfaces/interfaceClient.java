/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:interfaces/interfaceClient.java
package interfaces;
=======
<<<<<<< HEAD
package interfaces;
=======
package projet_transport.interfaces;
>>>>>>> master
>>>>>>> master:src/interfaces/interfaceClient.java

import java.util.ArrayList;
import java.util.Map;
import javafx.collections.ObservableList;
<<<<<<< HEAD:interfaces/interfaceClient.java
import entities.Utilisateur;
=======
<<<<<<< HEAD
import entities.Utilisateur;
=======
import projet_transport.model.Utilisateur;
>>>>>>> master
>>>>>>> master:src/interfaces/interfaceClient.java

/**
 *
 * @author aziz
 */
public interface interfaceClient<T> {
     public void inscription(T c);
     public void ajouter(T c);
     public void modifier(T c);
     public void Supprimer(int id);
     public Utilisateur getUserById(String id);
     public Utilisateur getUserByEmail(String email);
     public boolean CheckUserByEmail(String email);
     public boolean CheckUserAdmin(String email) ;
     public boolean CheckAccount(String email,String password) ;
     public ObservableList<Utilisateur> afficher() throws ClassNotFoundException;
}
