/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.order;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class InvalidOrderStatusTransitionException extends Exception {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 6293833681006585738L;
    
    public InvalidOrderStatusTransitionException(String message){
        super(message);
    }

}
