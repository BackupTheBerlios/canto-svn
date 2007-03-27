/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.activity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="ActivityDirection")
@DiscriminatorValue("ActivityDirection")
public class ActivityDirection extends EnumEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5013136088938421860L;

}
