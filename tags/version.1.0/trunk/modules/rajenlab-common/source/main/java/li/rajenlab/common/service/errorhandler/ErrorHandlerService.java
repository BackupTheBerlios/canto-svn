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



package li.rajenlab.common.service.errorhandler;

import li.rajenlab.common.domain.errorhandler.ErrorEvent;


/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ErrorHandlerService {
    
    public void handleError(ErrorEvent event);

}
