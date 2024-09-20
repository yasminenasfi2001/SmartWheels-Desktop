/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import entities.Evenement;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.StringConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.ContentDisplay;

public class DateCellEvent extends TableCell<Evenement, LocalDate> {

    private final DateTimeFormatter formatter;
    
    public DateCellEvent(DateTimeFormatter formatter) {
        this.formatter = formatter;
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }
    
    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
        }else {
            setText(formatter.format(item));
        }
    }
}