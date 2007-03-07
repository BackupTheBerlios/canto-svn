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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Guid {
    
    private final static Random random;
    private final static SecureRandom secureRandom;
    private final static String hostIP;

    /**
     * Static block to take care of one time secureRandom seed and
     * identification of IP address. It takes a few seconds to initialize
     * SecureRandom. You might want to consider removing this static block or
     * replacing it with a "time since first loaded" seed to reduce this time.
     * This block will run only once per JVM instance.
     */

    static {
        secureRandom = new SecureRandom ();
        random = new Random (secureRandom.nextLong ());

        try {
            hostIP = InetAddress.getLocalHost ().toString ();
        }
        catch (UnknownHostException e) {
            throw new RuntimeException ("Could not determine IP address", e);
        }
    }

    // Constructor -------------------------------------------------------------

    public Guid ()
    {
    }

    // Public ------------------------------------------------------------------

    /**
     * Default generation method. With no specification of security option, this
     * constructor defaults to lower security, high performance.
     */
    public String nextGUID ()
    {
        return getRandomGUID (false);
    }

    /**
     * generation method with security option. Setting secure true enables each
     * random number generated to be cryptographically strong. Secure false
     * defaults to the standard Random function seeded with a single
     * cryptographically strong random number.
     */
    public String nextGUID (final boolean secure)
    {
        return getRandomGUID (secure);
    }

    /**
     * convenience method to retrieve GUID
     * 
     * @see Guid#nextFormatedGUID(boolean)
     */
    public String nextFormatedGUID ()
    {
        return nextFormatedGUID (false);
    }

    /**
     * convenience method to retrieve GUID
     * 
     * Convert to the standard format for GUID (Useful for SQL Server
     * UniqueIdentifiers, etc.) this GUID will always be 36 chars in length! Pad
     * the hexidecimal String to 32 positions with leading '0'
     * 
     * Example: C2FEEEAC-CFCD-11D1-8B05-00600806D9B6
     */
    public String nextFormatedGUID (final boolean secure)
    {
        String md5sum = nextGUID (secure);
        StringBuffer buffer = new StringBuffer (md5sum.toUpperCase ());

        buffer.insert ( 8, '-');
        buffer.insert (13, '-');
        buffer.insert (18, '-');
        buffer.insert (23, '-');

        return buffer.toString ();
    }

    // Private -----------------------------------------------------------------

    /**
     * Method to generate the random GUID
     */

    private String getRandomGUID (final boolean secure)
    {
        try {
            long time = System.currentTimeMillis ();
            long rand = 0;

            if (secure) {
                rand = secureRandom.nextLong ();
            }
            else {
                rand = random.nextLong ();
            }

            // This StringBuffer can be a long as you need; the MD5
            // hash will always return 128 bits. You can change
            // the seed to include anything you want here.
            // You could even stream a file through the MD5 making
            // the odds of guessing it at least as great as that
            // of guessing the contents of the file!
            StringBuffer buffer = new StringBuffer ();
            buffer.append (hostIP);
            buffer.append (':');
            buffer.append (Long.toString (time));
            buffer.append (':');
            buffer.append (Long.toString (rand));

            return CheckSum.calculate ("MD5", buffer.toString ().getBytes (), 32, '0');
        }
        catch (Exception e) {
            throw new RuntimeException ("error while instantiating MD5", e);
        }
    }
}
