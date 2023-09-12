/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.communication.Operation;
import com.pajic.communication.Request;
import com.pajic.communication.Response;
import com.pajic.crypto.BCryptManager;
import com.pajic.model.Korisnik;
import com.pajic.validation.DateChooserVerifier;
import com.pajic.validation.LetterOnlyFieldVerifier;
import com.pajic.validation.TextFieldVerifier;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author pajic
 */
public class AddKorisnikPanel extends javax.swing.JPanel {
    
    private final MainFrame mainFrame;
    private final JDialog dialog;

    /**
     * Creates new form AddKorisnikPanel
     * @param mainFrame
     * @param dialog
     */
    public AddKorisnikPanel(MainFrame mainFrame, JDialog dialog) {
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        initComponents();
        btnCreateAccount.setEnabled(false);
        fieldDate.setDate(new Date());
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

        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        txtPasswordConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordConfirmKeyReleased(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Lozinka");

        jLabel3.setText("Potvrdi lozinku");

        btnCreateAccount.setText("Kreiraj korisnicki nalog");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        jLabel4.setText("Ime");

        jLabel5.setText("Prezime");

        jLabel6.setText("Datum rodjenja");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCreateAccount))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDate, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(txtPasswordConfirm)
                            .addComponent(txtUsername)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateAccount)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        verify();
    }//GEN-LAST:event_txtUsernameKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        verify();
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtPasswordConfirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordConfirmKeyReleased
        verify();
    }//GEN-LAST:event_txtPasswordConfirmKeyReleased

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        if (txtPassword.getText().equals(txtPasswordConfirm.getText())) {
            Korisnik korisnik = new Korisnik();
            korisnik.setIme(txtIme.getText());
            korisnik.setPrezime(txtPrezime.getText());
            korisnik.setUsername(txtUsername.getText());
            korisnik.setPassword(BCryptManager.passwordToHash(txtPassword.getText()));
            korisnik.setDatumRodjenja((fieldDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
            Request request = new Request();
            request.setData(korisnik);
            request.setOperation(Operation.ADD_KORISNIK);
            try {
                mainFrame.getClient().sendRequest(request);
                Response response = mainFrame.getClient().receiveResponse();
                if (response.getException() == null) JOptionPane.showMessageDialog(this, "Korisnicki nalog je kreiran. Mozete se ulogovati.");
                else JOptionPane.showMessageDialog(this, "Korisnik nije dodat\n" + response.getException().getMessage());
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
            dialog.dispose();
        }
        else JOptionPane.showMessageDialog(this, "Lozinke nisu iste");
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void txtImeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeKeyReleased
        verify();
    }//GEN-LAST:event_txtImeKeyReleased

    private void txtPrezimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrezimeKeyReleased
        verify();
    }//GEN-LAST:event_txtPrezimeKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private com.toedter.calendar.JDateChooser fieldDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtIme;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirm;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void setVerifiers() {
        txtIme.setInputVerifier(new LetterOnlyFieldVerifier(20, false));
        txtPrezime.setInputVerifier(new LetterOnlyFieldVerifier(20, false));
        txtUsername.setInputVerifier(new TextFieldVerifier(20, false));
        txtPassword.setInputVerifier(new TextFieldVerifier(20, false));
        txtPasswordConfirm.setInputVerifier(new TextFieldVerifier(20, false));
        fieldDate.setInputVerifier(new DateChooserVerifier());
    }

    private void verify() {
        if(txtIme.getInputVerifier().verify(txtIme) && txtPrezime.getInputVerifier().verify(txtPrezime)
                && txtUsername.getInputVerifier().verify(txtUsername) && txtPassword.getInputVerifier().verify(txtPassword) && txtPasswordConfirm.getInputVerifier().verify(txtPasswordConfirm))
            btnCreateAccount.setEnabled(true);
        else btnCreateAccount.setEnabled(false);
    }
}
