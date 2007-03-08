/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:48 $
 * $LastChangedDate:2007-03-07 13:51:41 +0000 (Mi, 07 Mrz 2007) $
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/rajenlab-common/source/main/java/li/rajenlab/common/dao/BaseDao.java $
 ******************************************************************************/
package li.rajenlab.common.dao.process;

import org.hibernate.LockMode;

import li.rajenlab.common.domain.process.ProcessInstance;
import li.rajenlab.common.domain.process.ProcessTimer;

import java.io.Serializable;

import java.util.List;


/**
 * Interface definition of the persistence layer of the ProcessInstance.
 *
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface ProcessInstanceDAO {
	
    /**
     * Find a ProcessInstance given the ProcessName and oid.
     *
     * @param processName the ProcessName.
     * @param oid the oid.
     *
     * @return a ProcessInstance given the ProcessName and oid or NULL if not found.
     */
    public ProcessInstance findByOid(String processName, String oid);

    /**
     * Find all ProcessInstances given the ProcessName and stateName.
     *
     * @param processName the ProcessName.
     * @param stateName the stateName.
     *
     * @return all ProcessInstances given the ProcessName and stateName.
     */
    public List<ProcessInstance> findByState(String processName, String stateName);

    /**
     * Find all ProcessInstances given the ProcessName and variable value.
     *
     * @param processName the ProcessName.
     * @param variableName the variable name.
     * @param variableValue the variable value.
     *
     * @return all ProcessInstances given the ProcessName and variable value.
     */
    public List<ProcessInstance> findByVariable(String processName, String variableName,
        String variableValue);

    /**
     * Find all ProcessInstances given the ProcessName and domain entity id.
     *
     * @param processName the ProcessName.
     * @param domainId the domain entity id.
     *
     * @return all ProcessInstances given the ProcessName and domain entity id.
     */
    public List<ProcessInstance> findByDomainId(String processName, Serializable domainId);

    /**
     * Find all ProcessInstances which have ProcessTimers which are ready to
     * trigger. Return up to maxTimers instances. 
     *
     * @param processName the ProcessName.
     * @param maxTimers the max number of instances to fetch.
     *
     * @return all ProcessInstances which have ProcessTimers which are ready to trigger.
     */
    public List<ProcessTimer> findByTimerReady(String processName, int maxTimers);

    /**
     * Refresh a ProcessInstance and optionally optain a lock.
     *
     * @param processInstance the ProcessInstance to refresh.
     * @param mode the Hibernate LockMode.
     *
     * @return the loaded ProcessInstance.
     */
    public ProcessInstance refresh(ProcessInstance processInstance, LockMode mode);

    /**
     * Save a ProcessInstance.
     *
     * @param processInstance the ProcessInstance to save.
     */
    public void save(ProcessInstance processInstance);

    /**
     * Delete a ProcessInstance.
     *
     * @param processInstance the ProcessInstance to delete.
     */
    public void delete(ProcessInstance processInstance);

    /**
     * Load a ProcessInstance given it's unique identifier.
     *
     * @param id the unique entity identifier.
     *
     * @return the ProcessInstance or NULL if not found.
     */
    public ProcessInstance load(Serializable id);

    /**
     * Return a list of all ProcessInstances for all Processes.
     *
     * @return a list of all ProcessInstances for all Processes.
     */
    public List<ProcessInstance> loadAll();

    /**
     * Return a list of all ProcessInstances for a particular Process.
     *
     * @param processName the ProcessName.
     *
     * @return a list of all ProcessInstances for a particular Process.
     */
    public List<ProcessInstance> loadAll(String processName);
}
