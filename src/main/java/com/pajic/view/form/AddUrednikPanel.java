/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.communication.Operation;
import com.pajic.communication.Request;
import com.pajic.communication.Response;
import com.pajic.crypto.BCryptManager;
import com.pajic.model.Administrator;
import com.pajic.model.GenericUser;
import com.pajic.model.Urednik;
import com.pajic.validation.DateChooserVerifier;
import com.pajic.validation.LetterOnlyFieldVerifier;
import com.pajic.validation.TextFieldVerifier;
import com.pajic.view.component.TableModelUrednici;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Predstavlja formu koja je namenjena za dodavanje novog urednika u bazu podataka.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class AddUrednikPanel extends javax.swing.JPanel {

    /**
     * Referenca ka MainFrame instanci.
     */
    private final MainFrame mainFrame;
    /**
     * Referenca ka dialogu u kome se nalazi ovaj panel.
     */
    private final JDialog dialog;
    /**
     * Trenutno ulogovani administrator.
     */
    private final Administrator currentUser;
    /**
     * Table model za urednike.
     */
    private TableModelUrednici tmu = null;

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     *
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     * @param currentUser - Trenutno ulogovani korisnik (administrator).
     */
    public AddUrednikPanel(MainFrame mainFrame, JDialog dialog, GenericUser currentUser) {
        this.mainFrame = mainFrame;
        this.currentUser = (Administrator) currentUser;
        this.dialog = dialog;
        initComponents();
        btnSacuvaj.setEnabled(false);
        dateDatumRodjenja.setDate(new Date());
        setVerifiers();
    }

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     *
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     * @param currentUser - Trenutno ulogovani korisnik (administrator).
     * @param tmu - Table model za urednike.
     */
    public AddUrednikPanel(MainFrame mainFrame, JDialog dialog, GenericUser currentUser, TableModelUrednici tmu) {
        this.mainFrame = mainFrame;
        this.currentUser = (Administrator) currentUser;
        this.dialog = dialog;
        this.tmu = tmu;
        initComponents();
        btnSacuvaj.setEnabled(false);
        dateDatumRodjenja.setDate(new Date());
        setVerifiers();
    }

    /**
     * Kreira graficke komponente i postavlja i podesava njihov izgled, poziciju i ponasanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        lblDatumRodjenja = new javax.swing.JLabel();
        lblKorisnickoIme = new javax.swing.JLabel();
        lblLozinka = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        dateDatumRodjenja = new com.toedter.calendar.JDateChooser();
        txtUsername = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        lblIme.setText("Ime");

        lblPrezime.setText("Prezime");

        lblDatumRodjenja.setText("Datum rodjenja");

        lblKorisnickoIme.setText("Korisnicko ime");

        lblLozinka.setText("Lozinka");

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

        dateDatumRodjenja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateDatumRodjenjaKeyReleased(evt);
            }
        });

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj urednika");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 183, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIme)
                            .addComponent(lblPrezime))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrezime)
                            .addComponent(txtIme)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblKorisnickoIme)
                        .addGap(10, 10, 10)
                        .addComponent(txtUsername))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatumRodjenja)
                            .addComponent(lblLozinka))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateDatumRodjenja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword))))
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
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrezime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKorisnickoIme)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLozinka)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatumRodjenja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Konstruise novog urednika koriscenjem podataka unetih u formu i dodaje ga u bazu podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        Urednik urednik = new Urednik();
        urednik.setIme(txtIme.getText());
        urednik.setPrezime(txtPrezime.getText());
        urednik.setUsername(txtUsername.getText());
        urednik.setPassword(BCryptManager.passwordToHash(txtPassword.getText()));
        urednik.setDatumRodjenja((dateDatumRodjenja.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
        urednik.setAdministrator(currentUser);
        Request request = new Request();
        request.setData(urednik);
        request.setOperation(Operation.ADD_UREDNIK);
        try {
            mainFrame.getClient().sendRequest(request);
            Response response = mainFrame.getClient().receiveResponse();
            if (response.getException() == null) JOptionPane.showMessageDialog(this, "Urednik je uspesno dodat");
            else JOptionPane.showMessageDialog(this, "Urednik nije dodat\n" + response.getException().getMessage());
            if (tmu != null) {
                tmu.addUrednik(urednik);
                tmu.fireTableDataChanged();
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        dialog.dispose();
    }//GEN-LAST:event_btnSacuvajActionPerformed

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
    private void dateDatumRodjenjaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateDatumRodjenjaKeyReleased
        verify();
    }//GEN-LAST:event_dateDatumRodjenjaKeyReleased

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        verify();
    }//GEN-LAST:event_txtPasswordKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme za dodavanje urednika u bazu podataka.
     */
    private javax.swing.JButton btnSacuvaj;
    /**
     * Polje za odabir datuma rodjenja urednika.
     */
    private com.toedter.calendar.JDateChooser dateDatumRodjenja;
    /**
     * Labela koja se odnosi na polje za odabir datuma rodjenja urednika.
     */
    private javax.swing.JLabel lblDatumRodjenja;
    /**
     * Labela koja se odnosi na polje za unos imena urednika.
     */
    private javax.swing.JLabel lblIme;
    /**
     * Labela koja se odnosi na polje za unos korisnickog imena urednika.
     */
    private javax.swing.JLabel lblKorisnickoIme;
    /**
     * Labela koja se odnosi na polje za unos lozinke urednika.
     */
    private javax.swing.JLabel lblLozinka;
    /**
     * Labela koja se odnosi na polje za unos prezimena urednika.
     */
    private javax.swing.JLabel lblPrezime;
    /**
     * Polje za unos imena urednika.
     */
    private javax.swing.JTextField txtIme;
    /**
     * Polje za unos lozinke urednika.
     */
    private javax.swing.JPasswordField txtPassword;
    /**
     * Polje za unos prezimena urednika.
     */
    private javax.swing.JTextField txtPrezime;
    /**
     * Polje za unos korisnickog imena urednika.
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
        dateDatumRodjenja.setInputVerifier(new DateChooserVerifier());
    }

    /**
     * Vrsi validaciju svih komponenti.
     */
    private void verify() {
        if(txtIme.getInputVerifier().verify(txtIme) && txtPrezime.getInputVerifier().verify(txtPrezime)
                && txtUsername.getInputVerifier().verify(txtUsername) && txtPassword.getInputVerifier().verify(txtPassword))
            btnSacuvaj.setEnabled(true);
        else btnSacuvaj.setEnabled(false);
    }
}
