package exception.check;

@SuppressWarnings("serial")
public class NonNumberStringException extends RuntimeException {

	public static final String MSG_FORMAT_STR = "%s 必須是數字";
	
	
	public NonNumberStringException() {
	}
	public NonNumberStringException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public NonNumberStringException(String message, Throwable cause) {
		super(message, cause);
	}
	public NonNumberStringException(String message) {
		super(message);
	}
	public NonNumberStringException(Throwable cause) {
		super(cause);
	}
	
	public static String getMsgStr(String fieldName) {
		
		return String.format(MSG_FORMAT_STR, fieldName);
	}
}
