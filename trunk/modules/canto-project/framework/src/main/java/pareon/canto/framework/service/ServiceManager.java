/**
 * 
 */
package pareon.canto.framework.service;

/**
 * @author tzhrora2
 *
 */
public interface ServiceManager<E> {
	
	
	/**
	 * Set up method of the manager
	 * @throws Exception
	 */
	public void setUp() throws Exception;
	
	/**
	 * Tear down method of the manager
	 * @throws Exception
	 */
	public void tearDown() throws Exception;
	
	/**
	 * Return the service
	 * @return
	 */
	public E getService();

}
