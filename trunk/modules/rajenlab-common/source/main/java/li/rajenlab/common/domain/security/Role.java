/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.security;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Role extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2198122558827402465L;
    
    private String name_;

    
    
    /**
     * @return the name
     */
    @Override
    public String getName() {
        return this.name_;
    }


    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name_ = name;
    }
    
    
    

}
