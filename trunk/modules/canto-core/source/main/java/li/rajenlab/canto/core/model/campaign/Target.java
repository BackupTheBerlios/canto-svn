/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.campaign;

import java.util.Date;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.common.Address;

/**
 * Targets are stand-alone records that are not attached to Contacts or Leads
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Target extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5039646749333923253L;
    private String firstName_;
    private String lastName_;
    private String companyName_;
    private String department_;
    private String officePhone_;
    private String mobilePhone_;
    private String homePhone_;
    private String fax_;
    private String email_;
    private String emailSecondary_;
    private String assistant_;
    private String assistantPhone_;
    private boolean emailNotShared_; // the lead opted to not share their email address with you
    private boolean invalidEmail_; // If an email address is invalid
    // The lead�s name to the Do Not Call list. 
    // This is to ensure that the lead is not targeted during campaigns.
    private boolean doNotCall_; 
    private Date birthdate_;
    private Address primaryAddress_;
    private Address secondaryAddress_;
    
    /**
     * @return the assistant
     */
    public String getAssistant() {
        return this.assistant_;
    }
    /**
     * @param assistant the assistant to set
     */
    public void setAssistant(String assistant) {
        this.assistant_ = assistant;
    }
    /**
     * @return the assistantPhone
     */
    public String getAssistantPhone() {
        return this.assistantPhone_;
    }
    /**
     * @param assistantPhone the assistantPhone to set
     */
    public void setAssistantPhone(String assistantPhone) {
        this.assistantPhone_ = assistantPhone;
    }
    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return this.birthdate_;
    }
    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate_ = birthdate;
    }
    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return this.companyName_;
    }
    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName_ = companyName;
    }
    /**
     * @return the department
     */
    public String getDepartment() {
        return this.department_;
    }
    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department_ = department;
    }
    /**
     * @return the doNotCall
     */
    public boolean isDoNotCall() {
        return this.doNotCall_;
    }
    /**
     * @param doNotCall the doNotCall to set
     */
    public void setDoNotCall(boolean doNotCall) {
        this.doNotCall_ = doNotCall;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return this.email_;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email_ = email;
    }
    /**
     * @return the emailNotShared
     */
    public boolean isEmailNotShared() {
        return this.emailNotShared_;
    }
    /**
     * @param emailNotShared the emailNotShared to set
     */
    public void setEmailNotShared(boolean emailNotShared) {
        this.emailNotShared_ = emailNotShared;
    }
    /**
     * @return the emailSecondary
     */
    public String getEmailSecondary() {
        return this.emailSecondary_;
    }
    /**
     * @param emailSecondary the emailSecondary to set
     */
    public void setEmailSecondary(String emailSecondary) {
        this.emailSecondary_ = emailSecondary;
    }
    /**
     * @return the fax
     */
    public String getFax() {
        return this.fax_;
    }
    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax_ = fax;
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
     * @return the homePhone
     */
    public String getHomePhone() {
        return this.homePhone_;
    }
    /**
     * @param homePhone the homePhone to set
     */
    public void setHomePhone(String homePhone) {
        this.homePhone_ = homePhone;
    }
    /**
     * @return the invalidEmail
     */
    public boolean isInvalidEmail() {
        return this.invalidEmail_;
    }
    /**
     * @param invalidEmail the invalidEmail to set
     */
    public void setInvalidEmail(boolean invalidEmail) {
        this.invalidEmail_ = invalidEmail;
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
     * @return the mobilePhone
     */
    public String getMobilePhone() {
        return this.mobilePhone_;
    }
    /**
     * @param mobilePhone the mobilePhone to set
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone_ = mobilePhone;
    }
    /**
     * @return the officePhone
     */
    public String getOfficePhone() {
        return this.officePhone_;
    }
    /**
     * @param officePhone the officePhone to set
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone_ = officePhone;
    }
    /**
     * @return the primaryAddress
     */
    public Address getPrimaryAddress() {
        return this.primaryAddress_;
    }
    /**
     * @param primaryAddress the primaryAddress to set
     */
    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress_ = primaryAddress;
    }
    /**
     * @return the secondaryAddress
     */
    public Address getSecondaryAddress() {
        return this.secondaryAddress_;
    }
    /**
     * @param secondaryAddress the secondaryAddress to set
     */
    public void setSecondaryAddress(Address secondaryAddress) {
        this.secondaryAddress_ = secondaryAddress;
    }   
    
    

}