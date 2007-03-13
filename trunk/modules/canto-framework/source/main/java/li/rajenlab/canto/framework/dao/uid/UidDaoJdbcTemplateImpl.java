/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.dao.uid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class UidDaoJdbcTemplateImpl implements UidDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(UidDaoJdbcTemplateImpl.class);

    private DataFieldMaxValueIncrementer incrementer_;
    private String prefix_ = "U";
   
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.framework.dao.uid.UidDao#getNextUid()
     */
    public long getNextUid() {
        return incrementer_.nextLongValue();
    }
    
    /**
     * @see li.rajenlab.canto.framework.dao.uid.UidDao#getNextUidWithPrefix()
     */
    public String getNextUidWithPrefix() {
        return getPrefix()!=null ? getPrefix() : "U" + getNextUid();
    }

    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

 

    /**
     * @return the incrementer
     */
    public DataFieldMaxValueIncrementer getIncrementer() {
        return this.incrementer_;
    }

    /**
     * @param incrementer the incrementer to set
     */
    public void setIncrementer(DataFieldMaxValueIncrementer incrementer) {
        this.incrementer_ = incrementer;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return this.prefix_;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix_ = prefix;
    }

        //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    
   

}
