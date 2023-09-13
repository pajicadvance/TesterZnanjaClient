/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.validation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * Predstavlja specifican InputVerifier specijalizovan za verifikaciju komponente JTextField gde je dozvoljen samo unos cifri.
 *
 * Sadrzi maksimalnu duzinu podatka, maksimalnu vrednost broja i da li je dozvoljeno prazno polje.
 *
 * Nasledjuje klasu InputVerifier.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class DigitOnlyFieldVerifier extends InputVerifier {

    /**
     * Maksimalna duzina podatka.
     */
    private final int maxLength;
    /**
     * Da li je dozvoljeno prazno polje.
     */
    private final boolean allowBlank;
    /**
     * Maksimalna vrednost broja unetog u polje.
     */
    private final int maxValue;

    /**
     * Konstruktor koji vraca novu instancu ovog verifikatora.
     * @param length - Vrednost koja se dodeljuje atributu length.
     * @param allowBlank - Vrednost koja se dodeljuje atributu allowBlank.
     * @param maxValue - Vrednost koja se dodeljuje atributu maxValue.
     */
    public DigitOnlyFieldVerifier(int length, boolean allowBlank, int maxValue) {
        this.maxLength = length;
        this.allowBlank = allowBlank;
        this.maxValue = maxValue;
    }

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        return !(!text.chars().allMatch(Character::isDigit) || text.length() > maxLength || (!allowBlank && text.isBlank()) || Integer.parseInt(text) > maxValue);
    }
    
}
