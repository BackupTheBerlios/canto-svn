/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.order;

import li.rajenlab.common.domain.AbstractEntity;

import org.springframework.core.style.ToStringCreator;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderXML extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1445444543555724477L;
    private String xml_;
    private Order order_;
    
    /**
     * @return the order
     */
    public Order getOrder() {
        return this.order_;
    }
    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order_ = order;
    }
    /**
     * @return the xml
     */
    public String getXml() {
        return this.xml_;
    }
    /**
     * @param xml the xml to set
     */
    public void setXml(String xml) {
        this.xml_ = xml;
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("xml", getXml())
            .toString();
    }
    

}
