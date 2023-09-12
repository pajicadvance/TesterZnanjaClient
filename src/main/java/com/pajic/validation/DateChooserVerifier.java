/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.validation;

import com.toedter.calendar.JDateChooser;
import javax.swing.InputVerifier;
import javax.swing.JComponent;

/**
 *
 * @author Pavle
 */
public class DateChooserVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        return ((JDateChooser) input).getDate() != null;
    }
    
}
