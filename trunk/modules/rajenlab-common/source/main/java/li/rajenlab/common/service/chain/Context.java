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
 **
 *****************************************************************************/

package li.rajenlab.common.service.chain;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface Context {

    /**
     * indicates whether the current chain execution is a dry run
     * @return boolean true if dry run
     */
    public boolean isDryRun();
    
    /**
     * can hold any object and is made to carrie multiple payloads
     * @param key key to find the payload with
     * @param value payload
     */
    public void setProperty(String key, Object value);
    
    /**
     * retreives a payload
     * @param key key to find the payload with
     * @return payload
     */
    public Object getProperty(String key);
}
