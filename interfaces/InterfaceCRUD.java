/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author DELL
 * @param <T>
 */
public interface InterfaceCRUD<T> {
    
       public void ajouterEvenement(T t);
        public List<T> AfficherlisteDesEvenements();
      public void  SupprimerEvenement(T t);
      public void modifierEvenement (T t, String x, LocalDate y, LocalDate z, String w, int a, String b, int c ) ;
       public void ajouterSponsor(T t);
      public List<T> AfficherlisteDesSponsors(T t) ;
      
      public void modifierSponsor(T t, String x, String y, String z, float w );
 public void SupprimerSponsor(T t); 
        
}
