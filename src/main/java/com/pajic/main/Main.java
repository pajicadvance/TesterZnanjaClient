/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.main;

import com.pajic.view.form.MainFrame;

import java.io.IOException;

/**
 * Main klasa projekta TesterZnanjaClient.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class Main {
    /**
     * Entrypoint klijentske aplikacije.
     *
     * Inicijalizuje i prikazuje glavnu klijentsku formu.
     *
     * @param args Argumenti pri pokretanju aplikacije iz komandne linije (neiskorisceno).
     * @throws IOException - - Ukoliko dodje do greske prilikom komunikacije klijenta sa serverom.
     */
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
