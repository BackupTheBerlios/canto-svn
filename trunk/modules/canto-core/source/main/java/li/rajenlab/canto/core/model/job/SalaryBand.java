/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.job;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SalaryBand implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 7072016922895503721L;
    private int id_;
    private String name_;
    private float downBand_;
    private float upperBand_;
    
    /**
     * @return the downBand
     */
    public float getDownBand() {
        return this.downBand_;
    }
    /**
     * @param downBand the downBand to set
     */
    public void setDownBand(float downBand) {
        this.downBand_ = downBand;
    }
    /**
     * @return the id
     */
    public int getId() {
        return this.id_;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id_ = id;
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
     * @return the upperBand
     */
    public float getUpperBand() {
        return this.upperBand_;
    }
    /**
     * @param upperBand the upperBand to set
     */
    public void setUpperBand(float upperBand) {
        this.upperBand_ = upperBand;
    }
    
    

}
