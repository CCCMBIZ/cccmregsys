/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author CH1CHOO1
 */
public class StringUtil {

    /*A Java class to verify if a String variable is a number*/
    public static boolean isNumeric(String number) {
        boolean isValid = false;
        /*Explaination:
        [-+]?: Can have an optional - or + sign at the beginning.
        [0-9]*: Can have any numbers of digits between 0 and 9
        \\.? : the digits may have an optional decimal point.
        [0-9]+$: The string must have a digit at the end.
        If you want to consider x. as a valid number change
        the expression as follows. (but I treat this as an invalid number.).
        String expression = "[-+]?[0-9]*\\.?[0-9\\.]+$";
         */
        String expression = "[-+]?[0-9]*\\.?[0-9]+$";
        CharSequence inputStr = number;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
