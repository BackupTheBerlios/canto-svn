/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/
package li.rajenlab.common.service.guid;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class CheckSum {
    /**
     * calculate a message digest
     * stock JDK supports:
     *
     * <ul>
     *   <li>MD5</li>
     *   <li>SHA, a.k.a. SHA-1</li>
     *   <li>SHA-256</li>
     *   <li>SHA-384</li>
     *   <li>SHA-512</li>
     * </ul>
     *
     * @param algorithmName one of the supported algorithms above
     * @param buffer a byte-array holding the message to evaluate the hash on
     *
     * @return String a hex-decimal hash value
     *
     * @throws NoSuchAlgorithmException if the algorithm is not registered
     */
    public static String calculate (
            final String algorithmName,
            final byte[] buffer)
        throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance (algorithmName);
        digest.reset ();
        digest.update (buffer);
        byte[] array = digest.digest ();

        return new BigInteger (1, array).toString (16);
    }

    /**
     * calculate a message digest
     * stock JDK supports:
     *
     * <ul>
     *   <li>MD5</li>
     *   <li>SHA, a.k.a. SHA-1</li>
     *   <li>SHA-256</li>
     *   <li>SHA-384</li>
     *   <li>SHA-512</li>
     * </ul>
     *
     * @param algorithmName one of the supported algorithms above
     * @param buffer a byte-array holding the message to evaluate the hash on
     * @param length minimal length of hex-decimal value
     * @param pad padding character, to left-justify hexa-decimal value
     *
     * @return String a hex-digit hash value
     *
     * @throws NoSuchAlgorithmException if the algorithm is not registered
     */
    public static String calculate (
            final String algorithmName,
            final byte[] buffer,
            final int length,
            final char pad)
        throws NoSuchAlgorithmException
    {
        String s = calculate (algorithmName, buffer);

        if (length <= s.length ()) {
            return s;
        }

        StringBuffer sb = new StringBuffer (s);

        while (sb.length () < length) {
            sb.insert (0, pad);
        }

        return sb.toString ();
    }
}
