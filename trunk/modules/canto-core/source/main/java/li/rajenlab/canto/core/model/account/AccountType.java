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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="AccountType")
@DiscriminatorValue("AccountType")
public class AccountType extends EnumEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4098688669963268757L;

   
    
    

}
