package springboot.exception;

@SuppressWarnings("serial")
public class AppException extends RuntimeException {

	public AppException() {
	}
	public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}
	public AppException(String message) {
		super(message);
	}
	public AppException(Throwable cause) {
		super(cause);
	}
}
