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

import java.util.List;

import li.rajenlab.canto.core.domain.job.Job;
import li.rajenlab.canto.core.domain.job.JobLevel;
import li.rajenlab.canto.core.domain.salary.SalaryRange;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface JobDao extends SimpleDao<Job> {
    
    /**
     * Get jobs by joblevel
     * @param level
     * @return
     */
    public List<Job> getJobsByLevel(JobLevel level);
    
    /**
     * Get jobs by salary range
     * @param range
     * @return
     */
    public List<Job> getJobsBySalaryRange(SalaryRange range);
    
    /**
     * Get jobs by code
     * @param code
     * @return
     */
    public Job getJobsByCode(String code) throws EntityNotFoundException;

}
