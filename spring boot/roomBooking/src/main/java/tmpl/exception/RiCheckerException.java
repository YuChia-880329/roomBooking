package tmpl.exception;

@SuppressWarnings("serial")
public class RiCheckerException extends CheckerException {


	public RiCheckerException() {
	}
	public RiCheckerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public RiCheckerException(String message, Throwable cause) {
		super(message, cause);
	}
	public RiCheckerException(String message) {
		super(message);
	}
	public RiCheckerException(Throwable cause) {
		super(cause);
	}
}
