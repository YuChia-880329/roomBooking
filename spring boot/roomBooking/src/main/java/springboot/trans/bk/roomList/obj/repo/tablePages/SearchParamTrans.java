package springboot.trans.bk.roomList.obj.repo.tablePages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.obj.repo.tablePages.SearchParamDto;
import springboot.bean.obj.bk.roomList.repo.tablePages.SearchParam;
import springboot.memory.repo.RepoInputTrans;

@Component("bk.roomList.obj.repo.tablePages.SearchParamTrans")
public class SearchParamTrans extends RepoInputTrans<SearchParam, SearchParamDto> {

	@Override
	protected SearchParam dtoToInputImpl(SearchParamDto dto) {
		
		return SearchParam.builder()
				.page(dto.getPage())
				.name(dto.getName())
				.totalNumMin(dto.getTotalNumMin())
				.totalNumMax(dto.getTotalNumMax())
				.usedNumMin(dto.getUsedNumMin())
				.usedNumMax(dto.getUsedNumMax())
				.invalidNumMin(dto.getInvalidNumMin())
				.invalidNumMax(dto.getInvalidNumMax())
				.priceMin(dto.getPriceMin())
				.priceMax(dto.getPriceMax())
				.status(dto.getStatus())
				.roomTableOrder(dto.getRoomTableOrder())
				.build();
	}

	@Override
	protected SearchParamDto inputToDtoImpl(SearchParam inputObj) {
		
		return SearchParamDto.builder()
				.page(inputObj.getPage())
				.name(inputObj.getName())
				.totalNumMin(inputObj.getTotalNumMin())
				.totalNumMax(inputObj.getTotalNumMax())
				.usedNumMin(inputObj.getUsedNumMin())
				.usedNumMax(inputObj.getUsedNumMax())
				.invalidNumMin(inputObj.getInvalidNumMin())
				.invalidNumMax(inputObj.getInvalidNumMax())
				.priceMin(inputObj.getPriceMin())
				.priceMax(inputObj.getPriceMax())
				.status(inputObj.getStatus())
				.roomTableOrder(inputObj.getRoomTableOrder())
				.build();
	}
}
