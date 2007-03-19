/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.price;

import java.util.List;

import li.rajenlab.canto.core.domain.price.ProductPriceList;
import li.rajenlab.canto.core.domain.product.ProductAvailability;
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
public class ProductPriceListDaoHibernateImpl extends
        AbstractSimpleDaoHibernateImpl<ProductPriceList> implements ProductPriceListDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(ProductPriceListDaoHibernateImpl.class);

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
    public Class<ProductPriceList> getEntityClass() {
        return ProductPriceList.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "id";
    }

    /**
     * @see li.rajenlab.canto.core.dao.price.ProductPriceListDao#getProductPriceListByAvailability(li.rajenlab.canto.core.domain.product.ProductAvailability)
     */
    @SuppressWarnings("unchecked")
    public ProductPriceList getProductPriceListByAvailability(
            ProductAvailability availability) throws EntityNotFoundException{
  
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.setFetchMode("availability", FetchMode.JOIN);
        criteria.add(Restrictions.eq("availability",availability));
        List<ProductPriceList> lists = getHibernateTemplate().findByCriteria(criteria);
        if (lists == null || lists.isEmpty() || lists.size()>1){
            throw new EntityNotFoundException("No ProductPriceList found for Availability ["+availability+"]");
        }
        return lists.get(0);
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
