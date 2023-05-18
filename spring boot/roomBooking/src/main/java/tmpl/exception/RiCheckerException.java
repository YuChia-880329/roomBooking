package tmpl.exception;

import tmpl.checker.IllegalInput;

@SuppressWarnings("serial")
public class RiCheckerException extends CheckerException {

	private IllegalInput illegalInput;
	
	public RiCheckerException() {
	}
	public RiCheckerException(IllegalInput illegalInput) {
		
		this.illegalInput = illegalInput;
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
	
	
	public IllegalInput getIllegalInput() {
		return illegalInput;
	}
	
	
	public void setIllegalInput(IllegalInput illegalInput) {
		this.illegalInput = illegalInput;
	}
}
