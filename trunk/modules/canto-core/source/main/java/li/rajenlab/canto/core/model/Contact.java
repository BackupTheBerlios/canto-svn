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

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Embeddable
public class Contact implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8148973991059629545L;
    
    @Column(name="FIRST_NAME",length=150,nullable=false)
    private String firstName_;
    
    @Column(name="LAST_NAME",length=150,nullable=false)
    private String lastName_;
    
    @Column(name="COMPANY_NAME",length=150)
    private String companyName_;
    
    @Column(name="STREET",length=150,nullable=false)
    private String street_;
    
    @Column(name="STREET_NR",length=10)
    private String streetNr_;
    
    @Column(name="CITY",length=150,nullable=false)
    private String city_;
    
    @Column(name="ZIP",length=20,nullable=false)
    private String zip_;

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
    
    
    

}
