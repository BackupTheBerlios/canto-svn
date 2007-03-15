/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.support.validation;

import org.springframework.validation.BindException;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface Validator<E> {
    
    /**
     * validate
     * @param errors
     * @param object
     */
    public void validate(BindException errors, E object);

}
