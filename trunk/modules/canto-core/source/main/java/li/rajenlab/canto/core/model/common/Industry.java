/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.common;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Industry implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3267750108572881037L;
    private int id_;
    private String industry_;
    
    /**
     * @return the id
     */
    public int getId() {
        return this.id_;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id_ = id;
    }
    /**
     * @return the industry
     */
    public String getIndustry() {
        return this.industry_;
    }
    /**
     * @param industry the industry to set
     */
    public void setIndustry(String industry) {
        this.industry_ = industry;
    }
    
    

}
