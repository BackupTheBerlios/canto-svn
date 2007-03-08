/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.process;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.domain.event.contenthandler.ObjectContentHandler;
import li.rajenlab.common.service.event.EventProcessor;
import li.rajenlab.common.service.event.EventQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.ejb.support.AbstractMessageDrivenBean;

/**
 * 
 * * Abstract EventConsumerMDB is a MDB implementation that dispatches 
 * incoming objects as an Event to the EventDispatcher Processor SpringBean.
 *
 * In an EJB project's ejb-jar.xml you need to setup an MDB:
 * <ul>
 *   <li>Declare the spring bean name for an EventProcessor and EventQueue in
 *       the env-entry section.</li>
 *   <li>Declare all JNDI references used to resources used in the spring 
 *       application context and match these in jboss.xml</li>
 *   <li>The event processor optionally adds declared property[X] to the 
 *       Event as event properties</li>
 * </ul>
 *       
 * 
 * <code>
 *         <message-driven>
 *             <ejb-name>...</ejb-name>
 *             <ejb-class>...concrete implementation class...</ejb-class>
 *             <messaging-type>... listener interface of concrete implementation ...</messaging-type>
 *             <transaction-type>Container</transaction-type>
 *             <activation-config>
 *               ... activation config of the concrete implementation ...
 *             </activation-config>
 *             <env-entry>
 *                 <description>EventProcessor bean reference name</description>
 *                 <env-entry-name>EventProcessor</env-entry-name>
 *                 <env-entry-type>java.lang.String</env-entry-type>
 *                 <env-entry-value>EventProcessor</env-entry-value>
 *             </env-entry>
 *             <env-entry>
 *                 <description>EventQueue bean reference name</description>
 *                 <env-entry-name>EventQueue</env-entry-name>
 *                 <env-entry-type>java.lang.String</env-entry-type>
 *                 <env-entry-value>EventQueue</env-entry-value>
 *             </env-entry>
 *             <env-entry>
 *                 <description>Event Property [0]</description>
 *                 <env-entry-name>property[0]</env-entry-name>
 *                 <env-entry-type>...</env-entry-type>
 *                 <env-entry-value>...</env-entry-value>
 *             </env-entry> 
 *             <env-entry>
 *                 <description>Event Property [1]</description>
 *                 <env-entry-name>property[1]</env-entry-name>
 *                 <env-entry-type>...</env-entry-type>
 *                 <env-entry-value>...</env-entry-value>
 *             </env-entry>
 *             <resource-ref>
 *                 <description>DataSource for Database</description>
 *                 <res-ref-name>jdbc/CantoDS</res-ref-name>
 *                 <res-type>javax.sql.DataSource</res-type>
 *                <res-auth>Container</res-auth>
 *             </resource-ref>
 *             <resource-ref>
 *               ... resource ref to the resource adapter of the concrete implementaion  ...
 *             </resource-ref>
 *         </message-driven>
 *     </enterprise-beans>
 *     
 *     <assembly-descriptor>
 *         <container-transaction>
 *             <method>
 *                 <ejb-name>...</ejb-name>
 *                 <method-name>*</method-name>
 *             </method>
 *             <trans-attribute>Required</trans-attribute>
 *         </container-transaction>
 *     </assembly-descriptor>
 * </code
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class EventConsumerMDB extends AbstractMessageDrivenBean
    implements MessageDrivenBean{
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -4871107654108086952L;

    private Log log = LogFactory.getLog(EventConsumerMDB.class);
    
    protected EventProcessor eventProcessor_;
    protected EventQueue eventQueue_;
    protected Map<String, String> eventProperties_ = new HashMap<String, String>();

    /**
     * Set the MessageDrivenContext - MDB lifecycle method.
     *
     * @param messageDrivenContext
     */
    public void setMessageDrivenContext(
        MessageDrivenContext messageDrivenContext) {
        super.setMessageDrivenContext(messageDrivenContext);
        try {
            InitialContext iniCtx = new InitialContext();
            Context envCtx = (Context) iniCtx.lookup("java:comp/env");
            
            // setup the FactoryLocatorKey
            String beanFactoryLocatorKey = (String) envCtx.lookup("BeanFactoryLocatorKey");
            String beanContextFile = (String) envCtx.lookup("BeanContextFile");
            setBeanFactoryLocator(ContextSingletonBeanFactoryLocator.getInstance(beanContextFile));
            setBeanFactoryLocatorKey(beanFactoryLocatorKey);
            
        } catch ( NamingException ne ) {
            throw new RuntimeException("Could not find MDB ENV configuration for SchedulerListener", ne);
        }
    }

    /**
     * onEjbCreate is a MDB lifecycle method. A singleton Spring
     * Application Context is loaded and an EventProcessor and 
     * EventQueue are looked up from it. Additionally the URN or
     * any event properties to set on the dispatched Event 
     * containing the incoming FileInputHandles is
     * configured via the MDB's environment.
     */
    public void onEjbCreate() {
        log.info("EventConsumerMDB onEjbCreate()");

        int index = 0;

        try {
            InitialContext iniCtx = new InitialContext();
            Context envCtx = (Context) iniCtx.lookup("java:comp/env");

            // setup the EventProcessor
            String eventProcessorBeanRef = (String) envCtx.lookup(
                    "EventProcessor");
            eventProcessor_ = (EventProcessor) getBeanFactory()
                                                  .getBean(eventProcessorBeanRef);

            // setup the EventQueue
            String eventQueueBeanRef = (String) envCtx.lookup("EventQueue");
            eventQueue_ = (EventQueue) getBeanFactory().getBean(eventQueueBeanRef);
            log.info("EventQueue " + eventQueue_);

            String eventProperty = null;

            do {
                String eventPropertyName = "property[" + index + "]";

                try {
                    eventProperty = (String) envCtx.lookup(eventPropertyName);

                    int idx = eventProperty.indexOf("=");

                    if (idx > 0) {
                        String key = eventProperty.substring(0, idx);
                        String value = eventProperty.substring(idx + 1);

                        log.info("EventProperty " + key + "=" + value);

                        eventProperties_.put(key, value);
                    } else {
                        log.warn("Illegal MDB EventProperty configured: " +
                            eventProperty);
                    }
                } catch (NamingException ne) {
                    eventProperty = null; // not a problem , we loop until we cant find an entry
                }

                index++;
            } while (eventProperty != null);
        } catch (NamingException ne) {
            throw new RuntimeException("Could not find MDB ENV configuration for EventProcessor or EventQueue",
                ne);
        }
    }

    /**
     * Process a FileInputHandle from the filera JCA adapter. Dispatch
     * the FileInputHandle as an (Object)Event to the EventProcessor.
     *
     * @param eventAttachment will be attached to the event with the name 
     *                  StandardEventProperties.REQUEST_ATTACHMENT_NAME
     */
    public void processEvent(Object eventAttachment) {
        log.debug("->dispatch event");

        Event event = new Event();
        Attachment reqAttachment = new Attachment(new ObjectContentHandler(
                    eventAttachment));
        event.addAttachment(StandardEventProperties.REQUEST_ATTACHMENT_NAME,
            reqAttachment);

        // typically the SendTo URL will be a configured property of the MDB.
        Iterator<String> propertiesIterator = eventProperties_.keySet().iterator();

        while (propertiesIterator.hasNext()) {
            String key = propertiesIterator.next();
            String value = eventProperties_.get(key);

            event.addProperty(key, value);
        }

        try {
            getEventQueue().push(event);
            getEventProcessor().process();
        } catch (RuntimeException e) {
            log.warn("RuntimeException thrown processing event [" +
                eventAttachment + "]", e);
            throw e;
        }
    }

    /**
     * Get the EventProcessor.
     *
     * @return the EventProcessor.
     */
    public EventProcessor getEventProcessor() {
        return eventProcessor_;
    }

    /**
     * Get the configured Event Properties.
     *
     * @return the configured Event Properties.
     */
    public Map<String, String> getEventProperties() {
        return eventProperties_;
    }

    /**
     * Get the EventQueue.
     *
     * @return the EventQueue.
     */
    public EventQueue getEventQueue() {
        return eventQueue_;
    }
}
