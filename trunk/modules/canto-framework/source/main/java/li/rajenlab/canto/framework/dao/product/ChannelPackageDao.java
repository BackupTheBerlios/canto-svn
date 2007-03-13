/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.dao.product;

import java.util.List;

import li.rajenlab.canto.framework.domain.product.ChannelPackage;
import li.rajenlab.canto.framework.domain.product.ChannelPackageStatus;
import li.rajenlab.canto.framework.domain.product.ChannelPackageType;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ChannelPackageDao extends SimpleDao<ChannelPackage> {
    
    /**
     * Get a list of channel package by type
     * @param type
     * @return
     */
    public List<ChannelPackage> getChannelPackagesByType(ChannelPackageType type);
    
    /**
     * Get channel package by uid
     * @param uid
     * @return
     * @throws EntityNotFoundException
     */
    public ChannelPackage getChannelPackageByUid(String uid) throws EntityNotFoundException;
    
    /**
     * Get channel package by status
     * @param status
     * @return
     */
    public List<ChannelPackage> getChannelPackagesByStatus(ChannelPackageStatus status);

}
