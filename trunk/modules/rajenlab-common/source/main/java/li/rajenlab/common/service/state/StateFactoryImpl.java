/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class StateFactoryImpl implements BeanFactoryAware, InitializingBean, StateFactory {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(StateFactoryImpl.class);

    private BeanFactory beanFactory_;
    private Map<String,String> stateBeanMap_;
    private List<String> stateRefs_;
    private String initialStateRef_;
    private String finalStateRef_;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    
    
    /**
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        stateBeanMap_ = new HashMap<String,String>();
        for( int i = 0; stateRefs_ != null && i < stateRefs_.size(); i++ ) {
            String beanName = stateRefs_.get(i);
            State state = (State)beanFactory_.getBean(beanName);
            stateBeanMap_.put(state.getName(), beanName);
        }
    }
    /**
     * @see li.rajenlab.common.service.state.StateFactory#getFinalState()
     */
    public State getFinalState() {
        if ( getFinalStateRef() != null ) {
            return (State)beanFactory_.getBean(getFinalStateRef());
        }
        return null;
    }

    /**
     * @see li.rajenlab.common.service.state.StateFactory#getInitialState()
     */
    public State getInitialState() {
        if ( getInitialStateRef() != null ) {
            return (State)beanFactory_.getBean(getInitialStateRef());
        }
        return null;
    }

    /**
     * @see li.rajenlab.common.service.state.StateFactory#getState(java.lang.String)
     */
    public synchronized State getState(String stateName) {
        String beanName = stateBeanMap_.get(stateName);
        if ( beanName == null ) {
            throw new RuntimeException("No bean name configured for " + stateName);
        }
        State state = (State)beanFactory_.getBean(beanName);
        return state;
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
     * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
     */
    public void setBeanFactory( BeanFactory beanFactory ) throws BeansException {
        this.beanFactory_ = beanFactory;
    }

    public String getFinalStateRef() {
        return finalStateRef_;
    }

    public void setFinalStateRef(String finalStateRef) {
        this.finalStateRef_ = finalStateRef;
    }

    public String getInitialStateRef() {
        return initialStateRef_;
    }

    public void setInitialStateRef(String initialStateRef) {
        this.initialStateRef_ = initialStateRef;
    }
    
    public List<String> getStateRefs() {
        return stateRefs_;
    }

    public void setStateRefs(List<String> stateRefs) {
        this.stateRefs_ = stateRefs;
    }
}
