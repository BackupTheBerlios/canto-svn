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

package li.rajenlab.canto.core.dao.resource;

import java.util.List;

import li.rajenlab.canto.core.domain.resource.Resource;
import li.rajenlab.canto.core.domain.resource.SearchResourceCriteria;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface ResourceDao extends SimpleDao<Resource> {
    
    /**
     * Get all POAs that match the criteria. All attributes 
     * specified in the criteria param are conjuncted.
     * @param criteria
     * @return resource
     */
    public List<Resource> searchResource(SearchResourceCriteria criteria);

}
