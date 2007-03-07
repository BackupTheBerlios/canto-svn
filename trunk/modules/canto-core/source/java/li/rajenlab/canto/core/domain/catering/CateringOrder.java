/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.catering;

import java.util.HashSet;
import java.util.Set;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class CateringOrder extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5659547879997000427L;
    
    private Set<CateringOrderItem> items_;
    private String orderId_;
    

    /**
     * @return the items
     */
    public Set<CateringOrderItem> getItems() {
        return this.items_;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Set<CateringOrderItem> items) {
        this.items_ = items;
    }
    
    public synchronized void addItem(CateringOrderItem cateringOrderItem){
        if (getItems()!=null){
            items_ = new HashSet<CateringOrderItem>();
        }
        items_.add(cateringOrderItem);
    }
    
    public synchronized void removeItem(CateringOrderItem cateringOrderItem){
        if (getItems()!=null){
            items_.remove(cateringOrderItem);
        }
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return this.orderId_;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId_ = orderId;
    }
    
    

}
