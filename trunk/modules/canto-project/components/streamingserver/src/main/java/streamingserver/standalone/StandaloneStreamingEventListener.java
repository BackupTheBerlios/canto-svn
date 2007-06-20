package streamingserver.standalone;


import java.util.HashMap;

import streamingserver.StreamingServerEventListener;

public class StandaloneStreamingEventListener implements
		StreamingServerEventListener {

	
	private HashMap<String,MeetingStreamInfo>		meetingStreamInfos;
	private	int		currentNumberOfStreams;
	
	public StandaloneStreamingEventListener(){
		meetingStreamInfos = new HashMap<String,MeetingStreamInfo>();
		currentNumberOfStreams = 0;
	}
	
	
	/* (non-Javadoc)
	 * @see streamingserver.StreamingServerEventListener#broadcasterStarted(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void broadcasterStarted(String meetingKey, String participantId,
			String streamId) {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServerEventListener#broadcasterStopped(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void broadcasterStopped(String meetingKey, String participantId,
			String streamId) {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServerEventListener#meetingClosed(java.lang.String)
	 */
	public void meetingClosed(String meetingKey) {
		MeetingStreamInfo ms = meetingStreamInfos.get(meetingKey);
		if (ms != null) {
			meetingStreamInfos.remove(meetingKey);
			currentNumberOfStreams -= ms.getTotalNumberOfStreams();
		}

	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServerEventListener#meetingStarted(java.lang.String, int, int)
	 */
	public void meetingStarted(String meetingKey, int maxExpectedParticipants,
			int maxExpectedMeetingLengthMinutes) {
		MeetingStreamInfo ms = meetingStreamInfos.get(meetingKey);
		if (ms == null) {
			meetingStreamInfos.put(meetingKey, new MeetingStreamInfo(meetingKey));
		}

	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServerEventListener#participantJoined(java.lang.String, java.lang.String)
	 */
	public void participantJoined(String meetingKey, String participantId) {
		MeetingStreamInfo ms = meetingStreamInfos.get(meetingKey);
		if (ms != null) {
			ms.addParticipant(participantId);
			currentNumberOfStreams += 1;
		}

	}

	/* (non-Javadoc)
	 * @see streamingserver.StreamingServerEventListener#participantLeft(java.lang.String, java.lang.String)
	 */
	public void participantLeft(String meetingKey, String participantId) {
		MeetingStreamInfo ms = meetingStreamInfos.get(meetingKey);
		if (ms != null) {
			ms.removeParticipant(participantId);
			currentNumberOfStreams -= 1;
		}

	}


	public int getCurrentNumberOfStreams() {
		return currentNumberOfStreams;
	}
	
	
	
}
