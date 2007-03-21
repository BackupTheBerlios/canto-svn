/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.service.product;

import java.util.Date;
import java.util.List;

import li.rajenlab.canto.core.domain.product.Product;
import li.rajenlab.canto.core.domain.product.ProductAvailability;
import li.rajenlab.canto.core.domain.product.ProductCategory;
import li.rajenlab.canto.core.domain.product.ProductType;
import li.rajenlab.canto.core.domain.product.SearchProductCriteria;
import li.rajenlab.common.dao.EntityNotFoundException;

import org.springframework.validation.BindException;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProductService {
    
    // PRODUCT CATEGORY SERVICE //
    
    /**
     * Create a new product category 
     * 
     * @param productCategory
     * @return
     * @throws BindException
     */
    public ProductCategory createProductCategory(ProductCategory productCategory)
        throws BindException;
    
    /**
     * Delete a product category. The product or product category children having
     * the product category to be deleted as parent or category, are receiven
     * the productCategoryReplacement as parent or category. 
     * @param productCategoryToDelete ProductCategory to delete
     * @param productCategoryReplacement ProductCategory to replace the producCategory to delete. 
     *                                   can be null
     * @throws BindException
     */
    public void deleteProductCategory(ProductCategory productCategoryToDelete,
            ProductCategory productCategoryReplacement)
        throws BindException;
    
    /**
     * Modify a product category
     * @param productCategory
     * @throws BindException
     */
    public void modifyProductCategory(ProductCategory productCategory)
        throws BindException;
    
    /**
     * Get the list of children of a product category
     * @param parent
     * @return
     */
    public List<ProductCategory> getProductCategoryChildren(ProductCategory parent);
    
    /**
     * Get product category by uid
     * @param uid
     * @return
     * @throws EntityNotFoundException
     */
    public ProductCategory getProductCategory(String uid)
        throws EntityNotFoundException;
    
    
    
    //  PRODUCT SERVICE //
    
    /**
     * Create Product
     * @param product
     * @return
     * @throws BindException
     */
    public Product createProduct(Product product)
        throws BindException;
    
    /**
     * modify product
     * @param product
     * @throws BindException
     */
    public void modifyProduct(Product product)
        throws BindException;
    
    /**
     * Delete product, set product to inactive
     * @param product
     * @throws BindException
     */
    public void deleteProduct(Product product)
        throws BindException;
    
    /**
     * Get Product by category
     * @param category
     * @return
     */
    public List<Product> getProductByCategory(ProductCategory category);
    
    /**
     * Get Product by type
     * @param type
     * @return
     */
    public List<Product> getProductByType(ProductType type);
    
    /**
     * Get product by uid
     * @param uid
     * @return
     * @throws EntityNotFoundException
     */
    public Product getProductByUid(String uid)
        throws EntityNotFoundException;
    
    /**
     * Search for product
     * @param searchProductCriteria
     * @return
     */
    public List<Product> searchProduct(SearchProductCriteria searchProductCriteria);
    
    
    //  PRODUCT AVAILABILITY SERVICE //
    
    /**
     * Get ProductAvailability of a product at a specific date
     * @param product
     * @param availabilityDate
     * @return
     * @throws EntityNotFoundException
     */
    public ProductAvailability getProductAvailability(Product product, Date availabilityDate)
        throws EntityNotFoundException;
    
    /**
     * Create ProductAvailability. ProductAvailability can only be created if there's
     * not interference with another ProductAvailability of a product
     * @param productAvailability
     * @return
     * @throws BindException
     */
    public ProductAvailability createProductAvailability(ProductAvailability productAvailability)
        throws BindException;
    
    /**
     * Modify ProductAvailability ProductAvailability can only be modify if there's
     * not interference with another ProductAvailability of a product
     * @param productAvailability
     * @throws BindException
     */
    public void modifyProductAvailability(ProductAvailability productAvailability)
        throws BindException;
    
    /**
     * Delete ProductAvailability
     * @param productAvailability
     */
    public void deleteProductAvailability(ProductAvailability productAvailability);

    /**
     * Get ProductAvailability of a product
     * @param product
     * @return
     */
    public List<ProductAvailability> getProductAvailabilityOfProduct(Product product);
}
