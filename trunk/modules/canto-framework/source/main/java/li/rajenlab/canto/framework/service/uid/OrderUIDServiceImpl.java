/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.uid;

import li.rajenlab.canto.framework.dao.uid.UidDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderUIDServiceImpl implements OrderUIDService {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(OrderUIDServiceImpl.class);
    private UidDao orderUidDao_;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.framework.service.uid.OrderUIDService#generate()
     */
    public String generate() {
        int uid = getOrderUidDao().getNextUid();
        return "O"+uid;
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    /**
     * @return the orderUidDao
     */
    public UidDao getOrderUidDao() {
        return this.orderUidDao_;
    }

    /**
     * @param orderUidDao the orderUidDao to set
     */
    public void setOrderUidDao(UidDao orderUidDao) {
        this.orderUidDao_ = orderUidDao;
    }

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    

}
