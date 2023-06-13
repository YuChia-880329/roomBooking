package springboot.trans.fr.home.obj.repo.hotelRoomPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.SearchParamDto;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.SearchParam;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.home.obj.repo.homeRooms.SearchParamTrans")
public class SearchParamTrans extends RepoInputTrans<SearchParam, SearchParamDto> {

	@Override
	protected SearchParam dtoToInputImpl(SearchParamDto dto) {
		
		return SearchParam.builder()
				.page(dto.getPage())
				.checkinDate(dto.getCheckinDate())
				.checkoutDate(dto.getCheckoutDate())
				.num(dto.getNum())
				.sectionCode(dto.getSectionCode())
				.build();
	}

	@Override
	protected SearchParamDto inputToDtoImpl(SearchParam input) {
		
		return SearchParamDto.builder()
				.page(input.getPage())
				.checkinDate(input.getCheckinDate())
				.checkoutDate(input.getCheckoutDate())
				.num(input.getNum())
				.sectionCode(input.getSectionCode())
				.build();
	}
}
