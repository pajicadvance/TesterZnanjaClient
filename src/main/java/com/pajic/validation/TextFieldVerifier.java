/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.validation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Pavle
 */
public class TextFieldVerifier extends InputVerifier {
    
    private final int maxLength;
    private final boolean allowBlank;

    public TextFieldVerifier(int length, boolean allowBlank) {
        this.maxLength = length;
        this.allowBlank = allowBlank;
    }

    @Override
    public boolean verify(JComponent input) {
        String text = input instanceof JTextField ? ((JTextField) input).getText() : ((JTextArea) input).getText();
        return !(text.length() > maxLength || (!allowBlank && text.isBlank()));
    }
}
