/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Contact implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 286259193572903913L;
    private Salutation saluation_;
    private Language language_;
    private String firstName_;
    private String lastName_;
    private String companyName_;
    private String department_;
    private Date birthdate_;
    private boolean doNotCall_;
    private String phoneHome_;
    private String phoneOffice_;
    private String phoneMobile_;
    private String phoneOther_;
    private String fax_;
    private String emailPrimary_;
    private String emailSecondary_;
    private Address primaryAddress_;
    private Address alternateAddress_;
    private ContactStatus status_;
    private boolean communicationEmail_;
    private boolean communicationPhone_;
    private boolean communicationPostal_;
    
    /**
     * @return the alternateAddress
     */
    public Address getAlternateAddress() {
        return this.alternateAddress_;
    }
    /**
     * @param alternateAddress the alternateAddress to set
     */
    public void setAlternateAddress(Address alternateAddress) {
        this.alternateAddress_ = alternateAddress;
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
     * @return the communicationEmail
     */
    public boolean isCommunicationEmail() {
        return this.communicationEmail_;
    }
    /**
     * @param communicationEmail the communicationEmail to set
     */
    public void setCommunicationEmail(boolean communicationEmail) {
        this.communicationEmail_ = communicationEmail;
    }
    /**
     * @return the communicationPhone
     */
    public boolean isCommunicationPhone() {
        return this.communicationPhone_;
    }
    /**
     * @param communicationPhone the communicationPhone to set
     */
    public void setCommunicationPhone(boolean communicationPhone) {
        this.communicationPhone_ = communicationPhone;
    }
    /**
     * @return the communicationPostal
     */
    public boolean isCommunicationPostal() {
        return this.communicationPostal_;
    }
    /**
     * @param communicationPostal the communicationPostal to set
     */
    public void setCommunicationPostal(boolean communicationPostal) {
        this.communicationPostal_ = communicationPostal;
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
     * @return the emailPrimary
     */
    public String getEmailPrimary() {
        return this.emailPrimary_;
    }
    /**
     * @param emailPrimary the emailPrimary to set
     */
    public void setEmailPrimary(String emailPrimary) {
        this.emailPrimary_ = emailPrimary;
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
     * @return the language
     */
    public Language getLanguage() {
        return this.language_;
    }
    /**
     * @param language the language to set
     */
    public void setLanguage(Language language) {
        this.language_ = language;
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
     * @return the phoneHome
     */
    public String getPhoneHome() {
        return this.phoneHome_;
    }
    /**
     * @param phoneHome the phoneHome to set
     */
    public void setPhoneHome(String phoneHome) {
        this.phoneHome_ = phoneHome;
    }
    /**
     * @return the phoneMobile
     */
    public String getPhoneMobile() {
        return this.phoneMobile_;
    }
    /**
     * @param phoneMobile the phoneMobile to set
     */
    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile_ = phoneMobile;
    }
    /**
     * @return the phoneOffice
     */
    public String getPhoneOffice() {
        return this.phoneOffice_;
    }
    /**
     * @param phoneOffice the phoneOffice to set
     */
    public void setPhoneOffice(String phoneOffice) {
        this.phoneOffice_ = phoneOffice;
    }
    /**
     * @return the phoneOther
     */
    public String getPhoneOther() {
        return this.phoneOther_;
    }
    /**
     * @param phoneOther the phoneOther to set
     */
    public void setPhoneOther(String phoneOther) {
        this.phoneOther_ = phoneOther;
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
     * @return the saluation
     */
    public Salutation getSaluation() {
        return this.saluation_;
    }
    /**
     * @param saluation the saluation to set
     */
    public void setSaluation(Salutation saluation) {
        this.saluation_ = saluation;
    }
    /**
     * @return the status
     */
    public ContactStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(ContactStatus status) {
        this.status_ = status;
    }
    
    
    

}
