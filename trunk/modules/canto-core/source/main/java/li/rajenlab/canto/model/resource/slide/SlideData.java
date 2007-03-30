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

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="SLIDE_DATA")
public class SlideData {
    
    @Id
    @Column(name="SLIDEDATA_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator = "SLIDEDATA_PK_ID_GENERATOR")
    @TableGenerator(name="TBL_PK_ID_GENERATOR", table = "PK_ID_GENERATOR", pkColumnName = "PK", valueColumnName = "PK_VALUE", pkColumnValue = "SlideDataPK")
    private int slideDataId;
    
    
    @ManyToOne
    @JoinColumn(name="SLIDE", referencedColumnName = "SLIDE_ID")
    private Slide slide;
    
    @Column(name="IS_THUMBNAIL")
    private boolean isThumbnail;
    
    @Column(name="DATA")
    private byte[] data;

}
