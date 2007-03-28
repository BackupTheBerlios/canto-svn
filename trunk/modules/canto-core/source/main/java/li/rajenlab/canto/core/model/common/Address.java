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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import li.rajenlab.canto.core.model.BeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="ADDRESS")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Address extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4747846292442336135L;
    
    @Column(name="STREET", nullable=false, length=150)
    private String street_;
    
    @Column(name="STREET_NR",length=5)
    private String streetNr_;
    
    @Column(name="PO_BOX",length=20)
    private String poBox_;
    
    @Column(name="CITY",length=150)
    private String city_;
    
    @Column(name="STATE",length=100)
    private String state_;
    
    @Column(name="COUNTRY",length=3)
    private String country_;
    
    @Column(name="ZIP",length=10)
    private String postalcode_;
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id_;
    
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
    /**
     * @return the id
     */
    public String getId() {
        return this.id_;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id_ = id;
    }
    
    


}
