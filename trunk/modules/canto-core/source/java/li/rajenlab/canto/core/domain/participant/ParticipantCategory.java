/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.participant;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * Representation of a participant category such as exhibitors, visitors,
 * speaker
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class ParticipantCategory extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 6108115844629411317L;
    
    private String name_;
    private Boolean system_;

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
     * @return the system
     */
    public Boolean getSystem() {
        return this.system_;
    }

    /**
     * @param system the system to set
     */
    public void setSystem(Boolean system) {
        this.system_ = system;
    }
    
    
    

}
