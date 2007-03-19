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

import li.rajenlab.canto.core.domain.product.Product;
import li.rajenlab.canto.core.domain.product.ProductCategory;
import li.rajenlab.canto.core.domain.product.ProductType;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Product>
        implements ProductDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(ProductDaoHibernateImpl.class);

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
    public Class<Product> getEntityClass() {
        return Product.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "ouid";
    }

    /**
     * @see li.rajenlab.canto.core.dao.product.ProductDao#getProductByUid(java.lang.String)
     */
    public Product getProductByUid(String uid) throws EntityNotFoundException {
        return load(uid);
    }

    /**
     * @see li.rajenlab.canto.core.dao.product.ProductDao#getProductsByCategory(li.rajenlab.canto.core.domain.product.ProductCategory)
     */
    @SuppressWarnings("unchecked")
    public List<Product> getProductsByCategory(ProductCategory category) {
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.setFetchMode("categories", FetchMode.JOIN);
        criteria.add(Restrictions.eq("categories",category));
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.core.dao.product.ProductDao#getProductsByType(li.rajenlab.canto.core.domain.product.ProductType)
     */
    @SuppressWarnings("unchecked")
    public List<Product> getProductsByType(ProductType type) {
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("type",type));
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.core.dao.product.ProductDao#getProductsPartOf(li.rajenlab.canto.core.domain.product.Product)
     */
    @SuppressWarnings("unchecked")
    public List<Product> getProductsPartOf(Product product) {
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.setFetchMode("parts", FetchMode.JOIN);
        criteria.add(Restrictions.eq("parts",product));
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
