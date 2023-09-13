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
 * Predstavlja specifican table model koji je prilagodjen za rad sa odgovorima.
 *
 * Nasledjuje klasu AbstractTableModel.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class TableModelOdgovori extends AbstractTableModel {

    /**
     * Lista odgovora sa cijim sadrzajem ce table model raditi.
     */
    private final List<Odgovor> odgovorList;
    /**
     * Niz stringova koji predstavlja nazive kolona u tabeli.
     */
    private final String[] columns = {"Tekst", "Tacan"};

    /**
     * Konstruktor koji vraca novu instancu ovog table modela i inicijalizuje listu odgovora.
     */
    public TableModelOdgovori() {  
        this.odgovorList = new ArrayList<>();
    }

    /**
     * Vraca broj redova u tabeli na osnovu broja odgovora ukoliko je postavljena instanca liste odgovora sa kojom radi table model, u suprotnom vraca 0.
     */
    @Override
    public int getRowCount() {
        if (odgovorList != null)
            return odgovorList.size();
        else return 0;
    }

    /**
     * Vraca broj kolona na osnovu velicine niza naziva kolona.
     */
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    /**
     * Vraca naziv kolone na osnovu rednog broja kolone.
     */
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    /**
     * Vraca vrednost iz odgovarajuceg polja u tabeli na osnovu rednog broja reda i kolone.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Odgovor odgovor = odgovorList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> odgovor.getTekst();
            case 1 -> odgovor.isTacan();
            default -> "n/a";
        };
    }

    /**
     * Dodaje odgovor konstruisan prosledjenim parametrima u listu odgovora.
     * @param tekst - Prosledjeni tekst odgovora.
     * @param tacan - Prosledjeni atribut tacan odgovora.
     */
    public void addOdgovor(String tekst, boolean tacan) {
        Odgovor odgovor = new Odgovor();
        odgovor.setTekst(tekst);
        odgovor.setTacan(tacan);
        odgovorList.add(odgovor);
        fireTableDataChanged();
    }

    /**
     * Izbacuje odgovor iz liste odgovora na osnovu prosledjenog izabranog reda u tabeli.
     * @param rowIndex - Prosledjeni redni broj izabrane stavke u tabeli.
     */
    public void removeOdgovor(int rowIndex) {
        odgovorList.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Vraca listu odgovora.
     * @return odgovorList - Lista odgovora.
     */
    public List<Odgovor> getOdgovorList() {
        return odgovorList;
    }
    
}
