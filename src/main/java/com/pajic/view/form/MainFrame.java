/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.client.Client;
import com.pajic.model.Administrator;
import com.pajic.model.GenericUser;
import com.pajic.model.Korisnik;
import com.pajic.model.Urednik;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 * Predstavlja glavnu klijentsku formu.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Instanca klase Client za komunikaciju sa serverom.
     */
    private final Client client;
    /**
     * Panel forme za login.
     */
    private LoginPanel loginPanel;
    /**
     * Panel korisnickog menija.
     */
    private MenuPanel menuPanel;
    /**
     * Trenutno ulogovani genericki korisnik.
     */
    private GenericUser currentUser;

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja.
     *
     * @throws IOException - Ukoliko dodje do greske prilikom komunikacije sa serverom.
     */
    public MainFrame() throws IOException {
        client = new Client();
        initComponents();
        this.setTitle("TesterZnanja");
        menuBar.setVisible(false);
        menuUrednici.setVisible(false);
        menuTestoviUrednik.setVisible(false);
        menuTestoviKorisnik.setVisible(false);
        client.connect();
        login();
    }

    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        menuUrednici = new javax.swing.JMenu();
        itemAddUrednik = new javax.swing.JMenuItem();
        itemManageUrednici = new javax.swing.JMenuItem();
        menuTestoviUrednik = new javax.swing.JMenu();
        itemAddTestZnanja = new javax.swing.JMenuItem();
        itemManageTestoviZnanja = new javax.swing.JMenuItem();
        menuTestoviKorisnik = new javax.swing.JMenu();
        itemPokreniTestZnanja = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuUrednici.setText("Urednici");

        itemAddUrednik.setText("Dodaj urednika");
        itemAddUrednik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddUrednikActionPerformed(evt);
            }
        });
        menuUrednici.add(itemAddUrednik);

        itemManageUrednici.setText("Upravljaj urednicima...");
        itemManageUrednici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManageUredniciActionPerformed(evt);
            }
        });
        menuUrednici.add(itemManageUrednici);

        menuBar.add(menuUrednici);

        menuTestoviUrednik.setText("Testovi znanja");

        itemAddTestZnanja.setText("Kreiraj test znanja");
        itemAddTestZnanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddTestZnanjaActionPerformed(evt);
            }
        });
        menuTestoviUrednik.add(itemAddTestZnanja);

        itemManageTestoviZnanja.setText("Upravljaj testovima znanja...");
        itemManageTestoviZnanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManageTestoviZnanjaActionPerformed(evt);
            }
        });
        menuTestoviUrednik.add(itemManageTestoviZnanja);

        menuBar.add(menuTestoviUrednik);

        menuTestoviKorisnik.setText("Testovi znanja");

        itemPokreniTestZnanja.setText("Pokreni test znanja");
        itemPokreniTestZnanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPokreniTestZnanjaActionPerformed(evt);
            }
        });
        menuTestoviKorisnik.add(itemPokreniTestZnanja);

        menuBar.add(menuTestoviKorisnik);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Prikazuje dialog za upravljanje urednicima.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void itemManageUredniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManageUredniciActionPerformed
        JDialog dialog = new JDialog(this, true);
        try {
            dialog.add(new UredniciManagementPanel(this, dialog, currentUser));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_itemManageUredniciActionPerformed

    /**
     * Prikazuje dialog za dodavanje novog urednika.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void itemAddUrednikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddUrednikActionPerformed
        JDialog dialog = new JDialog(this, true);
        dialog.add(new AddUrednikPanel(this, dialog, currentUser));
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_itemAddUrednikActionPerformed

    /**
     * Prikazuje dialog za dodavanje novog testa znanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void itemAddTestZnanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddTestZnanjaActionPerformed
        JDialog dialog = new JDialog(this, true);
        dialog.add(new AddTestZnanjaPanel(this, dialog));
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_itemAddTestZnanjaActionPerformed

    /**
     * Prikazuje dialog za upravljanje testovima znanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void itemManageTestoviZnanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManageTestoviZnanjaActionPerformed
        JDialog dialog = new JDialog(this, true);
        try {
            dialog.add(new TestoviZnanjaManagementPanel(this, dialog));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_itemManageTestoviZnanjaActionPerformed

    /**
     * Prikazuje dialog za pokretanje testa znanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void itemPokreniTestZnanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPokreniTestZnanjaActionPerformed
        JDialog dialog = new JDialog(this, true);
        try {
            dialog.add(new TestZnanjaSelectionPanel(this, dialog, currentUser));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_itemPokreniTestZnanjaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Stavka menija koja otvara formu za dodavanje novog testa znanja.
     */
    private javax.swing.JMenuItem itemAddTestZnanja;
    /**
     * Stavka menija koja otvara formu za dodavanje novog urednika.
     */
    private javax.swing.JMenuItem itemAddUrednik;
    /**
     * Stavka menija koja otvara formu za upravljanje testovima znanja.
     */
    private javax.swing.JMenuItem itemManageTestoviZnanja;
    /**
     * Stavka menija koja otvara formu za upravljanje urednicima.
     */
    private javax.swing.JMenuItem itemManageUrednici;
    /**
     * Stavka menija koja otvara formu za rad testova znanja.
     */
    private javax.swing.JMenuItem itemPokreniTestZnanja;
    /**
     * Glavni meni.
     */
    private javax.swing.JMenuBar menuBar;
    /**
     * Podmeni glavnog menija koji sadrzi opcije vezane za testove znanja dostupne korisnicima.
     */
    private javax.swing.JMenu menuTestoviKorisnik;
    /**
     * Podmeni glavnog menija koji sadrzi opcije vezane za testove znanja dostupne urednicima.
     */
    private javax.swing.JMenu menuTestoviUrednik;
    /**
     * Podmeni glavnog menija koji sadrzi opcije vezane za urednike dostupne administratorima.
     */
    private javax.swing.JMenu menuUrednici;
    // End of variables declaration//GEN-END:variables

    /**
     * Kreira formu za prijavu korisnika u sistem i prikazuje je u glavnoj klijentskoj formi.
     */
    private void login() {
        loginPanel = new LoginPanel(this);
        setLayout(new BorderLayout());
        add(loginPanel, BorderLayout.CENTER);
        pack();
        loginPanel.setVisible(true);
        validate();
        repaint();
    }

    /**
     * Odjavljuje trenutno ulogovanog korisnika sa sistema i ponovno prikazuje formu za prijavu korisnika.
     */
    public void logout() {
        menuPanel.setVisible(false);
        loginPanel.setVisible(true);
        if (menuUrednici.isVisible()) menuUrednici.setVisible(false);
        if (menuTestoviUrednik.isVisible()) menuTestoviUrednik.setVisible(false);
        if (menuTestoviKorisnik.isVisible()) menuTestoviKorisnik.setVisible(false);
    }

    /**
     * Kreira korisnicki meni i odredjuje tip menija koji ce biti prikazan u glavnoj klijentskoj formi u zavisnosti od tipa korisnika.
     * @param user - Trenutno ulogovani genericki korisnik.
     */
    public void determineUserType(GenericUser user) {
        menuPanel = new MenuPanel(this);
        loginPanel.setVisible(false);
        if (user instanceof Administrator administrator) loadAdministratorMenu(administrator);
        if (user instanceof Urednik urednik) loadUrednikMenu(urednik);
        if (user instanceof Korisnik korisnik) loadKorisnikMenu(korisnik);
    }

    /**
     * Priprema meni za administratora.
     * @param administrator - Trenutno ulogovani administrator.
     */
    private void loadAdministratorMenu(Administrator administrator) {
        currentUser = administrator;
        menuPanel.getLblUserType().setText("Administrator");
        menuPanel.getLblUserName().setText(administrator.getIme() + " " + administrator.getPrezime());
        menuUrednici.setVisible(true);
        presentMenu();
    }

    /**
     * Priprema meni za urednika.
     * @param urednik - Trenutno ulogovani urednik.
     */
    private void loadUrednikMenu(Urednik urednik) {
        currentUser = urednik;
        menuPanel.getLblUserType().setText("Urednik");
        menuPanel.getLblUserName().setText(urednik.getIme() + " " +  urednik.getPrezime());
        menuTestoviUrednik.setVisible(true);
        presentMenu();
    }

    /**
     * Priprema meni za korisnika.
     * @param korisnik - Trenutno ulogovani korisnik.
     */
    private void loadKorisnikMenu(Korisnik korisnik) {
        currentUser = korisnik;
        menuPanel.getLblUserType().setText("Korisnik");
        menuPanel.getLblUserName().setText(korisnik.getIme() + " " +  korisnik.getPrezime());
        menuTestoviKorisnik.setVisible(true);
        presentMenu();
    }

    /**
     * Prikazuje meni pripremljen za odgovarajuceg tipa korisnika.
     */
    private void presentMenu() {
        add(menuPanel, BorderLayout.CENTER);
        menuPanel.setVisible(true);
        menuBar.setVisible(true);
        pack();
        validate();
        repaint();
    }

    /**
     * Vraca Client instancu.
     * @return client - Client instanca.
     */
    public Client getClient() {
        return client;
    }
}
