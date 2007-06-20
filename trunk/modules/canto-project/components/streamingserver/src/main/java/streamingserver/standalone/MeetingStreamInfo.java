/**
 * 
 */
package streamingserver.standalone;

import java.util.Vector;

/**
 * Store information about a meeting using the stream of the StandaloneStreamingServer
 * @author tzhrora2
 *
 */
final class MeetingStreamInfo {
	
	private	String	meetingKey;
	private	Vector<String>	participants;
	private	int		totalNumberOfStreams;
	
	public	MeetingStreamInfo(String meetingKey) {
		this.meetingKey = meetingKey;
		this.participants = new Vector<String>();
		this.totalNumberOfStreams = 1;
	}
	
	public	void	addParticipant(String userId) {
		if (participants.contains(userId)) {
			participants.add(userId);
			totalNumberOfStreams++;
		}
	}
	
	public	void	removeParticipant(String userId) {
		if (participants.contains(userId)){
			participants.remove(userId);
			totalNumberOfStreams--;
		}
	}
	
	public	int	getTotalNumberOfStreams() {
		return	totalNumberOfStreams;
	}

	public String getMeetingKey() {
		return meetingKey;
	}
	
	

}
