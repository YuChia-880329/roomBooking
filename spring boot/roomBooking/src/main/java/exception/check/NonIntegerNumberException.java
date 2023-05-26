package exception.check;

@SuppressWarnings("serial")
public class NonIntegerNumberException extends InvalidInputException {

	public static final String MSG_FORMAT_STR = "%s 必須是整數";
	
	
	public NonIntegerNumberException() {
	}
	public NonIntegerNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public NonIntegerNumberException(String message, Throwable cause) {
		super(message, cause);
	}
	public NonIntegerNumberException(String message) {
		super(message);
	}
	public NonIntegerNumberException(Throwable cause) {
		super(cause);
	}
	
	public static String getMsgStr(String fieldName) {
		
		return String.format(MSG_FORMAT_STR, fieldName);
	}
}
