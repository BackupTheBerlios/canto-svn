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

import java.util.Date;

import li.rajenlab.canto.core.domain.employee.Employee;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SalaryPayment extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5338259851828049908L;
    
    private Employee employee_;
    private Date     paymentDate_;
    private Salary   salary_;
    private FinancialInstitut financialInstitut_;
    
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
    /**
     * @return the paymentDate
     */
    public Date getPaymentDate() {
        return this.paymentDate_;
    }
    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate_ = paymentDate;
    }
    /**
     * @return the salary
     */
    public Salary getSalary() {
        return this.salary_;
    }
    /**
     * @param salary the salary to set
     */
    public void setSalary(Salary salary) {
        this.salary_ = salary;
    }
    /**
     * @return the financialInstitut
     */
    public FinancialInstitut getFinancialInstitut() {
        return this.financialInstitut_;
    }
    /**
     * @param financialInstitut the financialInstitut to set
     */
    public void setFinancialInstitut(FinancialInstitut financialInstitut) {
        this.financialInstitut_ = financialInstitut;
    }
    
    

}
