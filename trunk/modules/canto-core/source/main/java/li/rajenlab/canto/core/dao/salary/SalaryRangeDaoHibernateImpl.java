/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.salary;

import java.util.List;

import li.rajenlab.canto.core.domain.salary.SalaryRange;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SalaryRangeDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<SalaryRange>
        implements SalaryRangeDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(SalaryRangeDaoHibernateImpl.class);

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
    public Class<SalaryRange> getEntityClass() {
        return SalaryRange.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "salaryRangeId";
    }

    /**
     * @see li.rajenlab.canto.core.dao.salary.SalaryRangeDao#getSalaryRangesByBound(float, float, float, float)
     */
    @SuppressWarnings("unchecked")
    public List<SalaryRange> getSalaryRangesByBound(Float fromLowerBound,
            Float toLowerBound, Float fromUpperBound, Float toUpperBound) {
        DetachedCriteria criteria = getDetachedCriteria();
        
        if (fromLowerBound!=null){
            criteria.add(Restrictions.ge("lowerBound", fromLowerBound));
        }
        if (toLowerBound!=null){
            criteria.add(Restrictions.le("lowerBound", toLowerBound));
        }
        
        if (fromUpperBound!=null){
            criteria.add(Restrictions.ge("upperBound", fromUpperBound));
        }
        if (toUpperBound!=null){
            criteria.add(Restrictions.le("upperBound", toUpperBound));
        }
        
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
