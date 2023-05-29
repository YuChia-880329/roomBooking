package springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot.bean.dto.vo.PaginationDto;
import springboot.bean.dto.vo.PaginationItemDto;

@Service("PaginationService")
public class PaginationService {
	
	public PaginationDto getPagination(int currentPage, int pagesPerPageGroup, int maxPage) {
		
		return PaginationDto.builder()
				.first(first(currentPage))
				.prev(prev(currentPage))
				.pages(pages(currentPage, pagesPerPageGroup, maxPage))
				.next(next(currentPage, maxPage))
				.last(last(currentPage, maxPage))
				.currentPage(currentPage)
				.build();
	}

	private PaginationItemDto first(int currentPage) {
		
		return PaginationItemDto.builder()
				.show(currentPage > 1)
				.toPage(1)
				.build();
	}
	private PaginationItemDto prev(int currentPage) {
		
		boolean show = currentPage > 1;
		
		return PaginationItemDto.builder()
				.show(show)
				.toPage(show ? currentPage-1 : 1)
				.build();
	}
	private List<Integer> pages(int currentPage, int pagesPerPageGroup, int maxPage){
		
		int basePage = (currentPage-1) / pagesPerPageGroup * pagesPerPageGroup;
		List<Integer> pages = new ArrayList<>();
		for(int i=basePage+1; i<=basePage+pagesPerPageGroup && i<=maxPage; i++) {
			
			pages.add(i);
		}
		return pages;
	}
	private PaginationItemDto next(int currentPage, int maxPage) {
		
		boolean show = currentPage < maxPage;
		
		return PaginationItemDto.builder()
				.show(show)
				.toPage(show ? currentPage+1 : maxPage)
				.build();
	}
	private PaginationItemDto last(int currentPage, int maxPage) {
		
		return PaginationItemDto.builder()
				.show(currentPage < maxPage)
				.toPage(maxPage)
				.build();
	}
}
