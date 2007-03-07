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

import java.util.HashMap;
import java.util.Map;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class ContextImpl implements Context {
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------

    private boolean isDryRun_;
    private Map<String,Object> properties_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------
    
    public ContextImpl() {
        properties_ = new HashMap<String,Object>();
    }
    
    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    public boolean isDryRun() {
        return isDryRun_;
    }
    
    public void setDryRun(boolean isDryRun) {
        this.isDryRun_ = isDryRun;
    }
    
    @SuppressWarnings("unchecked")
    public void setProperty(String key, Object value) {
        properties_.put(key,value);
    }
    
    public Object getProperty(String key) {
        return properties_.get(key);
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
}
