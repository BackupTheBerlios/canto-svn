/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.oppportunity;

import li.rajenlab.canto.core.model.EnumEntity;
import javax.persistence.Entity;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.Table;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="OPPORTUNITY_TYPE")
public class OpportunityType extends EnumEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2215275440033991622L;

}
