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
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProductAvailabilityDao extends SimpleDao<ProductAvailability> {
    
    
    
    public List<ProductAvailability> getProductAvailabilityByProduct(Product product);
    
    public ProductAvailability getProductAvaililityOfProduct(Product product,
            Date date)
        throws EntityNotFoundException;

}
