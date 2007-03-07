/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import li.rajenlab.canto.core.domain.organizer.Organizer;
import li.rajenlab.canto.core.domain.resource.Resource;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public abstract class AbstractEventEntity extends AbstractEntity {
    
    
    private String title_;
    private String description_;
    private Organizer organizer_;
    private Set<Resource> resources_;
    private Date startDate_;
    private Date endDate_;  
    private Date reminderDate_;
    
    
    
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
     * @return the organizer
     */
    public Organizer getOrganizer() {
        return this.organizer_;
    }
    /**
     * @param organizer the organizer to set
     */
    public void setOrganizer(Organizer organizer) {
        this.organizer_ = organizer;
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
     * @return the resources
     */
    public Set<Resource> getResources() {
        return this.resources_;
    }
    /**
     * @param resources the resources to set
     */
    public void setResources(Set<Resource> resources) {
        this.resources_ = resources;
    }
    
    
    public synchronized void addResource(Resource resource){
        if (getResources()!=null){
            resources_ = new HashSet<Resource>();
        }
        resources_.add(resource);
    }
    
    public synchronized void removeResource(Resource resource){
        if (getResources()!=null){
            resources_.remove(resource);
        }
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return this.description_;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description_ = description;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return this.title_;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title_ = title;
    }
    /**
     * @return the reminderDate
     */
    public Date getReminderDate() {
        return this.reminderDate_;
    }
    /**
     * @param reminderDate the reminderDate to set
     */
    public void setReminderDate(Date reminderDate) {
        this.reminderDate_ = reminderDate;
    }

    
    
}
