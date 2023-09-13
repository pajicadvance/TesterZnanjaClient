/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.validation.TextFieldVerifier;
import com.pajic.view.component.TableModelOdgovori;

import javax.swing.JDialog;

/**
 * Predstavlja formu koja je namenjena za dodavanje novog odgovora u pitanje.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class AddOdgovorPanel extends javax.swing.JPanel {

    /**
     * Referenca ka dialogu u kome se nalazi ovaj panel.
     */
    private final JDialog dialog;
    /**
     * Referenca ka table modelu za odgovore.
     */
    private final TableModelOdgovori tmo;

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     *
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     * @param tmo - Prosledjeni table model za odgovore.
     */
    public AddOdgovorPanel(JDialog dialog, TableModelOdgovori tmo) {
        this.dialog = dialog;
        this.tmo = tmo;
        initComponents();
        prepareView();
        setVerifiers();
    }

    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTekst = new javax.swing.JScrollPane();
        txtTekst = new javax.swing.JTextArea();
        checkBoxTacan = new javax.swing.JCheckBox();
        btnSacuvaj = new javax.swing.JButton();
        lblTekst = new javax.swing.JLabel();

        txtTekst.setColumns(20);
        txtTekst.setRows(5);
        txtTekst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTekstKeyReleased(evt);
            }
        });
        scrollPaneTekst.setViewportView(txtTekst);

        checkBoxTacan.setText("Tacan");

        btnSacuvaj.setText("Sacuvaj odgovor");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblTekst.setText("Tekst:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTekst, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBoxTacan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTekst)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTekst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTekst, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxTacan)
                    .addComponent(btnSacuvaj))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtTekstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTekstKeyReleased
        verify();
    }//GEN-LAST:event_txtTekstKeyReleased

    /**
     * Konstruise novi odgovor koriscenjem podataka unetih u formu i dodaje ga u table model za odgovore.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        tmo.addOdgovor(txtTekst.getText(), checkBoxTacan.isSelected());
        dialog.dispose();
    }//GEN-LAST:event_btnSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme za dodavanje odgovora u pitanje.
     */
    private javax.swing.JButton btnSacuvaj;
    /**
     * Checkbox za odredjivanje atributa odgovora tacan.
     */
    private javax.swing.JCheckBox checkBoxTacan;
    /**
     * Labela koja se odnosi na polje za unos teksta odgovora.
     */
    private javax.swing.JLabel lblTekst;
    /**
     * Scroll pane u kome se nalazi polje za unos teksta odgovora.
     */
    private javax.swing.JScrollPane scrollPaneTekst;
    /**
     * Polje za unos teksta odgovora.
     */
    private javax.swing.JTextArea txtTekst;
    // End of variables declaration//GEN-END:variables

    /**
     * Vrsi pripremu pocetnog stanja komponenti nakon njihove inicijalizacije.
     */
    private void prepareView() {
        dialog.setTitle("Odgovor");
        btnSacuvaj.setEnabled(false);
    }

    /**
     * Postavlja odgovarajuce verifikatore na komponente u formi.
     */
    private void setVerifiers() {
        txtTekst.setInputVerifier(new TextFieldVerifier(1024, false));
    }

    /**
     * Vrsi validaciju svih komponenti.
     */
    private void verify() {
        if (txtTekst.getInputVerifier().verify(txtTekst))
            btnSacuvaj.setEnabled(true);
        else btnSacuvaj.setEnabled(false);
    }

}
