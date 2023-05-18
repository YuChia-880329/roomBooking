package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogsUtil {

	private static final String ERROR_LOG_NAME = "throwable-log";
	
	public static <T> Logger getLogger(Class<T> cls) {
		
		return LoggerFactory.getLogger(cls);
	}
	public static Logger getThrowableLog() {
		
		return LoggerFactory.getLogger(ERROR_LOG_NAME);
	}
}
