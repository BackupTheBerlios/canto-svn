/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.employee;

import java.util.List;

import li.rajenlab.canto.core.domain.company.Property;
import li.rajenlab.canto.core.domain.company.Team;
import li.rajenlab.canto.core.domain.company.Workingplace;
import li.rajenlab.canto.core.domain.job.Job;
import li.rajenlab.canto.core.domain.salary.FinancialInstitut;
import li.rajenlab.canto.core.domain.salary.Salary;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Employee extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 7023555569802259990L;
    
    private String employeeCode_;
    private String firstName_;
    private String lastName_;
    private String street_;
    private String streetNr_;
    private String zip_;
    private String city_;
    private String homePhoneNumber_;
    private String homeMobileNumber_;
    private String homeEmailAddress_;
    private String companyPhoneNumber_;
    private String companyMobileNumber_;
    private String companyEmailAddress_;
    private String socialNumber_;
    
    private EmployeeType type_;
    private Job job_;
    private Salary fixSalary_;
    private Team team_;
    private Workingplace workingplace_;
    private EmployeeStatus status_;
    private int pensum_;
    private List<Property> companyProperty_;
    private FinancialInstitut currentFinancialInstitut_;
   
    /**
     * @return the city
     */
    public String getCity() {
        return this.city_;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city_ = city;
    }
    /**
     * @return the companyEmailAddress
     */
    public String getCompanyEmailAddress() {
        return this.companyEmailAddress_;
    }
    /**
     * @param companyEmailAddress the companyEmailAddress to set
     */
    public void setCompanyEmailAddress(String companyEmailAddress) {
        this.companyEmailAddress_ = companyEmailAddress;
    }
    /**
     * @return the companyMobileNumber
     */
    public String getCompanyMobileNumber() {
        return this.companyMobileNumber_;
    }
    /**
     * @param companyMobileNumber the companyMobileNumber to set
     */
    public void setCompanyMobileNumber(String companyMobileNumber) {
        this.companyMobileNumber_ = companyMobileNumber;
    }
    /**
     * @return the companyPhoneNumber
     */
    public String getCompanyPhoneNumber() {
        return this.companyPhoneNumber_;
    }
    /**
     * @param companyPhoneNumber the companyPhoneNumber to set
     */
    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber_ = companyPhoneNumber;
    }
    /**
     * @return the employeeCode
     */
    public String getEmployeeCode() {
        return this.employeeCode_;
    }
    /**
     * @param employeeCode the employeeCode to set
     */
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode_ = employeeCode;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName_;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName_ = firstName;
    }
    /**
     * @return the fixSalary
     */
    public Salary getFixSalary() {
        return this.fixSalary_;
    }
    /**
     * @param fixSalary the fixSalary to set
     */
    public void setFixSalary(Salary fixSalary) {
        this.fixSalary_ = fixSalary;
    }
    /**
     * @return the homeEmailAddress
     */
    public String getHomeEmailAddress() {
        return this.homeEmailAddress_;
    }
    /**
     * @param homeEmailAddress the homeEmailAddress to set
     */
    public void setHomeEmailAddress(String homeEmailAddress) {
        this.homeEmailAddress_ = homeEmailAddress;
    }
    /**
     * @return the homeMobileNumber
     */
    public String getHomeMobileNumber() {
        return this.homeMobileNumber_;
    }
    /**
     * @param homeMobileNumber the homeMobileNumber to set
     */
    public void setHomeMobileNumber(String homeMobileNumber) {
        this.homeMobileNumber_ = homeMobileNumber;
    }
    /**
     * @return the homePhoneNumber
     */
    public String getHomePhoneNumber() {
        return this.homePhoneNumber_;
    }
    /**
     * @param homePhoneNumber the homePhoneNumber to set
     */
    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber_ = homePhoneNumber;
    }
   
    /**
     * @return the job
     */
    public Job getJob() {
        return this.job_;
    }
    /**
     * @param job the job to set
     */
    public void setJob(Job job) {
        this.job_ = job;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName_;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName_ = lastName;
    }
   
    /**
     * @return the socialNumber
     */
    public String getSocialNumber() {
        return this.socialNumber_;
    }
    /**
     * @param socialNumber the socialNumber to set
     */
    public void setSocialNumber(String socialNumber) {
        this.socialNumber_ = socialNumber;
    }
    /**
     * @return the street
     */
    public String getStreet() {
        return this.street_;
    }
    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street_ = street;
    }
    /**
     * @return the streetNr
     */
    public String getStreetNr() {
        return this.streetNr_;
    }
    /**
     * @param streetNr the streetNr to set
     */
    public void setStreetNr(String streetNr) {
        this.streetNr_ = streetNr;
    }
    /**
     * @return the type
     */
    public EmployeeType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(EmployeeType type) {
        this.type_ = type;
    }
    /**
     * @return the zip
     */
    public String getZip() {
        return this.zip_;
    }
    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip_ = zip;
    }
    /**
     * @return the pensum
     */
    public int getPensum() {
        return this.pensum_;
    }
    /**
     * @param pensum the pensum to set
     */
    public void setPensum(int pensum) {
        this.pensum_ = pensum;
    }
    /**
     * @return the status
     */
    public EmployeeStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(EmployeeStatus status) {
        this.status_ = status;
    }
    /**
     * @return the team
     */
    public Team getTeam() {
        return this.team_;
    }
    /**
     * @param team the team to set
     */
    public void setTeam(Team team) {
        this.team_ = team;
    }
    /**
     * @return the workingplace
     */
    public Workingplace getWorkingplace() {
        return this.workingplace_;
    }
    /**
     * @param workingplace the workingplace to set
     */
    public void setWorkingplace(Workingplace workingplace) {
        this.workingplace_ = workingplace;
    }
    /**
     * @return the companyProperty
     */
    public List<Property> getCompanyProperty() {
        return this.companyProperty_;
    }
    /**
     * @param companyProperty the companyProperty to set
     */
    public void setCompanyProperty(List<Property> companyProperty) {
        this.companyProperty_ = companyProperty;
    }
    /**
     * @return the currentFinancialInstitut
     */
    public FinancialInstitut getCurrentFinancialInstitut() {
        return this.currentFinancialInstitut_;
    }
    /**
     * @param currentFinancialInstitut the currentFinancialInstitut to set
     */
    public void setCurrentFinancialInstitut(
            FinancialInstitut currentFinancialInstitut) {
        this.currentFinancialInstitut_ = currentFinancialInstitut;
    }
    
    
    

}
