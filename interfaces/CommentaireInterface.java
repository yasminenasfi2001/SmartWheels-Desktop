/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Commentaire;
import java.util.List;

/**
 *
 * @author user
 * @param <T>
 */
public interface CommentaireInterface<T> {
    public void ajouterCommentaire(T t) ; 
    public void supprimerCommentaire(int id);
    public void updateCommentaire(int id,T t);
    public List<T> listeDesCommentaires();
}
