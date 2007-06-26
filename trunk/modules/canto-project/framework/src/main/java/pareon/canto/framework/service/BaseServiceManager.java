/**
 * 
 */
package pareon.canto.framework.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pareon.canto.framework.exceptions.CantoCodingException;
import pareon.canto.framework.exceptions.CantoConfigurationException;
import pareon.canto.framework.service.component.ComponentService;

/**
 * @author tzhrora2
 *
 */
public abstract class BaseServiceManager<E> implements ServiceManager<E>{

	protected Log logger = LogFactory.getLog(getClass());
	
	private String serviceClassName;
	private ServiceManagerConfigurator<E> serviceManagerConfigurator;
	private E service;
	private String configurationFile;
	
	/*
	 * (non-Javadoc)
	 * @see pareon.canto.framework.service.ServiceManager#setUp()
	 */
	@SuppressWarnings("unchecked")
	public final void setUp() throws Exception {
		
		// create the service class
		try {
			Class<E> serviceClass = (Class<E>) Class.forName(serviceClassName);
			service = serviceClass.newInstance();
		} catch (ClassNotFoundException e){
			throw new CantoConfigurationException("No ServiceClass found for ["
					+serviceClassName+"]");
		} catch (Exception e){
			throw new CantoCodingException("ServiceClass["
					+service+"] can not be created");
		}
		
		// do the configuration of the service
		getServiceManagerConfigurator().configureService(service, 
				configurationFile);
		logger.info("Service["+service.getClass()+"] configured");
		
		// do specific setup
		doSetup();
		
		
		logger.info("ServiceManager for Service["+service.getClass()+"] " +
				"setup done");
	}

	/*
	 * (non-Javadoc)
	 * @see pareon.canto.framework.service.ServiceManager#tearDown()
	 */
	public final void tearDown() throws Exception {
		doTearDown();
		
		logger.info("ServiceManager for Service["+service.getClass()+"] " +
				"teardown done");
	}

	
	/**
	 * Setup action done by the subclass
	 * @throws Exception
	 */
	protected abstract void doSetup() throws Exception;
	
	/**
	 * Tear down action done by the subclass
	 * @throws Exception
	 */
	protected abstract void doTearDown() throws Exception;
	
	public E getService() {
		return service;
	}

	public String getServiceClassName() {
		return serviceClassName;
	}

	public void setServiceClassName(String serviceClassName) {
		this.serviceClassName = serviceClassName;
	}


	public ServiceManagerConfigurator<E> getServiceManagerConfigurator() {
		return serviceManagerConfigurator;
	}


	public void setServiceManagerConfigurator(
			ServiceManagerConfigurator<E> serviceManagerConfigurator) {
		this.serviceManagerConfigurator = serviceManagerConfigurator;
	}


	public String getConfigurationFile() {
		return configurationFile;
	}


	public void setConfigurationFile(String configurationFile) {
		this.configurationFile = configurationFile;
	}
	
	
	
}
