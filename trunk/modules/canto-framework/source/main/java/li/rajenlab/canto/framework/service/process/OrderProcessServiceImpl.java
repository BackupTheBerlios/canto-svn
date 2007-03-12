/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.process;

import li.rajenlab.canto.framework.domain.common.CantoProcessState;
import li.rajenlab.canto.framework.domain.order.OrderProcessState;
import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.domain.event.contenthandler.ObjectContentHandler;
import li.rajenlab.common.service.event.EventProcessor;
import li.rajenlab.common.service.event.EventQueue;
import li.rajenlab.common.service.process.eventmapper.TriggerEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderProcessServiceImpl implements OrderProcessService {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(OrderProcessServiceImpl.class);
    private EventQueue eventQueue_;
    private EventProcessor eventProcessor_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
   
    /**
     * @see li.rajenlab.canto.framework.service.process.OrderProcessService#scheduleProvisionOrder(java.lang.String, boolean)
     */
    public OrderProcessState scheduleProvisionOrder(String orderId, boolean immediateFlag) {
        log.info("scheduleProvisionOrder " + orderId + " immediate " + immediateFlag);
        
        String method = immediateFlag ? CantoProcessState.METHOD_PROVISION_ORDER.getValue() : CantoProcessState.METHOD_SCHEDULE.getValue();
        TriggerEvent trigger = new TriggerEvent(orderId,method);
        
        return sendToProcess(CantoProcessState.PROCESS_URL_PROVISION_ORDER.getValue(), trigger);
    }
   

    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------
    private OrderProcessState sendToProcess( String processUrl, TriggerEvent triggerEvent ) {
        
        Event event = new Event();
        Attachment reqAttachment = new Attachment( new ObjectContentHandler(triggerEvent));
        event.addAttachment( StandardEventProperties.REQUEST_ATTACHMENT_NAME, reqAttachment);
        event.addProperty( StandardEventProperties.SEND_TO, processUrl);

        getEventQueue().push( event );
        getEventProcessor().process();
        
        // the resulting state after sync is returned synchronously
        Attachment responseAttachment = event.getAttachment(StandardEventProperties.RESPONSE_ATTACHMENT_NAME);
        OrderProcessState resultingState = (OrderProcessState)responseAttachment.getContentHandlerObject();
        
        return resultingState;
    }

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    
    /**
     * @return the eventProcessor
     */
    public EventProcessor getEventProcessor() {
        return this.eventProcessor_;
    }
    /**
     * @param eventProcessor the eventProcessor to set
     */
    public void setEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessor_ = eventProcessor;
    }
    /**
     * @return the eventQueue
     */
    public EventQueue getEventQueue() {
        return this.eventQueue_;
    }
    /**
     * @param eventQueue the eventQueue to set
     */
    public void setEventQueue(EventQueue eventQueue) {
        this.eventQueue_ = eventQueue;
    }


 
  

}
