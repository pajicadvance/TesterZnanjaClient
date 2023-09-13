/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.model.Pitanje;
import com.pajic.validation.DigitOnlyFieldVerifier;
import com.pajic.validation.TextFieldVerifier;
import com.pajic.view.component.TableModelOdgovori;
import com.pajic.view.component.TableModelPitanja;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Predstavlja formu koja je namenjena za dodavanje novog pitanja u test znanja.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class AddPitanjePanel extends javax.swing.JPanel {

    /**
     * Referenca ka dialogu u kome se nalazi ovaj panel.
     */
    private final JDialog dialog;
    /**
     * Referenca ka table modelu za pitanja.
     */
    private final TableModelPitanja tmp;
    /**
     * Referenca ka table modelu za odgovore.
     */
    private TableModelOdgovori tmo;
    /**
     * Pitanje koje se priprema za dodavanje u test znanja.
     */
    private Pitanje pitanje;

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     *
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     * @param tmp - Prosledjeni table model za pitanja.
     */
    public AddPitanjePanel(JDialog dialog, TableModelPitanja tmp) {
        this.dialog = dialog;
        this.tmp = tmp;
        initComponents();
        prepareView();
        setVerifiers();
    }

    /**
     * Kreira graficke komponente i postavlja i podesava njihov izgled, poziciju i ponasanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTekst = new javax.swing.JLabel();
        lblPoeni = new javax.swing.JLabel();
        txtPoeni = new javax.swing.JTextField();
        scrollPaneTableOdgovori = new javax.swing.JScrollPane();
        tableOdgovori = new javax.swing.JTable();
        btnAddOdgovor = new javax.swing.JButton();
        btnDeleteOdgovor = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        scrollPaneTekst = new javax.swing.JScrollPane();
        txtTekst = new javax.swing.JTextArea();
        lblOdgovori = new javax.swing.JLabel();

        lblTekst.setText("Tekst");

        lblPoeni.setText("Poeni");

        txtPoeni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPoeniKeyReleased(evt);
            }
        });

        tableOdgovori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneTableOdgovori.setViewportView(tableOdgovori);

        btnAddOdgovor.setText("Dodaj odgovor");
        btnAddOdgovor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOdgovorActionPerformed(evt);
            }
        });

        btnDeleteOdgovor.setText("Obrisi izabrani odgovor");
        btnDeleteOdgovor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOdgovorActionPerformed(evt);
            }
        });

        btnSave.setText("Sacuvaj pitanje");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtTekst.setColumns(20);
        txtTekst.setRows(5);
        scrollPaneTekst.setViewportView(txtTekst);

        lblOdgovori.setText("Odgovori");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTekst)
                            .addComponent(scrollPaneTableOdgovori)
                            .addComponent(scrollPaneTekst))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeleteOdgovor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(btnAddOdgovor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPoeni)
                            .addComponent(txtPoeni)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOdgovori)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTekst)
                    .addComponent(lblPoeni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTekst, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPoeni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOdgovori)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddOdgovor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteOdgovor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addComponent(scrollPaneTableOdgovori, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Otvara novi dialog za dodavanje odgovora u pitanje i prosledjuje mu table model za odgovore.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnAddOdgovorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOdgovorActionPerformed
        JDialog dialog2 = new JDialog(dialog, true);
        dialog2.add(new AddOdgovorPanel(dialog2, tmo));
        dialog2.setLocationRelativeTo(null);
        dialog2.pack();
        dialog2.setVisible(true);
    }//GEN-LAST:event_btnAddOdgovorActionPerformed

    /**
     * Konstruise pitanje koriscenjem podataka unetih u formu i dodaje ga u table model za pitanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        pitanje.setTekst(txtTekst.getText());
        pitanje.setPoeni(Integer.parseInt(txtPoeni.getText()));
        pitanje.setListaOdgovora(tmo.getOdgovorList());
        tmp.addPitanje(txtTekst.getText(), Double.parseDouble(txtPoeni.getText()), tmo.getOdgovorList());
        dialog.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtPoeniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPoeniKeyReleased
        verify();
    }//GEN-LAST:event_txtPoeniKeyReleased

    /**
     * Brise trenutno selektovan odgovor u tabeli odgovora iz tabele.
     * Takodje brise isti odgovor iz pitanja kome pripada iz tabele pitanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnDeleteOdgovorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOdgovorActionPerformed
        int selectedRow = tableOdgovori.getSelectedRow();
        if (selectedRow >= 0) {
            tmo.removeOdgovor(selectedRow);
            if (tmp.getPitanjeList().contains(pitanje)) {
                tmp.removeOdgovorFromPitanje(selectedRow, pitanje);
            }
        }
        else JOptionPane.showMessageDialog(this, "Odgovor nije izabran");
    }//GEN-LAST:event_btnDeleteOdgovorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme za otvaranje forme za dodavanje novog odgovora u pitanje.
     */
    private javax.swing.JButton btnAddOdgovor;
    /**
     * Dugme za brisanje izabranog odgovora iz tabele odgovora.
     */
    private javax.swing.JButton btnDeleteOdgovor;
    /**
     * Dugme za dodavanje pitanja u test znanja.
     */
    private javax.swing.JButton btnSave;
    /**
     * Labela koja se odnosi na tabelu odgovora.
     */
    private javax.swing.JLabel lblOdgovori;
    /**
     * Labela koja se odnosi na polje za unos poena koje pitanje nosi.
     */
    private javax.swing.JLabel lblPoeni;
    /**
     * Labela koja se odnosi na polje za unos teksta pitanja.
     */
    private javax.swing.JLabel lblTekst;
    /**
     * Scroll pane u kome se nalazi tabela odgovora.
     */
    private javax.swing.JScrollPane scrollPaneTableOdgovori;
    /**
     * Scroll pane u kome se nalazi polje za unos teksta pitanja.
     */
    private javax.swing.JScrollPane scrollPaneTekst;
    /**
     * Tabela odgovora.
     */
    private javax.swing.JTable tableOdgovori;
    /**
     * Polje za unos poena koje pitanje nosi.
     */
    private javax.swing.JTextField txtPoeni;
    /**
     * Polje za unos teksta pitanja.
     */
    private javax.swing.JTextArea txtTekst;
    // End of variables declaration//GEN-END:variables

    /**
     * Vrsi pripremu pocetnog stanja komponenti nakon njihove inicijalizacije.
     */
    private void prepareView() {
        dialog.setTitle("Pitanje");
        pitanje = new Pitanje();
        tmo = new TableModelOdgovori();
        tableOdgovori.setModel(tmo);
        btnSave.setEnabled(false);
        txtTekst.requestFocusInWindow();
    }

    /**
     * Postavlja odgovarajuce verifikatore na komponente u formi.
     */
    private void setVerifiers() {
        txtPoeni.setInputVerifier(new DigitOnlyFieldVerifier(2, false, 99));
        txtTekst.setInputVerifier(new TextFieldVerifier(1024, false));
    }

    /**
     * Vrsi validaciju svih komponenti.
     */
    private void verify() {
        if (txtTekst.getInputVerifier().verify(txtTekst) && txtPoeni.getInputVerifier().verify(txtPoeni))
            btnSave.setEnabled(true);
        else btnSave.setEnabled(false);
    }
}
