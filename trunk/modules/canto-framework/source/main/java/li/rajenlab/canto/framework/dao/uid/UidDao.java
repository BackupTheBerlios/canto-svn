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


/**
 * Interface definition of the persistence layer of the UID
 * @author  RothR (raphael.roth@sunrise.net)
 * @version $Id$
 */
public interface UidDao {
    
    /**
     * Get next Uid.
     * @return the next Uid
     */
    public abstract int getNextUid();
}
