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

import li.rajenlab.canto.core.domain.participant.Participant;
import li.rajenlab.canto.core.domain.resource.Resource;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public abstract class AbstractEventEntity extends AbstractEntity {
    
    
    
    private Participant organizer_;
    private Set<Resource> resources_;
    private Date startDate_;
    private Date endDate_;  
    private Resource location_;
    
    
    
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
    public Participant getOrganizer() {
        return this.organizer_;
    }
    /**
     * @param organizer the organizer to set
     */
    public void setOrganizer(Participant organizer) {
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
     * @return the location
     */
    public Resource getLocation() {
        return this.location_;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(Resource location) {
        this.location_ = location;
    }

}
