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

package li.rajenlab.common.service.event.chain;

import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.service.chain.ChainException;



/**
 * An EventChainInvoker dispatches an Event ( wrapped in an EventChainContext )
 * down a Chain.
 * 
 * @see li.rajenlab.common.service.event.chain.EventChainHandlerImpl
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface EventChainInvoker {

    /**
     * invokes the chain takes care of construction the chain context.
     * @throws ChainException this exception will cause the chain to stop executing
     */
    public void invokeChain(Event event) throws ChainException;
    
}
