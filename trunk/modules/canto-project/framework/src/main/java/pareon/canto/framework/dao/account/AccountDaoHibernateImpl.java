/**
 * 
 */
package pareon.canto.framework.dao.account;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import pareon.canto.framework.dao.BaseDaoHibernateImpl;
import pareon.canto.framework.dao.EntityNotFoundException;
import pareon.canto.framework.domain.account.Account;

/**
 * @author tzhrora2
 *
 */
public class AccountDaoHibernateImpl extends BaseDaoHibernateImpl<Account> implements
		AccountDao {

	/* (non-Javadoc)
	 * @see pareon.canto.framework.dao.BaseDaoHibernateImpl#getEntityClass()
	 */
	@Override
	public Class<Account> getEntityClass() {
		return Account.class;
	}

	/* (non-Javadoc)
	 * @see pareon.canto.framework.dao.BaseDaoHibernateImpl#getKeyField()
	 */
	@Override
	public String getKeyField() {
		return "accountNr";
	}

	
	
	/* (non-Javadoc)
	 * @see pareon.canto.framework.dao.account.AccountDao#loadAccountByUsername(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Account loadAccountByUsername(String username) 
		throws EntityNotFoundException {
		
		DetachedCriteria crit = getDetachedCriteria();
		crit.add(Restrictions.eq("credentials.username",username));
		
		
		List<Account> results = getHibernateTemplate().findByCriteria(crit);
		
		if (results == null || results.size() == 0){
	            throw new EntityNotFoundException(username);
	        } else if (results.size() > 1) {
	            String msg = "more than one ["+results.size()+"] found : " + username;
	            throw new EntityNotFoundException(msg);
	        }
	        return results.get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see pareon.canto.framework.dao.account.AccountDao#loadAccount(java.lang.String)
	 */
	public Account loadAccount(String accountNr) throws EntityNotFoundException {
		return load(accountNr);
	}

	
}
