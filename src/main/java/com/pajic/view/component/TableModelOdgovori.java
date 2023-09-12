/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.view.component;

import com.pajic.model.Odgovor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pavle
 */
public class TableModelOdgovori extends AbstractTableModel {
    
    private final List<Odgovor> odgovorList;
    private final String[] columns = {"Tekst", "Tacan"};

    public TableModelOdgovori() {  
        this.odgovorList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (odgovorList != null)
            return odgovorList.size();
        else return 0;
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
        Odgovor odgovor = odgovorList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> odgovor.getTekst();
            case 1 -> odgovor.isTacan();
            default -> "n/a";
        };
    }
    
    public void addOdgovor(String tekst, boolean tacan) {
        Odgovor odgovor = new Odgovor();
        odgovor.setTekst(tekst);
        odgovor.setTacan(tacan);
        odgovorList.add(odgovor);
        fireTableDataChanged();
    }
    
    public void replaceOdgovor(String tekst, boolean tacan, int index) {
        Odgovor odgovor = new Odgovor();
        odgovor.setTekst(tekst);
        odgovor.setTacan(tacan);
        odgovorList.set(index, odgovor);
        fireTableDataChanged();
    }
    
    public void removeOdgovor(int rowIndex) {
        odgovorList.remove(rowIndex);
        fireTableDataChanged();
    }

    public List<Odgovor> getOdgovorList() {
        return odgovorList;
    }
    
}
