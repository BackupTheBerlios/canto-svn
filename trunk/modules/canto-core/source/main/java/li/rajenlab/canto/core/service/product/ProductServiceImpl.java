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
import li.rajenlab.canto.core.service.AbstractServiceImpl;
import li.rajenlab.common.dao.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductServiceImpl extends AbstractServiceImpl implements
        ProductService {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(ProductServiceImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#createProduct(li.rajenlab.canto.core.domain.product.Product)
     */
    public Product createProduct(Product product) throws BindException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#createProductAvailability(li.rajenlab.canto.core.domain.product.ProductAvailability)
     */
    public ProductAvailability createProductAvailability(
            ProductAvailability productAvailability) throws BindException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#createProductCategory(li.rajenlab.canto.core.domain.product.ProductCategory)
     */
    public ProductCategory createProductCategory(ProductCategory productCategory)
            throws BindException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#deleteProduct(li.rajenlab.canto.core.domain.product.Product)
     */
    public void deleteProduct(Product product) throws BindException {
        // TODO Auto-generated method stub

    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#deleteProductAvailability(li.rajenlab.canto.core.domain.product.ProductAvailability)
     */
    public void deleteProductAvailability(
            ProductAvailability productAvailability) {
        // TODO Auto-generated method stub

    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#deleteProductCategory(li.rajenlab.canto.core.domain.product.ProductCategory, li.rajenlab.canto.core.domain.product.ProductCategory)
     */
    public void deleteProductCategory(ProductCategory productCategoryToDelete,
            ProductCategory productCategoryReplacement) throws BindException {
        // TODO Auto-generated method stub

    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#getProductAvailability(li.rajenlab.canto.core.domain.product.Product, java.util.Date)
     */
    public ProductAvailability getProductAvailability(Product product,
            Date availabilityDate) throws EntityNotFoundException {
        return getDaoFactory().getProductAvailabilityDao().getProductAvaililityOfProduct(product, availabilityDate);
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#getProductAvailabilityOfProduct(li.rajenlab.canto.core.domain.product.Product)
     */
    public List<ProductAvailability> getProductAvailabilityOfProduct(
            Product product) {
        return getDaoFactory().getProductAvailabilityDao().getProductAvailabilityByProduct(product);
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#getProductByCategory(li.rajenlab.canto.core.domain.product.ProductCategory)
     */
    public List<Product> getProductByCategory(ProductCategory category) {
        return getDaoFactory().getProductDao().getProductsByCategory(category);
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#getProductByType(li.rajenlab.canto.core.domain.product.ProductType)
     */
    public List<Product> getProductByType(ProductType type) {
        return getDaoFactory().getProductDao().getProductsByType(type);
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#getProductByUid(java.lang.String)
     */
    public Product getProductByUid(String uid) throws EntityNotFoundException {
        return getDaoFactory().getProductDao().getProductByUid(uid);
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#getProductCategory(java.lang.String)
     */
    public ProductCategory getProductCategory(String uid)
            throws EntityNotFoundException {
        return getDaoFactory().getProductCategoryDao().getProductCategoryByUid(uid);
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#getProductCategoryChildren(li.rajenlab.canto.core.domain.product.ProductCategory)
     */
    public List<ProductCategory> getProductCategoryChildren(
            ProductCategory parent) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#modifyProduct(li.rajenlab.canto.core.domain.product.Product)
     */
    public void modifyProduct(Product product) throws BindException {
        // TODO Auto-generated method stub

    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#modifyProductAvailability(li.rajenlab.canto.core.domain.product.ProductAvailability)
     */
    public void modifyProductAvailability(
            ProductAvailability productAvailability) throws BindException {
        // TODO Auto-generated method stub

    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#modifyProductCategory(li.rajenlab.canto.core.domain.product.ProductCategory)
     */
    public void modifyProductCategory(ProductCategory productCategory)
            throws BindException {
        // TODO Auto-generated method stub

    }

    /**
     * @see li.rajenlab.canto.core.service.product.ProductService#searchProduct(li.rajenlab.canto.core.domain.product.SearchProductCriteria)
     */
    public List<Product> searchProduct(
            SearchProductCriteria searchProductCriteria) {
        // TODO Auto-generated method stub
        return null;
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
