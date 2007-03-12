/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.support;

import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.common.support.validation.ValidationException;
import li.rajenlab.common.support.validation.Validator;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderValidator implements Validator<Order> {

    /**
     * @see li.rajenlab.common.support.validation.Validator#validate(java.lang.Object)
     */
    public void validate(Order order) throws ValidationException {
        ValidationException validationException = new ValidationException(order,"order");
        if (order.getOrderItems()== null || order.getOrderItems().isEmpty()){
            validationException.rejectValue("orderItems", "orderItems.required");
        }
        if (validationException.hasErrors()){
            throw validationException;
        }

    }

}
