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

package li.rajenlab.common.service.event;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.ContentHandler;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.domain.event.contenthandler.BinaryContentHandler;
import li.rajenlab.common.domain.event.contenthandler.EmptyContentHandler;
import li.rajenlab.common.domain.event.contenthandler.ObjectContentHandler;
import li.rajenlab.common.domain.event.contenthandler.StringContentHandler;
import li.rajenlab.common.domain.event.contenthandler.XmlContentHandler;

/**
 * An EventService implementation which recognizes several configured 
 * ContentHandlers.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class EventServiceImpl implements EventService {

	private Map<String,Class> contentHandlerClassMap_ = new HashMap<String,Class> ();
	
	/**
	 * Whether or not the {@link StandardEventProperties#SENT_TIMESTAMP} and
	 * {@link StandardEventProperties#RECEIVED_TIMESTAMP} should be sent
	 * on serialization and deserialization respectively.
	 */
	private boolean timestampFlag_;
	
	public EventServiceImpl() {
		contentHandlerClassMap_.put( new BinaryContentHandler().getContentType(), BinaryContentHandler.class);
		contentHandlerClassMap_.put( new StringContentHandler().getContentType(), StringContentHandler.class);
		contentHandlerClassMap_.put( new XmlContentHandler().getContentType(), XmlContentHandler.class );
		contentHandlerClassMap_.put( new ObjectContentHandler().getContentType(), ObjectContentHandler.class);
		contentHandlerClassMap_.put( new EmptyContentHandler().getContentType(), EmptyContentHandler.class);
	}
	
	public byte[] serialize(Event event) {
		if ( event == null ) {
			throw new IllegalArgumentException("event");
		}
		try {
			if ( isTimestampFlag() ) {
				event.addProperty(StandardEventProperties.SENT_TIMESTAMP, "" + System.currentTimeMillis());
			}
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream daos = new DataOutputStream(baos);
			
			writeProperties(event.getProperties(), daos);
			
			List attachmentList = event.getAttachmentNames();
			daos.writeInt(attachmentList.size());
			Iterator attachmentIterator = attachmentList.iterator();
			while ( attachmentIterator.hasNext() ) {
				String attachmentname = (String)attachmentIterator.next();
				Attachment attachment = event.getAttachment(attachmentname);
				
				daos.writeUTF(attachmentname);
				daos.writeUTF(attachment.getContentType());
				writeProperties(attachment.getProperties(), daos);

				daos.writeInt(attachment.getContentLength());
				daos.write(attachment.getContent());
			}			
			
			return baos.toByteArray();
		} catch ( IOException iox ) {
			throw new RuntimeException("Unable to serialize Event " + event.toString(), iox);
		}
	}

	private ContentHandler getContentHandler( String contentType ) throws IllegalAccessException, InstantiationException {
		Class contentHandlerClass = contentHandlerClassMap_.get(contentType);
		if ( contentHandlerClass == null ) {
			throw new RuntimeException("No content handler class registered for " + contentType);
		}
		return (ContentHandler)contentHandlerClass.newInstance();
	}
	
	private void writeProperties( Properties properties, DataOutputStream daos ) throws IOException {
		daos.writeInt(properties.size());
		Iterator propertiesIterator = properties.keySet().iterator();
		while ( propertiesIterator.hasNext() ) {
			String key = (String)propertiesIterator.next();
			String value = properties.getProperty(key);
			
			daos.writeUTF(key);
			daos.writeUTF("=");
			daos.writeUTF(value);
		}
	}
	
	private Properties readProperties( DataInputStream dais ) throws IOException {
		Properties properties = new Properties();
		
		int numProperties = dais.readInt();
		for( int i = 0; i < numProperties; i++ ) {
			String key = dais.readUTF();
			dais.readUTF(); // =
			String value = dais.readUTF();
			
			properties.put(key, value);
		}
		return properties;
	}
	
	public Event deserialize(byte[] bytes) {
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			DataInputStream dais = new DataInputStream(bais);
			
			Properties properties = readProperties(dais);
			Event event = new Event(properties);
			
			int numAttachments = dais.readInt();
			for( int i = 0; i < numAttachments; i++ ) {
				String attachmentname = dais.readUTF();
				String contentType = dais.readUTF();
				properties = readProperties(dais);
				
				int contentLength = dais.readInt();
				byte[] content = new byte[contentLength];
				dais.read(content);
				
				Attachment attachment = new Attachment(contentType, content, properties);
				
				attachment.setContentHandler(getContentHandler(contentType));
				
				event.addAttachment(attachmentname, attachment);
			}
			
			if ( isTimestampFlag() ) {
				event.addProperty(StandardEventProperties.RECEIVED_TIMESTAMP, ""+ System.currentTimeMillis());				
			}
			
			return event;
		} catch ( Exception iox ) {
			throw new RuntimeException("Unable to deserialize eventdata.", iox);
		}
	}

	public boolean isTimestampFlag() {
		return timestampFlag_;
	}

	public void setTimestampFlag(boolean timestampFlag) {
		this.timestampFlag_ = timestampFlag;
	}

}
