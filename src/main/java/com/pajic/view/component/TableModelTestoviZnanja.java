/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.view.component;

import com.pajic.model.Pitanje;
import com.pajic.model.TestZnanja;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Pavle
 */
public class TableModelTestoviZnanja extends AbstractTableModel {
    
    private List<TestZnanja> testoviZnanjaList;
    private final String[] columns = {"Naziv", "Poeni za prolaz"};

    public TableModelTestoviZnanja(List<TestZnanja> testoviZnanjaList) {
        this.testoviZnanjaList = testoviZnanjaList;
    }

    @Override
    public int getRowCount() {
        return testoviZnanjaList.size();
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
        TestZnanja testZnanja = testoviZnanjaList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> testZnanja.getNaziv();
            case 1 -> testZnanja.getPoeniZaProlaz();
            default -> "n/a";
        };
    }
    
    public void addTestZnanja(String naziv, double poeniZaProlaz, List<Pitanje> listaPitanja) {
        TestZnanja testZnanja = new TestZnanja();
        testZnanja.setNaziv(naziv);
        testZnanja.setPoeniZaProlaz(poeniZaProlaz);
        testZnanja.setListaPitanja(listaPitanja);
        testoviZnanjaList.add(testZnanja);
        fireTableDataChanged();
    }
    
    public void removeTestZnanja(int rowIndex) {
        testoviZnanjaList.remove(rowIndex);
        fireTableDataChanged();
    }

    public List<TestZnanja> getTestoviZnanjaList() {
        return testoviZnanjaList;
    }

    public void setTestoviZnanjaList(List<TestZnanja> testoviZnanjaList) {
        this.testoviZnanjaList = testoviZnanjaList;
    }
}
