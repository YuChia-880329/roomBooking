package springboot.exception;

@SuppressWarnings("serial")
public class NotLoginException extends AppException {

	public static final String MSG = "請先登入";
	
	
	public NotLoginException() {
	}
	public NotLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public NotLoginException(String message, Throwable cause) {
		super(message, cause);
	}
	public NotLoginException(String message) {
		super(message);
	}
	public NotLoginException(Throwable cause) {
		super(cause);
	}
}
