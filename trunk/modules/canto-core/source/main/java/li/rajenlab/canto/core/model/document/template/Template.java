/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.document.template;

import java.io.Serializable;

import li.rajenlab.canto.core.model.document.DocumentType;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Template implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -4894185445022392858L;
    private String id_;
    private String templateName_;
    private byte []template_;
    private DocumentType type_;
    
   

}
