/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.subscription;

import java.util.List;

import li.rajenlab.canto.framework.domain.account.Account;
import li.rajenlab.canto.framework.domain.subscription.PackageSubscription;
import li.rajenlab.canto.framework.domain.subscription.SubscriptionStatus;
import li.rajenlab.common.support.validation.ValidationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SubscriptionServiceImpl implements SubscriptionService {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(SubscriptionServiceImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.framework.service.subscription.SubscriptionService#createPackageSubscription(li.rajenlab.canto.framework.domain.subscription.PackageSubscription)
     */
    public PackageSubscription createPackageSubscription(
            PackageSubscription packageSubscription) throws ValidationException {
        // TODO Auto-generated method stub
        
        
        return null;
    }

    /**
     * @see li.rajenlab.canto.framework.service.subscription.SubscriptionService#getActivePackageSubscriptionsByAccount(li.rajenlab.canto.framework.domain.account.Account)
     */
    public List<PackageSubscription> getActivePackageSubscriptionsByAccount(Account account) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see li.rajenlab.canto.framework.service.subscription.SubscriptionService#getPackageSubscriptionsByAccount(li.rajenlab.canto.framework.domain.account.Account)
     */
    public List<PackageSubscription> getPackageSubscriptionsByAccount(Account account) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see li.rajenlab.canto.framework.service.subscription.SubscriptionService#getPackageSubscriptionsByAccountAndStatus(li.rajenlab.canto.framework.domain.account.Account, li.rajenlab.canto.framework.domain.subscription.SubscriptionStatus)
     */
    public List<PackageSubscription> getPackageSubscriptionsByAccountAndStatus(Account account, SubscriptionStatus status) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see li.rajenlab.canto.framework.service.subscription.SubscriptionService#getPackageSubscriptionsByStatus(li.rajenlab.canto.framework.domain.subscription.SubscriptionStatus)
     */
    public List<PackageSubscription> getPackageSubscriptionsByStatus(SubscriptionStatus status) {
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
