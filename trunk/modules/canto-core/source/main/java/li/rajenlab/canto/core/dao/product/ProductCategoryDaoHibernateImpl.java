/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.product;

import java.util.List;

import li.rajenlab.canto.core.domain.product.ProductCategory;
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
public class ProductCategoryDaoHibernateImpl extends
        AbstractSimpleDaoHibernateImpl<ProductCategory> implements ProductCategoryDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(ProductCategoryDaoHibernateImpl.class);

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
    public Class<ProductCategory> getEntityClass() {
        return ProductCategory.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "ouid";
    }

    /**
     * @see li.rajenlab.canto.core.dao.product.ProductCategoryDao#getProductCategoryByUid(java.lang.String)
     */
    public ProductCategory getProductCategoryByUid(String uid)
            throws EntityNotFoundException {
        return load(uid);
    }

    /**
     * @see li.rajenlab.canto.core.dao.product.ProductCategoryDao#getProductCategoryChildren(li.rajenlab.canto.core.domain.product.ProductCategory)
     */
    @SuppressWarnings("unchecked")
    public List<ProductCategory> getProductCategoryChildren(
            ProductCategory parent) {
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("parent",parent));
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
