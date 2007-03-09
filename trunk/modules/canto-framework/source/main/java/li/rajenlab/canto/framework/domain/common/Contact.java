/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.common;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Contact implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 656611005027644430L;
    private String firstName_;
    private String lastName_;
    private String company_;
    private String mainPhoneNumber_;
    private String mobilePhoneNumber_;
    private String emailAddress_;
    private String zip_;
    private String Street_;
    private String StreetNr_;
    private String StreetAdditionnal_;
    private String city_;
    private String countryISO_;
    
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
     * @return the company
     */
    public String getCompany() {
        return this.company_;
    }
    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company_ = company;
    }
    /**
     * @return the countryISO
     */
    public String getCountryISO() {
        return this.countryISO_;
    }
    /**
     * @param countryISO the countryISO to set
     */
    public void setCountryISO(String countryISO) {
        this.countryISO_ = countryISO;
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
     * @return the street
     */
    public String getStreet() {
        return this.Street_;
    }
    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.Street_ = street;
    }
    /**
     * @return the streetAdditionnal
     */
    public String getStreetAdditionnal() {
        return this.StreetAdditionnal_;
    }
    /**
     * @param streetAdditionnal the streetAdditionnal to set
     */
    public void setStreetAdditionnal(String streetAdditionnal) {
        this.StreetAdditionnal_ = streetAdditionnal;
    }
    /**
     * @return the streetNr
     */
    public String getStreetNr() {
        return this.StreetNr_;
    }
    /**
     * @param streetNr the streetNr to set
     */
    public void setStreetNr(String streetNr) {
        this.StreetNr_ = streetNr;
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
