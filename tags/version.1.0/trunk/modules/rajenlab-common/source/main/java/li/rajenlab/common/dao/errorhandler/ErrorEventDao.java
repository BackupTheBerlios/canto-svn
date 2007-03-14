/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:48 $
 * $LastChangedDate:2007-03-07 13:51:41 +0000 (Mi, 07 Mrz 2007) $
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/rajenlab-common/source/main/java/li/rajenlab/common/dao/BaseDao.java $
 ******************************************************************************/


package li.rajenlab.common.dao.errorhandler;

import li.rajenlab.common.domain.errorhandler.ErrorEvent;

import org.springframework.dao.DataAccessException;



/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ErrorEventDao {
    
    /**
     * Make the given error event persistant.
     * @param event the ErrorEvent to make persistant.
     */
    public void persist(ErrorEvent event) throws DataAccessException;
    

}
