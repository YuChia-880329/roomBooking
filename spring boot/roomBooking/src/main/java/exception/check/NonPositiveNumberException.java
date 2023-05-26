package exception.check;

@SuppressWarnings("serial")
public class NonPositiveNumberException extends InvalidInputException {

	public static final String MSG_FORMAT_STR = "%s 必須大於0";
	
	
	public NonPositiveNumberException() {
	}
	public NonPositiveNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public NonPositiveNumberException(String message, Throwable cause) {
		super(message, cause);
	}
	public NonPositiveNumberException(String message) {
		super(message);
	}
	public NonPositiveNumberException(Throwable cause) {
		super(cause);
	}
	
	public static String getMsgStr(String fieldName) {
		
		return String.format(MSG_FORMAT_STR, fieldName);
	}
}
