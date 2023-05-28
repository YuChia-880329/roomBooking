package springboot.exception;

@SuppressWarnings("serial")
public class IllegalPageException extends AppException {

	public static final String MSG = "無此頁數";
	
	public IllegalPageException() {
	}
	public IllegalPageException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public IllegalPageException(String message, Throwable cause) {
		super(message, cause);
	}
	public IllegalPageException(String message) {
		super(message);
	}
	public IllegalPageException(Throwable cause) {
		super(cause);
	}
}
