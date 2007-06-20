package streamingserver;

public interface StreamingServer {
	
	/**
	 * Get the RTMPUrl for a specific meeting
	 * @param meetingKey
	 * @return
	 */
	public	String		getRTMPUrl(String meetingKey);
	
	/**
	 * Get the RTMPTUrl for a specific meeting
	 * @param meetingKey
	 * @return
	 */
	public	String		getRTMPTUrl(String meetingKey);
	
	
	/**
	 * Get Max Streams
	 * @return
	 */
	public	int			getMaxStreams();
	
	/**
	 * Get Available Streams
	 * @return
	 */
	public	int			getAvailableStreams();
	
	/**
	 * Return if stream is available
	 * @return
	 */
	public	boolean		isStreamAvailable();
	
	/**
	 * Check if the streamType is supported
	 * @param streamType
	 * @return
	 */
	public	boolean		supportsStreamType(String streamType);
	
	
	/**
	 * Return the StreamingServerEventListener of the StreamingServer
	 * @return
	 */
	public StreamingServerEventListener getStreamingServerEventListener();

}
