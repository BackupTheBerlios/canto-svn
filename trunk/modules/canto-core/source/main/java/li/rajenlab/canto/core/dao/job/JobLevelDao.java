/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.job;

import li.rajenlab.canto.core.domain.job.JobLevel;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface JobLevelDao extends SimpleDao<JobLevel> {
    
    
    /**
     * Get job level by code
     * @param code
     * @return
     * @throws EntityNotFoundException
     */
    public JobLevel getJobLevelByCode(String code) throws EntityNotFoundException;

}
