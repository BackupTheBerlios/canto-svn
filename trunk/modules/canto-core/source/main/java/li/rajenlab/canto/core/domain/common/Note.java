/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.common;

import java.io.Serializable;
import java.util.Date;

import li.rajenlab.common.domain.security.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Note implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 7683640486955484312L;
    private String message_;
    private Date noteDate_;
    private User user_;
    /**
     * @return the message
     */
    public String getMessage() {
        return this.message_;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message_ = message;
    }
    /**
     * @return the noteDate
     */
    public Date getNoteDate() {
        return this.noteDate_;
    }
    /**
     * @param noteDate the noteDate to set
     */
    public void setNoteDate(Date noteDate) {
        this.noteDate_ = noteDate;
    }
    /**
     * @return the user
     */
    public User getUser() {
        return this.user_;
    }
    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user_ = user;
    }
    
    
    

}
