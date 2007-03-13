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

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface UIDService {
    
    
    public abstract String generate(UIDType uidType);

}
