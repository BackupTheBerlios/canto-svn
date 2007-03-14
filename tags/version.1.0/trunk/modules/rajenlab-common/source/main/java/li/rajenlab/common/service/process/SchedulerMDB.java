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

import java.util.Iterator;
import java.util.List;

import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import li.rajenlab.common.domain.process.ProcessInstance;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.ejb.support.AbstractMessageDrivenBean;

/**
 * SchedulerMDB is an MDB implementation which delegates periodic onSchedule
 * calls to a SchedulerListener SpringBean.
 * 
 * Used to trigger Processes at regular intervals.
 * 
 * In ejb-jar.xml you need to configure the ejb-class with the fully 
 * qualified name of the SchedulerMDB, and set the env entry with name
 * SchedulerListener. The activation-config-property named "period"
 * determines how often the onSchedule() method is called. The 
 * activatin-config-property named "schedulername" is just used to keep
 * activation contexts separate from one another.
 * Example ejb-jar.xml:
 * 
        <message-driven>
            <ejb-name>BatchSchedulerProcessSchedulerMDB</ejb-name>
            <ejb-class>li.rajenlab.common.service.process.SchedulerMDB</ejb-class>
            <messaging-type>li.rajenlab.common.service.process.Scheduler</messaging-type>
            <transaction-type>Bean</transaction-type>
            <activation-config>
                <activation-config-property>
                    <activation-config-property-name>period</activation-config-property-name>
                    <activation-config-property-value>60000</activation-config-property-value>
                </activation-config-property>
                <activation-config-property>
                    <activation-config-property-name>schedulerName</activation-config-property-name>
                    <activation-config-property-value>service.BatchSchedulerProcess</activation-config-property-value>
                </activation-config-property>
            </activation-config>
            ...
        </message-driven>
        
 * 
 * In jboss.xml need to link each resource reference with jndi and
 * declare the resource-adapter-name as "schedulerra.rar".
 * 
        <message-driven>
            <ejb-name>BatchSchedulerProcessSchedulerMDB</ejb-name>
            <resource-adapter-name>schedulerra.rar</resource-adapter-name>
            <resource-ref>
                <res-ref-name>ra/FileProducer</res-ref-name>
                <jndi-name>java:/FileProducer</jndi-name>
            </resource-ref>
            <depends>jboss:name=CantoBarrier,type=Barrier</depends>
        </message-driven>
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SchedulerMDB extends AbstractMessageDrivenBean implements
        MessageDrivenBean {

    private static final long serialVersionUID = 8808699368539479980L;

    private Log log = LogFactory.getLog(SchedulerMDB.class);

    private SchedulerListener schedulerListener_;
    private String schedulerListenerBeanRef_;
    
    /**
     * EJB lifecycle method. Load shared Spring Application Context.
     */
    @Override
    public void setMessageDrivenContext(MessageDrivenContext messageDrivenContext)
    {
        super.setMessageDrivenContext( messageDrivenContext );
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
     * EJB lifecycle method. Create the Spring Application Context and retrieve
     * the SchedulerListener from it given the name in the MDB's environment.
     */
    @Override
    public void onEjbCreate()
    {
        log.info("SchedulerMDB created.");
        try {
            InitialContext iniCtx = new InitialContext();
            Context envCtx = (Context) iniCtx.lookup("java:comp/env");
            
            // setup the SchedulerListener
            schedulerListenerBeanRef_ = (String) envCtx.lookup("SchedulerListener");
            schedulerListener_ = (SchedulerListener)getBeanFactory().getBean(schedulerListenerBeanRef_);
            
        } catch ( NamingException ne ) {
            throw new RuntimeException("Could not find MDB ENV configuration for SchedulerListener", ne);
        }
            
    }
    
    /**
     * Schedule up to maxTimersPerSchedule ready ProcessTimers.
     */
    public void onSchedule() {
        log.debug("onSchedule called " + schedulerListenerBeanRef_);
        long startTime = System.currentTimeMillis();
        try {
            if ( schedulerListener_ != null ) {
                int maxTimers = schedulerListener_.getMaxTimersPerSchedule();
                int maxSelect = schedulerListener_.getMaxTimersPerSelect();
                if ( maxTimers > 0 && maxSelect > 0) {
                    int timersProcessed = 0;
                    int totalProcessed = 0;
                    do {
                        timersProcessed = 0;
                        List list = schedulerListener_.getReadyTimers(maxSelect);
                        Iterator listenerIterator = list.iterator();
                        while( listenerIterator.hasNext() && totalProcessed <= maxTimers ) 
                        {
                            ProcessInstance instance = (ProcessInstance)listenerIterator.next();
                            schedulerListener_.onTimer(instance);
                            
                            timersProcessed++;
                            totalProcessed++;
                        }
                    } while( timersProcessed == maxSelect && totalProcessed <= maxTimers );
                    // if timersProcessed == maxTimers then we fetched a whole batch
                    // and we could potentially fetch and process more without delay.
                    // if weve not maxed out
                } else {
                    log.warn("Not fetching timers since maxTimersPerSchedule=" + maxTimers + " and maxTimersPerSelect=" + maxSelect);
                }
            }
        } catch ( Throwable t ) {
            log.error("Error in onSchedule " + schedulerListenerBeanRef_, t);
        }
        long endTime = System.currentTimeMillis();
        long scheduledDuration = endTime - startTime;
        log.info("onSchedule finish " + schedulerListenerBeanRef_ + " in " + scheduledDuration + " ms.");
    }

}
