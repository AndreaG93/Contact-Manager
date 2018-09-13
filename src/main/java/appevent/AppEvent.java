package appevent;

/**
 * This class is used to represent application events like errors, warnings, crashes and so on.
 *
 * @author Andrea Graziani
 * @version 1.0
 */
public abstract class AppEvent {

    byte ApplicationEventCode;
    String ApplicationEventDescription;

    /**
     * This method is used to get code relating to the event that occurred.
     *
     * @return A {@code byte} value.
     */
    public byte getApplicationEventCode() {
        return this.ApplicationEventCode;
    }

    /**
     * This method return a description relating to the event that occurred.
     *
     * @return A {@code String} object.
     */
    public String getApplicationEventDescription() {
        return this.ApplicationEventDescription;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " #" + this.ApplicationEventCode + " --> " + this.ApplicationEventDescription;
    }
}