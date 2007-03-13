/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.dao.product;

import java.util.List;

import li.rajenlab.canto.framework.domain.product.ChannelPackage;
import li.rajenlab.canto.framework.domain.product.ChannelPackageStatus;
import li.rajenlab.canto.framework.domain.product.ChannelPackageType;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ChannelPackageDaoHibernateImpl extends
        AbstractSimpleDaoHibernateImpl<ChannelPackage> implements ChannelPackageDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(ChannelPackageDaoHibernateImpl.class);

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
    public Class<ChannelPackage> getEntityClass() {
        return ChannelPackage.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "uid";
    }

    /**
     * @see li.rajenlab.canto.framework.dao.product.ChannelPackageDao#getChannelPackageByUid(java.lang.String)
     */
    public ChannelPackage getChannelPackageByUid(String uid)
            throws EntityNotFoundException {
        return load(uid);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.product.ChannelPackageDao#getChannelPackagesByType(li.rajenlab.canto.framework.domain.product.ChannelPackageType)
     */
    @SuppressWarnings("unchecked")
    public List<ChannelPackage> getChannelPackagesByType(ChannelPackageType type) {
        
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("channelPackageType",type));
        
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.product.ChannelPackageDao#getChannelpackagesByStatus(li.rajenlab.canto.framework.domain.product.ChannelPackageStatus)
     */
    @SuppressWarnings("unchecked")
    public List<ChannelPackage> getChannelPackagesByStatus(ChannelPackageStatus status) {
        
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("channelPackageStatus",status));
        
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
