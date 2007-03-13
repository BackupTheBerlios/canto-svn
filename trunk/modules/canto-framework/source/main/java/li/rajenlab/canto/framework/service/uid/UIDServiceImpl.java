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

import java.util.Map;

import li.rajenlab.canto.framework.dao.uid.UidDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class UIDServiceImpl implements UIDService {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(UIDServiceImpl.class);
    private Map<UIDType,UidDao> UidDaos_;
    
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    
    /**
     * @see li.rajenlab.canto.framework.service.uid.UIDService#generate(li.rajenlab.canto.framework.service.uid.UIDType)
     */
    public String generate(UIDType uidType) {
        UidDao uidDao = getUidDaos().get(uidType);
        if (uidDao==null){
            throw new IllegalArgumentException("UidDao not found for uidType["+uidType+"]");
        }
        return uidDao.getNextUidWithPrefix();
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    /**
     * @return the uidDaos
     */
    public Map<UIDType, UidDao> getUidDaos() {
        return this.UidDaos_;
    }

    /**
     * @param uidDaos the uidDaos to set
     */
    public void setUidDaos(Map<UIDType, UidDao> uidDaos) {
        this.UidDaos_ = uidDaos;
    }

   

    

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    

}
