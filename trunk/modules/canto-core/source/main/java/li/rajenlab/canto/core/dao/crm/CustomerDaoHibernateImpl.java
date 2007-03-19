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

import java.util.Collections;
import java.util.List;

import li.rajenlab.canto.core.domain.crm.Contact;
import li.rajenlab.canto.core.domain.crm.Customer;
import li.rajenlab.canto.core.domain.crm.Organization;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class CustomerDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Customer>
        implements CustomerDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(CustomerDaoHibernateImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "ouid";
    }

    /**
     * @see li.rajenlab.canto.core.dao.crm.CustomerDao#getCustomerByLegalContact(li.rajenlab.canto.core.domain.crm.Contact)
     */
    @SuppressWarnings("unchecked")
    public Customer getCustomerByLegalContact(Contact legalContact)
            throws EntityNotFoundException {
        
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("legalContact",legalContact));
        
        List<Customer> customers = getHibernateTemplate().findByCriteria(criteria);
        if (customers==null || customers.isEmpty() || customers.size() > 1){
            throw new EntityNotFoundException("For legalContact " + legalContact 
                    + ", no customer found");
        }
        return customers.get(0);
        
    }

    /**
     * @see li.rajenlab.canto.core.dao.crm.CustomerDao#getCustomerByOuid(java.lang.String)
     */
    public Customer getCustomerByOuid(String ouid)
            throws EntityNotFoundException {
        return load(ouid);
    }

    /**
     * @see li.rajenlab.canto.core.dao.crm.CustomerDao#getCustomersByLegalFirstAndLastName(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Customer> getCustomersByLegalFirstAndLastName(String firstName,
            String lastName) {
        if (!StringUtils.hasText(firstName) && !StringUtils.hasText(lastName)){
            return Collections.emptyList();
        }
        DetachedCriteria criteria = getDetachedCriteria();
        if (StringUtils.hasText(firstName)){
            criteria.add(Restrictions.eq("firstName",firstName));
        }
        if (StringUtils.hasText(lastName)){
            criteria.add(Restrictions.eq("lastName",lastName));
        }
        
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.core.dao.crm.CustomerDao#getCustomersByOrganisation(li.rajenlab.canto.core.domain.crm.Organization)
     */
    @SuppressWarnings("unchecked")
    public List<Customer> getCustomersByOrganisation(Organization orgranization) {
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("organization",orgranization));
        
       return getHibernateTemplate().findByCriteria(criteria);
    }

    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
   
   }
