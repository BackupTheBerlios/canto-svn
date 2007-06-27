/**
 * 
 */
package pareon.canto.framework.service.component;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import pareon.canto.components.logging.SystemLogger;
import pareon.canto.framework.domain.component.Component;

/**
 * Default implementation of the ComponentService
 * @author tzhrora2
 *
 */
public class ComponentServiceImpl implements ComponentService {
	
	private SystemLogger logger = new SystemLogger(getClass());
	private Hashtable<String,pareon.canto.framework.domain.component.Component>components;
	
	
	protected ComponentServiceImpl(){
		components = new Hashtable<String,
				pareon.canto.framework.domain.component.Component>();
	}

	/* (non-Javadoc)
	 * @see pareon.canto.framework.service.component.ComponentService#getComponents()
	 */
	public List<Component> getComponents() {
		return new Vector<Component>(components.values());
	}

	/* (non-Javadoc)
	 * @see pareon.canto.framework.service.component.ComponentService#isComponentEnabled(java.lang.String)
	 */
	public boolean isComponentEnabled(String name) {
		if (components.containsKey(name)){
			Component comp = components.get(name);
			return comp.isEnabled();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see pareon.canto.framework.service.component.ComponentService#registerComponent(pareon.canto.framework.domain.component.Component)
	 */
	public synchronized void registerComponent(Component component) {
		if (!components.containsKey(component.getName())){
			components.put(component.getName(),component);
			logger.logInfo("Component ["+component.getName()+"] registred");
		} else {
			logger.logInfo("Component ["+component.getName()+"] already registred");
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see pareon.canto.framework.service.component.ComponentService#unregisterComponent(pareon.canto.framework.domain.component.Component)
	 */
	public synchronized void unregisterComponent(Component component) {
		if (components.containsKey(component.getName())){
			components.remove(component.getName());
			logger.logInfo("Component ["+component.getName()+"] unregistred");
		} else {
			logger.logInfo("Component ["+component.getName()+"] already unregistred");
		}
	}
	
	

}
