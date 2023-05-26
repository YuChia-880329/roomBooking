package exception.check;

import java.util.ArrayList;
import java.util.List;

import util.StringConcatUtil;

@SuppressWarnings("serial")
public class StringIsNotOneOfException extends InvalidInputException {

	public static final String MSG_FORMAT_STR = "%s 必須為 : %s 的其中之一";
	
	
	public StringIsNotOneOfException() {
	}
	public StringIsNotOneOfException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public StringIsNotOneOfException(String message, Throwable cause) {
		super(message, cause);
	}
	public StringIsNotOneOfException(String message) {
		super(message);
	}
	public StringIsNotOneOfException(Throwable cause) {
		super(cause);
	}
	
	
	public static String getMsgStr(String fieldName, String[] options) {
		
		List<String> strs = new ArrayList<>();
		
		for(int i=0; i<options.length; i++) {
			
			if(i > 0)
				strs.add(", ");
			strs.add(options[i]);
		}
		
		
		return String.format(MSG_FORMAT_STR, fieldName, 
				StringConcatUtil.concate(strs.toArray(new String[strs.size()])));
	}
}
