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

import li.rajenlab.canto.framework.domain.product.Product;
import li.rajenlab.canto.framework.domain.product.ProductCategory;
import li.rajenlab.canto.framework.domain.product.ProductSegment;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProductDao extends SimpleDao<Product> {
    
    /**
     * Products by category
     * @param category
     * @return
     */
    public List<Product> getProductsByCategory(ProductCategory category);
    
    /**
     * Prodcuts by segment
     * @param segment
     * @return
     */
    public List<Product> getProductsBySegment(ProductSegment segment);
    
    /**
     * Product by productId
     * @param productId
     * @return
     * @throws EntityNotFoundException
     */
    public Product getProductByProductId(String productId) throws
        EntityNotFoundException;

}
