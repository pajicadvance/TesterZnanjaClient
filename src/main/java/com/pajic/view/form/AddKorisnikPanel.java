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
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Predstavlja formu koja je namenjena za dodavanje novog korisnika u bazu podataka.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class AddKorisnikPanel extends javax.swing.JPanel {

    /**
     * Referenca ka MainFrame instanci.
     */
    private final MainFrame mainFrame;
    /**
     * Referenca ka dialogu u kome se nalazi ovaj panel.
     */
    private final JDialog dialog;

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     *
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param dialog - Dialog u kome se nalazi ovaj panel.
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
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        lblUsername = new javax.swing.JLabel();
        lblLozinka = new javax.swing.JLabel();
        lblPotvrdiLozinku = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        lblIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        fieldDate = new com.toedter.calendar.JDateChooser();
        lblDatumRodjenja = new javax.swing.JLabel();
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

        lblUsername.setText("Username");

        lblLozinka.setText("Lozinka");

        lblPotvrdiLozinku.setText("Potvrdi lozinku");

        btnCreateAccount.setText("Kreiraj korisnicki nalog");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        lblIme.setText("Ime");

        lblPrezime.setText("Prezime");

        lblDatumRodjenja.setText("Datum rodjenja");

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
                            .addComponent(lblUsername)
                            .addComponent(lblPotvrdiLozinku)
                            .addComponent(lblLozinka)
                            .addComponent(lblIme)
                            .addComponent(lblPrezime)
                            .addComponent(lblDatumRodjenja))
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
                    .addComponent(lblIme)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLozinka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPotvrdiLozinku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatumRodjenja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateAccount)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        verify();
    }//GEN-LAST:event_txtUsernameKeyReleased

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        verify();
    }//GEN-LAST:event_txtPasswordKeyReleased

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtPasswordConfirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordConfirmKeyReleased
        verify();
    }//GEN-LAST:event_txtPasswordConfirmKeyReleased

    /**
     * Konstruise novog korisnika koriscenjem podataka unetih u formu i dodaje ga u bazu podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
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

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtImeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeKeyReleased
        verify();
    }//GEN-LAST:event_txtImeKeyReleased

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtPrezimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrezimeKeyReleased
        verify();
    }//GEN-LAST:event_txtPrezimeKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme za dodavanje korisnika u bazu podataka.
     */
    private javax.swing.JButton btnCreateAccount;
    /**
     * Polje za odabir datuma rodjenja.
     */
    private com.toedter.calendar.JDateChooser fieldDate;
    /**
     * Labela koja se odnosi na polje za odabir datuma rodjenja.
     */
    private javax.swing.JLabel lblDatumRodjenja;
    /**
     * Labela koja se odnosi na polje za unos imena.
     */
    private javax.swing.JLabel lblIme;
    /**
     * Labela koja se odnosi na polje za unos lozinke.
     */
    private javax.swing.JLabel lblLozinka;
    /**
     * Labela koja se odnosi na polje za potvrdu lozinke.
     */
    private javax.swing.JLabel lblPotvrdiLozinku;
    /**
     * Labela koja se odnosi na polje za unos prezimena.
     */
    private javax.swing.JLabel lblPrezime;
    /**
     * Labela koja se odnosi na polje za unos korisnickog imena.
     */
    private javax.swing.JLabel lblUsername;
    /**
     * Polje za unos imena.
     */
    private javax.swing.JTextField txtIme;
    /**
     * Polje za unos lozinke.
     */
    private javax.swing.JPasswordField txtPassword;
    /**
     * Polje za potvrdu lozinke.
     */
    private javax.swing.JPasswordField txtPasswordConfirm;
    /**
     * Polje za unos prezimena.
     */
    private javax.swing.JTextField txtPrezime;
    /**
     * Polje za unos korisnickog imena.
     */
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    /**
     * Postavlja odgovarajuce verifikatore na komponente u formi.
     */
    private void setVerifiers() {
        txtIme.setInputVerifier(new LetterOnlyFieldVerifier(20, false));
        txtPrezime.setInputVerifier(new LetterOnlyFieldVerifier(20, false));
        txtUsername.setInputVerifier(new TextFieldVerifier(20, false));
        txtPassword.setInputVerifier(new TextFieldVerifier(20, false));
        txtPasswordConfirm.setInputVerifier(new TextFieldVerifier(20, false));
        fieldDate.setInputVerifier(new DateChooserVerifier());
    }

    /**
     * Vrsi validaciju svih komponenti.
     */
    private void verify() {
        if(txtIme.getInputVerifier().verify(txtIme) && txtPrezime.getInputVerifier().verify(txtPrezime)
                && txtUsername.getInputVerifier().verify(txtUsername) && txtPassword.getInputVerifier().verify(txtPassword) && txtPasswordConfirm.getInputVerifier().verify(txtPasswordConfirm))
            btnCreateAccount.setEnabled(true);
        else btnCreateAccount.setEnabled(false);
    }
}
