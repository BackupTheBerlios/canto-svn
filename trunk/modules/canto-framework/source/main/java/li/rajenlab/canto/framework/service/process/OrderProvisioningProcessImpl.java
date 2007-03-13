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
public class OrderProvisioningProcessImpl implements OrderProvisioningProcess {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(OrderProvisioningProcessImpl.class);
    private EventQueue eventQueue;
    private EventProcessor eventProcessor;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * 
     * @see li.rajenlab.canto.framework.service.process.OrderProvisioningProcess#scheduleOrderProvisioningStep(java.lang.String)
     */
    public OrderProvisioningProcessState scheduleOrderProvisioningStep(
            String orderProvisioningId) {
        log.info("scheduleOrderProvisioningStep " + orderProvisioningId);
        
        TriggerEvent trigger = new TriggerEvent(orderProvisioningId,
                OrderProvisioningProcessState.METHOD_PROCESS_ORDER_PROVISIONING_STEP.getValue());
        
        Event event = new Event();
        Attachment reqAttachment = new Attachment( new ObjectContentHandler(trigger));
        event.addAttachment( StandardEventProperties.REQUEST_ATTACHMENT_NAME, reqAttachment);
        event.addProperty( StandardEventProperties.SEND_TO, 
                OrderProvisioningProcessState.PROCESS_URL_ORDER_PROVISIONING_STEP.getValue());

        getEventQueue().push( event );
        getEventProcessor().process();
        
        Attachment responseAttachment = event.getAttachment(StandardEventProperties.RESPONSE_ATTACHMENT_NAME);
        OrderProvisioningProcessState resultingState = (OrderProvisioningProcessState)
                                            responseAttachment.getContentHandlerObject();
        return resultingState;
        
       }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

   

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
        return this.eventProcessor;
    }

    /**
     * @param eventProcessor the eventProcessor to set
     */
    public void setEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    /**
     * @return the eventQueue
     */
    public EventQueue getEventQueue() {
        return this.eventQueue;
    }

    /**
     * @param eventQueue the eventQueue to set
     */
    public void setEventQueue(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

}
