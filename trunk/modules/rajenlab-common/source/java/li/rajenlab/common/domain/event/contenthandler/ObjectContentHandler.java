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

package li.rajenlab.common.domain.event.contenthandler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.ContentHandler;


/**
 * A ContentHandler for java Objects. 
 * 
 * If the content is not Serializable then the content can still be 
 * transported intra-vm in an Attachment but cannot be serialized by 
 * the EventService.
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class ObjectContentHandler implements ContentHandler {

	public static final String CONTENT_TYPE = "java-application/object";
	
	private Object content;
	private Attachment attachment;
	
	public ObjectContentHandler() {
	}
	
	public ObjectContentHandler( Object content ) {
		this.content = content;
	}
	
	public String getContentType() {
		return CONTENT_TYPE;
	}

	public void attach(Attachment attachment) {
		this.attachment = attachment;
		if ( content != null ) {
			store();
		} else {
			load();
		}
	}

	protected void load() {
		if ( attachment != null ) {
			try {
				content = deserialise(attachment.getContent());
			} catch ( Exception e ) {
				throw new RuntimeException(e);
			}
		}
	}
	
	protected void store() {
		if ( attachment != null ) {
			try {
				attachment.setContent(serialise(content));
			} catch ( NotSerializableException nse ) {
				attachment.setContent(null);
			} catch ( Exception e ) {
				throw new RuntimeException(e);
			}
			attachment.setContentType( CONTENT_TYPE );
		}
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
		store();
	}
	
	public Object getContentObject() {
		return getContent();
	}
	
	/**
	 * convert a serialised byte[] into an Object
	 *
	 * @throws Exception
	 */
	public static Object deserialise (final byte aSerialisedBuffer[])
		throws Exception
	{
		ByteArrayInputStream byteStream = new ByteArrayInputStream (aSerialisedBuffer);
		ObjectInputStream stream = new ObjectInputStream (byteStream);

		Object object = stream.readObject ();
		stream.close ();

		return object;
	}

	/**
	 * persist an Object to a byte[]
	 *
	 * @throws Exception
	 */
	public static byte [] serialise(final Object anObject)
		throws Exception
	{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream ();
		ObjectOutputStream outputStream = new ObjectOutputStream (byteStream);
		outputStream.writeObject (anObject);
		outputStream.flush ();
		outputStream.close ();

		return byteStream.toByteArray ();
	}

	@Override
    public String toString() {
		if ( this.content != null ) {
			return this.content.toString();
		}
		return "";
	}
}
