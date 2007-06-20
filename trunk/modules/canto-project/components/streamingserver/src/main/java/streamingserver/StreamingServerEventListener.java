package streamingserver;

/**
 * Defines the event that the StreamingServer can receives regarding a meeting
 * @author tzhrora2
 *
 */
public interface StreamingServerEventListener {

	
	/**
	 * Action for the streamingServer to perform when meeting has started
	 * @param meetingKey
	 * @param maxExpectedParticipants
	 * @param maxExpectedMeetingLengthMinutes
	 */
	public	void	meetingStarted(String meetingKey,
			int maxExpectedParticipants,
			int maxExpectedMeetingLengthMinutes);
	
	/**
	 * Action for the streamingServer to perform when participant has joined
	 * @param meetingKey
	 * @param participantId
	 */
	public	void	participantJoined(String meetingKey, String participantId);
	
	/**
	 * Action for the streamingServer to perform when participant left
	 * @param meetingKey
	 * @param participantId
	 */
	public	void	participantLeft(String meetingKey, String participantId);
	
	/**
	 * Action for the streamingServer to perform when meeting closed
	 * @param meetingKey
	 */
	public	void	meetingClosed(String meetingKey);
	
	/**
	 * Action for the streamingServer to perform when broadcaster started
	 * @param meetingKey
	 * @param participantId
	 * @param streamId
	 */
	public	void	broadcasterStarted(String meetingKey, String participantId, String streamId);
	
	/**
	 * Action for the streamingServer to perform when broadcaster stopped
	 * @param meetingKey
	 * @param participantId
	 * @param streamId
	 */
	public	void	broadcasterStopped(String meetingKey, String participantId, String streamId);
	
}
