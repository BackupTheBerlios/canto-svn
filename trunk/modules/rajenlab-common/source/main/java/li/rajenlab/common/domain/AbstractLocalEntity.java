/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain;


/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class AbstractLocalEntity extends AbstractEntity {
    
    private String localeKey_;

    
    /**
     * @return the localeKey
     */
    public String getLocaleKey() {
        return this.localeKey_;
    }
    /**
     * @param localeKey the localeKey to set
     */
    public void setLocaleKey(String localeKey) {
        this.localeKey_ = localeKey;
    }
   
}
