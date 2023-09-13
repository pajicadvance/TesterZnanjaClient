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
import com.pajic.view.component.TableModelUrednici;

import java.io.IOException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Predstavlja formu koja je namenjena za upravljane urednicima.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class UredniciManagementPanel extends javax.swing.JPanel {

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
    private TableModelUrednici tmu;
    /**
     * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     * @param currentUser - Trenutno ulogovani korisnik (administrator).
     * @throws IOException - Ukoliko dodje do greske prilikom komunikacije sa serverom.
     * @throws ClassNotFoundException - Ukoliko klasa serijalizovanog objekta ne moze biti pronadjena.
     */
    public UredniciManagementPanel(MainFrame mainFrame, JDialog dialog, GenericUser currentUser) throws IOException, ClassNotFoundException {
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        this.currentUser = (Administrator) currentUser;
        initComponents();
        prepareView();
    }

    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTableUrednici = new javax.swing.JScrollPane();
        tableUrednici = new javax.swing.JTable();
        btnAddUrednik = new javax.swing.JButton();
        btnRemoveUrednik = new javax.swing.JButton();
        btnSearchUrednici = new javax.swing.JButton();

        tableUrednici.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPaneTableUrednici.setViewportView(tableUrednici);

        btnAddUrednik.setText("Dodaj urednika...");
        btnAddUrednik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUrednikActionPerformed(evt);
            }
        });

        btnRemoveUrednik.setText("Obrisi izabranog urednika");
        btnRemoveUrednik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveUrednikActionPerformed(evt);
            }
        });

        btnSearchUrednici.setText("Pretraga urednika...");
        btnSearchUrednici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUredniciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTableUrednici)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemoveUrednik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddUrednik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearchUrednici, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddUrednik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchUrednici)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveUrednik)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPaneTableUrednici))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Prikazuje dialog za dodavanje novog urednika.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void btnAddUrednikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUrednikActionPerformed
        JDialog dialog2 = new JDialog(dialog, true);
        dialog2.add(new AddUrednikPanel(mainFrame, dialog2, currentUser, tmu));
        dialog2.setLocationRelativeTo(null);
        dialog2.pack();
        dialog2.setVisible(true);
    }//GEN-LAST:event_btnAddUrednikActionPerformed

    /**
     * Brise trenutno selektovanog urednika u tabeli urednika iz baze podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnRemoveUrednikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveUrednikActionPerformed
        Urednik urednik = tmu.getUrednikList().get(tableUrednici.getSelectedRow());
        Request request = new Request();
        request.setData(urednik);
        request.setOperation(Operation.DELETE_UREDNIK);
        try {
            mainFrame.getClient().sendRequest(request);
            Response response = mainFrame.getClient().receiveResponse();
            if (response.getException() == null) {
                JOptionPane.showMessageDialog(this, "Urednik je uspesno obrisan");
                tmu.removeUrednik(tableUrednici.getSelectedRow());
                tmu.fireTableDataChanged();
            }
            else JOptionPane.showMessageDialog(this, "Urednik nije obrisan\n" + response.getException().getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }//GEN-LAST:event_btnRemoveUrednikActionPerformed

    /**
     * Prikazuje dialog za pretragu urednika.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSearchUredniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUredniciActionPerformed
        JDialog dialog2 = new JDialog(dialog, true);
        dialog2.add(new SearchUrednikPanel(mainFrame, dialog2, currentUser, tmu));
        dialog2.setLocationRelativeTo(null);
        dialog2.pack();
        dialog2.setVisible(true);
    }//GEN-LAST:event_btnSearchUredniciActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme koje otvara formu za dodavanje novog urednika u bazu podataka.
     */
    private javax.swing.JButton btnAddUrednik;
    /**
     * Dugme koje brise izabranog urednika iz tabele urednika iz baze podataka.
     */
    private javax.swing.JButton btnRemoveUrednik;
    /**
     * Dugme koje otvara formu za pretragu urednika.
     */
    private javax.swing.JButton btnSearchUrednici;
    /**
     * Scroll pane u kome se nalazi tabela urednika.
     */
    private javax.swing.JScrollPane scrollPaneTableUrednici;
    /**
     * Tabela urednika.
     */
    private javax.swing.JTable tableUrednici;
    // End of variables declaration//GEN-END:variables

    /**
     * Vrsi pripremu pocetnog stanja komponenti nakon njihove inicijalizacije.
     */
    private void prepareView() throws IOException, ClassNotFoundException {
        List<Urednik> urednici;
        String searchParameter = " WHERE administrator_id=" + currentUser.getId();
        Request request = new Request();
        request.setData(searchParameter);
        request.setOperation(Operation.FIND_UREDNIK);
        mainFrame.getClient().sendRequest(request);
        Response response = mainFrame.getClient().receiveResponse();
        if (response.getData() != null) {
            urednici = (List<Urednik>) response.getData();
            tmu = new TableModelUrednici(urednici, currentUser);
            tableUrednici.setModel(tmu);
        }
        else JOptionPane.showMessageDialog(mainFrame, "Neuspesno ucitavanje liste urednika");
    }
}
