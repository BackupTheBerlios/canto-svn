/**
 * 
 */
package streamingserver.standalone;

import java.io.Serializable;
import java.util.Vector;

import streamingserver.StreamType;

/**
 * @author tzhrora2
 *
 */
public class StandaloneStreamingServerConfig implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4593177836881873895L;
	
	private String rtmpUrl;
	private String rtmptUrl;
	private int maxStreams;
	private Vector<StreamType> supportedStreamType;
	
	public String getRtmpUrl() {
		return rtmpUrl;
	}
	public void setRtmpUrl(String rtmpUrl) {
		this.rtmpUrl = rtmpUrl;
	}
	public String getRtmptUrl() {
		return rtmptUrl;
	}
	public void setRtmptUrl(String rtmptUrl) {
		this.rtmptUrl = rtmptUrl;
	}
	public int getMaxStreams() {
		return maxStreams;
	}
	public void setMaxStreams(int maxStreams) {
		this.maxStreams = maxStreams;
	}
	public Vector<StreamType> getSupportedStreamType() {
		return supportedStreamType;
	}
	public void setSupportedStreamType(Vector<StreamType> supportedStreamType) {
		this.supportedStreamType = supportedStreamType;
	}
	
	
}
