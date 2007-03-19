/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.crm;

import java.util.List;

import li.rajenlab.canto.core.domain.crm.Contact;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ContactDao extends SimpleDao<Contact> {
    
    
    public List<Contact> getContactsByEmail(String email);
    
    
    public List<Contact> getContactsByName(String firstName, String lastName);
    
    

}
