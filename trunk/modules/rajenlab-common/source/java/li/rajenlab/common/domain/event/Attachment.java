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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import li.rajenlab.common.domain.event.contenthandler.EmptyContentHandler;

/**
 *  A part of an Event which contains content of a certain ContentType and
 * any number of Properties. A ContentHandler can be associated with an 
 * Attachment to assist in serialization and deserialization from the 
 * byte[] content into usefull Objects.
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Attachment {

    private ContentHandler contentHandler_;
    private Properties properties_ = new Properties();
    private byte[] content_;
    private String contentType_;
    
    public Attachment() {
        this( new EmptyContentHandler() );
    }

    public Attachment( String contentType, byte[] content, Properties properties ){
        setContentType(contentType);
        setContent(content);
        addProperties(properties);
    }
    
    public Attachment( ContentHandler contentHandler ){
        setContentHandler(contentHandler);
    }
    
    public ContentHandler getContentHandler() {
        return contentHandler_;
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler_ = contentHandler;
        this.contentHandler_.attach(this);
    }

    public byte[] getContent() {
        return content_;
    }

    /**
     * Convenience method to get the Content from the ContentHandler as an
     * Object.
     * 
     * @see ContentHandler#getContentObject()
     * 
     * @return the Content from the ContentHandler as an Object.
     */
    public Object getContentHandlerObject() {
        if ( getContentHandler() != null ) {
            return getContentHandler().getContentObject();
        }
        return null;
    }
    
    public int getContentLength() {
        return content_ != null ? content_.length : 0;
    }
    
    public void setContent(byte[] content) {
        this.content_ = content;
    }

    public String getContentType() {
        return contentType_;
    }

    public void setContentType(String contentType) {
        this.contentType_ = contentType;
    }

    public void addProperty( String name, String value ) {
        properties_.put(name,value);
    }
    
    public String getProperty( String name ) {
        return (String)properties_.get(name);
    }
    
    public void removeProperty( String name ) {
        properties_.remove(name);
    }
    
    public Properties getProperties() {
        return properties_;
    }
    
    public void addProperties( Properties properties ) {
        this.properties_.putAll(properties);
    }
    
    @SuppressWarnings("unchecked")
    public List<String> getPropertyNames() {
        return new ArrayList( properties_.keySet() );
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append( "ContentType=").append( contentType_ );
        if ( content_ != null ) {
            s.append(" Length=" ).append( content_.length ).append("\n");
        } else {
            s.append(" No content.\n");
        }
        Iterator iterator = this.properties_.keySet().iterator();
        while( iterator.hasNext() ) {
            String key = (String)iterator.next();
            s.append( key ).append("=").append(this.properties_.get(key)).append("\n");
        }
        if ( contentHandler_ != null ) {
            s.append(" Content=").append(contentHandler_);
        }
        return s.toString();
    }
}
