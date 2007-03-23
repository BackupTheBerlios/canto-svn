/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Applicant implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1285748369151980445L;
    private String applicantId_;
    private String firstName_;
    private String lastName_;
    private String street_;
    private String streetNr_;
    private String zip_;
    private String city_;
    private String phoneNumber_;
    private String email_;
    private String workingPermit_;
    private String nationnality_;
    
    /**
     * @return the applicantId
     */
    public String getApplicantId() {
        return this.applicantId_;
    }
    /**
     * @param applicantId the applicantId to set
     */
    public void setApplicantId(String applicantId) {
        this.applicantId_ = applicantId;
    }
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
     * @return the nationnality
     */
    public String getNationnality() {
        return this.nationnality_;
    }
    /**
     * @param nationnality the nationnality to set
     */
    public void setNationnality(String nationnality) {
        this.nationnality_ = nationnality;
    }
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber_;
    }
    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber_ = phoneNumber;
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
     * @return the workingPermit
     */
    public String getWorkingPermit() {
        return this.workingPermit_;
    }
    /**
     * @param workingPermit the workingPermit to set
     */
    public void setWorkingPermit(String workingPermit) {
        this.workingPermit_ = workingPermit;
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
    
    

}
