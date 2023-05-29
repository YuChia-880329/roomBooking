package springboot.trans.vo;

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
		
		return Pagination.builder()
				.first(paginationItemTrans.dtoToVo(dto.getFirst()))
				.prev(paginationItemTrans.dtoToVo(dto.getPrev()))
				.pages(dto.getPages())
				.next(paginationItemTrans.dtoToVo(dto.getNext()))
				.last(paginationItemTrans.dtoToVo(dto.getLast()))
				.currentPage(dto.getCurrentPage())
				.build();
	}
}
