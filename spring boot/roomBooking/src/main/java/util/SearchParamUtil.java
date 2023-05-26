package util;

import java.util.function.BiFunction;

public class SearchParamUtil {
	

	public static <T> boolean equals(T t1, T t2, BiFunction<T, T, Boolean> notNullFctn) {
		
		return (t1==null && t2==null) ||
				((t1!=null && t2!=null) && notNullFctn.apply(t1, t2));
	}
	
	public static String queryStr(String param) {
		
		return param==null ? "IS NOT NULL" : StringConcatUtil.concate("LIKE % ", param, "%");
	}
	public static String queryStrMin(Integer param) {
		
		return param==null ? "IS NOT NULL" : StringConcatUtil.concate("> ", String.valueOf(param));
	}
	public static String queryStrMax(Integer param) {
		
		return param==null ? "IS NOT NULL" : StringConcatUtil.concate("< ", String.valueOf(param));
	}
}
