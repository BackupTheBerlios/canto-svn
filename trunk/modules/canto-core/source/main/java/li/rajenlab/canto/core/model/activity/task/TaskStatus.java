/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.activity.task;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="TaskStatus")
@DiscriminatorValue("TaskStatus")
public class TaskStatus extends EnumEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 8948384846491739645L;

}
