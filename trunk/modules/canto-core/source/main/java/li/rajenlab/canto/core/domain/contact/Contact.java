/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.contact;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Contact extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2382024781391186486L;
    
    private ContactType contactType_;
    private String companyName_;
    private String firstName_;
    private String lastName_;
    private String salutation_;
    private String street_;
    private String streetNr_;
    private String pobox_;
    private String emailAddress_;
    private String mainPhoneNumber_;
    private String faxPhoneNumber_;
    private String directPhoneNumber_;
    private String mobilePhoneNumber_;
    private boolean active_;
    private String countryISOCode_;
    
    /**
     * @return the active
     */
    public boolean isActive() {
        return this.active_;
    }
    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active_ = active;
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
     * @return the contactType
     */
    public ContactType getContactType() {
        return this.contactType_;
    }
    /**
     * @param contactType the contactType to set
     */
    public void setContactType(ContactType contactType) {
        this.contactType_ = contactType;
    }
    /**
     * @return the directPhoneNumber
     */
    public String getDirectPhoneNumber() {
        return this.directPhoneNumber_;
    }
    /**
     * @param directPhoneNumber the directPhoneNumber to set
     */
    public void setDirectPhoneNumber(String directPhoneNumber) {
        this.directPhoneNumber_ = directPhoneNumber;
    }
    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return this.emailAddress_;
    }
    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress_ = emailAddress;
    }
    /**
     * @return the faxPhoneNumber
     */
    public String getFaxPhoneNumber() {
        return this.faxPhoneNumber_;
    }
    /**
     * @param faxPhoneNumber the faxPhoneNumber to set
     */
    public void setFaxPhoneNumber(String faxPhoneNumber) {
        this.faxPhoneNumber_ = faxPhoneNumber;
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
     * @return the mainPhoneNumber
     */
    public String getMainPhoneNumber() {
        return this.mainPhoneNumber_;
    }
    /**
     * @param mainPhoneNumber the mainPhoneNumber to set
     */
    public void setMainPhoneNumber(String mainPhoneNumber) {
        this.mainPhoneNumber_ = mainPhoneNumber;
    }
    /**
     * @return the mobilePhoneNumber
     */
    public String getMobilePhoneNumber() {
        return this.mobilePhoneNumber_;
    }
    /**
     * @param mobilePhoneNumber the mobilePhoneNumber to set
     */
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber_ = mobilePhoneNumber;
    }
    /**
     * @return the pobox
     */
    public String getPobox() {
        return this.pobox_;
    }
    /**
     * @param pobox the pobox to set
     */
    public void setPobox(String pobox) {
        this.pobox_ = pobox;
    }
    /**
     * @return the salutation
     */
    public String getSalutation() {
        return this.salutation_;
    }
    /**
     * @param salutation the salutation to set
     */
    public void setSalutation(String salutation) {
        this.salutation_ = salutation;
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
     * @return the countryISOCode
     */
    public String getCountryISOCode() {
        return this.countryISOCode_;
    }
    /**
     * @param countryISOCode the countryISOCode to set
     */
    public void setCountryISOCode(String countryISOCode) {
        this.countryISOCode_ = countryISOCode;
    }
    
    
    

}
