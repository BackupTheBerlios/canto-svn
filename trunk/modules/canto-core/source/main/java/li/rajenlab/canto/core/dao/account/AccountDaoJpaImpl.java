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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.account.AccountSearchCriteria;
import li.rajenlab.canto.core.model.account.AccountStatus;
import li.rajenlab.canto.core.model.account.AccountType;
import li.rajenlab.canto.core.model.common.Contact;
import li.rajenlab.canto.core.model.common.Industry;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.jpa.AbstractSimpleDaoJpaImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.JpaCallback;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class AccountDaoJpaImpl extends AbstractSimpleDaoJpaImpl<Account> implements
        AccountDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(AccountDaoJpaImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.common.dao.jpa.AbstractSimpleDaoJpaImpl#getEntityClass()
     */
    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }

    /**
     * @see li.rajenlab.common.dao.jpa.AbstractSimpleDaoJpaImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "accountId";
    }

    /**
     * @see li.rajenlab.canto.core.dao.account.AccountDao#getAccountByContact(li.rajenlab.canto.core.model.common.Contact)
     */
    public Account getAccountByContact(final Contact contact) 
       throws EntityNotFoundException {
        
       try { 
            return (Account) getJpaTemplate().execute(new JpaCallback(){
    
                /**
                 * @see org.springframework.orm.jpa.JpaCallback#doInJpa(javax.persistence.EntityManager)
                 */
                @SuppressWarnings("unchecked")
                public Object doInJpa(EntityManager em) throws PersistenceException {
                    Query query = em.createQuery(" from Account where Account.contact = :contactParam");
                    query.setParameter("contactParam", contact);
                    List<Account> results = query.getResultList();
                    
                    if (results == null || results.isEmpty()
                            || results.size() > 1){
                        throw new javax.persistence.EntityNotFoundException();
                    }
                    return results.get(0);
                }
                
                
            });
        
       } catch (javax.persistence.EntityNotFoundException ef){
           throw new EntityNotFoundException("No Account for contact [" + contact+"]");
       }
    }

    /**
     * @see li.rajenlab.canto.core.dao.account.AccountDao#getAccountById(java.lang.String)
     */
    public Account getAccountById(String accountId)
            throws EntityNotFoundException {
        return load(accountId);
    }

    /**
     * @see li.rajenlab.canto.core.dao.account.AccountDao#getAccountByIndustry(li.rajenlab.canto.core.model.common.Industry)
     */
    @SuppressWarnings("unchecked")
    public List<Account> getAccountByIndustry(final Industry industry) {
        
        return getJpaTemplate().executeFind(new JpaCallback(){

            /**
             * @see org.springframework.orm.jpa.JpaCallback#doInJpa(javax.persistence.EntityManager)
             */
            @SuppressWarnings("unchecked")
            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery(" from Account where Account.industry = :industryParam");
                query.setParameter("industryParam", industry);
                List<Account> results = query.getResultList();
                
                return results;
            }
            
            
        });
        
       
    }

    /**
     * @see li.rajenlab.canto.core.dao.account.AccountDao#getAccountByStatus(li.rajenlab.canto.core.model.account.AccountStatus)
     */
    @SuppressWarnings("unchecked")
    public List<Account> getAccountByStatus(final AccountStatus status) {
        return getJpaTemplate().executeFind(new JpaCallback(){

            /**
             * @see org.springframework.orm.jpa.JpaCallback#doInJpa(javax.persistence.EntityManager)
             */
            @SuppressWarnings("unchecked")
            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery(" from Account where Account.status = :statusParam");
                query.setParameter("statusParam", status);
                List<Account> results = query.getResultList();
                
                return results;
            }
            
            
        });
    }

    /**
     * @see li.rajenlab.canto.core.dao.account.AccountDao#getAccountByType(li.rajenlab.canto.core.model.account.AccountType)
     */
    @SuppressWarnings("unchecked")
    public List<Account> getAccountByType(final AccountType accountType) {
        return getJpaTemplate().executeFind(new JpaCallback(){

            /**
             * @see org.springframework.orm.jpa.JpaCallback#doInJpa(javax.persistence.EntityManager)
             */
            @SuppressWarnings("unchecked")
            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery(" from Account where Account.accountType = :accountTypeParam");
                query.setParameter("accountTypeParam", accountType);
                List<Account> results = query.getResultList();
                
                return results;
            }
            
            
        });
    }

    /**
     * @see li.rajenlab.canto.core.dao.account.AccountDao#searchAccount(li.rajenlab.canto.core.model.account.AccountSearchCriteria)
     */
    public List<Account> searchAccount(
            AccountSearchCriteria accountSearchCriteria) {
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
