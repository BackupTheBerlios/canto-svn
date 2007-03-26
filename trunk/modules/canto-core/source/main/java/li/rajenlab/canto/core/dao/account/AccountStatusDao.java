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
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface AccountStatusDao extends SimpleDao<AccountStatus> {
    
    
    public List<AccountStatus> getAllAccountStatus();

}
