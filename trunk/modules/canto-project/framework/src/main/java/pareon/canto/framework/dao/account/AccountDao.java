/**
 * 
 */
package pareon.canto.framework.dao.account;

import pareon.canto.framework.dao.BaseDao;
import pareon.canto.framework.dao.EntityNotFoundException;
import pareon.canto.framework.domain.account.Account;


/**
 * @author tzhrora2
 *
 */
public interface AccountDao extends BaseDao<Account> {
	
	/**
	 * Load an account by username of the account
	 * @param credentials
	 * @return
	 */
	public Account loadAccountByUsername(String username)
		throws EntityNotFoundException;
	/**
	 * Load an account by it's accountNr
	 * @param accountNr
	 * @return
	 * @throws EntityNotFoundException
	 */
	public Account loadAccount(String accountNr)
		throws EntityNotFoundException;

}
