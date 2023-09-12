/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.view.component;

import com.pajic.model.Odgovor;
import com.pajic.model.Pitanje;
import com.pajic.model.TestZnanja;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pavle
 */
public class TableModelPitanja extends AbstractTableModel {
    
    private List<Pitanje> pitanjeList;
    private final String[] columns = {"Tekst", "Poeni"};

    public TableModelPitanja() {
        this.pitanjeList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (pitanjeList != null)
            return pitanjeList.size();
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
        Pitanje pitanje = pitanjeList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> pitanje.getTekst();
            case 1 -> pitanje.getPoeni();
            default -> "n/a";
        };
    }
    
    public void addPitanje(String tekst, double poeni, List<Odgovor> listaOdgovora) {
        Pitanje pitanje = new Pitanje();
        pitanje.setTekst(tekst);
        pitanje.setPoeni(poeni);
        pitanje.setListaOdgovora(listaOdgovora);
        pitanjeList.add(pitanje);
        fireTableDataChanged();
    }
    
    public void removePitanje(int rowIndex) {
        pitanjeList.remove(rowIndex);
        fireTableDataChanged();
    }
    
    public void removeOdgovorFromPitanje(int rowIndex, Pitanje pitanje) {
        for (Pitanje p : pitanjeList) {
            if (p.equals(pitanje)) {
                p.getListaOdgovora().remove(rowIndex);
            }
        }
        fireTableDataChanged();
    }

    public void addTestZnanja(TestZnanja tz) {
        for (Pitanje p : pitanjeList) {
            p.setTestZnanja(tz);
            for (Odgovor o : p.getListaOdgovora()) {
                o.setPitanje(p);
                o.setTestZnanja(tz);
            }
        }
    }

    public List<Pitanje> getPitanjeList() {
        return pitanjeList;
    }

    public void setPitanjeList(List<Pitanje> pitanjeList) {
        this.pitanjeList = pitanjeList;
    }
    
}
