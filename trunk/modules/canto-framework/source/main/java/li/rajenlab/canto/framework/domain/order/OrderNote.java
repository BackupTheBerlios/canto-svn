/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.order;

import li.rajenlab.common.domain.AbstractEntity;
import li.rajenlab.common.domain.security.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderNote extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -4756470558081585264L;
    private Order order_;
    private String message_;
    private User   user_;
    
    /**
     * @return the message
     */
    public String getMessage() {
        return this.message_;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message_ = message;
    }
    /**
     * @return the order
     */
    public Order getOrder() {
        return this.order_;
    }
    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order_ = order;
    }
   
    /**
     * @return the user
     */
    public User getUser() {
        return this.user_;
    }
    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user_ = user;
    }
    
    /**
     * System note or not, if user defined it's not a system note
     * @return
     */
    public boolean isSystem(){
        return getUser()!=null ? false : true;
    }
    

}
