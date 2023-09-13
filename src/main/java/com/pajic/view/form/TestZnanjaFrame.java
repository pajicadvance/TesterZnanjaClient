/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.model.Korisnik;
import com.pajic.model.Odgovor;
import com.pajic.model.Pitanje;
import com.pajic.model.TestZnanja;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

/**
 * Predstavlja formu koja je namenjena za rad testa znanja od strane korisnika.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class TestZnanjaFrame extends javax.swing.JFrame {

    /**
     * Test znanja koji se radi.
     */
    private final TestZnanja testZnanja;
    /**
     * Korisnik koji radi test.
     */
    private final Korisnik korisnik;
    /**
     * Referenca ka MainFrame instanci.
     */
    private final MainFrame mainFrame;

    /**
     * HashMap koji povezuje odgovore sa objektima tipa JCheckBox.
     */
    private HashMap<Odgovor, JCheckBox> odgovori;
    /**
     * Brojac pitanja.
     */
    private int pitanjeCounter = 0;
    /**
     * Brojac ostvarenih poena.
     */
    private int ukupnoPoena = 0;
    /**
     * Maksimalan moguc broj ostvarenih poena.
     */
    private int maxPoena = 0;

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     *
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param testZnanja - Test znanja koji se radi.
     * @param korisnik - Korisnik koji radi test.
     */
    public TestZnanjaFrame(TestZnanja testZnanja, Korisnik korisnik, MainFrame mainFrame) {
        this.testZnanja = testZnanja;
        this.korisnik = korisnik;
        this.mainFrame = mainFrame;
        initComponents();
        prepareView();
    }

    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHBrojPitanja = new javax.swing.JLabel();
        lblTekstPitanja = new javax.swing.JLabel();
        separator2 = new javax.swing.JSeparator();
        btnProveri = new javax.swing.JButton();
        btnSledecePitanje = new javax.swing.JButton();
        separator1 = new javax.swing.JSeparator();
        lblHPoeni = new javax.swing.JLabel();
        lblHVrednostPitanja = new javax.swing.JLabel();
        lblVrednostPitanja = new javax.swing.JLabel();
        lblBrojPitanja = new javax.swing.JLabel();
        lblPoeni = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblPoeniZaProlaz = new javax.swing.JLabel();
        lblHPoeniZaProlaz = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Test znanja");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblHBrojPitanja.setText("Pitanje");

        lblTekstPitanja.setText("jLabel1");
        lblTekstPitanja.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnProveri.setText("Proveri");
        btnProveri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveriActionPerformed(evt);
            }
        });

        btnSledecePitanje.setText("Slecece pitanje");
        btnSledecePitanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSledecePitanjeActionPerformed(evt);
            }
        });

        lblHPoeni.setText("Poeni:");

        lblHVrednostPitanja.setText("Vrednost:");

        lblVrednostPitanja.setText("jLabel1");

        lblBrojPitanja.setText("jLabel1");

        lblPoeni.setText("jLabel1");

        lblStatus.setText("jLabel1");

        lblPoeniZaProlaz.setText("jLabel1");

        lblHPoeniZaProlaz.setText("Prolaz:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTekstPitanja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separator2)
                    .addComponent(separator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProveri, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSledecePitanje)
                        .addGap(18, 18, 18)
                        .addComponent(lblStatus)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHBrojPitanja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBrojPitanja)
                        .addGap(44, 44, 44)
                        .addComponent(lblHVrednostPitanja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVrednostPitanja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                        .addComponent(lblHPoeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPoeni)
                        .addGap(32, 32, 32)
                        .addComponent(lblHPoeniZaProlaz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPoeniZaProlaz)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHBrojPitanja)
                    .addComponent(lblHPoeni)
                    .addComponent(lblHVrednostPitanja)
                    .addComponent(lblVrednostPitanja)
                    .addComponent(lblBrojPitanja)
                    .addComponent(lblPoeni)
                    .addComponent(lblPoeniZaProlaz)
                    .addComponent(lblHPoeniZaProlaz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTekstPitanja, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProveri)
                    .addComponent(btnSledecePitanje)
                    .addComponent(lblStatus))
                .addContainerGap(400, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ponovno prikazuje glavnu klijentsku formu nakon prekida rada testa.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom (zatvaranje forme).
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        mainFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * Proverava da li je tacno odgovoreno na trenutno prikazano pitanje.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnProveriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveriActionPerformed
        boolean tacan = true;
        for (Map.Entry<Odgovor, JCheckBox> set : odgovori.entrySet()) {
            if ((set.getKey().isTacan() && !set.getValue().isSelected()) || (!set.getKey().isTacan() && set.getValue().isSelected())) {
                lblStatus.setText("Odgovor nije tacan");
                tacan = false;
                break;
            }
        }
        for (Map.Entry<Odgovor, JCheckBox> set : odgovori.entrySet()) {
            set.getValue().setSelected(set.getKey().isTacan());
            set.getValue().setEnabled(false);
        }
        if (tacan) {
            lblStatus.setText("Odgovor je tacan");
            ukupnoPoena = (int) (ukupnoPoena + testZnanja.getListaPitanja().get(pitanjeCounter).getPoeni());
            lblPoeni.setText(String.valueOf(ukupnoPoena + "/" + maxPoena));
        }
        pitanjeCounter++;
        btnProveri.setEnabled(false);
        btnSledecePitanje.setEnabled(true);
    }//GEN-LAST:event_btnProveriActionPerformed

    /**
     * Pokrece proceduru za ucitavanje sledeceg pitanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSledecePitanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSledecePitanjeActionPerformed
        nextPitanje();
    }//GEN-LAST:event_btnSledecePitanjeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme koje pokrece proveru da li je tacno odgovoreno na pitanje.
     */
    private javax.swing.JButton btnProveri;
    /**
     * Dugme koje prelazi na sledece pitanje.
     */
    private javax.swing.JButton btnSledecePitanje;
    /**
     * Labela koja prikazuje redni broj trenutnog pitanja.
     */
    private javax.swing.JLabel lblBrojPitanja;
    /**
     * Labela koja se odnosi na labelu koja prikazuje redni broj trenutnog pitanja.
     */
    private javax.swing.JLabel lblHBrojPitanja;
    /**
     * Labela koja se odnosi na labelu koja prikazuje trenutni broj poena koji je korisnik ostvario.
     */
    private javax.swing.JLabel lblHPoeni;
    /**
     * Labela koja se odnosi na labelu koja prikazuje koliko je potrebno poena da bi se test polozio.
     */
    private javax.swing.JLabel lblHPoeniZaProlaz;
    /**
     * Labela koja se odnosi na labelu koja prikazuje koliko poena vredi trenutno pitanje.
     */
    private javax.swing.JLabel lblHVrednostPitanja;
    /**
     * Labela koja prikazuje trenutni broj poena koji je korisnik ostvario.
     */
    private javax.swing.JLabel lblPoeni;
    /**
     * Labela koja prikazuje koliko je potrebno poena da bi se test polozio.
     */
    private javax.swing.JLabel lblPoeniZaProlaz;
    /**
     * Labela koja prikazuje da li je korisnik tacno odgovorio na trenutno pitanje ili ne.
     */
    private javax.swing.JLabel lblStatus;
    /**
     * Labela koja prikazuje tekst trenutnog pitanja.
     */
    private javax.swing.JLabel lblTekstPitanja;
    /**
     * Labela koja prikazuje koliko poena vredi trenutno pitanje.
     */
    private javax.swing.JLabel lblVrednostPitanja;
    /**
     * Separator koji odvaja status bar od teksta pitanja.
     */
    private javax.swing.JSeparator separator1;
    /**
     * Separator koji odvaja tekst pitanja od liste ponudjenih odgovora.
     */
    private javax.swing.JSeparator separator2;
    // End of variables declaration//GEN-END:variables

    /**
     * Prikazuje sledece pitanje iz liste pitanja u testu znanja.
     * Dinamicki kreira i prikazuje objekte tipa JCheckBox u zavisnosti od broja ponudjenih odgovora u pitanju.
     * Ako je odgovoreno na sva pitanja, prelazi se na odredjivanje rezultata.
     */
    private void nextPitanje() {
        if (pitanjeCounter < testZnanja.getListaPitanja().size()) {
            if (!odgovori.isEmpty()) {
                for (Map.Entry<Odgovor, JCheckBox> set : odgovori.entrySet()) 
                    this.remove(set.getValue());
                odgovori.clear();
                this.repaint();
            }
            lblStatus.setText("");
            Pitanje p = testZnanja.getListaPitanja().get(pitanjeCounter);
            lblBrojPitanja.setText(String.valueOf(pitanjeCounter));
            lblVrednostPitanja.setText(String.valueOf(p.getPoeni()));
            lblTekstPitanja.setText(p.getTekst());
            int odgovorCounter = 0;
            for (Odgovor o : p.getListaOdgovora()) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setText(o.getTekst());
                checkBox.setBounds(10, 220 + odgovorCounter * 40, 790, 30);
                checkBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
                checkBox.setVisible(true);
                odgovori.put(o, checkBox);
                this.add(odgovori.get(o));
                odgovorCounter++;
            }
            btnSledecePitanje.setEnabled(false);
            btnProveri.setEnabled(true);
            this.repaint();
        }
        else odrediRezultat();
    }

    /**
     * Otvara dialog koji korisniku prikazuje rezultat koji je ostvario na testu znanja i cuva ga u bazu podataka.
     */
    private void odrediRezultat() {
        JDialog dialog = new JDialog(this, true);
        dialog.add(new AddRezultatPanel(mainFrame, this, dialog, testZnanja, korisnik, ukupnoPoena, maxPoena));
        dialog.setTitle("Rezultat");
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }

    /**
     * Postavlja font komponenti.
     */
    private void setFont() {
        btnProveri.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnSledecePitanje.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblBrojPitanja.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblPoeni.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblTekstPitanja.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblVrednostPitanja.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblHVrednostPitanja.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblHBrojPitanja.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblHPoeni.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblHPoeniZaProlaz.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblPoeniZaProlaz.setFont(new Font("Tahoma", Font.PLAIN, 11));
    }

    /**
     * Vrsi pripremu pocetnog stanja komponenti nakon njihove inicijalizacije.
     */
    private void prepareView() {
        this.odgovori = new HashMap<>();
        this.setResizable(false);
        this.setTitle("Test: " + testZnanja.getNaziv());
        mainFrame.setVisible(false);
        setFont();
        lblPoeniZaProlaz.setText(String.valueOf(testZnanja.getPoeniZaProlaz()));
        lblStatus.setText("");
        for (Pitanje p : testZnanja.getListaPitanja()) maxPoena = (int) (maxPoena + p.getPoeni());
        lblPoeni.setText(String.valueOf(ukupnoPoena + "/" + maxPoena));
        nextPitanje();
    }
}
