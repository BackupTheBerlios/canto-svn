/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao;

import li.rajenlab.canto.core.dao.crm.ContactDao;
import li.rajenlab.canto.core.dao.crm.CustomerDao;
import li.rajenlab.canto.core.dao.crm.OrganizationDao;
import li.rajenlab.canto.core.dao.market.MarketDao;
import li.rajenlab.canto.core.dao.market.SalesChannelDao;
import li.rajenlab.canto.core.dao.price.ProductPriceListDao;
import li.rajenlab.canto.core.dao.product.ProductAvailabilityDao;
import li.rajenlab.canto.core.dao.product.ProductCategoryDao;
import li.rajenlab.canto.core.dao.product.ProductDao;
import li.rajenlab.common.dao.user.UserDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface DaoFactory {
    
    public static final String REFBEAN_USER_DAO = "userDao";
    public static final String REFBEAN_PRODUCT_DAO = "productDao";
    public static final String REFBEAN_PRODUCTCAT_DAO = "productCategoryDao";
    public static final String REFBEAN_PRODUCTAVA_DAO = "productAvailabilityDao";
    public static final String REFBEAN_PRODUCTPRICE_DAO = "productPriceListDao";
    public static final String REFBEAN_CUSTOMER_DAO = "customerDao";
    public static final String REFBEAN_CONTACT_DAO = "contactDao";
    public static final String REFBEAN_ORG_DAO = "organizationDao";
    public static final String REFBEAN_MARKET_DAO = "marketDao";
    public static final String REFBEAN_SALESCHANNEL_DAO = "salesChannelDao";
    

    
    /**
     * Get UserDao instance
     * @return
     */
    public abstract UserDao getUserDao();
    
    public abstract ProductDao getProductDao();
    
    public abstract ProductCategoryDao getProductCategoryDao();
    
    public abstract ProductAvailabilityDao getProductAvailabilityDao();
    
    public abstract ProductPriceListDao getProductPriceListDao();
    
    public abstract MarketDao getMarketDao();
    
    public abstract CustomerDao getCustomerDao();
    
    public abstract ContactDao getContactDao();
    
    public abstract OrganizationDao getOrganizationDao();
    
    public abstract SalesChannelDao getSalesChannelDao();

}
