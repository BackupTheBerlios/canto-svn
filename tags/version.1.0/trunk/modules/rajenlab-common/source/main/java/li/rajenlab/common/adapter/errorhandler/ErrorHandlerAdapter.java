/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.adapter.errorhandler;

import li.rajenlab.common.domain.errorhandler.ErrorEvent;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ErrorHandlerAdapter {
    
    
    public void raiseError(ErrorEvent error);

}
