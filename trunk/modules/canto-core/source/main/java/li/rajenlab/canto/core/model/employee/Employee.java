/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.employee;

import li.rajenlab.canto.core.model.Entity;
import li.rajenlab.canto.core.model.common.Address;
import li.rajenlab.canto.core.model.common.MessengerType;
import li.rajenlab.common.domain.security.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Employee extends Entity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1894657874532120935L;
    private User user_;
    private String firstName_;
    private String lastName_;
    private String title_;
    private String department_;
    private Employee reportsTo_;
    private String phoneHome_;
    private String phoneMobile_;
    private String phoneOffice_;
    private String phoneFax_;
    private String email_;
    private Address address_;
    private EmployeeStatus status_;
    private String messagenrId_;
    private MessengerType messengerType_;
    
    /**
     * @return the address
     */
    public Address getAddress() {
        return this.address_;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address_ = address;
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
     * @return the messagenrId
     */
    public String getMessagenrId() {
        return this.messagenrId_;
    }
    /**
     * @param messagenrId the messagenrId to set
     */
    public void setMessagenrId(String messagenrId) {
        this.messagenrId_ = messagenrId;
    }
    /**
     * @return the messengerType
     */
    public MessengerType getMessengerType() {
        return this.messengerType_;
    }
    /**
     * @param messengerType the messengerType to set
     */
    public void setMessengerType(MessengerType messengerType) {
        this.messengerType_ = messengerType;
    }
    /**
     * @return the phoneFax
     */
    public String getPhoneFax() {
        return this.phoneFax_;
    }
    /**
     * @param phoneFax the phoneFax to set
     */
    public void setPhoneFax(String phoneFax) {
        this.phoneFax_ = phoneFax;
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
     * @return the reportsTo
     */
    public Employee getReportsTo() {
        return this.reportsTo_;
    }
    /**
     * @param reportsTo the reportsTo to set
     */
    public void setReportsTo(Employee reportsTo) {
        this.reportsTo_ = reportsTo;
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
     * @return the title
     */
    public String getTitle() {
        return this.title_;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title_ = title;
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
