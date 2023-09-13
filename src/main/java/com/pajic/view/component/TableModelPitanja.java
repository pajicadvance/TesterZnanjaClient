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
 * Predstavlja specifican table model koji je prilagodjen za rad sa pitanjima.
 *
 * Nasledjuje klasu AbstractTableModel.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class TableModelPitanja extends AbstractTableModel {

    /**
     * Lista pitanja sa cijim sadrzajem ce table model raditi.
     */
    private List<Pitanje> pitanjeList;
    /**
     * Niz stringova koji predstavlja nazive kolona u tabeli.
     */
    private final String[] columns = {"Tekst", "Poeni"};

    /**
     * Konstruktor koji vraca novu instancu ovog table modela i inicijalizuje listu pitanja.
     */
    public TableModelPitanja() {
        this.pitanjeList = new ArrayList<>();
    }

    /**
     * Vraca broj redova u tabeli na osnovu broja pitanja ukoliko je postavljena instanca liste pitanja sa kojom radi table model, u suprotnom vraca 0.
     */
    @Override
    public int getRowCount() {
        if (pitanjeList != null)
            return pitanjeList.size();
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
        Pitanje pitanje = pitanjeList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> pitanje.getTekst();
            case 1 -> pitanje.getPoeni();
            default -> "n/a";
        };
    }

    /**
     * Dodaje pitanje konstruisano prosledjenim parametrima u listu pitanja.
     * @param tekst - Prosledjeni tekst pitanja.
     * @param poeni - Prosledjeni poeni koje pitanje nosi.
     * @param listaOdgovora - Prosledjena lista odgovora koji pripadaju pitanju.
     */
    public void addPitanje(String tekst, double poeni, List<Odgovor> listaOdgovora) {
        Pitanje pitanje = new Pitanje();
        pitanje.setTekst(tekst);
        pitanje.setPoeni(poeni);
        pitanje.setListaOdgovora(listaOdgovora);
        pitanjeList.add(pitanje);
        fireTableDataChanged();
    }

    /**
     * Izbacuje pitanje iz liste pitanja na osnovu prosledjenog izabranog reda u tabeli.
     * @param rowIndex - Prosledjeni redni broj izabrane stavke u tabeli.
     */
    public void removePitanje(int rowIndex) {
        pitanjeList.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Izbacuje odgovor iz specificnog pitanja iz liste pitanja na osnovu prosledjenog izabranog reda u tabeli.
     * @param rowIndex - Prosledjeni redni broj izabrane stavke u tabeli.
     * @param pitanje - Prosledjeno pitanje iz kojeg je potrebno izbaciti odgovor.
     */
    public void removeOdgovorFromPitanje(int rowIndex, Pitanje pitanje) {
        for (Pitanje p : pitanjeList) {
            if (p.equals(pitanje)) {
                p.getListaOdgovora().remove(rowIndex);
            }
        }
        fireTableDataChanged();
    }

    /**
     * Povezuje sva pitanja iz liste pitanja i sve njihove odgovore sa prosledjenim testom znanja.
     * @param tz - Prosledjeni test znanja.
     */
    public void addTestZnanja(TestZnanja tz) {
        for (Pitanje p : pitanjeList) {
            p.setTestZnanja(tz);
            for (Odgovor o : p.getListaOdgovora()) {
                o.setPitanje(p);
                o.setTestZnanja(tz);
            }
        }
    }

    /**
     * Vraca listu pitanja.
     * @return pitanjeList - Lista pitanja.
     */
    public List<Pitanje> getPitanjeList() {
        return pitanjeList;
    }

    /**
     * Postavlja listu pitanja na prosledjenu listu pitanja.
     * @param pitanjeList - Prosledjena lista pitanja.
     */
    public void setPitanjeList(List<Pitanje> pitanjeList) {
        this.pitanjeList = pitanjeList;
    }
    
}
