/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.communication.Operation;
import com.pajic.communication.Request;
import com.pajic.communication.Response;
import com.pajic.model.TestZnanja;
import com.pajic.model.TipTestaZnanja;
import com.pajic.validation.DigitOnlyFieldVerifier;
import com.pajic.validation.TextFieldVerifier;
import com.pajic.view.component.TableModelPitanja;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Pavle
 */
public class AddTestZnanjaPanel extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final JDialog dialog;
    private TestZnanja tz;
    private TableModelPitanja tmp;
    
    /**
     * Creates new form CreateTestZnanjaPanel
     * @param mainFrame
     * @param dialog
     */
    public AddTestZnanjaPanel(MainFrame mainFrame, JDialog dialog) {
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        initComponents();
        prepareView();
        setVerifiers();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPoeniZaProlaz = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePitanja = new javax.swing.JTable();
        btnAddPitanje = new javax.swing.JButton();
        btnDeletePitanje = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TipComboBox = new javax.swing.JComboBox<>();

        jLabel1.setText("Naziv");

        jLabel2.setText("Poeni za prolaz");

        txtPoeniZaProlaz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPoeniZaProlazKeyReleased(evt);
            }
        });

        txtNaziv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNazivKeyReleased(evt);
            }
        });

        tablePitanja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePitanja);

        btnAddPitanje.setText("Dodaj pitanje");
        btnAddPitanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPitanjeActionPerformed(evt);
            }
        });

        btnDeletePitanje.setText("Obrisi izabrano pitanje");
        btnDeletePitanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePitanjeActionPerformed(evt);
            }
        });

        btnSave.setText("Sacuvaj test znanja");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Pitanja");

        jLabel4.setText("Tip");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNaziv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TipComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeletePitanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPoeniZaProlaz, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAddPitanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtPoeniZaProlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TipComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddPitanje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletePitanje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNazivKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNazivKeyReleased
        verify();
    }//GEN-LAST:event_txtNazivKeyReleased

    private void txtPoeniZaProlazKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPoeniZaProlazKeyReleased
        verify();
    }//GEN-LAST:event_txtPoeniZaProlazKeyReleased

    private void btnAddPitanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPitanjeActionPerformed
        JDialog dialog2 = new JDialog(dialog, true);
        dialog2.add(new AddPitanjePanel(dialog2, tmp));
        dialog2.setLocationRelativeTo(null);
        dialog2.pack();
        dialog2.setVisible(true);
    }//GEN-LAST:event_btnAddPitanjeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        tz.setNaziv(txtNaziv.getText());
        tz.setPoeniZaProlaz(Integer.parseInt(txtPoeniZaProlaz.getText()));
        tz.setListaPitanja(tmp.getPitanjeList());
        tz.setTipTestaZnanja((TipTestaZnanja) TipComboBox.getSelectedItem());
        tmp.addTestZnanja(tz);
        Request request = new Request();
        request.setData(tz);
        request.setOperation(Operation.ADD_TEST_ZNANJA);
        try {
            mainFrame.getClient().sendRequest(request);
            Response response = mainFrame.getClient().receiveResponse();
            if (response.getException() == null) {
                JOptionPane.showMessageDialog(this, "Test znanja je dodat");
                dialog.dispose();
            }
            else JOptionPane.showMessageDialog(this, "Test znanja nije dodat\n" + response.getException().getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AddTestZnanjaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeletePitanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePitanjeActionPerformed
        int selectedRow = tablePitanja.getSelectedRow();
        if (selectedRow >= 0) tmp.removePitanje(selectedRow);
        else JOptionPane.showMessageDialog(this, "Pitanje nije izabrano");
    }//GEN-LAST:event_btnDeletePitanjeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<TipTestaZnanja> TipComboBox;
    private javax.swing.JButton btnAddPitanje;
    private javax.swing.JButton btnDeletePitanje;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePitanja;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPoeniZaProlaz;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        dialog.setTitle("Test znanja");
        tz = new TestZnanja();
        tmp = new TableModelPitanja();
        tablePitanja.setModel(tmp);
        btnSave.setEnabled(false);
        TipComboBox.addItem(new TipTestaZnanja(1, "Kviz"));
        TipComboBox.addItem(new TipTestaZnanja(2, "Test"));
        TipComboBox.addItem(new TipTestaZnanja(3, "Ispit"));
    }

    private void setVerifiers() {
        txtNaziv.setInputVerifier(new TextFieldVerifier(64, false));
        txtPoeniZaProlaz.setInputVerifier(new DigitOnlyFieldVerifier(3, false, 100));
    }

    private void verify() {
        if (txtNaziv.getInputVerifier().verify(txtNaziv) && txtPoeniZaProlaz.getInputVerifier().verify(txtPoeniZaProlaz)) {
            btnSave.setEnabled(true);
        }
        else btnSave.setEnabled(false);
    }
}
