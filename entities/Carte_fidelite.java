/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author aziz
 */
public class Carte_fidelite {
    int id;
    int points;

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carte_fidelite(int id, int points) {
        this.id = id;
        this.points = points;
    }

    public Carte_fidelite() {
        id=-1;
        points=0;
    }
    
}
