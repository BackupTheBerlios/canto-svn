/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.company;

import java.util.List;
import java.util.Vector;

import li.rajenlab.canto.core.domain.employee.Employee;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Team extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 8141916523011024756L;
    private String code_;
    private Department department_;
    private Employee manager_;
    private Employee hrManager_;
    private List<Employee> members_;
    /**
     * @return the department
     */
    public Department getDepartment() {
        return this.department_;
    }
    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department_ = department;
    }
    /**
     * @return the hrManager
     */
    public Employee getHrManager() {
        return this.hrManager_;
    }
    /**
     * @param hrManager the hrManager to set
     */
    public void setHrManager(Employee hrManager) {
        this.hrManager_ = hrManager;
    }
    /**
     * @return the manager
     */
    public Employee getManager() {
        return this.manager_;
    }
    /**
     * @param manager the manager to set
     */
    public void setManager(Employee manager) {
        this.manager_ = manager;
    }
    /**
     * @return the members
     */
    public List<Employee> getMembers() {
        return this.members_;
    }
    /**
     * @param members the members to set
     */
    public void setMembers(List<Employee> members) {
        this.members_ = members;
    }
    
    public synchronized void addMember(Employee member){
        if (getMembers()==null){
            members_ = new Vector<Employee>();
        }
        members_.add(member);
    }
    
    public synchronized void removeMember(Employee member){
        members_.remove(member);
    }
}
