package RUBBISH;

/**
 * This class is used to represent application error events.
 *
 * @author Andrea Graziani
 * @version 1.0
 */
public class Error extends AppEvent {

    // =================================================================== //
    // Database related errors...
    // =================================================================== //

    public static final Error DATABASE_ERROR = new Error((byte) 0, "A database error has occurred. Please contact system administrator.");

    // =================================================================== //
    // "BAD_FORMAT" application errors...
    // =================================================================== //

    public static final Error NAME_BAD_FORMAT = new Error((byte) 0, " -- TODO --.");
    public static final Error SURNAME_BAD_FORMAT = new Error((byte) 0, "A database error has occurred. Please contact system administrator.");
    public static final Error TELEPHONE_NUMBER_BAD_FORMAT = new Error((byte) 0, "A database error has occurred. Please contact system administrator.");
    public static final Error FISCAL_CODE_BAD_FORMAT = new Error((byte) 0, "A database error has occurred. Please contact system administrator.");

    // =================================================================== //
    // "TOO_LONG" application errors...
    // =================================================================== //

    public static final Error NAME_TOO_LONG = new Error((byte) 0, "A database error has occurred. Please contact system administrator.");
    public static final Error SURNAME_TOO_LONG = new Error((byte) 0, "A database error has occurred. Please contact system administrator.");
    public static final Error TELEPHONE_NUMBER_TOO_LONG = new Error((byte) 0, "A database error has occurred. Please contact system administrator.");
    public static final Error FISCAL_CODE_TOO_LONG = new Error((byte) 0, "A database error has occurred. Please contact system administrator.");


    /**
     * Construct a newly allocated {@code Error} object.
     *
     * @param applicationEventCode - Represents a {@code byte} value.
     * @param applicationEventDescription - Represents a {@code String} object.
     */
    private Error(byte applicationEventCode, String applicationEventDescription) {
        this.ApplicationEventCode = applicationEventCode;
        this.ApplicationEventDescription = applicationEventDescription;
    }
}