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

import javax.persistence.Embeddable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Embeddable
public class Address implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4747846292442336135L;
    private String street_;
    private String streetNr_;
    private String poBox_;
    private String city_;
    private String state_;
    private String country_;
    private String postalcode_;
    
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
     * @return the country
     */
    public String getCountry() {
        return this.country_;
    }
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country_ = country;
    }
    /**
     * @return the poBox
     */
    public String getPoBox() {
        return this.poBox_;
    }
    /**
     * @param poBox the poBox to set
     */
    public void setPoBox(String poBox) {
        this.poBox_ = poBox;
    }
    /**
     * @return the postalcode
     */
    public String getPostalcode() {
        return this.postalcode_;
    }
    /**
     * @param postalcode the postalcode to set
     */
    public void setPostalcode(String postalcode) {
        this.postalcode_ = postalcode;
    }
    /**
     * @return the state
     */
    public String getState() {
        return this.state_;
    }
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state_ = state;
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
    
    


}
