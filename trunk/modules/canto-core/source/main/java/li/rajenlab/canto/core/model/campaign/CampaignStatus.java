/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.campaign;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="CampaignStatus")
@DiscriminatorValue("CampaignStatus")
public class CampaignStatus extends EnumEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1418361241552446362L;

}
