/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.model.conference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import li.rajenlab.canto.model.participant.Participant;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="CONFERENCE")
public class Conference implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -4547396797619402531L;

    @Id
    @Column(name="CONFERENCE_ID",length=80,updatable=false)
    private String conferenceId;
    
    @Column(name="CONFERENCE_KEY",length=80,nullable=false)
    private String conferenceKey;
    
    @ManyToOne
    @JoinColumn(name="ORGANIZER_ID", referencedColumnName = "PARTICIPANT_ID")
    private Participant organizer;
    
    @Column(name="CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @Column(name="START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    @Column(name="EXPECTED_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedEndDate;
    
    @Column(name="TITLE",length=150,nullable=false)
    private String title;
    
    @Column(name="DESCRIPTION",length=2000)
    private String description;
    
    @ManyToMany
    @OrderBy
    @JoinTable(joinColumns=@JoinColumn(name="CONFERENCE_ID", referencedColumnName = "CONFERENCE_ID"), inverseJoinColumns = @JoinColumn(name = "PARTICIPANT_ID", referencedColumnName = "PARTICIPANT_ID"), name = "CONFERENCE_PARTICIPANTS")
    private List<Participant> registeredParticipants;
    
    @Column(name="STATE",nullable=false)
    @Enumerated(value=EnumType.STRING)
    private ConferenceState conferenceState;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="conference")
    private List<ConferenceAttribute> conferenceAttributes;
    
    @Column(name="TYPE",nullable=false)
    @Enumerated(value=EnumType.STRING)
    private ConferenceType conferenceType;
    
    
    @Transient
    private List<Participant> currentParticipants;


    /**
     * @return the conferenceId
     */
    public String getConferenceId() {
        return this.conferenceId;
    }


    /**
     * @param conferenceId the conferenceId to set
     */
    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }


    /**
     * @return the conferenceState
     */
    public ConferenceState getConferenceState() {
        return this.conferenceState;
    }


    /**
     * @param conferenceState the conferenceState to set
     */
    public void setConferenceState(ConferenceState conferenceState) {
        this.conferenceState = conferenceState;
    }


    /**
     * @return the currentParticipants
     */
    public List<Participant> getCurrentParticipants() {
        return this.currentParticipants;
    }


    /**
     * @param currentParticipants the currentParticipants to set
     */
    public void setCurrentParticipants(List<Participant> currentParticipants) {
        this.currentParticipants = currentParticipants;
    }


    /**
     * @return the expectedEndDate
     */
    public Date getExpectedEndDate() {
        return this.expectedEndDate;
    }


    /**
     * @param expectedEndDate the expectedEndDate to set
     */
    public void setExpectedEndDate(Date expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }


    /**
     * @return the organizer
     */
    public Participant getOrganizer() {
        return this.organizer;
    }


    /**
     * @param organizer the organizer to set
     */
    public void setOrganizer(Participant organizer) {
        this.organizer = organizer;
    }


    /**
     * @return the registeredParticipants
     */
    public List<Participant> getRegisteredParticipants() {
        return this.registeredParticipants;
    }


    /**
     * @param registeredParticipants the registeredParticipants to set
     */
    public void setRegisteredParticipants(List<Participant> registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }


    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate;
    }


    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    /**
     * @return the conferenceKey
     */
    public String getConferenceKey() {
        return this.conferenceKey;
    }


    /**
     * @param conferenceKey the conferenceKey to set
     */
    public void setConferenceKey(String conferenceKey) {
        this.conferenceKey = conferenceKey;
    }


    /**
     * @return the conferenceAttributes
     */
    public List<ConferenceAttribute> getConferenceAttributes() {
        return this.conferenceAttributes;
    }


    /**
     * @param conferenceAttributes the conferenceAttributes to set
     */
    public void setConferenceAttributes(
            List<ConferenceAttribute> conferenceAttributes) {
        this.conferenceAttributes = conferenceAttributes;
    }


    /**
     * @return the conferenceType
     */
    public ConferenceType getConferenceType() {
        return this.conferenceType;
    }


    /**
     * @param conferenceType the conferenceType to set
     */
    public void setConferenceType(ConferenceType conferenceType) {
        this.conferenceType = conferenceType;
    }


    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return this.createDate;
    }


    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }


    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }


    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    

}
