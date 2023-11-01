package tikale.bot.help.exception;

public class DataFileNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataFileNotFoundException() {
        super();
    }

    public DataFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFileNotFoundException(String message) {
        super(message);
    }

    public DataFileNotFoundException(Throwable cause) {
        super(cause);
    }

}
