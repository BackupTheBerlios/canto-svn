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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class DaoFactoryImpl implements DaoFactory, ApplicationContextAware {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(DaoFactoryImpl.class);
    private ApplicationContext context_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
   
    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getUserDao()
     */
    public UserDao getUserDao() {
        return (UserDao)getApplicationContext().getBean(REFBEAN_USER_DAO);
    }
    
    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getContactDao()
     */
    public ContactDao getContactDao() {
        return (ContactDao)getApplicationContext().getBean(REFBEAN_CONTACT_DAO);
    }


    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getCustomerDao()
     */
    public CustomerDao getCustomerDao() {
        return (CustomerDao)getApplicationContext().getBean(REFBEAN_CUSTOMER_DAO);
    }


    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getMarketDao()
     */
    public MarketDao getMarketDao() {
        return (MarketDao)getApplicationContext().getBean(REFBEAN_MARKET_DAO);
    }


    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getOrganizationDao()
     */
    public OrganizationDao getOrganizationDao() {
        return (OrganizationDao)getApplicationContext().getBean(REFBEAN_ORG_DAO);
    }


    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getProductAvailabilityDao()
     */
    public ProductAvailabilityDao getProductAvailabilityDao() {
        return (ProductAvailabilityDao)getApplicationContext().getBean(REFBEAN_PRODUCTAVA_DAO);
    }


    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getProductCategoryDao()
     */
    public ProductCategoryDao getProductCategoryDao() {
        return (ProductCategoryDao)getApplicationContext().getBean(REFBEAN_PRODUCTCAT_DAO);
    }


    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getProductDao()
     */
    public ProductDao getProductDao() {
        return (ProductDao)getApplicationContext().getBean(REFBEAN_PRODUCT_DAO);
    }


    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getProductPriceListDao()
     */
    public ProductPriceListDao getProductPriceListDao() {
        return (ProductPriceListDao)getApplicationContext().getBean(REFBEAN_PRODUCTPRICE_DAO);
    }

    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getSalesChannelDao()
     */
    public SalesChannelDao getSalesChannelDao() {
        return (SalesChannelDao)getApplicationContext().getBean(REFBEAN_SALESCHANNEL_DAO);
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
    
  

   



    /**
     * @return the context
     */
    public ApplicationContext getApplicationContext() {
        return this.context_;
    }

    /**
     * @param context the context to set
     */
    public void setApplicationContext(ApplicationContext context) {
        this.context_ = context;
    }

}
