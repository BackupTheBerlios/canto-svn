/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.catering;

import java.util.List;

import li.rajenlab.canto.core.domain.catering.Catering;
import li.rajenlab.canto.core.domain.catering.CateringType;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface CateringDao extends SimpleDao<Catering> {
    
    /**
     * Get all catering of a specific type
     * @param type
     * @return
     */
    public List<Catering> getCateringsByType(CateringType type);

}
