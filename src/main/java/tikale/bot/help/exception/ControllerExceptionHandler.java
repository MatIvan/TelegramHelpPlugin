package tikale.bot.help.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import tikale.bot.help.util.StringUtil;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(DataFileNotFoundException.class)
    public ResponseEntity<String> handleException(DataFileNotFoundException e) {
        LOG.error(e.getClass() + StringUtil.SPACE + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataFileUnableToLoadException.class)
    public ResponseEntity<String> handleException(DataFileUnableToLoadException e) {
        LOG.error(e.getClass() + StringUtil.SPACE + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataFileUnableToSaveException.class)
    public ResponseEntity<String> handleException(DataFileUnableToSaveException e) {
        LOG.error(e.getClass() + StringUtil.SPACE + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOG.error(StringUtil.ERROR_TEXT, e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
