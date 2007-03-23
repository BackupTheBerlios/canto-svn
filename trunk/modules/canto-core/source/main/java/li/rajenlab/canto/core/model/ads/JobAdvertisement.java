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
import java.util.List;

import li.rajenlab.canto.core.model.job.profile.JobProfile;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class JobAdvertisement implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 9197241589439645989L;
    private String id_;
    private String jobAdUID_;
    
    private JobProfile jobProfile_;
    public List<JobAdvertisementPublication> publications_;

    
  
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
     * @return the jobAdUID
     */
    public String getJobAdUID() {
        return this.jobAdUID_;
    }
    /**
     * @param jobAdUID the jobAdUID to set
     */
    public void setJobAdUID(String jobAdUID) {
        this.jobAdUID_ = jobAdUID;
    }
    /**
     * @return the jobProfile
     */
    public JobProfile getJobProfile() {
        return this.jobProfile_;
    }
    /**
     * @param jobProfile the jobProfile to set
     */
    public void setJobProfile(JobProfile jobProfile) {
        this.jobProfile_ = jobProfile;
    }
    /**
     * @return the publications
     */
    public List<JobAdvertisementPublication> getPublications() {
        return this.publications_;
    }
    /**
     * @param publications the publications to set
     */
    public void setPublications(List<JobAdvertisementPublication> publications) {
        this.publications_ = publications;
    }
    
    

}
