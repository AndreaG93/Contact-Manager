package appevent;

/**
 * This class is used to represent application warning events.
 *
 * @author Andrea Graziani
 * @version 1.0
 */
public class Warning extends AppEvent {

    public static final Warning TEST = new Warning((byte) 0, "A database error has occurred. Please contact system administrator.");

    /**
     * Construct a newly allocated {@code Warning} object.
     *
     * @param applicationEventCode - Represents a {@code byte} value.
     * @param applicationEventDescription - Represents a {@code String} object.
     */
    private Warning(byte applicationEventCode, String applicationEventDescription) {
        this.ApplicationEventCode = applicationEventCode;
        this.ApplicationEventDescription = applicationEventDescription;
    }
}
