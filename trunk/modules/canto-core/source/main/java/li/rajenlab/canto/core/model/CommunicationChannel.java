/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class CommunicationChannel implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1564592810651170875L;
    private int id_;
    private String name_;
    
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
    
    
}
