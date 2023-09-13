/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.pajic.communication.Operation;
import com.pajic.communication.Request;
import com.pajic.communication.Response;
import com.pajic.model.GenericUser;
import com.pajic.model.Korisnik;
import com.pajic.model.Rezultat;
import com.pajic.model.TestZnanja;
import com.pajic.view.component.TableModelTestoviZnanja;

import java.awt.Dialog;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Predstavlja formu koja je namenjena za odabir testa znanja koji korisnik zeli da pokrene.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class TestZnanjaSelectionPanel extends javax.swing.JPanel {

    /**
     * Referenca ka MainFrame instanci.
     */
    private final MainFrame mainFrame;
    /**
     * Referenca ka dialogu u kome se nalazi ovaj panel.
     */
    private final JDialog dialog;
    /**
     * Korisnik koji radi test.
     */
    private final Korisnik korisnik;
    /**
     * Table model za testove znanja.
     */
    private TableModelTestoviZnanja tmtz;

    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     * @param user - Trenutno ulogovani genericki korisnik (korisnik).
     * @throws IOException - Ukoliko dodje do greske prilikom komunikacije sa serverom.
     * @throws ClassNotFoundException - Ukoliko klasa serijalizovanog objekta ne moze biti pronadjena.
     */
    public TestZnanjaSelectionPanel(MainFrame mainFrame, JDialog dialog, GenericUser user) throws IOException, ClassNotFoundException {
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        this.korisnik = (Korisnik) user;
        initComponents();
        prepareView();
    }

    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTableTestoviZnanja = new javax.swing.JScrollPane();
        tableTestoviZnanja = new javax.swing.JTable();
        btnSearchTestZnanja = new javax.swing.JButton();
        btnPokreni = new javax.swing.JButton();

        tableTestoviZnanja.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPaneTableTestoviZnanja.setViewportView(tableTestoviZnanja);

        btnSearchTestZnanja.setText("Pretraga testova znanja...");
        btnSearchTestZnanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTestZnanjaActionPerformed(evt);
            }
        });

        btnPokreni.setText("Pokreni izabrani test znanja");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTableTestoviZnanja, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPokreni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearchTestZnanja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearchTestZnanja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPokreni)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPaneTableTestoviZnanja))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Pokrece rad trenutno selektovanog testa znanja u tabeli testova znanja.
     * Ako je korisnik vec radio izabrani test znanja, prikazace se poruka i test se nece pokrenuti.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        int selectedRow = tableTestoviZnanja.getSelectedRow();
        if (selectedRow >= 0) {
            TestZnanja testZnanja = tmtz.getTestoviZnanjaList().get(tableTestoviZnanja.getSelectedRow());
            String searchParameter = " WHERE korisnik_id=" + korisnik.getId() + " AND test_znanja_id=" + testZnanja.getId();
            Request request = new Request();
            request.setData(searchParameter);
            request.setOperation(Operation.FIND_REZULTAT);
            try {
                mainFrame.getClient().sendRequest(request);
                Response response = mainFrame.getClient().receiveResponse();
                List<Rezultat> rezultati = (List<Rezultat>) response.getData();
                if (rezultati.isEmpty()) {
                    TestZnanjaFrame tzf = new TestZnanjaFrame(testZnanja, korisnik, mainFrame);
                    tzf.setLocationRelativeTo(null);
                    tzf.pack();
                    tzf.setVisible(true);
                    dialog.dispose();
                }
                else JOptionPane.showMessageDialog(this, "Vec ste radili ovaj test");
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(TestZnanjaSelectionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else JOptionPane.showMessageDialog(this, "Nije odabran test znanja");
    }//GEN-LAST:event_btnPokreniActionPerformed

    /**
     * Prikazuje dialog za pretragu testova znanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSearchTestZnanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTestZnanjaActionPerformed
        JDialog dialog2 = new JDialog(dialog, true);
        dialog2.add(new SearchTestZnanjaPanel(mainFrame, dialog2, tmtz));
        dialog2.setLocationRelativeTo(null);
        dialog2.pack();
        dialog2.setVisible(true);
    }//GEN-LAST:event_btnSearchTestZnanjaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme koje pokrece rad izabranog testa znanja iz tabele testova znanja.
     */
    private javax.swing.JButton btnPokreni;
    /**
     * Dugme koje otvara formu za pretragu testova znanja.
     */
    private javax.swing.JButton btnSearchTestZnanja;
    /**
     * Scroll pane u kome se nalazi tabela testova znanja.
     */
    private javax.swing.JScrollPane scrollPaneTableTestoviZnanja;
    /**
     * Tabela testova znanja.
     */
    private javax.swing.JTable tableTestoviZnanja;
    // End of variables declaration//GEN-END:variables

    /**
     * Vrsi pripremu pocetnog stanja komponenti nakon njihove inicijalizacije.
     */
    private void prepareView() throws IOException, ClassNotFoundException {
        List<TestZnanja> testoviZnanja;
        Request request = new Request();
        request.setOperation(Operation.GET_ALL_TEST_ZNANJA);
        mainFrame.getClient().sendRequest(request);
        Response response = mainFrame.getClient().receiveResponse();
        if (response.getData() != null) {
            testoviZnanja = (List<TestZnanja>) response.getData();
            tmtz = new TableModelTestoviZnanja(testoviZnanja);
            tableTestoviZnanja.setModel(tmtz);
        }
        else JOptionPane.showMessageDialog(mainFrame, "Neuspesno ucitavanje liste testova znanja\n" + response.getException().getMessage());
    }
}
