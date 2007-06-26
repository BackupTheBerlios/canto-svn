/**
 * 
 */
package streamingserver.standalone;

import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import streamingserver.NoAvailableStreamingServerException;
import streamingserver.StreamType;
import streamingserver.StreamingServer;
import streamingserver.StreamingServerAdapter;
import streamingserver.StreamingServerType;

/**
 * StreamingServerAdapter for StandaloneStreamingServer
 * @author tzhrora2
 *
 */
public class StandaloneStreamingServerAdapter implements
		StreamingServerAdapter {
	
	private Log logger = LogFactory.getLog(getClass());
	
	private int numberOfStreamingServers;
	private Vector<StandaloneStreamingServer>	streamingServers;
	private String name;
	
	public StandaloneStreamingServerAdapter (String name,
			List<StandaloneStreamingServerConfig> configs){
		this.name = name;
		this.streamingServers = new Vector<StandaloneStreamingServer>();
		
		try {
			 for (StandaloneStreamingServerConfig config : configs){
				 StandaloneStreamingServer saStreamingServer = new StandaloneStreamingServer(
					 config.getRtmpUrl(),config.getRtmptUrl(),config.getMaxStreams(), 
					 config.getSupportedStreamType());
					 streamingServers.add(saStreamingServer);
			 }
			 logger.info("For Adapter["+name+"], added ["+streamingServers.size()
					 +"] StandaloneStreamingServer");
			 numberOfStreamingServers = streamingServers.size();
			
		} catch (Exception e){
			logger.warn("StreamingServer setup for Adapter+["+name+"] not possible, " +
					"reason["+e.getMessage()+"]");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see streamingserver.StreamingServerAdapter#getAvailableServer(streamingserver.StreamType)
	 */
	public synchronized StreamingServer getAvailableServer(StreamType streamType)
		throws NoAvailableStreamingServerException {
		if (streamingServers.size() > 0){
			for (StandaloneStreamingServer saStreamingServer : streamingServers){
				if (saStreamingServer.supportsStreamType(streamType)
						&& saStreamingServer.isStreamAvailable()){
					return saStreamingServer;
				}
			}
		} 
		throw new NoAvailableStreamingServerException("No " +
				"StreamingServer found for StreamType["+streamType+"]");
		
	}

		/* (non-Javadoc)
	 * @see streamingserver.StreamingServerAdapter#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServerAdapter#getNumberOfServers()
	 */
	public int getNumberOfServers() {
		return numberOfStreamingServers;
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServerAdapter#getStreamingServerType()
	 */
	public StreamingServerType getStreamingServerType() {
		return StreamingServerType.STANDALONE;
	}

}
