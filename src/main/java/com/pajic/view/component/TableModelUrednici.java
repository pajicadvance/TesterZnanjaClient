/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.view.component;

import com.pajic.model.Administrator;
import com.pajic.model.Urednik;

import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pavle
 */
public class TableModelUrednici extends AbstractTableModel {
    
    private List<Urednik> urednikList;
    private final Administrator administrator;
    private final String[] columns = {"Ime", "Prezime", "Datum rodjenja", "Username", "Password"};

    public TableModelUrednici(List<Urednik> urednikList, Administrator administrator) {
        this.urednikList = urednikList;
        this.administrator = administrator;
    }

    @Override
    public int getRowCount() {
        return urednikList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Urednik urednik = urednikList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> urednik.getIme();
            case 1 -> urednik.getPrezime();
            case 2 -> urednik.getDatumRodjenja();
            case 3 -> urednik.getUsername();
            case 4 -> urednik.getPassword();
            default -> "n/a";
        };
    }
    
    public void addUrednik(String ime, String prezime, LocalDate datumRodjenja, String username, String password) {
        Urednik urednik = new Urednik();
        urednik.setIme(ime);
        urednik.setPrezime(prezime);
        urednik.setDatumRodjenja(datumRodjenja);
        urednik.setUsername(username);
        urednik.setPassword(password);
        urednik.setAdministrator(administrator);
        urednikList.add(urednik);
        fireTableDataChanged();
    }
    
    public void addUrednik(Urednik u) {
        urednikList.add(u);
        fireTableDataChanged();
    }
    
    public void removeUrednik(int rowIndex) {
        urednikList.remove(rowIndex);
        fireTableDataChanged();
    }

    public List<Urednik> getUrednikList() {
        return urednikList;
    }

    public void setUrednikList(List<Urednik> urednikList) {
        this.urednikList = urednikList;
    }
}
