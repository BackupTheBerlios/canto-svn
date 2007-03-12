/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import li.rajenlab.common.domain.AbstractEntity;
import li.rajenlab.common.domain.security.User;

import org.springframework.util.StringUtils;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Order extends AbstractEntity{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7583837354691861873L;
    
   private String orderId_; 
   private OrderType orderType_;
   private OrderStatus orderStatus_;
   private Map<String,String> orderAttributes_;
   private User createdBy_;
   private Set<OrderNote> orderNotes_;
   private OrderXML orderXml_;
   
    /**
     * @return the orderAttributes
     */
    public Map<String, String> getOrderAttributes() {
        return this.orderAttributes_;
    }
    /**
     * @param orderAttributes the orderAttributes to set
     */
    public void setOrderAttributes(Map<String, String> orderAttributes) {
        this.orderAttributes_ = orderAttributes;
    }
    /**
     * @return the orderStatus
     */
    public OrderStatus getOrderStatus() {
        return this.orderStatus_;
    }
    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus_ = orderStatus;
    }
    /**
     * @return the orderType
     */
    public OrderType getOrderType() {
        return this.orderType_;
    }
    /**
     * @param orderType the orderType to set
     */
    public void setOrderType(OrderType orderType) {
        this.orderType_ = orderType;
    }
   
    
    /**
     * Adds OrderAttribute to the Order.
     * 
     * @param name the name of the OrderAttribute.
     * @param value the value of the OrderAttribute.
     */
    public synchronized void addOrderAttribute( String name, String value ) {
        if ( getOrderAttributes() == null ) {
            setOrderAttributes( new HashMap<String,String>() );
        }
        getOrderAttributes().put(name,value);
    }
    
    /**
     * Adds OrderAttribute to the Order but only if the OrderAttribute is not set already.
     * 
     * @param name the name of the OrderAttribute.
     * @param value the value of the OrderAttribute.
     */
    public synchronized void addOrderAttributeIfMissing( String name, String value ) {
        if ( getOrderAttributes() == null ) {
            setOrderAttributes( new HashMap<String,String>() );
        }
        if ( getOrderAttributeValue(name) != null && !StringUtils.hasText(getOrderAttributeValue(name))) {
            getOrderAttributes().put(name,value);
        }
    }
    
    /**
     * Adds OrderAttribute to the order. If the value is already set, the new value is appended 
     * to the current value (separated by a comma).
     * 
     * @param name the name of the OrderAttribute.
     * @param value the value of the OrderAttribute.
     */
    public synchronized void mergeOrderAttributeTokenized( String name, String value, String token ) {
        if ( getOrderAttributes() == null ) {
            setOrderAttributes(new HashMap<String,String>() );
        }
        String orderAttributeValue = getOrderAttributeValue(name);
        if (StringUtils.hasText(orderAttributeValue)) {
            StringTokenizer st = new StringTokenizer(orderAttributeValue, token);
            
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals(value)){
                    // not necessary to add a value twice
                    return;
                }
            }

            // value not present but other content -> append value
            orderAttributeValue = orderAttributeValue + token + value;

        } else {
            // OrderAttribute value not set before
            orderAttributeValue = value;
        }
        getOrderAttributes().put(name,StringUtils.trimAllWhitespace(orderAttributeValue));
        
    }
    
    /**
     * Gets OrderAttribute value from the Order of a certain key.
     * 
     * @param name the name of the metadata.
     */
    public synchronized String getOrderAttributeValue (String name) {
        return (getOrderAttributes() != null ? getOrderAttributes().get(name) : null);
    }

    /**
     * Removes OrderAttribute from the Order.
     * 
     * @param name the name of the metadata.
     */
    public synchronized void removeOrderAttribute( String name ) {
        if ( getOrderAttributes() != null ) {
            getOrderAttributes().remove(name);
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
    /**
     * @return the createdBy
     */
    public User getCreatedBy() {
        return this.createdBy_;
    }
    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy_ = createdBy;
    }
    /**
     * @return the orderNotes
     */
    public Set<OrderNote> getOrderNotes() {
        return this.orderNotes_;
    }
    /**
     * @param orderNotes the orderNotes to set
     */
    public void setOrderNotes(Set<OrderNote> orderNotes) {
        this.orderNotes_ = orderNotes;
    }
    /**
     * @return the orderXml
     */
    public OrderXML getOrderXml() {
        return this.orderXml_;
    }
    /**
     * @param orderXml the orderXml to set
     */
    public void setOrderXml(OrderXML orderXml) {
        this.orderXml_ = orderXml;
    }
   
   

}