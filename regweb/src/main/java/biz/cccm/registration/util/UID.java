/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.logging.Logger;

public class UID {

    private static Logger m_log = Logger.getAnonymousLogger();
    private static char separator;
    private static StringBuilder IPAddressSegment;
    private static SecureRandom prng;

    static {
        try {
            // Get IPAddress Segment
            IPAddressSegment = new StringBuilder();
            InetAddress addr = InetAddress.getLocalHost();
            StringBuilder strTemp = new StringBuilder();
            byte[] ipaddr = addr.getAddress();
            for (int i = 0; i < ipaddr.length; i++) {
                Byte b = new Byte(ipaddr[i]);

                strTemp = new StringBuilder(Integer.toHexString(b.intValue() & 0x000000ff));
                while (strTemp.length() < 2) {
                    strTemp.insert(0, '0');
                }
                IPAddressSegment.append(strTemp);
            }

            if (separator != '\u0000') {
                IPAddressSegment.append(separator);
            }

            //Get Random Segment Algoritm
            prng = SecureRandom.getInstance("SHA1PRNG");

        } catch (UnknownHostException ex) {
            m_log.severe("Unknown Host Exception Caught: " + ex.getMessage());
        } catch (NoSuchAlgorithmException nsae) {
            m_log.severe("No Such Algorithm Exception Caught: " + nsae.getMessage());
        }
    }

    public static final String getUID() {
        StringBuilder strRetVal = new StringBuilder(IPAddressSegment);
        StringBuilder strTemp = new StringBuilder();

        //Get CurrentTimeMillis() segment
        strTemp = new StringBuilder(Long.toHexString(System.currentTimeMillis()));
        while (strTemp.length() < 12) {
            strTemp.insert(0, '0');
        }
        strRetVal.append(strTemp);
        if (separator != '\u0000') {
            IPAddressSegment.append(separator);
        }

        // Get Random Segment
        strTemp = new StringBuilder(Integer.toHexString(prng.nextInt()));
        while (strTemp.length() < 8) {
            strTemp.insert(0, '0');
        }

        strRetVal.append(strTemp.substring(4));
        if (separator != '\u0000') {
            IPAddressSegment.append(separator);
        }

        //Get IdentityHash() segment
        strTemp = new StringBuilder(Long.toHexString(System.identityHashCode((Object) new UID())));
        while (strTemp.length() < 8) {
            strTemp.insert(0, '0');
        }
        strRetVal.append(strTemp);

        return strRetVal.toString().toUpperCase();
    }

    public static int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String str = "" + idOne;
        int uid = str.hashCode();
        String filterStr = "" + uid;
        str = filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }
}
