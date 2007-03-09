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

import li.rajenlab.canto.framework.domain.product.ProductCategory;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductCategoryDaoHibernateImpl extends
        AbstractSimpleDaoHibernateImpl<ProductCategory> implements ProductCategoryDao {

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
        return "id";
    }

    /**
     * @see li.rajenlab.canto.framework.dao.product.ProductCategoryDao#getProductCategoryChildren(li.rajenlab.canto.framework.domain.product.ProductCategory)
     */
    @SuppressWarnings("unchecked")
    public List<ProductCategory> getProductCategoryChildren(
            ProductCategory productCategory) {
        DetachedCriteria critiera = getDetachedCriteria();
        
        critiera.add(Restrictions.eq("parent",productCategory));
        
        return getHibernateTemplate().findByCriteria(critiera);
    }

   
}
