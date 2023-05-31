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
	
	
	public static int countMaxPage(int rowsPerPage, int totalRows) {
		
		return (totalRows-1) / rowsPerPage + 1;
	}
	
	public static int[] countPage(int page, int pagesPerPageGroup, int maxPage) {
		
		if(page > maxPage)
			return null;
		
		int basePage = (page-1) / pagesPerPageGroup * pagesPerPageGroup;
		
		int minP = basePage + 1;
		int maxP = basePage + pagesPerPageGroup;
		
		maxP = maxP<=maxPage ? maxP : maxPage;
		
		return new int[] {minP, maxP};
	}
}
