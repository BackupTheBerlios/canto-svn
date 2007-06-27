/**
 * 
 */
package pareon.canto.framework.service.account;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;

import pareon.canto.components.logging.SystemLogger;
import pareon.canto.framework.dao.EntityNotFoundException;
import pareon.canto.framework.dao.account.AccountDao;
import pareon.canto.framework.domain.account.Account;

/**
 * @author tzhrora2
 *
 */
public class AccountServiceImpl implements AccountService {

	
	private SystemLogger logger = new SystemLogger(getClass());
	private AccountDao accountDao;
	
	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		try {
			Account account = getAccountDao().loadAccountByUsername(username);
			logger.logInfo("Account for username["+username+"] loaded");
			
			return account;
		
		} catch (EntityNotFoundException e){
			throw new UsernameNotFoundException(username + " is not known username");
		}
		
		
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	
}
