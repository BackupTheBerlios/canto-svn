/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.job.application;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import li.rajenlab.canto.core.model.Applicant;
import li.rajenlab.canto.core.model.CommunicationChannel;
import li.rajenlab.canto.core.model.action.Action;
import li.rajenlab.canto.core.model.ads.JobAdvertisement;
import li.rajenlab.canto.core.model.ads.JobAdvertisementPublication;
import li.rajenlab.canto.core.model.document.Document;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class JobApplication implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -6134708860269509474L;
    
    private JobAdvertisement jobAdvertisement_;
    private JobAdvertisementPublication publication_;
    
    private Date applicationDate_;
    private CommunicationChannel applicationEntryChannel_;
    private JobApplicationStatus applicationStatus_;
    private Set<Action> actions_;
    private List<Document> applicationDocuments_;
    private Applicant applicant_;
   
    
    /**
     * @return the applicationDate
     */
    public Date getApplicationDate() {
        return this.applicationDate_;
    }
    /**
     * @param applicationDate the applicationDate to set
     */
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate_ = applicationDate;
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
    /**
     * @return the publication
     */
    public JobAdvertisementPublication getPublication() {
        return this.publication_;
    }
    /**
     * @param publication the publication to set
     */
    public void setPublication(JobAdvertisementPublication publication) {
        this.publication_ = publication;
    }
    /**
     * @return the applicationEntryChannel
     */
    public CommunicationChannel getApplicationEntryChannel() {
        return this.applicationEntryChannel_;
    }
    /**
     * @param applicationEntryChannel the applicationEntryChannel to set
     */
    public void setApplicationEntryChannel(
            CommunicationChannel applicationEntryChannel) {
        this.applicationEntryChannel_ = applicationEntryChannel;
    }
    /**
     * @return the applicationStatus
     */
    public JobApplicationStatus getApplicationStatus() {
        return this.applicationStatus_;
    }
    /**
     * @param applicationStatus the applicationStatus to set
     */
    public void setApplicationStatus(JobApplicationStatus applicationStatus) {
        this.applicationStatus_ = applicationStatus;
    }
    /**
     * @return the actions
     */
    public Set<Action> getActions() {
        return this.actions_;
    }
    /**
     * @param actions the actions to set
     */
    public void setActions(Set<Action> actions) {
        this.actions_ = actions;
    }
    /**
     * @return the applicationDocuments
     */
    public List<Document> getApplicationDocuments() {
        return this.applicationDocuments_;
    }
    /**
     * @param applicationDocuments the applicationDocuments to set
     */
    public void setApplicationDocuments(List<Document> applicationDocuments) {
        this.applicationDocuments_ = applicationDocuments;
    }
    /**
     * @return the applicant
     */
    public Applicant getApplicant() {
        return this.applicant_;
    }
    /**
     * @param applicant the applicant to set
     */
    public void setApplicant(Applicant applicant) {
        this.applicant_ = applicant;
    }
    
    
    
    
   

}
