package springboot.trans.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.vo.PaginationDto;
import springboot.bean.vo.Pagination;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("vo.PaginationTrans")
public class PaginationTrans implements VoWoTrans<Pagination, PaginationDto> {

	@Autowired
	@Qualifier("vo.PaginationItemTrans")
	private PaginationItemTrans paginationItemTrans;
	
	@Override
	public Pagination dtoToVoImpl(PaginationDto dto) {
		
		List<Integer> pages = dto.getPages();
		int[] pageArray = new int[pages.size()];
		for(int i=0; i<pages.size(); i++) {
			
			pageArray[i] = pages.get(i);
		}
		
		return Pagination.builder()
				.first(paginationItemTrans.dtoToVo(dto.getFirst()))
				.prev(paginationItemTrans.dtoToVo(dto.getPrev()))
				.pages(pageArray)
				.next(paginationItemTrans.dtoToVo(dto.getNext()))
				.last(paginationItemTrans.dtoToVo(dto.getLast()))
				.currentPage(dto.getCurrentPage())
				.build();
	}
}
