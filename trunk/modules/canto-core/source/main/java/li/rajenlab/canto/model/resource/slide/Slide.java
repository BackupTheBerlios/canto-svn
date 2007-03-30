/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.model.resource.slide;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import li.rajenlab.canto.model.user.User;
import javax.persistence.ManyToOne;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="SLIDE")
public class Slide implements Serializable {
    
    
   /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 8295463212771370776L;

@Id
   @Column(name="SLIDE_ID")
   @GeneratedValue(strategy=GenerationType.TABLE, generator = "SLIDE_PK_ID_GENERATOR")
   @TableGenerator(name="TBL_PK_ID_GENERATOR", table = "PK_ID_GENERATOR", pkColumnName = "PK", valueColumnName = "PK_VALUE", pkColumnValue = "SlidePK")
   private int slideId;
   
   @Column(name="NAME",length=150)
   private String slideName;
   
   @Column(name="THUMBNAIL_SIZE") 
   private long slideThumbnailSize;
   
   @Column(name="SLIDE_SIZE")
   private long slideSize;
   
   @OneToOne(mappedBy="slide")
   @JoinColumn(name="THUMBNAIL", referencedColumnName = "SLIDEDATA_ID")
   private SlideData thumbnail;
   
   @OneToOne(mappedBy="slide")
   @JoinColumn(name="SLIDE_NORMAL", referencedColumnName = "SLIDEDATA_ID")
   private SlideData slideNormal;
   
   @Column(name="UPLOAD_DATE")
   @Temporal(TemporalType.TIMESTAMP)
   private Date uploadDate;
   
   @ManyToOne
   @JoinColumn(name="USER", referencedColumnName = "USERNAME", nullable=false)
   private User uploadedBy;

    /**
     * @return the slideId
     */
    public int getSlideId() {
        return this.slideId;
    }
    
    /**
     * @param slideId the slideId to set
     */
    public void setSlideId(int slideId) {
        this.slideId = slideId;
    }
    
    /**
     * @return the slideName
     */
    public String getSlideName() {
        return this.slideName;
    }
    
    /**
     * @param slideName the slideName to set
     */
    public void setSlideName(String slideName) {
        this.slideName = slideName;
    }
    
    /**
     * @return the slideSize
     */
    public long getSlideSize() {
        return this.slideSize;
    }
    
    /**
     * @param slideSize the slideSize to set
     */
    public void setSlideSize(long slideSize) {
        this.slideSize = slideSize;
    }
    
    /**
     * @return the slideThumbnailSize
     */
    public long getSlideThumbnailSize() {
        return this.slideThumbnailSize;
    }
    
    /**
     * @param slideThumbnailSize the slideThumbnailSize to set
     */
    public void setSlideThumbnailSize(long slideThumbnailSize) {
        this.slideThumbnailSize = slideThumbnailSize;
    }

    /**
     * @return the slideNormal
     */
    public SlideData getSlideNormal() {
        return this.slideNormal;
    }

    /**
     * @param slideNormal the slideNormal to set
     */
    public void setSlideNormal(SlideData slideNormal) {
        this.slideNormal = slideNormal;
    }

    /**
     * @return the thumbnail
     */
    public SlideData getThumbnail() {
        return this.thumbnail;
    }

    /**
     * @param thumbnail the thumbnail to set
     */
    public void setThumbnail(SlideData thumbnail) {
        this.thumbnail = thumbnail;
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
       
       
   
    
    
    
    

}
