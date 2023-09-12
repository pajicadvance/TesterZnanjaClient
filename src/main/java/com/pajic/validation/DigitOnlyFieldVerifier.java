/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.validation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Pavle
 */
public class DigitOnlyFieldVerifier extends InputVerifier {
    
    private final int maxLength;
    private final boolean allowBlank;
    private final int maxValue;

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
