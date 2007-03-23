/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.job;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Pensum implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 6711636091250378289L;
    
    private String code_;
    private String name_;
    
    /**
     * @return the code
     */
    public String getCode() {
        return this.code_;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code_ = code;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    
    

}
