package tmpl.exception;

@SuppressWarnings("serial")
public class CheckerException extends Exception {

	public CheckerException() {
	}
	public CheckerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public CheckerException(String message, Throwable cause) {
		super(message, cause);
	}
	public CheckerException(String message) {
		super(message);
	}
	public CheckerException(Throwable cause) {
		super(cause);
	}
}
