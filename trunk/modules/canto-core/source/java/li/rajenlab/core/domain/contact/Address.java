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

package li.rajenlab.core.domain.contact;

import java.io.Serializable;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Address implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2695786729822979763L;
    
    private String street_;
    private String streetNr_;
    private String zip_;
    private String city_;
    private String ISOCountry_;
    private String poBox_;
    
    
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
     * @return the iSOCountry
     */
    public String getISOCountry() {
        return this.ISOCountry_;
    }
    /**
     * @param country the iSOCountry to set
     */
    public void setISOCountry(String country) {
        this.ISOCountry_ = country;
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
