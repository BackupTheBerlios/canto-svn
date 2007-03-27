/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.leads;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="LeadStatus")
@DiscriminatorValue("LeadStatus")
public class LeadStatus extends EnumEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4280543990949953954L;

}
