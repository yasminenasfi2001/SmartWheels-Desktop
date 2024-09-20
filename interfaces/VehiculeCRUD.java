/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Vehicule;
import java.util.Map;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 * @param <T>
 */
public interface VehiculeCRUD<T> {

    /**
     *
     * @param t
     */
    public void ajouter_vehicule(T t);
    public void Supprimer_Vehicule(int id);
    public ObservableList<Vehicule> afficher_vehicule();
    public void modifier_vehicule(Vehicule v);
    
}
