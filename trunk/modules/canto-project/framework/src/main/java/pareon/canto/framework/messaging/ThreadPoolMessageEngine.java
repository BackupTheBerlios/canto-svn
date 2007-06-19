package pareon.canto.framework.messaging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMessageEngine extends BaseMessagingEventEngine {
	
	protected	static	ExecutorService		threadPool;
	
	protected	static	ExecutorService	getThreadPool() {
		if (ThreadPoolMessageEngine.threadPool == null) {
			ThreadPoolMessageEngine.createThreadPool(20);
		}
		return	ThreadPoolMessageEngine.threadPool;
	}
	
	public	synchronized	static	void	setThreadPoolSize(int numberOfThreads) {
		ThreadPoolMessageEngine.threadPool = Executors.newFixedThreadPool(numberOfThreads);
	}
	
	protected	synchronized	static	void	createThreadPool(int numberOfThreads) {
		if (ThreadPoolMessageEngine.threadPool == null) {
			ThreadPoolMessageEngine.threadPool = Executors.newFixedThreadPool(numberOfThreads);
		}
	}
	

	@Override
	public void checkAddEventReceiver() throws MaxReceiverReachedException {
		// nothing to do
	}

	
	
	
	@Override
	protected void doDispatchEvent(MessagingEvent event,
			MessagingEventReceiverFilter filter) {
		MessageDispatchTask task = new MessageDispatchTask(this,event,filter);
		ThreadPoolMessageEngine.getThreadPool().submit(task);
	}

	@Override
	protected void doDispatchEvent(MessagingEvent event) {
		MessageDispatchTask task = new MessageDispatchTask(this,event,null,null);
		ThreadPoolMessageEngine.getThreadPool().submit(task);
	}

	@Override
	protected void doDispatchEventToAllExcept(MessagingEvent event,
			String... excludeReceiverWithId) {
		MessageDispatchTask task = new MessageDispatchTask(this,event,null,excludeReceiverWithId);
		ThreadPoolMessageEngine.getThreadPool().submit(task);
	}

	@Override
	protected void doDispatchEventToReceiver(MessagingEvent event,
			String... onlyToReceiverWithId) {
		MessageDispatchTask task = new MessageDispatchTask(this,event,onlyToReceiverWithId,null);
		ThreadPoolMessageEngine.getThreadPool().submit(task);
	}

	protected	void	realDispatchEvent(MessagingEvent event) {
		super.doDispatchEvent(event);
	}
	
	protected	void	realDispatchEvent(MessagingEvent event, MessagingEventReceiverFilter filter) {
		super.doDispatchEvent(event, filter);  
	}
	
	protected	void	realDispatchEventToAllExcept(MessagingEvent event, String... excludeReceiverWithId) {
		super.doDispatchEventToAllExcept(event, excludeReceiverWithId);
	}
	
	protected	void	realDispatchEventToReceiver(MessagingEvent event, String... onlyToReceiverWithId) {
		super.doDispatchEventToReceiver(event,onlyToReceiverWithId);
	}

}
