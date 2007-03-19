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
import li.rajenlab.canto.core.domain.crm.Customer;
import li.rajenlab.canto.core.domain.crm.Organization;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface CustomerDao extends SimpleDao<Customer> {
    
    
    public List<Customer> getCustomersByOrganisation(Organization orgranization);
    
    
    public List<Customer> getCustomersByLegalFirstAndLastName(String firstName, String lastName);
    
    
    public Customer getCustomerByLegalContact(Contact legalContact) throws EntityNotFoundException;
    
    
    public Customer getCustomerByOuid(String ouid) throws EntityNotFoundException;

}
