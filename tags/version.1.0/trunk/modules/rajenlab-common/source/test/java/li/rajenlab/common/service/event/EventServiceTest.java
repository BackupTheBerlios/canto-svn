package li.rajenlab.common.service.event;

import junit.framework.TestCase;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.facade.EventFacade;


public class EventServiceTest extends TestCase {

	public void testSerializeDeserialize() throws Exception {
		EventFacade eventfacade = new EventFacade();
		
		Event event = eventfacade.constructEvent();
		EventService service = new EventServiceImpl();
		byte[] bytes = service.serialize(event);
		Event readevent = service.deserialize(bytes);
		
		assertTrue( event != readevent );
		System.out.println("old " + event.toString());
		System.out.println("new " + readevent.toString());
		assertEquals( event.toString(), readevent.toString());
		
		byte[] writebytes = service.serialize(readevent);
		assertBytesEquals( bytes, writebytes );
	}
	
	private void assertBytesEquals( byte[] ar1, byte[] ar2) {
		assertEquals( ar1.length, ar2.length);
		for( int i = 0; i < ar1.length; i++){
			assertEquals( ar1[i], ar2[i] );
		}
	}
	
}
