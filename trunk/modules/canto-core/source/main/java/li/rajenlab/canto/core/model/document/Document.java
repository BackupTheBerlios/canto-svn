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

import java.util.Date;

import li.rajenlab.canto.core.model.BeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Document extends BeanEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3678522003373910766L;
    private Date activeDate_;
    private Date expiryDate_;
    private Revision documentRevisionId_;
    private String fileName_;
    private Document relatedDocument_;
    private boolean isTemplate_;
    private String contentType_;
    

}
