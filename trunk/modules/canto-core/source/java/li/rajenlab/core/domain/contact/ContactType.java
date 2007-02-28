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

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public enum ContactType {
    
    BILLING("billing"),
    SHIPPING("shipping"),
    CONTACT("contact");
    
    private String name_;
    
    private ContactType(String name){
        this.name_ = name;
    }
    
   

}
