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
    private ContentHandler contentHandler;

    private Properties properties = new Properties();
    private byte[] content;
    private String contentType;
    
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
        return contentHandler;
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
        this.contentHandler.attach(this);
    }

    public byte[] getContent() {
        return content;
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
        return content != null ? content.length : 0;
    }
    
    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void addProperty( String name, String value ) {
        properties.put(name,value);
    }
    
    public String getProperty( String name ) {
        return (String)properties.get(name);
    }
    
    public void removeProperty( String name ) {
        properties.remove(name);
    }
    
    public Properties getProperties() {
        return properties;
    }
    
    public void addProperties( Properties properties ) {
        this.properties.putAll(properties);
    }
    
    @SuppressWarnings("unchecked")
    public List<String> getPropertyNames() {
        return new ArrayList( properties.keySet() );
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append( "ContentType=").append( contentType );
        if ( content != null ) {
            s.append(" Length=" ).append( content.length ).append("\n");
        } else {
            s.append(" No content.\n");
        }
        Iterator iterator = this.properties.keySet().iterator();
        while( iterator.hasNext() ) {
            String key = (String)iterator.next();
            s.append( key ).append("=").append(this.properties.get(key)).append("\n");
        }
        if ( contentHandler != null ) {
            s.append(" Content=").append(contentHandler);
        }
        return s.toString();
    }
}
