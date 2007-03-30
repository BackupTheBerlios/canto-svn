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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */

@Entity
@Table(name="CONFERENCE_ATTRIBUTES")
public class ConferenceAttribute implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4074548979221579743L;

    @Id
    @Column(name="ATTR_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator = "CONF_ATTR_PK_ID_GENERATOR")
    @TableGenerator(name="TBL_PK_ID_GENERATOR", table = "PK_ID_GENERATOR", pkColumnName = "PK", valueColumnName = "PK_VALUE", pkColumnValue = "ConfAttrPK")
    private int id;
    
    @ManyToOne
    @JoinColumn(name="CONFERENCE_ID", nullable=false)
    private Conference conference;
    
    @Column(name="ATTR_NAME",length=50,nullable=false)
    private String attributeName;
    
    @Column(name="ATTR_TYPE",nullable=false)
    @Enumerated(value=EnumType.STRING)
    private ConferenceAttributeType attributeType;
    
    @Column(name="ATTR_VAL__STRING")
    private String attributeValueString;
  
    @Column(name="ATTR_VAL_INTEGER")
    private Integer attributeValueNumeric;
    
    @Column(name="ATTR_VAL__DATE")
    private Date attributeValueDate;

    /**
     * @return the attributeName
     */
    public String getAttributeName() {
        return this.attributeName;
    }

    /**
     * @param attributeName the attributeName to set
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * @return the attributeType
     */
    public ConferenceAttributeType getAttributeType() {
        return this.attributeType;
    }

    /**
     * @param attributeType the attributeType to set
     */
    public void setAttributeType(ConferenceAttributeType attributeType) {
        this.attributeType = attributeType;
    }

    /**
     * @return the attributeValueDate
     */
    public Date getAttributeValueDate() {
        return this.attributeValueDate;
    }

    /**
     * @param attributeValueDate the attributeValueDate to set
     */
    public void setAttributeValueDate(Date attributeValueDate) {
        this.attributeValueDate = attributeValueDate;
    }

    /**
     * @return the attributeValueNumeric
     */
    public Integer getAttributeValueNumeric() {
        return this.attributeValueNumeric;
    }

    /**
     * @param attributeValueNumeric the attributeValueNumeric to set
     */
    public void setAttributeValueNumeric(Integer attributeValueNumeric) {
        this.attributeValueNumeric = attributeValueNumeric;
    }

    /**
     * @return the attributeValueString
     */
    public String getAttributeValueString() {
        return this.attributeValueString;
    }

    /**
     * @param attributeValueString the attributeValueString to set
     */
    public void setAttributeValueString(String attributeValueString) {
        this.attributeValueString = attributeValueString;
    }

    /**
     * @return the conference
     */
    public Conference getConference() {
        return this.conference;
    }

    /**
     * @param conference the conference to set
     */
    public void setConference(Conference conference) {
        this.conference = conference;
    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    

}
