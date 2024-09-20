/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.time.LocalDate;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author DELL
 */
public class DatePickerTableCell<T> extends TableCell<T, LocalDate> {
    private final DatePicker datePicker;
    private boolean editable;

    public DatePickerTableCell(TableColumn<T, LocalDate> column) {
        this.datePicker = new DatePicker();
        this.datePicker.editableProperty().bind(column.editableProperty());
        this.datePicker.disableProperty().bind(column.editableProperty().not());
        this.datePicker.setOnShowing(event -> {
            final TableView<T> tableView = getTableView();
            tableView.getSelectionModel().select(getTableRow().getIndex());
            tableView.edit(tableView.getSelectionModel().getSelectedIndex(), column);
        });
        this.datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (isEditing())
            {
                commitEdit(newValue);
            }
        });
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
       
             editable = column.isEditable();
        column.editableProperty().addListener((observable, oldValue, newValue) -> {
            editable = newValue;
            updateContent();
        });
        
    }
        
    

    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (empty) {
            setGraphic(null);
            
        } else {
            
            
            this.datePicker.setValue(item);
            setGraphic(this.datePicker);
            
        }}
    
    
    
    
    
        private String getString() {
        return getItem() == null ? "" : getItem().toString();
    
    }
private void updateContent() {
        if (!editable) {
            setText(getString());
            setGraphic(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        } else {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }

}