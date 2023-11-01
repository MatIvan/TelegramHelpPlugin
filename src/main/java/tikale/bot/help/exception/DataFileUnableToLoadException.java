package tikale.bot.help.exception;

public class DataFileUnableToLoadException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataFileUnableToLoadException() {
        super();
    }

    public DataFileUnableToLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataFileUnableToLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFileUnableToLoadException(String message) {
        super(message);
    }

    public DataFileUnableToLoadException(Throwable cause) {
        super(cause);
    }

}
