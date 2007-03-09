/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.dao.account;

import java.util.List;

import li.rajenlab.canto.framework.domain.account.Account;
import li.rajenlab.canto.framework.domain.account.AccountStatus;
import li.rajenlab.canto.framework.domain.account.AccountType;
import li.rajenlab.canto.framework.domain.account.SearchAccountCriteria;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface AccountDao extends SimpleDao<Account> {
    
    /**
     * Get account by id
     * @param accountId
     * @return
     * @throws EntityNotFoundException
     */
    public Account getAccountByAccountId(String accountId)
        throws EntityNotFoundException;
    
    /**
     * Get account by status
     * @param status
     * @return
     */
    public List<Account> getAccountByStatus(AccountStatus status);
    
    /**
     * Get account by type
     * @param type
     * @return
     */
    public List<Account> getAccountByType(AccountType type);
    
    /**
     * Search account by criteria
     * @param accountCriteria
     * @return
     */
    public List<Account> getAccountByCriteria(SearchAccountCriteria accountCriteria);

}
