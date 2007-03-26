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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="ACCOUNT_TYPE")
@AttributeOverrides({@AttributeOverride(name="id_", column = @Column(name = "ACCOUNT_TYPE_ID")),@AttributeOverride(name="name_", column = @Column(name = "ACCOUNT_TYPE_NAME"))})
public class AccountType extends EnumEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4098688669963268757L;

   
    
    

}
