/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pajic.view.form;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pajic.communication.Operation;
import com.pajic.communication.Request;
import com.pajic.communication.Response;
import com.pajic.model.TestZnanja;
import com.pajic.model.TipTestaZnanja;
import com.pajic.validation.DigitOnlyFieldVerifier;
import com.pajic.validation.TextFieldVerifier;
import com.pajic.view.component.TableModelPitanja;
import java.io.FileWriter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Predstavlja formu koja je namenjena za dodavanje novog testa znanja u bazu podataka.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class AddTestZnanjaPanel extends javax.swing.JPanel {

    /**
     * Referenca ka MainFrame instanci.
     */
    private final MainFrame mainFrame;
    /**
     * Referenca ka dialogu u kome se ovaj panel nalazi.
     */
    private final JDialog dialog;
    /**
     * Test znanja koji se priprema za dodavanje u bazu podataka.
     */
    private TestZnanja tz;
    /**
     * Referenca ka table modelu za pitanja.
     */
    private TableModelPitanja tmp;
    
    /**
     * Konstruktor koji vrsi pocetno kreiranje i konfigurisanje elemenata forme i inicijalizuje vrednosti.
     * @param mainFrame - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
     * @param dialog - Dialog u kome se nalazi ovaj panel.
     */
    public AddTestZnanjaPanel(MainFrame mainFrame, JDialog dialog) {
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        initComponents();
        prepareView();
        setVerifiers();
    }

    /**
     * Kreira graficke komponente i postavlja i podesava njihov izgled, poziciju i ponasanje.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaziv = new javax.swing.JLabel();
        lblPoeniZaProlaz = new javax.swing.JLabel();
        txtPoeniZaProlaz = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        scrollPaneTablePitanja = new javax.swing.JScrollPane();
        tablePitanja = new javax.swing.JTable();
        btnAddPitanje = new javax.swing.JButton();
        btnDeletePitanje = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblPitanja = new javax.swing.JLabel();
        lblTip = new javax.swing.JLabel();
        comboBoxTip = new javax.swing.JComboBox<>();
        btnSaveToJson = new javax.swing.JButton();

        lblNaziv.setText("Naziv");

        lblPoeniZaProlaz.setText("Poeni za prolaz");

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
        scrollPaneTablePitanja.setViewportView(tablePitanja);

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

        lblPitanja.setText("Pitanja");

        lblTip.setText("Tip");

        btnSaveToJson.setText("Sacuvaj izabrani test znanja u fajl");
        btnSaveToJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveToJsonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNaziv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNaziv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPaneTablePitanja, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(lblPoeniZaProlaz)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPoeniZaProlaz))
                                    .addComponent(btnAddPitanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaveToJson)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPitanja)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNaziv)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPoeniZaProlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTip)
                        .addComponent(lblPoeniZaProlaz)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPitanja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddPitanje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletePitanje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveToJson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addComponent(scrollPaneTablePitanja, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
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
     * Pokrece validaciju svih komponenti pri bilo kojoj promeni podatka unutar komponente.
     * @param evt - Predstavlja dogadjaj koji se desio nad komponentom.
     */
    private void txtPoeniZaProlazKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPoeniZaProlazKeyReleased
        verify();
    }//GEN-LAST:event_txtPoeniZaProlazKeyReleased

    /**
     * Otvara novi dialog za dodavanje pitanja u test znanja i prosledjuje mu table model za pitanja.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnAddPitanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPitanjeActionPerformed
        JDialog dialog2 = new JDialog(dialog, true);
        dialog2.add(new AddPitanjePanel(dialog2, tmp));
        dialog2.setLocationRelativeTo(null);
        dialog2.pack();
        dialog2.setVisible(true);
    }//GEN-LAST:event_btnAddPitanjeActionPerformed

    /**
     * Konstruise test znanja koriscenjem podataka unetih u formu i dodaje ga u bazu podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        tz.setNaziv(txtNaziv.getText());
        tz.setPoeniZaProlaz(Integer.parseInt(txtPoeniZaProlaz.getText()));
        tz.setListaPitanja(tmp.getPitanjeList());
        tz.setTipTestaZnanja((TipTestaZnanja) comboBoxTip.getSelectedItem());
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

    /**
     * Brise trenutno selektovano pitanje u tabeli pitanja iz tabele.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnDeletePitanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePitanjeActionPerformed
        int selectedRow = tablePitanja.getSelectedRow();
        if (selectedRow >= 0) tmp.removePitanje(selectedRow);
        else JOptionPane.showMessageDialog(this, "Pitanje nije izabrano");
    }//GEN-LAST:event_btnDeletePitanjeActionPerformed

    /**
     * Konstruise test znanja koriscenjem podataka unetih u formu i cuva ga u JSON fajl na lokalnom uredjaju.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveToJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveToJsonActionPerformed
        tz.setNaziv(txtNaziv.getText());
        tz.setPoeniZaProlaz(Integer.parseInt(txtPoeniZaProlaz.getText()));
        tz.setListaPitanja(tmp.getPitanjeList());
        tz.setTipTestaZnanja((TipTestaZnanja) comboBoxTip.getSelectedItem());
        tmp.addTestZnanja(tz);
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath() + "\\" + tz.getNaziv() + ".json";
            System.out.println(path);
            try (FileWriter writer = new FileWriter(path)) {
                gson.toJson(tz, writer);
                JOptionPane.showMessageDialog(this, "Test znanja uspesno sacuvan u JSON fajl");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Neuspesno cuvanje JSON fajla" + ex);
            }
        }
    }//GEN-LAST:event_btnSaveToJsonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Dugme koje otvara formu za dodavanje novog pitanja u test znanja.
     */
    private javax.swing.JButton btnAddPitanje;
    /**
     * Dugme koje brise izabrano pitanje iz tabele pitanja.
     */
    private javax.swing.JButton btnDeletePitanje;
    /**
     * Dugme koje dodaje test znanja u bazu podataka.
     */
    private javax.swing.JButton btnSave;
    /**
     * Dugme koje cuva test znanja u JSON fajl na lokalnom uredjaju.
     */
    private javax.swing.JButton btnSaveToJson;
    /**
     * Combo box kojim se bira tip testa znanja.
     */
    private javax.swing.JComboBox<TipTestaZnanja> comboBoxTip;
    /**
     * Labela koja se odnosi na polje za unos naziva testa znanja.
     */
    private javax.swing.JLabel lblNaziv;
    /**
     * Labela koja se odnosi na tabelu pitanja.
     */
    private javax.swing.JLabel lblPitanja;
    /**
     * Labela koja se odnosi na polje za unos poena potrebnih za prolaz testa znanja.
     */
    private javax.swing.JLabel lblPoeniZaProlaz;
    /**
     * Labela koja se odnosi na polje za odabir tipa testa znanja.
     */
    private javax.swing.JLabel lblTip;
    /**
     * Scroll pane u kome se nalazi tabela pitanja.
     */
    private javax.swing.JScrollPane scrollPaneTablePitanja;
    /**
     * Tabela pitanja.
     */
    private javax.swing.JTable tablePitanja;
    /**
     * Polje za unos naziva testa znanja.
     */
    private javax.swing.JTextField txtNaziv;
    /**
     * Polje za unos poena potrebnih za prolaz testa znanja.
     */
    private javax.swing.JTextField txtPoeniZaProlaz;
    // End of variables declaration//GEN-END:variables

    /**
     * Vrsi pripremu pocetnog stanja komponenti nakon njihove inicijalizacije.
     */
    private void prepareView() {
        dialog.setTitle("Test znanja");
        tz = new TestZnanja();
        tmp = new TableModelPitanja();
        tablePitanja.setModel(tmp);
        btnSave.setEnabled(false);
        comboBoxTip.addItem(new TipTestaZnanja(1, "Kviz"));
        comboBoxTip.addItem(new TipTestaZnanja(2, "Test"));
        comboBoxTip.addItem(new TipTestaZnanja(3, "Ispit"));
    }

    /**
     * Postavlja odgovarajuce verifikatore na komponente u formi.
     */
    private void setVerifiers() {
        txtNaziv.setInputVerifier(new TextFieldVerifier(64, false));
        txtPoeniZaProlaz.setInputVerifier(new DigitOnlyFieldVerifier(3, false, 100));
    }

    /**
     * Vrsi validaciju svih komponenti.
     */
    private void verify() {
        if (txtNaziv.getInputVerifier().verify(txtNaziv) && txtPoeniZaProlaz.getInputVerifier().verify(txtPoeniZaProlaz)) {
            btnSave.setEnabled(true);
        }
        else btnSave.setEnabled(false);
    }
}
