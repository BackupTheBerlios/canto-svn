/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.common;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="INDUSTRY")
public class Industry extends EnumEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3267750108572881037L;
    

}