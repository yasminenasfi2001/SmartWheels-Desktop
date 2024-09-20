/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Reservation;

import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public interface ReservationCRUD<T>{
    
    
    public void ajouter_reservation(T t);
   public void Supprimer_reservation(int id);
    public ObservableList<Reservation> afficher_Reservation();
    public void modifier_Reservation(Reservation v);
      public Reservation GetUserById(int id);
    
}
