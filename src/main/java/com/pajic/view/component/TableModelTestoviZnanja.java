/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.view.component;

import com.pajic.model.Pitanje;
import com.pajic.model.TestZnanja;
import com.pajic.model.TipTestaZnanja;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Predstavlja specifican table model koji je prilagodjen za rad sa testovima znanja.
 *
 * Nasledjuje klasu AbstractTableModel.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class TableModelTestoviZnanja extends AbstractTableModel {

    /**
     * Lista testova znanja.
     */
    private List<TestZnanja> testoviZnanjaList;
    /**
     * Niz stringova koji predstavlja nazive kolona u tabeli.
     */
    private final String[] columns = {"Naziv", "Poeni za prolaz", "Tip"};

    /**
     * Konstruktor koji vraca novu instancu ovog table modela i inicijalizuje listu testova znanja na prosledjenu listu testova znanja.
     * @param testoviZnanjaList - Prosledjena lista testova znanja.
     */
    public TableModelTestoviZnanja(List<TestZnanja> testoviZnanjaList) {
        this.testoviZnanjaList = testoviZnanjaList;
    }

    /**
     * Vraca broj redova u tabeli na osnovu broja pitanja ukoliko je postavljena instanca liste pitanja sa kojom radi table model, u suprotnom vraca 0.
     */
    @Override
    public int getRowCount() {
        return testoviZnanjaList.size();
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
        TestZnanja testZnanja = testoviZnanjaList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> testZnanja.getNaziv();
            case 1 -> testZnanja.getPoeniZaProlaz();
            case 2 -> testZnanja.getTipTestaZnanja();
            default -> "n/a";
        };
    }

    /**
     * Dodaje test znanja konstruisan prosledjenim parametrima u listu testova znanja.
     * @param naziv - Prosledjeni naziv testa znanja.
     * @param poeniZaProlaz - Prosledjeni poeni za prolaz testa znanja.
     * @param listaPitanja - Prosledjena lista pitanja koja pripadaju testu znanja.
     * @param tipTestaZnanja - Prosledjen tip testa znanja.
     */
    public void addTestZnanja(String naziv, double poeniZaProlaz, List<Pitanje> listaPitanja, TipTestaZnanja tipTestaZnanja) {
        TestZnanja testZnanja = new TestZnanja();
        testZnanja.setNaziv(naziv);
        testZnanja.setPoeniZaProlaz(poeniZaProlaz);
        testZnanja.setListaPitanja(listaPitanja);
        testZnanja.setTipTestaZnanja(tipTestaZnanja);
        testoviZnanjaList.add(testZnanja);
        fireTableDataChanged();
    }

    /**
     * Izbacuje test znanja iz liste testova znanja na osnovu prosledjenog izabranog reda u tabeli.
     * @param rowIndex - Prosledjeni redni broj izabrane stavke u tabeli.
     */
    public void removeTestZnanja(int rowIndex) {
        testoviZnanjaList.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Vraca listu testova znanja.
     * @return testoviZnanjaList - Lista testova znanja.
     */
    public List<TestZnanja> getTestoviZnanjaList() {
        return testoviZnanjaList;
    }

    /**
     * Postavlja listu testova znanja na prosledjenu listu testova znanja.
     * @param testoviZnanjaList - Prosledjena lista testova znanja.
     */
    public void setTestoviZnanjaList(List<TestZnanja> testoviZnanjaList) {
        this.testoviZnanjaList = testoviZnanjaList;
    }
}
