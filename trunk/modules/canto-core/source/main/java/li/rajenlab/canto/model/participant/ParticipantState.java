/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.model.participant;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum ParticipantState {
    
   STATE_NOT_IN_CONFERENCE,
   STATE_JOINING,
   STATE_WAITING_IN_LOBBY,
   STATE_LOADING_CONSOLE,
   STATE_IN_CONFERENCE,
   STATE_IN_CONFERENCE_PRESENTER,
   STATE_IN_CONFERENCE_ATTENDEE,
   STATE_IN_CONFERENCE_ACTIVE_PRESENTER,
   STATE_LEAVING_CONFERENCE,
   STATE_LEFT_CONFERENCE,
   STATE_DENIED_ENTRY,
   STATE_REMOVED_FROM_CONFERENCE;

}
