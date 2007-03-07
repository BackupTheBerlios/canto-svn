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

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public enum ContactType implements StringValuedEnum {
    
    
    LEGAL("LEGAL"),
    SHIPPING("SHIPPING"),
    BILLING("BILLING");
    
    
    private String contactType_;
    
    
    private ContactType(String contactType){
        this.contactType_ = contactType;
    }

    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return contactType_;
    }
}
