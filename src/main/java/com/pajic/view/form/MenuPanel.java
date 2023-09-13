/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import javax.swing.JLabel;

/**
 * Predstavlja formu glavnog menija u okviru aplikacije.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Referenca ka MainFrame instanci.
     */
    private final MainFrame mainFrame;

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja.
     * @param mainFrame- JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     */
    public MenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUlogovanKao = new javax.swing.JLabel();
        lblImePrezime = new javax.swing.JLabel();
        lblUserType = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        lblUlogovanKao.setText("Ulogovan kao:");

        lblImePrezime.setText("Ime i prezime:");

        lblUserType.setText("jLabel3");

        lblUserName.setText("jLabel4");

        btnLogout.setText("Odjava");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUlogovanKao)
                    .addComponent(lblImePrezime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName)
                    .addComponent(lblUserType))
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUlogovanKao)
                    .addComponent(lblUserType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImePrezime)
                    .addComponent(lblUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Odjavljuje trenutno ulogovanog korisnika sa sistema.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        mainFrame.logout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme za odjavu korisnika.
     */
    private javax.swing.JButton btnLogout;
    /**
     * Labela koja se odnosi na labelu koja prikazuje ime i prezime trenutno ulogovanog korisnika.
     */
    private javax.swing.JLabel lblImePrezime;
    /**
     * Labela koja se odnosi na labelu koja prikazuje tip trenutno ulogovanog korisnika.
     */
    private javax.swing.JLabel lblUlogovanKao;
    /**
     * Labela koja prikazuje ime i prezime trenutno ulogovanog korisnika.
     */
    private javax.swing.JLabel lblUserName;
    /**
     * Labela koja prikazuje tip trenutno ulogovanog korisnika.
     */
    private javax.swing.JLabel lblUserType;
    // End of variables declaration//GEN-END:variables

    /**
     * Vraca JLabel koriscen za prikaz korisnickog imena.
     * @return lblUserName - JLabel koriscen za prikaz korisnickog imena.
     */
    public JLabel getLblUserName() {
        return lblUserName;
    }

    /**
     * Vraca JLabel koriscen za prikaz tipa korisnika.
     * @return lblUserName - JLabel koriscen za prikaz tipa korisnika.
     */
    public JLabel getLblUserType() {
        return lblUserType;
    }

}
