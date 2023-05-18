package util;

public class StringConcatUtil {

	private static final StringBuffer SB = new StringBuffer();
	
	public static String concate(String... strings) {
		
		clearBuffer();
		for(int i=0; i<strings.length; i++) {
			
			SB.append(strings[i]);
		}
		
		return SB.toString();
	}
	
	private static void clearBuffer() {
		
		SB.delete(0, SB.length());
	}
}
