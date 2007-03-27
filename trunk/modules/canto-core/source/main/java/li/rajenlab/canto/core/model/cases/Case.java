/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.cases;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;

/**
 * Use the Cases module to track and manage problems 
 * with your services that are reported by your users and customers.
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Case extends BeanEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3134358677233735280L;
    
    private String name_;
    private String description_;
    private CaseStatus status_;
    private CaseType type_;
    private Account account_;
    private String resolution_;
    private String priority_;
    
    /**
     * @return the account
     */
    public Account getAccount() {
        return this.account_;
    }
    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account_ = account;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return this.description_;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description_ = description;
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
     * @return the priority
     */
    public String getPriority() {
        return this.priority_;
    }
    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority_ = priority;
    }
    /**
     * @return the resolution
     */
    public String getResolution() {
        return this.resolution_;
    }
    /**
     * @param resolution the resolution to set
     */
    public void setResolution(String resolution) {
        this.resolution_ = resolution;
    }
    /**
     * @return the status
     */
    public CaseStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(CaseStatus status) {
        this.status_ = status;
    }
    /**
     * @return the type
     */
    public CaseType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(CaseType type) {
        this.type_ = type;
    }
    
    

}
