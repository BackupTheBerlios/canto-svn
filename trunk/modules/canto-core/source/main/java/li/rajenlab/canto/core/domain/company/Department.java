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
public class Department extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -6681234549810462631L;
    private String name_;
    private String code_;
    private Department parent_;
    private List<Team> teams_;
    private Employee manager_;
  
    
    /**
     * @return the code
     */
    public String getCode() {
        return this.code_;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code_ = code;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    /**
     * @return the parent
     */
    public Department getParent() {
        return this.parent_;
    }
    /**
     * @param parent the parent to set
     */
    public void setParent(Department parent) {
        this.parent_ = parent;
    }
    /**
     * @return the teams
     */
    public List<Team> getTeams() {
        return this.teams_;
    }
    /**
     * @param teams the teams to set
     */
    public void setTeams(List<Team> teams) {
        this.teams_ = teams;
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
     * Add team to department
     * @param team
     */
    public synchronized void addTeam(Team team){
        if (getTeams()==null){
            teams_ = new Vector<Team>();
        }
        teams_.add(team);
    }
    
    public synchronized void removeTeam(Team team){
        if (getTeams()!=null){
            teams_.remove(team);
        }
    }

}
