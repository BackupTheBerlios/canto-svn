/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.booking;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import li.rajenlab.canto.core.domain.common.Note;
import li.rajenlab.canto.core.domain.crm.Customer;
import li.rajenlab.canto.core.domain.market.SalesChannel;
import li.rajenlab.canto.core.domain.payment.PaymentType;
import li.rajenlab.common.domain.AbstractEntity;
import li.rajenlab.common.domain.security.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Booking extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1768916612642750215L;
    private List<BookingItem> items_;
    private Customer customer_;
    private Date startDate_;
    private Date endDate_;
    private User createdBy_;
    private User lastModifiedBy_;
    private SalesChannel orderChannel_;
    private PaymentType paymentType_;
    private String bookingNr_;
    private BookingStatus status_;
    private Set<Note> notes_;
    
    
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
     * @return the status
     */
    public BookingStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(BookingStatus status) {
        this.status_ = status;
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
     * @return the customer
     */
    public Customer getCustomer() {
        return this.customer_;
    }
    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer_ = customer;
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
     * @return the items
     */
    public List<BookingItem> getItems() {
        return this.items_;
    }
    /**
     * @param items the items to set
     */
    public void setItems(List<BookingItem> items) {
        this.items_ = items;
    }
    
    public synchronized void addItem(BookingItem item){
        if (getItems()==null){
            items_ = new Vector<BookingItem>();
        }
        items_.add(item);
    }
    
    public synchronized void removeItem(BookingItem item){
        if (getItems()!=null){
            items_.remove(item);
        }
    }
    
    /**
     * @return the lastModifiedBy
     */
    public User getLastModifiedBy() {
        return this.lastModifiedBy_;
    }
    /**
     * @param lastModifiedBy the lastModifiedBy to set
     */
    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy_ = lastModifiedBy;
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
     * @return the orderChannel
     */
    public SalesChannel getOrderChannel() {
        return this.orderChannel_;
    }
    /**
     * @param orderChannel the orderChannel to set
     */
    public void setOrderChannel(SalesChannel orderChannel) {
        this.orderChannel_ = orderChannel;
    }
    /**
     * @return the paymentType
     */
    public PaymentType getPaymentType() {
        return this.paymentType_;
    }
    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType_ = paymentType;
    }
    /**
     * @return the bookingNr
     */
    public String getBookingNr() {
        return this.bookingNr_;
    }
    /**
     * @param bookingNr the bookingNr to set
     */
    public void setBookingNr(String bookingNr) {
        this.bookingNr_ = bookingNr;
    }
    
    
    
    
    

}
