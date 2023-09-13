/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.communication.Operation;
import com.pajic.communication.Request;
import com.pajic.communication.Response;
import com.pajic.model.Korisnik;
import com.pajic.model.Rezultat;
import com.pajic.model.TestZnanja;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Predstavlja formu koja je namenjena za prikaz rezultata i njegovog dodavanja u bazu podataka.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class AddRezultatPanel extends javax.swing.JPanel {

    /**
     * Test znanja vezan za rezultat.
     */
    private final TestZnanja testZnanja;
    /**
     * Korisnik koji je radio test.
     */
    private final Korisnik korisnik;
    /**
     * Referenca ka formi za rad testa znanja.
     */
    private final TestZnanjaFrame frame;
    /**
     * Referenca ka MainFrame instanci.
     */
    private final MainFrame mainFrame;
    /**
     * Referenca ka dialogu u kome se ovaj panel nalazi.
     */
    private final JDialog dialog;
    /**
     * Poeni koje je korisnik ostvario na testu.
     */
    private final int ukupnoPoena;
    /**
     * Maksimalan broj poena koji je moguce ostvariti na testu.
     */
    private final int maxPoena;
    /**
     * Da li je korisnik polozio test.
     */
    private boolean prosao;
    
    /**
     * Konstruktor koji vrsi pocetno kreiranje i konfigurisanje elemenata forme i inicijalizuje vrednosti.
     * @param mainFrame
     * @param frame
     * @param dialog
     * @param testZnanja
     * @param korisnik
     * @param ukupnoPoena
     * @param maxPoena
     */
    public AddRezultatPanel(MainFrame mainFrame, TestZnanjaFrame frame, JDialog dialog, TestZnanja testZnanja, Korisnik korisnik, int ukupnoPoena, int maxPoena) {
        this.mainFrame = mainFrame;
        this.testZnanja = testZnanja;
        this.korisnik = korisnik;
        this.frame = frame;
        this.dialog = dialog;
        this.ukupnoPoena = ukupnoPoena;
        this.maxPoena = maxPoena;
        initComponents();
        prepareView();
    }

    /**
     * Kreira graficke komponente i postavlja i podesava njihov izgled, poziciju i ponasanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRezultat = new javax.swing.JLabel();
        lblHKorisnik = new javax.swing.JLabel();
        lblKorisnik = new javax.swing.JLabel();
        lblHTest = new javax.swing.JLabel();
        lblTest = new javax.swing.JLabel();
        lblHPoeni = new javax.swing.JLabel();
        lblPoeni = new javax.swing.JLabel();
        btnZavrsi = new javax.swing.JButton();
        lblHProlaz = new javax.swing.JLabel();
        lblProlaz = new javax.swing.JLabel();

        lblRezultat.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblRezultat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRezultat.setText("jLabel1");

        lblHKorisnik.setText("Korisnik:");

        lblKorisnik.setText("jLabel2");

        lblHTest.setText("Test:");

        lblTest.setText("jLabel4");

        lblHPoeni.setText("Poeni:");

        lblPoeni.setText("jLabel6");

        btnZavrsi.setText("Zavrsi test");
        btnZavrsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZavrsiActionPerformed(evt);
            }
        });

        lblHProlaz.setText("Prolaz:");

        lblProlaz.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnZavrsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRezultat, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTest))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHKorisnik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblKorisnik))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHPoeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPoeni))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHProlaz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProlaz)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRezultat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHKorisnik)
                    .addComponent(lblKorisnik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHTest)
                    .addComponent(lblTest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHPoeni)
                    .addComponent(lblPoeni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHProlaz)
                    .addComponent(lblProlaz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnZavrsi)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Konstruise rezultat koristeci podatke iz forme i dodaje taj rezultat u bazu podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnZavrsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZavrsiActionPerformed
        Rezultat rezultat = new Rezultat();
        rezultat.setProsao(prosao);
        rezultat.setKorisnik(korisnik);
        rezultat.setBrojPoena(ukupnoPoena);
        rezultat.setTestZnanja(testZnanja);
        rezultat.setDatumRada(LocalDate.now());
        Request request = new Request();
        request.setData(rezultat);
        request.setOperation(Operation.ADD_REZULTAT);
        try {
            mainFrame.getClient().sendRequest(request);
            Response response = mainFrame.getClient().receiveResponse();
            if (response.getException() == null) JOptionPane.showMessageDialog(this, "Rezultat je uspesno dodat");
            else JOptionPane.showMessageDialog(this, "Rezultat nije dodat\n" + response.getException().getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AddRezultatPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialog.dispose();
        frame.dispose();
    }//GEN-LAST:event_btnZavrsiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme za zavrsetak testa i dodavanje rezultata u bazu podataka.
     */
    private javax.swing.JButton btnZavrsi;
    /**
     * Labela koja se odnosi na labelu koja prikazuje ime i prezime korisnika.
     */
    private javax.swing.JLabel lblHKorisnik;
    /**
     * Labela koja se odnosi na labelu koja prikazuje poene koje je korisnik ostvario na testu.
     */
    private javax.swing.JLabel lblHPoeni;
    /**
     * Labela koja se odnosi na labelu koja prikazuje koliko poena je bilo potrebno za prolaz na testu.
     */
    private javax.swing.JLabel lblHProlaz;
    /**
     * Labela koja se odnosi na labelu koja prikazuje naziv radjenog testa.
     */
    private javax.swing.JLabel lblHTest;
    /**
     * Labela koja prikazuje ime i prezime korisnika.
     */
    private javax.swing.JLabel lblKorisnik;
    /**
     * Labela koja prikazuje poene koje je korisnik ostvario na testu.
     */
    private javax.swing.JLabel lblPoeni;
    /**
     * Labela koja prikazuje koliko poena je bilo potrebno za prolaz na testu.
     */
    private javax.swing.JLabel lblProlaz;
    /**
     * Labela koja prikazuje da li je korisnik prosao ili pao test.
     */
    private javax.swing.JLabel lblRezultat;
    /**
     * Labela koja prikazuje naziv radjenog testa.
     */
    private javax.swing.JLabel lblTest;
    // End of variables declaration//GEN-END:variables

    /**
     * Vrsi pripremu pocetnog stanja komponenti nakon njihove inicijalizacije.
     */
    private void prepareView() {
        lblKorisnik.setText(korisnik.getIme() + " " + korisnik.getPrezime());
        lblPoeni.setText(String.valueOf(ukupnoPoena + "/" + maxPoena));
        lblProlaz.setText(String.valueOf(testZnanja.getPoeniZaProlaz()));
        lblTest.setText(testZnanja.getNaziv());
        if (ukupnoPoena >= testZnanja.getPoeniZaProlaz()) {
            lblRezultat.setText("PROSAO");
            prosao = true;
        }
        else {
            lblRezultat.setText("PAO");
            prosao = false;
        }
    }
}
