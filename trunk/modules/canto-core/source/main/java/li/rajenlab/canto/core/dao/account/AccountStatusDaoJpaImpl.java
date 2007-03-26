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

import li.rajenlab.canto.core.model.account.AccountStatus;
import li.rajenlab.common.dao.jpa.AbstractSimpleDaoJpaImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class AccountStatusDaoJpaImpl extends AbstractSimpleDaoJpaImpl<AccountStatus> implements
        AccountStatusDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(AccountStatusDaoJpaImpl.class);

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
    public Class<AccountStatus> getEntityClass() {
        return AccountStatus.class;
    }

    /**
     * @see li.rajenlab.common.dao.jpa.AbstractSimpleDaoJpaImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "id";
    }

    /**
     * @see li.rajenlab.canto.core.dao.account.AccountStatusDao#getAllAccountStatus()
     */
    @SuppressWarnings("unchecked")
    public List<AccountStatus> getAllAccountStatus() {
        return getJpaTemplate().find(" from AccountStatus");
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
