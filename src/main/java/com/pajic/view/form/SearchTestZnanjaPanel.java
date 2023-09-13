/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.communication.Operation;
import com.pajic.communication.Request;
import com.pajic.communication.Response;
import com.pajic.model.TestZnanja;
import com.pajic.validation.TextFieldVerifier;
import com.pajic.view.component.TableModelTestoviZnanja;

import java.io.IOException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Predstavlja formu koja je namenjena za pretragu testova znanja iz baze podataka.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class SearchTestZnanjaPanel extends javax.swing.JPanel {

    /**
     * Referenca ka MainFrame instanci.
     */
    private final MainFrame mainFrame;
    /**
     * Referenca ka dialogu u kome se nalazi ovaj panel.
     */
    private final JDialog dialog;
    /**
     * Table model za testove znanja.
     */
    TableModelTestoviZnanja tmtz;
    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     *
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     * @param tmtz - Table model za testove znanja.
     */
    public SearchTestZnanjaPanel(MainFrame mainFrame, JDialog dialog, TableModelTestoviZnanja tmtz) {
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        this.tmtz = tmtz;
        initComponents();
        setVerifiers();
    }

    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();

        lblNaziv.setText("Naziv");

        txtNaziv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNazivKeyReleased(evt);
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
                        .addComponent(lblNaziv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPretrazi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPretrazi)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtNazivKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNazivKeyReleased
        verify();
    }//GEN-LAST:event_txtNazivKeyReleased

    /**
     * Konstruise parametar za pretragu koriscenjem podataka unetih u formu, salje zahtev serveru i prima listu pronadjenih testova znanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        String searchParameter = "";
        if (!txtNaziv.getText().isEmpty()) {
             searchParameter = " WHERE naziv LIKE '%" + txtNaziv.getText() + "%'";
        }
        Request request = new Request();
        request.setData(searchParameter);
        request.setOperation(Operation.FIND_TEST_ZNANJA);
        try {
            mainFrame.getClient().sendRequest(request);
            Response response = mainFrame.getClient().receiveResponse();
            if (response.getException() != null) JOptionPane.showMessageDialog(mainFrame, "Greska\n" + response.getException().getMessage());
            else if (response.getData() != null) {
                List<TestZnanja> testoviZnanja = (List<TestZnanja>) response.getData();
                if (testoviZnanja.isEmpty()) 
                    JOptionPane.showMessageDialog(mainFrame, "Nije pronadjen nijedan test znanja");
                else {
                    JOptionPane.showMessageDialog(mainFrame, "Pretraga je uspesno izvrsena");
                    tmtz.setTestoviZnanjaList(testoviZnanja);
                    tmtz.fireTableDataChanged();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        dialog.dispose();
    }//GEN-LAST:event_btnPretraziActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme za pokretanje pretrage testova znanja.
     */
    private javax.swing.JButton btnPretrazi;
    /**
     * Labela koja se odnosi na polje za unos naziva testa znanja.
     */
    private javax.swing.JLabel lblNaziv;
    /**
     * Polje za unos naziva testa znanja.
     */
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    /**
     * Postavlja odgovarajuce verifikatore na komponente u formi.
     */
    private void setVerifiers() {
        txtNaziv.setInputVerifier(new TextFieldVerifier(64, true));
    }

    /**
     * Vrsi validaciju svih komponenti.
     */
    private void verify() {
        if (txtNaziv.getInputVerifier().verify(txtNaziv))
            btnPretrazi.setEnabled(true);
        else btnPretrazi.setEnabled(false);
    }
}
