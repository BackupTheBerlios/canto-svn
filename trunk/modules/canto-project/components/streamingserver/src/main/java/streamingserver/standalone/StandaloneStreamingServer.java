package streamingserver.standalone;

import java.util.Vector;

import streamingserver.StreamType;
import streamingserver.StreamingServer;
import streamingserver.StreamingServerEventListener;

/**
 * Standalone StreamingServer. The server has fixed url. 
 * It does not require the knowledge of the meeting information for the
 * streaming urls.
 * @author tzhrora2
 *
 */
public class StandaloneStreamingServer implements StreamingServer {
	
	private	String		rtmpUrl;
	private	String		rtmptUrl;
	private	int			maxNumberOfStreams;
	private	int		currentNumberOfStreams = 0;
	private	Vector<StreamType>		supportedStreamTypes;
	private StandaloneStreamingEventListener streamingServerEventListener;
	
	public	StandaloneStreamingServer(String rtmpUrl, String rtmptUrl,
			int maxNumberOfStreams, Vector<StreamType> supportedStreamTypes) {
		this.rtmpUrl = rtmpUrl;
		this.rtmptUrl = rtmptUrl;
		this.maxNumberOfStreams = maxNumberOfStreams;
		this.supportedStreamTypes = supportedStreamTypes;
		this.streamingServerEventListener = new StandaloneStreamingEventListener(this);
	
	}
	

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServer#getAvailableStreams()
	 */
	public int getAvailableStreams() {
		if (maxNumberOfStreams < 0) {
			return	-1;
		}
		return (maxNumberOfStreams - getCurrentNumberOfStreams());
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServer#getMaxStreams()
	 */
	public int getMaxStreams() {
		return maxNumberOfStreams;
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServer#getRTMPTUrl(java.lang.String)
	 */
	public String getRTMPTUrl(String meetingKey) {
		return rtmpUrl;
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServer#getRTMPUrl(java.lang.String)
	 */
	public String getRTMPUrl(String meetingKey) {
		return rtmptUrl;
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServer#getStreamingServerEventListener()
	 */
	public StreamingServerEventListener getStreamingServerEventListener() {
		return streamingServerEventListener;
	}

	
	/* (non-Javadoc)
	 * @see streamingserver.StreamingServer#isStreamAvailable()
	 */
	public boolean isStreamAvailable() {
		if (maxNumberOfStreams < 0) {
			return	true;
		}
		return (getCurrentNumberOfStreams()
				< maxNumberOfStreams);
	}

	/*
	 * (non-Javadoc)
	 * @see streamingserver.StreamingServer#supportsStreamType(streamingserver.StreamType)
	 */
	public boolean supportsStreamType(StreamType streamType) {
		if (supportedStreamTypes != null &&
				supportedStreamTypes.size() > 0) {
			if (supportedStreamTypes.contains(streamType)) {
				return	true;
			}
		}
		
	return false;
	}
	
	protected void setCurrentNumberOfStreams(int currentNumberOfStreams){
		this.currentNumberOfStreams = currentNumberOfStreams;
	}
	
	protected int getCurrentNumberOfStreams(){
		return currentNumberOfStreams;
	}
}
