/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.validation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JPasswordField;

/**
 *
 * @author Pavle
 */
public class PasswordFieldVerifier extends InputVerifier {

    private final int maxLength;
    private final boolean allowBlank;

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
