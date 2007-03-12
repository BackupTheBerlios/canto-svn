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

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

/**
 * @author  RothR (raphael.roth@sunrise.net)
 * @version $Id$
 */
public class OrderUidDaoJdbcTemplateImpl implements UidDao {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    public static final String UID_SEQ_NAME = "ORDER_UID_SEQ";
    
    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(OrderUidDaoJdbcTemplateImpl.class);

    private DataSource dataSource;
    private OracleSequenceMaxValueIncrementer incr;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
   

    public int getNextUid() {
    	return this.incr.nextIntValue();
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

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
    	this.incr = new OracleSequenceMaxValueIncrementer(dataSource, UID_SEQ_NAME);
	}

}
