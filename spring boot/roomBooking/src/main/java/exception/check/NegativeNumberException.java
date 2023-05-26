package exception.check;

@SuppressWarnings("serial")
public class NegativeNumberException extends InvalidInputException {

	public static final String MSG_FORMAT_STR = "%s 不可為負數";
	
	
	public NegativeNumberException() {
	}
	public NegativeNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public NegativeNumberException(String message, Throwable cause) {
		super(message, cause);
	}
	public NegativeNumberException(String message) {
		super(message);
	}
	public NegativeNumberException(Throwable cause) {
		super(cause);
	}
	
	
	public static String getMsgStr(String fieldName) {
		
		return String.format(MSG_FORMAT_STR, fieldName);
	}
}
