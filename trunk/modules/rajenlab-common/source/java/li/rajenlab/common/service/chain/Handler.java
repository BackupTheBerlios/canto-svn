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
public interface Handler {

    /**
     * invocation method that is triggered by the chain implementation.
     * @param context the chain context.
     * @throws ChainException if the chain execution should be stopped.
     */
    public void invoke(Context context) throws ChainException;
}
