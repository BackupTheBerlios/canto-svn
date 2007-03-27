/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.organization;

import li.rajenlab.canto.core.model.BeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Organization extends BeanEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5285002059717085923L;
    
    private String name_;
    private Region region_;
    
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
    /**
     * @return the region
     */
    public Region getRegion() {
        return this.region_;
    }
    /**
     * @param region the region to set
     */
    public void setRegion(Region region) {
        this.region_ = region;
    }
      

}
