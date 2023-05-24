package exception.check;

@SuppressWarnings("serial")
public class NullException extends RuntimeException {

	public static final String MSG_FORMAT_STR = "請填寫 %s";
	
	
	public NullException() {
	}
	public NullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public NullException(String message, Throwable cause) {
		super(message, cause);
	}
	public NullException(String message) {
		super(message);
	}
	public NullException(Throwable cause) {
		super(cause);
	}
	
	public static String getMsgStr(String fieldName) {
		
		return String.format(MSG_FORMAT_STR, fieldName);
	}
}
