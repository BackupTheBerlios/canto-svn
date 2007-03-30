/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.model.resource;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import li.rajenlab.canto.model.user.User;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="RESOURCE")
public class Resource implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -991945193624610258L;

    @Id
    @Column(name="RESOURCE_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator = "RES_PK_ID_GENERATOR")
    @TableGenerator(name="TBL_PK_ID_GENERATOR", table = "PK_ID_GENERATOR", pkColumnName = "PK", valueColumnName = "PK_VALUE", pkColumnValue = "ResourcePK")
    private int resourceId;
    
    @Column(name="TITLE")
    private String title;
    
    @Column(name="CONTENT_TYPE")
    private String contentType;
    
    @Column(name="TYPE")
    @Enumerated(value=EnumType.STRING)
    private ResourceType type;
    
    @Column(name="UPLOAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
   
    @Column(name="RESOURCE_URL")
    private String resourceUrl;
    
    
    @OneToOne(mappedBy="resource", cascade = CascadeType.ALL)
    @JoinColumn(name="RESOURCE_DATA", referencedColumnName = "RESDATA_ID")
    private ResourceData data;
    
    
    @ManyToOne
    @JoinColumn(name="USER", referencedColumnName = "USERNAME", nullable=false)
    private User uploadedBy;


    /**
     * @return the contentType
     */
    public String getContentType() {
        return this.contentType;
    }


    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    /**
     * @return the data
     */
    public ResourceData getData() {
        return this.data;
    }


    /**
     * @param data the data to set
     */
    public void setData(ResourceData data) {
        this.data = data;
    }


    /**
     * @return the resourceId
     */
    public int getResourceId() {
        return this.resourceId;
    }


    /**
     * @param resourceId the resourceId to set
     */
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }


    /**
     * @return the resourceUrl
     */
    public String getResourceUrl() {
        return this.resourceUrl;
    }


    /**
     * @param resourceUrl the resourceUrl to set
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
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


    /**
     * @return the type
     */
    public ResourceType getType() {
        return this.type;
    }


    /**
     * @param type the type to set
     */
    public void setType(ResourceType type) {
        this.type = type;
    }


    /**
     * @return the uploadDate
     */
    public Date getUploadDate() {
        return this.uploadDate;
    }


    /**
     * @param uploadDate the uploadDate to set
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }


    /**
     * @return the uploadedBy
     */
    public User getUploadedBy() {
        return this.uploadedBy;
    }


    /**
     * @param uploadedBy the uploadedBy to set
     */
    public void setUploadedBy(User uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    
    

}
