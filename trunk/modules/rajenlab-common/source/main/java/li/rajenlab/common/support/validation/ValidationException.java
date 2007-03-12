/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.support.validation;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.util.Assert;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ValidationException extends Exception {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3872410698936375302L;
    private Object target_;
    private String objectName_;
    
    private Map<String,String> validationResult_;
    
    public ValidationException(Object target, String objectName){
        Assert.notNull(target, "Target object must not be null");
        this.target_ = target;
        this.objectName_ = objectName;
        this.validationResult_ = new Hashtable<String,String>();
    }
    
    
    public void rejectValue(String field, String errorCode){
        this.validationResult_.put(field, errorCode);
    }


    /**
     * @return the objectName
     */
    public String getObjectName() {
        return this.objectName_;
    }


    /**
     * @return the target
     */
    public Object getTarget() {
        return this.target_;
    }

    /**
     * @return the validationResult
     */
    public Map<String, String> getValidationResult() {
        return this.validationResult_;
    }
    
    
    public boolean hasErrors(){
        return validationResult_!=null && !validationResult_.isEmpty();
    }
    
}
