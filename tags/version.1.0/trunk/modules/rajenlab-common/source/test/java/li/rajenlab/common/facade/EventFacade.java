package li.rajenlab.common.facade;

import java.util.Properties;

import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.contenthandler.BinaryContentHandler;
import li.rajenlab.common.domain.event.contenthandler.EmptyContentHandler;
import li.rajenlab.common.domain.event.contenthandler.ObjectContentHandler;
import li.rajenlab.common.domain.event.contenthandler.StringContentHandler;
import li.rajenlab.common.domain.event.contenthandler.XmlContentHandler;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;



public class EventFacade {

	public Event constructEvent() {
		Event event = new Event();
		
		String attachmentname = "string";
		Attachment a1 = constructStringAttachment(attachmentname, "helloworld");
		a1.addProperties(constructProperties(attachmentname, 10));
		event.addAttachment(attachmentname, a1);
		
		attachmentname = "binary";
		Attachment a2 = constructBinaryAttachment(attachmentname, "helloworld".getBytes());
		a2.addProperties(constructProperties(attachmentname, 0));
		event.addAttachment(attachmentname, a2);
		
		attachmentname = "object";
		Attachment a3 = constructObjectAttachment(attachmentname, "helloworld");
		a3.addProperties(constructProperties(attachmentname, 0));
		event.addAttachment(attachmentname, a3);
		
		attachmentname = "xml";
		Attachment a4 = constructXmlAttachment(attachmentname);
		a4.addProperties(constructProperties(attachmentname, 0));
		event.addAttachment(attachmentname, a4);
		
		attachmentname = "empty";
		Attachment a5 = constructEmptyAttachment(attachmentname);
		a5.addProperties(constructProperties(attachmentname, 0));
		event.addAttachment(attachmentname, a5);
		
		return event;
	}
	
	public Attachment constructEmptyAttachment(String prefix ) {
		Attachment attachment = new Attachment( new EmptyContentHandler());
		return attachment;
	}
	
	public Attachment constructXmlAttachment(String prefix ) {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("root");
		root.addAttribute("attr","attrvalue");
		root.addElement("child");
		
		Attachment attachment = new Attachment( new XmlContentHandler(doc));
		return attachment;
	}
	
	public Attachment constructObjectAttachment(String prefix, Object obj ) {
		Attachment attachment = new Attachment( new ObjectContentHandler(obj));
		return attachment;
	}
	
	public Attachment constructBinaryAttachment(String prefix, byte[] value) {
		Attachment attachment = new Attachment( new BinaryContentHandler(value));
		return attachment;
	}
	
	public Attachment constructStringAttachment(String prefix, String value) {
		Attachment attachment = new Attachment( new StringContentHandler(value));
		return attachment;
	}
	
	protected Properties constructProperties(String prefix, int numProperties) {
		Properties properties = new Properties();
		for( int i = 0; i < numProperties ; i++ ) {
			String key = prefix + i;
			String value = prefix + i + "value";
			properties.put(key, value);
		}
		return properties;
	}

}
