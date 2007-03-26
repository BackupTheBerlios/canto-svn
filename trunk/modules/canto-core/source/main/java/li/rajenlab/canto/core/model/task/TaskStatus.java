/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.task;

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
@Table(name="TASK_STATUS")
public class TaskStatus extends EnumEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5467035685078407349L;
    
}
