package tikale.bot.help.exception;

public class DataFileUnableToSaveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataFileUnableToSaveException() {
        super();
    }

    public DataFileUnableToSaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataFileUnableToSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFileUnableToSaveException(String message) {
        super(message);
    }

    public DataFileUnableToSaveException(Throwable cause) {
        super(cause);
    }

}
