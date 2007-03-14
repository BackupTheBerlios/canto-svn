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
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface SalaryRangeDao extends SimpleDao<SalaryRange> {

  /**
   * 
   * @param fromLowerBound
   * @param toLowerBound
   * @param fromUpperBound
   * @param toUpperBound
   * @return
   */
    public List<SalaryRange> getSalaryRangesByBound(Float fromLowerBound, 
            Float toLowerBound, Float fromUpperBound, Float toUpperBound);
    
    
}
