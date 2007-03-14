package li.rajenlab.common.service.event;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.facade.EventFacade;



public class EventDispatcherTest extends TestCase {

	public void testProcess() {
		EventDispatcherImpl dispatcher = new EventDispatcherImpl();
		dispatcher.setNoMatchCausesErrorFlag(true);
		
		EventChainInvokerMock chain1 = new EventChainInvokerMock();
		EventChainInvokerMock chain2 = new EventChainInvokerMock();

		Map<String,Object> dispatchMap = new HashMap<String,Object>();
		dispatchMap.put("urn://processA", chain1);
		dispatchMap.put("urn://processB", chain2);
		
		dispatcher.setDispatchMap(dispatchMap);
		EventFacade eventfacade = new EventFacade();
		for( int i = 0; i < 10; i++ ) {
			Event ev = eventfacade.constructEvent();
			ev.addProperty(StandardEventProperties.SEND_TO, "urn://processA/methodCall");
			dispatcher.dispatch(ev);
		}
		for( int i = 0; i < 10; i++ ) {
			Event ev = eventfacade.constructEvent();
			ev.addProperty(StandardEventProperties.SEND_TO, "urn://processB/methodcall");
			dispatcher.dispatch(ev);
		}
		assertTrue( chain1.getEvents().size() == 10);
		assertTrue( chain2.getEvents().size() == 10);

		boolean failed = false;
		try {
			Event ev = eventfacade.constructEvent();
			ev.addProperty(StandardEventProperties.SEND_TO, "urn://nowhere");
			dispatcher.dispatch(ev);
		} catch ( Exception e ) {
			failed = true;
		}
		assertTrue( failed );
	}
}
