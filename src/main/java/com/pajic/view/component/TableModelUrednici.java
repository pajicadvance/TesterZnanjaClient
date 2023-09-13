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
 * Predstavlja specifican table model koji je prilagodjen za rad sa urednicima.
 *
 * Nasledjuje klasu AbstractTableModel.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class TableModelUrednici extends AbstractTableModel {

    /**
     * Lista urednika.
     */
    private List<Urednik> urednikList;
    /**
     * Trenutno ulogovani administrator.
     */
    private final Administrator administrator;
    /**
     * Niz stringova koji predstavlja nazive kolona u tabeli.
     */
    private final String[] columns = {"Ime", "Prezime", "Datum rodjenja", "Username", "Password"};

    /**
     * Konstruktor koji vraca novu instancu ovog table modela, inicijalizuje listu urednika na prosledjenu listu urednika i postavlja administratora.
     * @param urednikList - Prosledjena lista urednika.
     * @param administrator - Prosledjeni administrator.
     */
    public TableModelUrednici(List<Urednik> urednikList, Administrator administrator) {
        this.urednikList = urednikList;
        this.administrator = administrator;
    }

    /**
     * Vraca broj redova u tabeli na osnovu broja pitanja ukoliko je postavljena instanca liste pitanja sa kojom radi table model, u suprotnom vraca 0.
     */
    @Override
    public int getRowCount() {
        return urednikList.size();
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

    /**
     * Dodaje urednika konstruisanog prosledjenim parametrima u listu urednika.
     * @param ime - Prosledjeno ime urednika.
     * @param prezime - Prosledjeno prezime urednika.
     * @param datumRodjenja - Prosledjen datum rodjenja urednika.
     * @param username - Prosledjeno korisnicko ime urednika.
     * @param password - Prosledjena lozinka urednika.
     */
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

    /**
     * Dodaje prosledjenog urednika u listu urednika.
     * @param u - Prosledjeni urednik.
     */
    public void addUrednik(Urednik u) {
        urednikList.add(u);
        fireTableDataChanged();
    }

    /**
     * Izbacuje urednika iz liste urednika na osnovu prosledjenog izabranog reda u tabeli.
     * @param rowIndex - Prosledjeni redni broj izabrane stavke u tabeli.
     */
    public void removeUrednik(int rowIndex) {
        urednikList.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Vraca listu urednika.
     * @return urednikList - Lista urednika.
     */
    public List<Urednik> getUrednikList() {
        return urednikList;
    }

    /**
     * Postavlja listu urednika na prosledjenu listu urednika.
     * @param urednikList - Prosledjena lista urednika.
     */
    public void setUrednikList(List<Urednik> urednikList) {
        this.urednikList = urednikList;
    }
}
