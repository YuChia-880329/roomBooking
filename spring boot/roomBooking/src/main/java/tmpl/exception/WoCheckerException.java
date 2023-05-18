package tmpl.exception;

@SuppressWarnings("serial")
public class WoCheckerException extends CheckerException {


	public WoCheckerException() {
	}
	public WoCheckerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public WoCheckerException(String message, Throwable cause) {
		super(message, cause);
	}
	public WoCheckerException(String message) {
		super(message);
	}
	public WoCheckerException(Throwable cause) {
		super(cause);
	}
}
