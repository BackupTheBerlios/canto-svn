/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.account;

import li.rajenlab.canto.core.model.EnumEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="AccountStatus")
@DiscriminatorValue("AccountStatus")
public class AccountStatus extends EnumEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 6657079409920641138L;

}
