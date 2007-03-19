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

import li.rajenlab.canto.core.domain.product.ProductCategory;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProductCategoryDao extends SimpleDao<ProductCategory>{
    
    
    public ProductCategory getProductCategoryByUid(String uid)
        throws EntityNotFoundException;
    
    
    public List<ProductCategory> getProductCategoryChildren(ProductCategory parent);

}
