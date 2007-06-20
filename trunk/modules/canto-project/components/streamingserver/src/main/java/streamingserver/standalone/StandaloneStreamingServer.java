package streamingserver.standalone;

import java.util.Vector;

import streamingserver.StreamingServer;
import streamingserver.StreamingServerConstants;
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
	private	Vector<String>		supportedStreamTypes;
	private StandaloneStreamingEventListener streamingServerEventListener;
	
	public	StandaloneStreamingServer(String rtmpUrl, String rtmptUrl,
			int maxNumberOfStreams, Vector<String> supportedStreamTypes) {
		this.rtmpUrl = rtmpUrl;
		this.rtmptUrl = rtmptUrl;
		this.maxNumberOfStreams = maxNumberOfStreams;
		this.supportedStreamTypes = supportedStreamTypes;
		this.streamingServerEventListener = new StandaloneStreamingEventListener();
	
	}
	

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServer#getAvailableStreams()
	 */
	public int getAvailableStreams() {
		return (maxNumberOfStreams - streamingServerEventListener.getCurrentNumberOfStreams());
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
		return (streamingServerEventListener.getCurrentNumberOfStreams()
				< maxNumberOfStreams);
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServer#supportsStreamType(java.lang.String)
	 */
	public boolean supportsStreamType(String streamType) {
		if (supportedStreamTypes != null &&
				supportedStreamTypes.size() > 0) {
			if (supportedStreamTypes.contains(streamType) ||
			supportedStreamTypes.contains(StreamingServerConstants.ANY_STREAMS)) {
			return	true;
			}
		}
		
	return false;
	}
	

}
