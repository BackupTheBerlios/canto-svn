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
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class JobDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Job>
        implements JobDao {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(JobDaoHibernateImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Job> getEntityClass() {
        return Job.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "code";
    }

    /**
     * @see li.rajenlab.canto.core.dao.job.JobDao#getJobsByCode(java.lang.String)
     */
    public Job getJobsByCode(String code) throws EntityNotFoundException {
        return load(code);
    }

    /**
     * @see li.rajenlab.canto.core.dao.job.JobDao#getJobsByLevel(li.rajenlab.canto.core.domain.job.JobLevel)
     */
    @SuppressWarnings("unchecked")
    public List<Job> getJobsByLevel(JobLevel level) {
        
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("level",level));
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.core.dao.job.JobDao#getJobsBySalaryRange(li.rajenlab.canto.core.domain.salary.SalaryRange)
     */
    @SuppressWarnings("unchecked")
    public List<Job> getJobsBySalaryRange(SalaryRange range) {
        
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("salaryRange",range));
        return getHibernateTemplate().findByCriteria(criteria);
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
