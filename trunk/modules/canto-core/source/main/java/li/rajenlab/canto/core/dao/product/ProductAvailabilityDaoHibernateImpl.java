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

import java.util.Date;
import java.util.List;

import li.rajenlab.canto.core.domain.product.Product;
import li.rajenlab.canto.core.domain.product.ProductAvailability;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;
import li.rajenlab.common.support.DateUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductAvailabilityDaoHibernateImpl extends
        AbstractSimpleDaoHibernateImpl<ProductAvailability> implements ProductAvailabilityDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(ProductAvailabilityDaoHibernateImpl.class);

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
    public Class<ProductAvailability> getEntityClass() {
        return ProductAvailability.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "id";
    }

    /**
     * @see li.rajenlab.canto.core.dao.product.ProductAvailabilityDao#getProductAvailabilityByProduct(li.rajenlab.canto.core.domain.product.Product)
     */
    @SuppressWarnings("unchecked")
    public List<ProductAvailability> getProductAvailabilityByProduct(
            Product product) {
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("product",product));
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * 
     * @see li.rajenlab.canto.core.dao.product.ProductAvailabilityDao#getProductAvaililityOfProduct(li.rajenlab.canto.core.domain.product.Product, java.util.Date)
     */
    @SuppressWarnings("unchecked")
    public ProductAvailability getProductAvaililityOfProduct(Product product,
            Date date) throws EntityNotFoundException{
       
        if (product == null || date == null){
            throw new EntityNotFoundException("no product avail found");
        }
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("product",product));
        criteria.add(Restrictions.ge("introductionDate", DateUtils.normalizeDateFrom(date)));
        criteria.add(Restrictions.ge("expiryDate", DateUtils.normalizeDateTo(date)));
        
        
        List<ProductAvailability> productsAvail = getHibernateTemplate().findByCriteria(criteria);
        if (productsAvail==null || productsAvail.isEmpty() || productsAvail.size()>1){
            throw new EntityNotFoundException("no product avail found");
        }
        
        return productsAvail.get(0);
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
