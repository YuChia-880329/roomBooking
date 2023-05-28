package util;

import java.util.function.Predicate;

public class ThrowableUtil {

	@SuppressWarnings("unchecked")
	public static <T extends Throwable> T getNestedThrowable(Throwable th, Predicate<Throwable> isType) {
		
		Throwable lastNestedTh = null;
		Throwable nestedTh = th;
		
		while(true) {
			
			lastNestedTh = nestedTh;
			nestedTh = nestedTh.getCause();
			
			if(nestedTh==null || lastNestedTh==nestedTh)
				break;
			else if(isType.test(nestedTh))
				return (T)nestedTh;
		}
		
		return null;
	}
}
