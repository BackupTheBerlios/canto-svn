/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.salary;

import li.rajenlab.canto.core.domain.employee.Employee;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class FinancialInstitut extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3744256053270918545L;
    
    private String name_;
    private String address_;
    private String clearingNr_;
    private String accountNr_;
    private String financialInstituAccountNr_;
    private String ibanNr_;
    private Employee employee_;
    
    /**
     * @return the accountNr
     */
    public String getAccountNr() {
        return this.accountNr_;
    }
    /**
     * @param accountNr the accountNr to set
     */
    public void setAccountNr(String accountNr) {
        this.accountNr_ = accountNr;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return this.address_;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address_ = address;
    }
    /**
     * @return the clearingNr
     */
    public String getClearingNr() {
        return this.clearingNr_;
    }
    /**
     * @param clearingNr the clearingNr to set
     */
    public void setClearingNr(String clearingNr) {
        this.clearingNr_ = clearingNr;
    }
    /**
     * @return the financialInstituAccountNr
     */
    public String getFinancialInstituAccountNr() {
        return this.financialInstituAccountNr_;
    }
    /**
     * @param financialInstituAccountNr the financialInstituAccountNr to set
     */
    public void setFinancialInstituAccountNr(String financialInstituAccountNr) {
        this.financialInstituAccountNr_ = financialInstituAccountNr;
    }
    /**
     * @return the ibanNr
     */
    public String getIbanNr() {
        return this.ibanNr_;
    }
    /**
     * @param ibanNr the ibanNr to set
     */
    public void setIbanNr(String ibanNr) {
        this.ibanNr_ = ibanNr;
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
     * @return the employee
     */
    public Employee getEmployee() {
        return this.employee_;
    }
    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee_ = employee;
    }
    
    

}
