/**
 * 
 */
package streamingserver;

/**
 * 
 * Each server adapter provides each meeting its own stream server.
 * The meeting is expected to provide the participants join and leave
 * activities to this server. This is to allow the streaming server to
 * take any appropriate actions depending on the load, which may include not
 * accepting any more streams.
 * 
 * @author tzhrora2
 *
 */
public interface StreamingServerAdapter {
	
	/**
	 * Get the name of the adapter
	 * @return
	 */
	public	String	getName();
	
	/**
	 * Get the StreamingServerAdapterType of the StreamingServer
	 * @return
	 */
	public	StreamingServerAdapterType	getStreamingServerAdapterType();
	
	/**
	 * This method is expected to return 1 if cluster is not in use.
	 * @return
	 */
	public	int		getNumberOfServers();
	
	/**
	 * Return the StreamingServer of the StreamType
	 * @param streamType
	 * @return
	 */
	public	StreamingServer	getAvailableServer(String streamType);
	
	/**
	 * This method implementation is essentially expected to return a server
	 * for stream type 'ANY'.
	 * 
	 * @return
	 */
	
	public	StreamingServer	getAvailableServer();

}
