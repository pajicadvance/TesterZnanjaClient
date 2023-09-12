/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.communication.Operation;
import com.pajic.communication.Request;
import com.pajic.communication.Response;
import com.pajic.model.Administrator;
import com.pajic.model.GenericUser;
import com.pajic.model.Urednik;
import com.pajic.validation.LetterOnlyFieldVerifier;
import com.pajic.validation.TextFieldVerifier;
import com.pajic.view.component.TableModelUrednici;

import java.io.IOException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Pavle
 */
public class SearchUrednikPanel extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final JDialog dialog;
    private final Administrator currentUser;
    private final TableModelUrednici tmu;
    /**
     * Creates new form SearchUrednikPanel
     * @param mainFrame
     * @param dialog
     * @param currentUser
     * @param tmu
     */
    public SearchUrednikPanel(MainFrame mainFrame, JDialog dialog, GenericUser currentUser, TableModelUrednici tmu) {
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        this.currentUser = (Administrator) currentUser;
        this.tmu = tmu;
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        fieldYear = new com.toedter.calendar.JYearChooser();
        checkBoxYearEnabled = new javax.swing.JCheckBox();

        jLabel1.setText("Pretraga po:");

        jLabel2.setText("Imenu");

        jLabel3.setText("Prezimenu");

        jLabel4.setText("Godini rodjenja");

        jLabel5.setText("Korisnickom imenu");

        txtIme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImeKeyReleased(evt);
            }
        });

        txtPrezime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrezimeKeyReleased(evt);
            }
        });

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPretrazi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxYearEnabled))
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxYearEnabled))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPretrazi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        String searchParameter = " WHERE administrator_id=" + currentUser.getId();
        if (!txtIme.getText().isBlank()) searchParameter = searchParameter.concat(" AND ime LIKE '%" + txtIme.getText() + "%'");
        if (!txtPrezime.getText().isBlank()) searchParameter = searchParameter.concat(" AND prezime LIKE '%" + txtPrezime.getText() + "%'");
        if (!txtUsername.getText().isBlank()) searchParameter = searchParameter.concat(" AND username LIKE '%" + txtUsername.getText() + "%'");
        if (checkBoxYearEnabled.isSelected()) searchParameter = searchParameter.concat(" AND YEAR(datum_rodjenja)=" + fieldYear.getYear());
        System.out.println(searchParameter);
        Request request = new Request();
        request.setData(searchParameter);
        request.setOperation(Operation.FIND_UREDNIK);
        try {
            mainFrame.getClient().sendRequest(request);
            Response response = mainFrame.getClient().receiveResponse();
            if (response.getException() != null) JOptionPane.showMessageDialog(mainFrame, "Greska\n" + response.getException().getMessage());
            else if (response.getData() != null) {
                List<Urednik> urednici = (List<Urednik>) response.getData();
                if (urednici.isEmpty())
                    JOptionPane.showMessageDialog(mainFrame, "Nije pronadjen nijedan urednik.");
                else {
                    JOptionPane.showMessageDialog(mainFrame, "Pretraga je uspesno izvrsena.");
                    tmu.setUrednikList(urednici);
                    tmu.fireTableDataChanged();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        dialog.dispose();
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void txtImeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeKeyReleased
        verify();
    }//GEN-LAST:event_txtImeKeyReleased

    private void txtPrezimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrezimeKeyReleased
        verify();
    }//GEN-LAST:event_txtPrezimeKeyReleased

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        verify();
    }//GEN-LAST:event_txtUsernameKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JCheckBox checkBoxYearEnabled;
    private com.toedter.calendar.JYearChooser fieldYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void setVerifiers() {
        txtIme.setInputVerifier(new LetterOnlyFieldVerifier(20, true));
        txtPrezime.setInputVerifier(new LetterOnlyFieldVerifier(20, true));
        txtUsername.setInputVerifier(new TextFieldVerifier(20, true));
    }
    
    private void verify() {
        if (txtIme.getInputVerifier().verify(txtIme) && txtPrezime.getInputVerifier().verify(txtPrezime) 
                && txtUsername.getInputVerifier().verify(txtUsername))
            btnPretrazi.setEnabled(true);
        else btnPretrazi.setEnabled(false);
    }
}
