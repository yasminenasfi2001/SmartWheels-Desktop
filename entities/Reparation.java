/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author yosra
 */
public class Reparation {
    
    private int id;
    private int id_v;
    private int id_employee;
    private String Description_panne;
    private String Etat;
    private LocalDate Date_rep;
    private LocalDate Date_manu;
    private LocalDate Date_defect;
    
    
    public Reparation() { 
    }
    
    public Reparation(String Description_panne, String Etat, LocalDate Date_rep, LocalDate Date_manu, LocalDate Date_defect) {
        this.Description_panne = Description_panne;
        this.Etat = Etat;
        this.Date_rep = Date_rep;
        this.Date_manu = Date_manu;
        this.Date_defect = Date_defect;
      }
    public Reparation(int id,String Description_panne, String Etat, LocalDate Date_rep, LocalDate Date_manu, LocalDate Date_defect) {
        this.Description_panne = Description_panne;
        this.id= id;
        this.Etat = Etat;
        this.Date_rep = Date_rep;
        this.Date_manu = Date_manu;
        this.Date_defect = Date_defect;
      }

    public int getId() {
        return id;
    }

    public int getId_v() {
        return id_v;
    }

    public String getDescription_panne() {
        return Description_panne;
    }

    public String getEtat() {
        return Etat;
    }

    public LocalDate getDate_rep() {
        return Date_rep;
    }

    public LocalDate getDate_manu() {
        return Date_manu;
    }

    public LocalDate getDate_defect() {
        return Date_defect;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public void setDescription_panne(String Description_panne) {
        this.Description_panne = Description_panne;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setDate_rep(LocalDate Date_rep) {
        this.Date_rep = Date_rep;
    }

    public void setDate_manu(LocalDate Date_manu) {
        this.Date_manu = Date_manu;
    }

    public void setDate_defect(LocalDate Date_defect) {
        this.Date_defect = Date_defect;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    @Override
    public String toString() {
        return "Reparation{" + "id=" + id + ", id_v=" + id_v + ", Description_panne=" + Description_panne + ", Etat=" + Etat + ", Date_rep=" + Date_rep + ", Date_manu=" + Date_manu + ", Date_defect=" + Date_defect +"id_employee"+id_employee+ '}';
    }
}
    
    

    