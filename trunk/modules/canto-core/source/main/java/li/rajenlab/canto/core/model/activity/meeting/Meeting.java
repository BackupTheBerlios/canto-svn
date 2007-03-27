/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.activity.meeting;

import java.util.List;

import li.rajenlab.canto.core.model.activity.AbstractActivity;
import li.rajenlab.canto.core.model.employee.Employee;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Meeting extends AbstractActivity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7616391196936508688L;
    private String location_;
    private List<Employee> invitees_;
    
    /**
     * @return the invitees
     */
    public List<Employee> getInvitees() {
        return this.invitees_;
    }
    /**
     * @param invitees the invitees to set
     */
    public void setInvitees(List<Employee> invitees) {
        this.invitees_ = invitees;
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return this.location_;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location_ = location;
    }
    
    

}
