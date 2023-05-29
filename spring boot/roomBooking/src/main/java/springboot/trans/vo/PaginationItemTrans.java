package springboot.trans.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.vo.PaginationItemDto;
import springboot.bean.vo.PaginationItem;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("vo.PaginationItemTrans")
public class PaginationItemTrans implements VoWoTrans<PaginationItem, PaginationItemDto> {

	@Override
	public PaginationItem dtoToVoImpl(PaginationItemDto dto) {
		
		return PaginationItem.builder()
				.show(dto.isShow())
				.toPage(dto.getToPage())
				.build();
	}
}
