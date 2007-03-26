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

import li.rajenlab.canto.core.model.account.AccountType;
import li.rajenlab.common.dao.jpa.AbstractSimpleDaoJpaImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class AccountTypeDaoJpaImpl extends
        AbstractSimpleDaoJpaImpl<AccountType> implements AccountTypeDao {
 
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(AccountTypeDaoJpaImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.core.dao.account.AccountTypeDao#getAllAccountType()
     */
    @SuppressWarnings("unchecked")
    public List<AccountType> getAllAccountType() {
        return getJpaTemplate().find(" from AccountType");
    }

    /**
     * @see li.rajenlab.common.dao.jpa.AbstractSimpleDaoJpaImpl#getEntityClass()
     */
    @Override
    public Class<AccountType> getEntityClass() {
        return AccountType.class;
    }

    /**
     * @see li.rajenlab.common.dao.jpa.AbstractSimpleDaoJpaImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "id";
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
