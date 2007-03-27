/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.account;

import java.util.List;

import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.account.AccountSearchCriteria;
import li.rajenlab.canto.core.model.account.AccountStatus;
import li.rajenlab.canto.core.model.account.AccountType;
import li.rajenlab.canto.core.model.common.Industry;
import li.rajenlab.canto.core.model.contact.Contact;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface AccountDao extends SimpleDao<Account> {
    
    /**
     * Retrieve Account by Type
     * @param accountType
     * @return
     */
    public List<Account> getAccountByType(AccountType accountType);

    /**
     * Retrieve Account By Status
     * @param status
     * @return
     */
    public List<Account> getAccountByStatus(AccountStatus status);
    
    /**
     * Retrieve Account By Id
     * @param accountId
     * @return
     * @throws EntityNotFoundException
     */
    public Account getAccountById(String accountId)
        throws EntityNotFoundException;
    
    /**
     * Get Account by industry
     * @param industry
     * @return
     */
    public List<Account> getAccountByIndustry(Industry industry);
    
    /**
     * Get Account by contact
     * @param contact
     * @return
     */
    public Account getAccountByContact(Contact contact)
        throws EntityNotFoundException;
    
    /**
     * Search Account by AccountSearchCriteria
     * @param accountSearchCriteria
     * @return
     */
    public List<Account> searchAccount(AccountSearchCriteria accountSearchCriteria);
    
    
}
