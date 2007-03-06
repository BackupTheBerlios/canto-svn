/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.event;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface ContentHandler {
    
    
    /**
     * Get the ContentType supported by this ContentHandler. There is a 1:1
     * relationship between ContentType and ContentHandler.
     * 
     * @return the ContentType supported by this ContentHandler.
     */
    public String getContentType();
    
    /**
     * Attach to the Attachment. If the ContentHandler contains a content
     * object then this must be transferred to the Attachment in bytes. If
     * the ContentHandler does not contain a content object, then it should
     * try and interpret any content in the Attachment and form the content
     * object.
     * 
     * @param attachment the Attachment to attach to.
     */
    public void attach( Attachment attachment );
    
    /**
     * A convenience method to return the ContentHandler's content
     * as an object without having to cast to the concrete implementation
     * of the content handler to do getContent().
     * 
     * @see Attachment#getContentObject
     * 
     * @return the ContentHandler's object.
     */
    public Object getContentObject();

}
