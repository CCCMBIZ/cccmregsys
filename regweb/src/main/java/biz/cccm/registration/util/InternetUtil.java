/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.util;

/**
 *
 * @author CccmStaff
 */
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Static convenience methods for common web-related tasks.
 */
public final class InternetUtil {

    /**
     * Validate the form of an email address.
     *
     * <P>
     * Return <tt>true</tt> only if
     * <ul>
     * <li> <tt>aEmailAddress</tt> can successfully construct an
     * {@link javax.mail.internet.InternetAddress}
     * <li> when parsed with "@" as delimiter, <tt>aEmailAddress</tt> contains
     * two tokens which satisfy
     * {@link hirondelle.web4j.util.Util#textHasContent}.
     * </ul>
     *
     * <P>
     * The second condition arises since local email addresses, simply of the
     * form "<tt>albert</tt>", for example, are valid for
     * {@link javax.mail.internet.InternetAddress}, but almost always undesired.
     * @param emailAddress
     * @return 
     */
    public static boolean isValidEmailAddress(String emailAddress) {
        if (emailAddress == null) {
            return false;
        }
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(emailAddress);
            if (!hasNameAndDomain(emailAddress)) {
                result = false;
            }
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    private static boolean hasNameAndDomain(String aEmailAddress) {
        String[] tokens = aEmailAddress.split("@");
        return tokens.length == 2
                && textHasContent(tokens[0])
                && textHasContent(tokens[1]);
    }

    /**
     * Return <tt>true</tt> only if <tt>aText</tt> is not null, and if its raw
     * <tt>String</tt> is not empty after trimming. (Trimming removes both
     * leading/trailing whitespace and ASCII control characters. See
     * {@link String#trim()}.)
     *
     * @param aText possibly-null.
     */
    private static boolean textHasContent(String aText) {
        return (aText != null) && (aText.trim().length() > 0);
    }
}
