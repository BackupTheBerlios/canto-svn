/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.module;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Control implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4096023070198635792L;
    
    private String name_;
    private ControlSetting setting_;
    private int minRun_;
    private int maxRun_;
    
    /**
     * @return the maxRun
     */
    public int getMaxRun() {
        return this.maxRun_;
    }
    /**
     * @param maxRun the maxRun to set
     */
    public void setMaxRun(int maxRun) {
        this.maxRun_ = maxRun;
    }
    /**
     * @return the minRun
     */
    public int getMinRun() {
        return this.minRun_;
    }
    /**
     * @param minRun the minRun to set
     */
    public void setMinRun(int minRun) {
        this.minRun_ = minRun;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    /**
     * @return the setting
     */
    public ControlSetting getSetting() {
        return this.setting_;
    }
    /**
     * @param setting the setting to set
     */
    public void setSetting(ControlSetting setting) {
        this.setting_ = setting;
    }
    
    
}
