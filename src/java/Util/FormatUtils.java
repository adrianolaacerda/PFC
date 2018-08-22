/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.DecimalFormat;

/**
 *
 * @author PC
 */
public class FormatUtils {
    
    public static String formataDinheiro(Double quantia) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(quantia);
    }
}
