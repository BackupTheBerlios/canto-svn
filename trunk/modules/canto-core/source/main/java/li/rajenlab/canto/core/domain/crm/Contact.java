/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.crm;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Contact extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 7789694797339282442L;
    private String firstName_;
    private String lastName_;
    private String companyName_;
    private String street_;
    private String streetNr_;
    private String pobox_;
    private String city_;
    private String zip_;
    private String email_;
    private String phoneNumber_;
    private String directPhoneNumber_;
    private String mobilePhoneNumber_;
    private String faxNumber_;
    private Language language_;
    private Salutation salutation_;
    
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
     * @return the faxNumber
     */
    public String getFaxNumber() {
        return this.faxNumber_;
    }
    /**
     * @param faxNumber the faxNumber to set
     */
    public void setFaxNumber(String faxNumber) {
        this.faxNumber_ = faxNumber;
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
     * @return the salutation
     */
    public Salutation getSalutation() {
        return this.salutation_;
    }
    /**
     * @param salutation the salutation to set
     */
    public void setSalutation(Salutation salutation) {
        this.salutation_ = salutation;
    }
    
    
}
