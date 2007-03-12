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

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface Validator<E> {
    
    /**
     * Validate an object
     * @param object
     * @throws ValidationException
     */
    public void validate(E object) throws ValidationException;

}
