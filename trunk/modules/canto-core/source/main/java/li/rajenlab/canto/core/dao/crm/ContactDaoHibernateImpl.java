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
public class ContactDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Contact>
        implements ContactDao {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(ContactDaoHibernateImpl.class);

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
    public Class<Contact> getEntityClass() {
        return Contact.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "id";
    }

    /**
     * @see li.rajenlab.canto.core.dao.crm.ContactDao#getContactsByEmail(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Contact> getContactsByEmail(String email) {
        if (!StringUtils.hasText(email)){
            return Collections.emptyList();
        }
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("email",email));
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.core.dao.crm.ContactDao#getContactsByName(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Contact> getContactsByName(String firstName, String lastName) {
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
