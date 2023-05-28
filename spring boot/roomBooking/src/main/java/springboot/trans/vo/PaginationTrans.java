package springboot.trans.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.vo.PaginationDto;
import springboot.bean.vo.Pagination;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("vo.PaginationTrans")
public class PaginationTrans implements VoWoTrans<Pagination, PaginationDto> {

	@Override
	public Pagination dtoToVoImpl(PaginationDto dto) {
		
		return Pagination.builder()
				.showFirst(dto.isShowFirst())
				.showPrev(dto.isShowPrev())
				.pages(dto.getPages())
				.showNext(dto.isShowNext())
				.showLast(dto.isShowLast())
				.currentPage(dto.getCurrentPage())
				.build();
	}
}
