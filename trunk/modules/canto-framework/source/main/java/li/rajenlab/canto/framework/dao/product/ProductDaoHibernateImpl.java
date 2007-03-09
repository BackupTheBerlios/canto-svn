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

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import li.rajenlab.canto.framework.domain.product.Product;
import li.rajenlab.canto.framework.domain.product.ProductCategory;
import li.rajenlab.canto.framework.domain.product.ProductSegment;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Product>
        implements ProductDao {

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
        return "productId";
    }

    /**
     * @see li.rajenlab.canto.framework.dao.product.ProductDao#getProductByProductId(java.lang.String)
     */
    public Product getProductByProductId(String productId)
            throws EntityNotFoundException {
        return load(productId);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.product.ProductDao#getProductsByCategory(li.rajenlab.canto.framework.domain.product.ProductCategory)
     */
    @SuppressWarnings("unchecked")
    public List<Product> getProductsByCategory(ProductCategory category) {
        DetachedCriteria critiera = getDetachedCriteria();
        
        critiera.add(Restrictions.eq("categories",category));
        
        return getHibernateTemplate().findByCriteria(critiera);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.product.ProductDao#getProductsBySegment(li.rajenlab.canto.framework.domain.product.ProductSegment)
     */
    @SuppressWarnings("unchecked")
    public List<Product> getProductsBySegment(ProductSegment segment) {
        DetachedCriteria critiera = getDetachedCriteria();
        
        critiera.add(Restrictions.eq("segments",segment));
        
        return getHibernateTemplate().findByCriteria(critiera);
    }

}
