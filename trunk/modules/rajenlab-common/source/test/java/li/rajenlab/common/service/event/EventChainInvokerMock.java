package li.rajenlab.common.service.event;

import java.util.ArrayList;
import java.util.List;

import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.service.chain.ChainException;
import li.rajenlab.common.service.event.chain.EventChainInvoker;



public class EventChainInvokerMock implements EventChainInvoker {

	public List<Event> events = new ArrayList<Event>();
	
	public void invokeChain(Event event) throws ChainException {
		events.add(event);
	}

	public List getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
