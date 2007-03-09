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

import java.util.Collections;
import java.util.List;

import li.rajenlab.canto.framework.domain.account.Account;
import li.rajenlab.canto.framework.domain.account.AccountStatus;
import li.rajenlab.canto.framework.domain.account.AccountType;
import li.rajenlab.canto.framework.domain.account.SearchAccountCriteria;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class AccountDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Account>
        implements AccountDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "accountId";
    }

    /**
     * @see li.rajenlab.canto.framework.dao.account.AccountDao#getAccountByAccountId(java.lang.String)
     */
    public Account getAccountByAccountId(String accountId)
            throws EntityNotFoundException {
        return load(accountId);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.account.AccountDao#getAccountByCriteria(li.rajenlab.canto.framework.domain.account.SearchAccountCriteria)
     */
    public List<Account> getAccountByCriteria(
            SearchAccountCriteria accountCriteria) {
        return Collections.emptyList();
    }

    /**
     * @see li.rajenlab.canto.framework.dao.account.AccountDao#getAccountByStatus(li.rajenlab.canto.framework.domain.account.AccountStatus)
     */
    @SuppressWarnings("unchecked")
    public List<Account> getAccountByStatus(AccountStatus status) {
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("status",status));
        criteria.addOrder(Order.asc("accountId"));
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.account.AccountDao#getAccountByType(li.rajenlab.canto.framework.domain.account.AccountType)
     */
    @SuppressWarnings("unchecked")
    public List<Account> getAccountByType(AccountType type) {
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("type",type));
        criteria.addOrder(Order.asc("accountId"));
        return getHibernateTemplate().findByCriteria(criteria);
    }

}
