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
 *
 * @author pajic
 */
public class SearchTestZnanjaPanel extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final JDialog dialog;
    TableModelTestoviZnanja tmtz;
    /**
     * Creates new form SearchTestZnanjaPanel
     * @param mainFrame
     * @param dialog
     * @param tmtz
     */
    public SearchTestZnanjaPanel(MainFrame mainFrame, JDialog dialog, TableModelTestoviZnanja tmtz) {
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        this.tmtz = tmtz;
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
        txtNaziv = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();

        jLabel1.setText("Naziv");

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
                        .addComponent(jLabel1)
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
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPretrazi)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNazivKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNazivKeyReleased
        verify();
    }//GEN-LAST:event_txtNazivKeyReleased

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
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void setVerifiers() {
        txtNaziv.setInputVerifier(new TextFieldVerifier(64, true));
    }

    private void verify() {
        if (txtNaziv.getInputVerifier().verify(txtNaziv))
            btnPretrazi.setEnabled(true);
        else btnPretrazi.setEnabled(false);
    }
}
