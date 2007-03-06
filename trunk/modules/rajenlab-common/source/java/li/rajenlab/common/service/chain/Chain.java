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

package li.rajenlab.common.service.chain;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface Chain {
    
    /**
     * main chain invocation method. this method invokes the actual chain 
     * @param context the chain context that is handed through each handler
     * @throws ChainException if the chain execution comes to a halt because
     * a handler has thrown an exception.
     */
    public void invoke(Context context) throws ChainException;
}
