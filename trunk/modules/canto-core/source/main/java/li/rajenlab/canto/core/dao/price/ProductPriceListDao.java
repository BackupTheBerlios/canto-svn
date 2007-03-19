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

import li.rajenlab.canto.core.domain.price.ProductPriceList;
import li.rajenlab.canto.core.domain.product.ProductAvailability;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProductPriceListDao extends SimpleDao<ProductPriceList> {
    
    
    public ProductPriceList getProductPriceListByAvailability(ProductAvailability availability)
        throws EntityNotFoundException;

}
