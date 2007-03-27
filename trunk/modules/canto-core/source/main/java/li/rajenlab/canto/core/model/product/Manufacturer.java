/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.product;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.common.Address;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Manufacturer extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 8474343314051249789L;
    private String name_;
    private String code_;
    private Address address_;
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
     * @return the code
     */
    public String getCode() {
        return this.code_;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code_ = code;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    

}
