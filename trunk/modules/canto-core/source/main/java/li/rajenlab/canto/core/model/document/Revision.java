/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.document;

import li.rajenlab.canto.core.model.BeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Revision extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 6384406929911344567L;
    private String revisionUrl_;
    private byte[] revision_;
    private String revisionName_;

    
    /**
     * @return the revision
     */
    public byte[] getRevision() {
        return this.revision_;
    }
    /**
     * @param revision the revision to set
     */
    public void setRevision(byte[] revision) {
        this.revision_ = revision;
    }
   
    /**
     * @return the revisionName
     */
    public String getRevisionName() {
        return this.revisionName_;
    }
    /**
     * @param revisionName the revisionName to set
     */
    public void setRevisionName(String revisionName) {
        this.revisionName_ = revisionName;
    }
    /**
     * @return the revisionUrl
     */
    public String getRevisionUrl() {
        return this.revisionUrl_;
    }
    /**
     * @param revisionUrl the revisionUrl to set
     */
    public void setRevisionUrl(String revisionUrl) {
        this.revisionUrl_ = revisionUrl;
    }
    
    

}
