/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.ads;

import java.io.Serializable;
import java.util.Date;

import li.rajenlab.canto.core.model.document.template.Template;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class JobAdvertisementPublication implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 9001525742637353944L;
    private String id_;
    private Date startDate_;
    private Date endDate_;
    private JobAdvertisementChannel channel_;
    private Template template_;
    private JobAdvertisement jobAdvertisement_;
    
    /**
     * @return the channel
     */
    public JobAdvertisementChannel getChannel() {
        return this.channel_;
    }
    /**
     * @param channel the channel to set
     */
    public void setChannel(JobAdvertisementChannel channel) {
        this.channel_ = channel;
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
     * @return the id
     */
    public String getId() {
        return this.id_;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id_ = id;
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
     * @return the template
     */
    public Template getTemplate() {
        return this.template_;
    }
    /**
     * @param template the template to set
     */
    public void setTemplate(Template template) {
        this.template_ = template;
    }
    /**
     * @return the jobAdvertisement
     */
    public JobAdvertisement getJobAdvertisement() {
        return this.jobAdvertisement_;
    }
    /**
     * @param jobAdvertisement the jobAdvertisement to set
     */
    public void setJobAdvertisement(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisement_ = jobAdvertisement;
    }
    
    
}
