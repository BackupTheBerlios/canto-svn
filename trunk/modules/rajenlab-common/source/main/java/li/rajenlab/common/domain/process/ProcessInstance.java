/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.process;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import li.rajenlab.common.domain.AbstractEntity;

import org.springframework.core.style.ToStringCreator;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProcessInstance extends AbstractEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1857424499997232463L;
    
    private String processName_;
    private String oid_;
    private String stateName_;
    private Map<String,String> variables_;
    private Map<String,byte[]> data_;
    private ProcessTimer timer_;
    private Serializable domainId_;
    
    public String getProcessName() {
        return processName_;
    }

    public void setProcessName(String processName) {
        this.processName_ = processName;
    }

    public String getStateName() {
        return stateName_;
    }

    public void setStateName(String stateName) {
        this.stateName_ = stateName;
    }

    public Map<String,String> getVariables() {
        return variables_;
    }

    public void setVariables(Map<String,String> variables) {
        this.variables_ = variables;
    }

    public String getOid() {
        return oid_;
    }

    public void setOid(String oid) {
        this.oid_ = oid;
    }

    public ProcessTimer getTimer() {
        return timer_;
    }

    public void setTimer(ProcessTimer timer) {
        this.timer_ = timer;
    }

    public Map<String,byte[]> getData() {
        return data_;
    }

    public void setData(Map<String,byte[]> data) {
        this.data_ = data;
    }
    
    public void addVariable( String name, String value ) {
        if ( getVariables() == null ) {
            setVariables(new HashMap<String,String>());
        }
        getVariables().put(name,value);
    }
    
    public String getVariable( String name ) {
        if ( getVariables() != null ) {
            return getVariables().get(name);
        }
        return null;
    }
    
    public void addIntegerVariable( String name, int value ) {
        if ( getVariables() == null ) {
            setVariables(new HashMap<String,String>());
        }
        getVariables().put(name,""+value);
    }
    
    public int getIntegerVariable( String name ) {
        if ( getVariables() != null ) {
            String value = getVariables().get(name);
            if ( value != null ) {
                return Integer.parseInt(value);
            }
        }
        return 0;
    }
    
    public void addData( String name, byte[] value ) {
        if ( getData() == null ) {
            setData(new HashMap<String,byte[]>());
        }
        getData().put(name,value);
    }
    
    public Serializable getDomainId() {
        return domainId_;
    }

    public void setDomainId(Serializable domainId) {
        this.domainId_ = domainId;
    }

    public byte[] getData( String name ) {
        if ( getData() != null ) {
            return getData().get(name);
        }
        return null;
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("process", getProcessName())
            .append("oid", getOid())
            .toString();
    }

}
