/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-conference
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.conference.domain.conference;

import li.rajenlab.canto.core.domain.AbstractEventEntity;

/**
 * A conference is an online "event" where the communication is one-to-many. The
 * organizer/moderator interacts while the participant are only taking part to 
 * the conference as "viewer", they can not influence the lifecycle of the conference
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Conference extends AbstractEventEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1365012739962767504L;

}
