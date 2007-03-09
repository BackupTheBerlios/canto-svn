/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.order;

import li.rajenlab.canto.framework.domain.order.Order;
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
    private OrderProcessMethodNameResolver orderProcessMethodNameResolver_;
    private EventQueue eventQueue_;
    private EventProcessor eventProcessor_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.framework.service.order.OrderProcessService#processOrder(li.rajenlab.canto.framework.domain.order.Order)
     */
    public OrderProcessState processOrder(Order order) {
        
        try {
            String methodName = getOrderProcessMethodNameResolver().resolveProcessMethodName(order.getOrderType());
            TriggerEvent trigger = new TriggerEvent(order.getOrderId(),methodName);
           
            return sendToProcess("urn://processOrder",trigger);
            
        } catch (Exception e) {
            return OrderProcessState.FAILED;
        }
      
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------
    private OrderProcessState sendToProcess( String processUrl, TriggerEvent trigger ) {
        
        Event event = new Event();
        Attachment reqAttachment = new Attachment( new ObjectContentHandler(trigger));
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
     * @return the orderProcessMethodNameResolver
     */
    public OrderProcessMethodNameResolver getOrderProcessMethodNameResolver() {
        return this.orderProcessMethodNameResolver_;
    }

    /**
     * @param orderProcessMethodNameResolver the orderProcessMethodNameResolver to set
     */
    public void setOrderProcessMethodNameResolver(
            OrderProcessMethodNameResolver orderProcessMethodNameResolver) {
        this.orderProcessMethodNameResolver_ = orderProcessMethodNameResolver;
    }
    
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
