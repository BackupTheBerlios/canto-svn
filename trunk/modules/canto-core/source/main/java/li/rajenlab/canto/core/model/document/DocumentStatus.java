/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.document;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="DocumentStatus")
@DiscriminatorValue("DocumentStatus")
public class DocumentStatus extends EnumEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5831074630069479142L;
    
    

}
