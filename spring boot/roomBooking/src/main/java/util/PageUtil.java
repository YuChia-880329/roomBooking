package util;

public class PageUtil {

	public static int[] countRow(int rowsPerPage, int page) {
		
		int baseRow = rowsPerPage * (page-1);
		int rowMin = baseRow + 1;
		int rowMax = baseRow + rowsPerPage;
		return new int[] {rowMin, rowMax};
	}
	
	public static int[] countRow(int rowsPerPage, int pageMin, int pageMax) {
		
		int baseRow = rowsPerPage * (pageMin-1);
		int rowMin = baseRow + 1;
		int rowMax = baseRow + rowsPerPage * (pageMax-pageMin+1);
		return new int[] {rowMin, rowMax};
	}
}
