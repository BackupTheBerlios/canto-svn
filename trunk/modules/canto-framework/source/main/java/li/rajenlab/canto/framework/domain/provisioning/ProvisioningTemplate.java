/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.provisioning;

import java.util.List;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProvisioningTemplate extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 6380074452451117335L;
    
    private String name_; // has to be unique
    private List<ProvisioningStep> steps_;


      /**
     * @return the steps
     */
    public List<ProvisioningStep> getSteps() {
        return this.steps_;
    }


    /**
     * @param steps the steps to set
     */
    public void setSteps(List<ProvisioningStep> steps) {
        this.steps_ = steps;
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
