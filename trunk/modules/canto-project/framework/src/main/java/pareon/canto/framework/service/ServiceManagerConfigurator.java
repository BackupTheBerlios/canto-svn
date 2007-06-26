/**
 * 
 */
package pareon.canto.framework.service;

/**
 * @author tzhrora2
 *
 */
public interface ServiceManagerConfigurator<E> {
	
	
	public void configureService(E e,String configFile);

}
