/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.job;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class JobLevel extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4495938312470551631L;
    
    private String level_;
    private int levelCode_;
    
    /**
     * @return the level
     */
    public String getLevel() {
        return this.level_;
    }
    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level_ = level;
    }
    /**
     * @return the levelCode
     */
    public int getLevelCode() {
        return this.levelCode_;
    }
    /**
     * @param levelCode the levelCode to set
     */
    public void setLevelCode(int levelCode) {
        this.levelCode_ = levelCode;
    }
   

}
