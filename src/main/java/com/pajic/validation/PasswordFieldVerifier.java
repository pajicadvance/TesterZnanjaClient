/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.validation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JPasswordField;

/**
 * Predstavlja specifican InputVerifier specijalizovan za verifikaciju komponente JPasswordField.
 *
 * Sadrzi maksimalnu duzinu podatka i da li je dozvoljeno prazno polje.
 *
 * Nasledjuje klasu InputVerifier.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class PasswordFieldVerifier extends InputVerifier {

    /**
     * Maksimalna duzina podatka.
     */
    private final int maxLength;
    /**
     * Da li je dozvoljeno prazno polje.
     */
    private final boolean allowBlank;

    /**
     * Konstruktor koji vraca novu instancu ovog verifikatora.
     * @param length - Vrednost koja se dodeljuje atributu length.
     * @param allowBlank - Vrednost koja se dodeljuje atributu allowBlank.
     */
    public PasswordFieldVerifier(int length, boolean allowBlank) {
        this.maxLength = length;
        this.allowBlank = allowBlank;
    }

    @Override
    public boolean verify(JComponent input) {
        String text = String.valueOf(((JPasswordField) input).getPassword());
        return !(text.length() > maxLength || (!allowBlank && text.isBlank()));
    }
    
}
