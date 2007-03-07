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
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class ResourceDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Resource>
        implements ResourceDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Resource> getEntityClass() {
        return Resource.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "code";
    }


    /**
     * @see li.rajenlab.canto.core.dao.resource.ResourceDao#searchResource(li.rajenlab.canto.core.domain.resource.SearchResourceCriteria)
     */
    @SuppressWarnings("unchecked")
    public List<Resource> searchResource(final SearchResourceCriteria criteria) {
        
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Resource.class);
        
        if (StringUtils.hasText(criteria.getCode())){
            detachedCriteria.add(Restrictions.eq("code",criteria.getCode()));
        }
        
        if (criteria.getResourceType() !=null){
            detachedCriteria.add(Restrictions.eq("resourceType",criteria.getResourceType()));
        }
        
        if (criteria.getSettings()!=null){
            for (String key : criteria.getSettings().keySet()){
                detachedCriteria.add(Restrictions.eq("settings.SETTINGS_NAME", key));
                detachedCriteria.add(Restrictions.eq("settings.SETTINGS_VALUE",criteria.getSettings().get(key)));
            }
        }
        
        return getHibernateTemplate().findByCriteria(detachedCriteria,0,criteria.getMaxSearchResult());
        
    }
   

}
