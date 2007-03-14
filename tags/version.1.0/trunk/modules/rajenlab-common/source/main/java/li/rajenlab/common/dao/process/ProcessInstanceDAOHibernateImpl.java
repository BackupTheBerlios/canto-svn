/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * Copyright: (c) TDC Switzerland AG 2005
 * 
 ******************************************************************************
 * Project: poc
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.dao.process;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import li.rajenlab.common.domain.process.ProcessInstance;
import li.rajenlab.common.domain.process.ProcessTimer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ProcessInstanceDAOHibernateImpl extends HibernateDaoSupport 
    implements ProcessInstanceDAO {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(ProcessInstanceDAOHibernateImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    public ProcessInstance findByOid(String processName, String oid) {
        
        String query = "from ProcessInstance pi where pi.processName = ? and pi.oid = ?";
        List qr = getHibernateTemplate().find(query, new Object[]{processName, oid});
        if ( qr.size() > 1 ) {
        	log.warn("More than one ProcessInstance found for process " + processName + " with oid " + oid);
        } else if ( qr.size() == 0 ) {
        	return null;
        }
        return (ProcessInstance)qr.get(0);
    }
    
    @SuppressWarnings("unchecked")
    public List<ProcessInstance> findByState(String processName, String stateName) {
        String query = "from ProcessInstance pi where pi.processName = ? and pi.stateName = ?";
        return getHibernateTemplate().find(query, new Object[]{processName, stateName});
    }
    
    @SuppressWarnings("unchecked")
    public List<ProcessInstance> findByVariable(String processName, String variableName, String variableValue ) {
        String query = "from ProcessInstance pi where pi.processName = ? and pi.variables[?] = ?";
        return getHibernateTemplate().find(query, new Object[]{variableName, processName, variableValue});
    }
    
    @SuppressWarnings("unchecked")
    public List<ProcessInstance> findByDomainId(String processName, Serializable domainId ) {
        String query = "from ProcessInstance pi where pi.processName = ? and pi.domainId = ?";
        return getHibernateTemplate().find(query, new Object[]{processName, domainId});
    }
    
    @SuppressWarnings("unchecked")
    public List<ProcessTimer> findByTimerReady(String processName, int maxTimers ) {
        Date now = new Date();
     
        DetachedCriteria crit = DetachedCriteria.forClass(ProcessInstance.class);

        crit.add(Restrictions.eq("processName", processName));
        crit.add(Restrictions.isNotNull("timer.timerId"));
        crit.add(Restrictions.le("timer.date", now));
        
        return getHibernateTemplate().findByCriteria(crit, 0, maxTimers);
    }
    

    public ProcessInstance refresh(ProcessInstance processInstance, LockMode mode ) {
    	try {
    		getHibernateTemplate().refresh(processInstance, mode);
    	} catch ( ConcurrencyFailureException ce ) {
    		if ( mode == LockMode.UPGRADE_NOWAIT ) {
    			log.info("Don't worry. Unable to get lock without wait for process instance " + processInstance);
    			return null;
    		} else {
    			// if i'm trying to get an upgrade lock with waiting, then
    			// it may still timeout ( an DB parameter probably )
    			// this should produce a runtime error, since returning null
    			// is only supported for NO_WAIT.
    			throw ce;
    		}
    	} catch ( DataRetrievalFailureException rfe ) {
    		if ( mode == LockMode.UPGRADE_NOWAIT ) {
    			log.info("Don't worry. ProcessInstance " + processInstance + " has been deleted already.");
    			return null;
    		} else {
    			// if i'm trying to get an upgrade lock with waiting, then
    			// and the object has been deleted, then this is a problem.
    			throw rfe;
    		}
    	}
    	return processInstance;
    }
    
    public void save(ProcessInstance processInstance) {
        getHibernateTemplate().save(processInstance);
    }

    public void delete(ProcessInstance processInstance) {
        getHibernateTemplate().delete(processInstance);
    }

    public ProcessInstance load(Serializable id) {
        return (ProcessInstance) getHibernateTemplate().load(ProcessInstance.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<ProcessInstance> loadAll() {
        return  getHibernateTemplate().loadAll(ProcessInstance.class);
    }  

    @SuppressWarnings("unchecked")
    public List<ProcessInstance> loadAll(String processName) {
        String query = "from ProcessInstance pi where pi.processName = ?";
        List qr = getHibernateTemplate().find(query, new Object[]{processName});
        return qr;
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
