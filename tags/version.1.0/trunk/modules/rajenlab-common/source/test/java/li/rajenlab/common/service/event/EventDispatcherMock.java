package li.rajenlab.common.service.event;

import java.util.ArrayList;
import java.util.List;

import li.rajenlab.common.domain.event.Event;



public class EventDispatcherMock implements EventDispatcher {

	private List<Event> events = new ArrayList<Event>();
	
	public void dispatch(Event event) {
		events.add(event);
	}

	public List getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	
}
