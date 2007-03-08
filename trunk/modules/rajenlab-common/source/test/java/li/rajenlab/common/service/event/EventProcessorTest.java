package li.rajenlab.common.service.event;


import junit.framework.TestCase;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.facade.EventFacade;

public class EventProcessorTest extends TestCase {

	public void testProcess() {
		EventProcessorImpl processor = new EventProcessorImpl();
		EventQueueImpl queue = new EventQueueImpl();
		EventDispatcherMock dispatcher = new EventDispatcherMock();
		
		processor.setEventQueue(queue);
		processor.setEventDispatcher(dispatcher);
		
		EventFacade eventfacade = new EventFacade();
		for( int i = 0; i < 10; i++ ) {
			Event ev = eventfacade.constructEvent();
			queue.push(ev);
		}
		
		processor.process();
		
		assertTrue( dispatcher.getEvents().size() == 10);
	}

}
