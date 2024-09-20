/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.List;

/**
 *
 * @author yosra
 */
public interface InterfaceCRUDY<T> {
    
    public void ajouterEntitee(T t);
    public List<T> listeDesEntites();

}
