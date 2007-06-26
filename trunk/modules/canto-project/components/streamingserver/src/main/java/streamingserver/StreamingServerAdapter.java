/**
 * 
 */
package streamingserver;

/**
 * 
 * Each streaming server adapter provides each meeting its own stream server.
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
	 * Get the StreamingServerType of the StreamingServer
	 * @return
	 */
	public	StreamingServerType	getStreamingServerType();
	
	/**
	 * This method is expected to return 1 if cluster is not in use.
	 * @return
	 */
	public	int		getNumberOfServers();
	
	/**
	 * Return the StreamingServer of the StreamType
	 * @param streamType
	 * @return StreamingServer for the StreamType
	 * @throws NoAvailableStreamingServerException when no available Streaming Server found for the StreamType
	 */
	public	StreamingServer	getAvailableServer(StreamType streamType)
		throws NoAvailableStreamingServerException;
	
}
