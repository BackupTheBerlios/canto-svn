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
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProductDao extends SimpleDao<Product> {
    
    
    public List<Product> getProductsByType(ProductType type);
    
    public List<Product> getProductsByCategory(ProductCategory category);
    
    public List<Product> getProductsPartOf(Product product);
    
    public Product getProductByUid(String uid)
        throws EntityNotFoundException;

}
