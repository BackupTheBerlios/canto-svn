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

/**
 * Convenience base class for statefull or stateless Processes.
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class BaseProcess implements Process {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------

	private String name_;
	private int maxTimersPerSelect_; 
	private int maxTimersPerSchedule_; 
	
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------

	/**
	 * @return Returns the maxTimersPerSchedule.
	 */
	public int getMaxTimersPerSchedule() {
		return maxTimersPerSchedule_;
	}

	/**
	 * @param maxTimersPerSchedule The maxTimersPerSchedule to set.
	 */
	public void setMaxTimersPerSchedule(int maxTimersPerSchedule) {
		this.maxTimersPerSchedule_ = maxTimersPerSchedule;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name_;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name_ = name;
	}

	/**
	 * @return Returns the maxTimersPerSelect.
	 */
	public int getMaxTimersPerSelect() {
		return maxTimersPerSelect_;
	}

	/**
	 * @param maxTimersPerSelect The maxTimersPerSelect to set.
	 */
	public void setMaxTimersPerSelect(int maxTimersPerSelect) {
		this.maxTimersPerSelect_ = maxTimersPerSelect;
	}


}
