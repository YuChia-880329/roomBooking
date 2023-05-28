package springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot.bean.dto.vo.PaginationDto;

@Service("PaginationService")
public class PaginationService {
	
	public PaginationDto getPagination(int currentPage, int pagesPerPageGroup, int maxPage) {
		
		return PaginationDto.builder()
				.showFirst(showFirst(currentPage))
				.showPrev(showPrev(currentPage))
				.pages(pages(currentPage, pagesPerPageGroup, maxPage))
				.showNext(showNext(currentPage, maxPage))
				.showLast(showLast(currentPage, maxPage))
				.currentPage(currentPage)
				.build();
	}

	public boolean showFirst(int currentPage) {
		
		return currentPage > 1;
	}
	public boolean showPrev(int currentPage) {
		
		return currentPage > 1;
	}
	public List<Integer> pages(int currentPage, int pagesPerPageGroup, int maxPage){
		
		int basePage = (currentPage-1) / pagesPerPageGroup * pagesPerPageGroup;
		List<Integer> pages = new ArrayList<>();
		for(int i=basePage+1; i<=basePage+pagesPerPageGroup && i<=maxPage; i++) {
			
			pages.add(i);
		}
		return pages;
	}
	public boolean showNext(int currentPage, int maxPage) {
		
		return currentPage < maxPage;
	}
	public boolean showLast(int currentPage, int maxPage) {
		
		return currentPage < maxPage;
	}
}
