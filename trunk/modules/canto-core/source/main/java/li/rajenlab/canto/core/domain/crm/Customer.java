/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.crm;

import java.util.HashSet;
import java.util.Set;

import li.rajenlab.canto.core.domain.common.Note;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Customer extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8565373710659258836L;

    private Contact legalContact_;
    private Contact billingContact_;
    private CustomerType customerType_;
    private Set<Note> notes_;
    private Organization organization_;
    
    /**
     * @return the billingContact
     */
    public Contact getBillingContact() {
        return this.billingContact_;
    }
    /**
     * @param billingContact the billingContact to set
     */
    public void setBillingContact(Contact billingContact) {
        this.billingContact_ = billingContact;
    }
    /**
     * @return the customerType
     */
    public CustomerType getCustomerType() {
        return this.customerType_;
    }
    /**
     * @param customerType the customerType to set
     */
    public void setCustomerType(CustomerType customerType) {
        this.customerType_ = customerType;
    }
   
    /**
     * @return the legalContact
     */
    public Contact getLegalContact() {
        return this.legalContact_;
    }
    /**
     * @param legalContact the legalContact to set
     */
    public void setLegalContact(Contact legalContact) {
        this.legalContact_ = legalContact;
    }
   
    /**
     * @return the notes
     */
    public Set<Note> getNotes() {
        return this.notes_;
    }
    /**
     * @param notes the notes to set
     */
    public void setNotes(Set<Note> notes) {
        this.notes_ = notes;
    }
   
    /**
     * Add note
     * @param note
     */
    public synchronized void addNote(Note note){
        if (getNotes()!=null){
            notes_ = new HashSet<Note>();
        }
        
        notes_.add(note);
    }
    /**
     * @return the organization
     */
    public Organization getOrganization() {
        return this.organization_;
    }
    /**
     * @param organization the organization to set
     */
    public void setOrganization(Organization organization) {
        this.organization_ = organization;
    }
    
    

}
