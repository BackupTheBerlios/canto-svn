/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.chain;

import java.lang.reflect.Constructor;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class ChainFactoryBean implements FactoryBean {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------

    private static final String DEFAULT_IMPLEMENTATION = "li.rajenlab.common.service.chain.DefaultChainImpl";
    
    private String implementation_;
    private List handler_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    @SuppressWarnings("cast")
    public Object getObject() throws Exception {
        if(implementation_ == null) {
            implementation_ = DEFAULT_IMPLEMENTATION;
        }
        if(handler_ == null || handler_.size() <= 0) {
            throw new Exception("Please add at least one handler to the chain");
        }
        Class chainClass = Class.forName(implementation_);
        if(!Chain.class.isAssignableFrom(chainClass)) {
            throw new Exception("Please specify a valid implementation class that implements the Chain interface");
        }
        // constructing the actual chain.
        Constructor constructor = chainClass.getConstructor(new Class[]{List.class});
        return (Chain)constructor.newInstance(new Object[]{handler_});
    }

    public Class getObjectType() {
        return Chain.class;
    }

    public boolean isSingleton() {
        return false;
    }
    
    public List getHandler() {
        return handler_;
    }

    public void setHandler(List handler) {
        this.handler_ = handler;
    }

    public String getImplementation() {
        return implementation_;
    }

    public void setImplementation(String implementation) {
        this.implementation_ = implementation;
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
}
