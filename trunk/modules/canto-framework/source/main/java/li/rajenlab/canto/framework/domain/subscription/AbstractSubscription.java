/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.subscription;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.util.StringUtils;

import li.rajenlab.canto.framework.domain.account.Account;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class AbstractSubscription extends AbstractEntity {

    
    private Account account_;
    private Date startDate_;
    private Date endDate_;
    private SubscriptionStatus status_;
    private int rollover_;
    private Map<String,String> attributes_;
    
    /**
     * @return the account
     */
    public Account getAccount() {
        return this.account_;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account_ = account;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return this.endDate_;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate_ = endDate;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate_;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate_ = startDate;
    }

    /**
     * @return the status
     */
    public SubscriptionStatus getStatus() {
        return this.status_;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(SubscriptionStatus status) {
        this.status_ = status;
    }

    /**
     * @return the rollover
     */
    public int getRollover() {
        return this.rollover_;
    }

    /**
     * @param rollover the rollover to set
     */
    public void setRollover(int rollover) {
        this.rollover_ = rollover;
    }

    /**
     * @return the attributes
     */
    public Map<String, String> getAttributes() {
        return this.attributes_;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(Map<String, String> attributes) {
        this.attributes_ = attributes;
    }
    
    /**
     * Adds attributes to the Subscription.
     * 
     * @param name the name of the attributes.
     * @param value the value of the attributes.
     */
    public synchronized void addAttribute( String name, String value ) {
        if ( getAttributes() == null ) {
            setAttributes( new HashMap<String,String>() );
        }
        getAttributes().put(name,value);
    }
    
    /**
     * Adds attributes to the Subscription but only if the attributes is not set already.
     * 
     * @param name the name of the attributes.
     * @param value the value of the attributes.
     */
    public synchronized void addAttributeIfMissing( String name, String value ) {
        if ( getAttributes() == null ) {
            setAttributes( new HashMap<String,String>() );
        }
        if ( getAttributeValue(name) != null && 
                            !StringUtils.hasText(getAttributeValue(name))) {
            getAttributes().put(name,value);
        }
    }
    
    /**
     * Adds attributes to the Subscription. If the value is already set, the new value is appended 
     * to the current value (separated by a comma).
     * 
     * @param name the name of the attributes.
     * @param value the value of the attributes.
     */
    public synchronized void mergeAttributeTokenized( String name, String value, String token ) {
        if ( getAttributes() == null ) {
            setAttributes( new HashMap<String,String>() );
        }
        String attributeValue = getAttributeValue(name);
        if (StringUtils.hasText(attributeValue)) {
            StringTokenizer st = new StringTokenizer(attributeValue, token);
            
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals(value)){
                    // not necessary to add a value twice
                    return;
                }
            }

            // value not present but other content -> append value
            attributeValue = attributeValue + token + value;

        } else {
            // metadata value not set before
            attributeValue = value;
        }
        getAttributes().put(name,StringUtils.trimAllWhitespace(attributeValue));
        
    }
    
    /**
     * Gets attributes value from the Subscription of a certain key.
     * 
     * @param name the name of the attributes.
     */
    public synchronized String getAttributeValue (String name) {
        return (getAttributes() != null ? getAttributes().get(name) : null);
    }

    /**
     * Removes attributes from the Subscription.
     * 
     * @param name the name of the attributes.
     */
    public synchronized void removeAttribute( String name ) {
        if ( getAttributes() != null ) {
            getAttributes().remove(name);
        }
    }
    
}
