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
 * Predstavlja formu koja je namenjena za pretragu urednika iz baze podataka.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class SearchUrednikPanel extends javax.swing.JPanel {

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
    private final TableModelUrednici tmu;
    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     *
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     * @param currentUser - Trenutno ulogovani genericki korisnik (administrator).
     * @param tmu - Table model za urednike.
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
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPretragaPo = new javax.swing.JLabel();
        lblImenu = new javax.swing.JLabel();
        lblPrezimenu = new javax.swing.JLabel();
        lblGodiniRodjenja = new javax.swing.JLabel();
        lblKorisnickomImenu = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        fieldYear = new com.toedter.calendar.JYearChooser();
        checkBoxYearEnabled = new javax.swing.JCheckBox();

        lblPretragaPo.setText("Pretraga po:");

        lblImenu.setText("Imenu");

        lblPrezimenu.setText("Prezimenu");

        lblGodiniRodjenja.setText("Godini rodjenja");

        lblKorisnickomImenu.setText("Korisnickom imenu");

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
                        .addComponent(lblImenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPrezimenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPretrazi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKorisnickomImenu)
                            .addComponent(lblPretragaPo)
                            .addComponent(lblGodiniRodjenja))
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
                .addComponent(lblPretragaPo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImenu)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezimenu)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKorisnickomImenu)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGodiniRodjenja)
                    .addComponent(fieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxYearEnabled))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPretrazi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Konstruise parametar za pretragu koriscenjem podataka unetih u formu, salje zahtev serveru i prima listu pronadjenih urednika.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme za pokretanje pretrage korisnika.
     */
    private javax.swing.JButton btnPretrazi;
    /**
     * Check box koji odredjuje da li ce odabrana godina rodjenja biti ukljucena u parametar za pretragu.
     */
    private javax.swing.JCheckBox checkBoxYearEnabled;
    /**
     * Polje za odabir godine rodjenja urednika.
     */
    private com.toedter.calendar.JYearChooser fieldYear;
    /**
     * Labela koja se odnosi na polje za odabir godine rodjenja urednika.
     */
    private javax.swing.JLabel lblGodiniRodjenja;
    /**
     * Labela koja se odnosi na polje za unos imena urednika.
     */
    private javax.swing.JLabel lblImenu;
    /**
     * Labela koja se odnosi na polje za unos korisnickog imena urednika.
     */
    private javax.swing.JLabel lblKorisnickomImenu;
    /**
     * Labela koja naznacava da se polja ispod nje koriste za definisanje parametra za pretragu.
     */
    private javax.swing.JLabel lblPretragaPo;
    /**
     * Labela koja se odnosi na polje za unos prezimena urednika.
     */
    private javax.swing.JLabel lblPrezimenu;
    /**
     * Polje za unos imena urednika.
     */
    private javax.swing.JTextField txtIme;
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
        txtIme.setInputVerifier(new LetterOnlyFieldVerifier(20, true));
        txtPrezime.setInputVerifier(new LetterOnlyFieldVerifier(20, true));
        txtUsername.setInputVerifier(new TextFieldVerifier(20, true));
    }

    /**
     * Vrsi validaciju svih komponenti.
     */
    private void verify() {
        if (txtIme.getInputVerifier().verify(txtIme) && txtPrezime.getInputVerifier().verify(txtPrezime) 
                && txtUsername.getInputVerifier().verify(txtUsername))
            btnPretrazi.setEnabled(true);
        else btnPretrazi.setEnabled(false);
    }
}
