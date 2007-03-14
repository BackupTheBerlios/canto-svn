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

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface SubscriptionService {
    
    /**
     * Create a package subscription
     * @param packageSubscription
     * @return
     * @throws ValidationException
     */
    public PackageSubscription createPackageSubscription(PackageSubscription packageSubscription)
        throws ValidationException;
    
    /**
     * Get list of package subscription of an account
     * @param account
     * @return
     */
    public List<PackageSubscription> getPackageSubscriptionsByAccount(Account account);
    
    /**
     * Get list of active package subscription of an account
     * @param account
     * @return
     */
    public List<PackageSubscription> getActivePackageSubscriptionsByAccount(Account account);
    
    /**
     * Get list of package subscription of an account and status
     * @param account
     * @param status
     * @return
     */
    public List<PackageSubscription> getPackageSubscriptionsByAccountAndStatus(Account account, 
                                            SubscriptionStatus status);
    
    /**
     * Get list of package subscription by status
     * @param status
     * @return
     */
    public List<PackageSubscription> getPackageSubscriptionsByStatus(SubscriptionStatus status);

}
