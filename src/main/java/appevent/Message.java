package appevent;

/**
 * This class is used to represent application message events.
 *
 * @author Andrea Graziani
 * @version 1.0
 */
public class Message extends AppEvent {

    public static final Message TEST = new Message((byte) 0, "A database error has occurred. Please contact system administrator.");

    /**
     * Construct a newly allocated {@code Warning} object.
     *
     * @param applicationEventCode - Represents a {@code byte} value.
     * @param applicationEventDescription - Represents a {@code String} object.
     */
    private Message(byte applicationEventCode, String applicationEventDescription) {
        this.ApplicationEventCode = applicationEventCode;
        this.ApplicationEventDescription = applicationEventDescription;
    }
}
