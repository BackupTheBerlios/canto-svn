/**
 * 
 */
package streamingserver;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * @author tzhrora2
 *
 */
public class StreamingServerAdapterProvider {
	
	
	private HashMap<String, StreamingServerAdapter> streamingServerAdapters;

	public StreamingServerAdapterProvider(){
		streamingServerAdapters = new HashMap<String, StreamingServerAdapter>();
	}
	
	/**
	 * List of StreamingServerAdapter Name
	 * @return
	 */
	public	List<String> getAvailableAdapterNames(){
		return	new Vector<String>(streamingServerAdapters.keySet());
	}
	
	/**
	 * Get the StreamingServerAdapter by Name
	 * @param name
	 * @return
	 */
	public	StreamingServerAdapter	getAdapter(String name) {
		return	streamingServerAdapters.get(name);
	}
}
