/**
 * 
 */
package pareon.canto.framework.service.component;

import java.util.List;

import pareon.canto.framework.domain.component.Component;

/**
 * @author tzhrora2
 *
 */
public interface ComponentService {
	
	/**
	 * Get list of components
	 * @return Components
	 */
	public List<Component> getComponents();
	
	/**
	 * Check if the component is enabled
	 * @param name
	 * @return
	 */
	public boolean isComponentEnabled(String name);
	
	/**
	 * Register a component
	 * @param component
	 */
	public void registerComponent(Component component);
	
	/**
	 * Unregister a component
	 * @param component
	 */
	public void unregisterComponent(Component component);

}
