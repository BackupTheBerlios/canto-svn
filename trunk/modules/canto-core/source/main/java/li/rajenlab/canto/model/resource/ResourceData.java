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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="RESOURCE_DATA")
public class ResourceData implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2480195592175291719L;


    @Id
    @Column(name="RESDATA_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator = "RESDATA_PK_ID_GENERATOR")
    @TableGenerator(name="TBL_PK_ID_GENERATOR", table = "PK_ID_GENERATOR", pkColumnName = "PK", valueColumnName = "PK_VALUE", pkColumnValue = "ResourceDataPK")
    private int resourceDataId;
 
    
    @OneToOne(mappedBy="data")
    @JoinColumn(name="RESOURCE", referencedColumnName = "RESOURCE_ID")
    private Resource resource;
    
    @Column(name="data")
    private byte[] data;

}
