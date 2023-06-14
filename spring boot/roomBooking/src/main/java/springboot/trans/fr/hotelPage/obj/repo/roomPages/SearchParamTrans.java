package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.SearchParamDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.SearchParam;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.SearchParamTrans")
public class SearchParamTrans extends RepoInputTrans<SearchParam, SearchParamDto> {

	@Override
	protected SearchParam dtoToInputImpl(SearchParamDto dto) {
		
		return SearchParam.builder()
				.hotelId(dto.getHotelId())
				.page(dto.getPage())
				.checkinDate(dto.getCheckinDate())
				.checkoutDate(dto.getCheckoutDate())
				.num(dto.getNum())
				.build();
	}

	@Override
	protected SearchParamDto inputToDtoImpl(SearchParam input) {
		
		return SearchParamDto.builder()
				.hotelId(input.getHotelId())
				.page(input.getPage())
				.checkinDate(input.getCheckinDate())
				.checkoutDate(input.getCheckoutDate())
				.num(input.getNum())
				.build();
	}
}
