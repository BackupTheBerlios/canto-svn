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
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProductCategoryDao extends SimpleDao<ProductCategory> {
    
    
    /**
     * Get the product category children of the product category
     * @param productCategory
     * @return
     */
    public List<ProductCategory> getProductCategoryChildren(ProductCategory productCategory);

}
