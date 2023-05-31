package springboot.trans.bk.bookingOrderList.obj.repo.tablePages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.SearchParamDto;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.SearchParam;
import springboot.memory.repo.RepoInputTrans;

@Component("bk.bookingOrderList.obj.repo.tablePages.SearchParamTrans")
public class SearchParamTrans extends RepoInputTrans<SearchParam, SearchParamDto> {

	@Override
	protected SearchParam dtoToInputImpl(SearchParamDto dto) {
		
		return SearchParam.builder()
				.page(dto.getPage())
				.idMin(dto.getIdMin())
				.idMax(dto.getIdMax())
				.clientName(dto.getClientName())
				.clientPhone(dto.getClientPhone())
				.roomType(dto.getRoomType())
				.roomNumMin(dto.getRoomNumMin())
				.roomNumMax(dto.getRoomNumMax())
				.priceMin(dto.getPriceMin())
				.priceMax(dto.getPriceMax())
				.payMethods(dto.getPayMethods())
				.checkinDateTimeFrom(dto.getCheckinDateTimeFrom())
				.checkinDateTimeTo(dto.getCheckinDateTimeTo())
				.checkoutDateFrom(dto.getCheckoutDateFrom())
				.checkoutDateTo(dto.getCheckoutDateTo())
				.useDayMin(dto.getUseDayMin())
				.useDayMax(dto.getUseDayMax())
				.totalPriceMin(dto.getTotalPriceMin())
				.totalPriceMax(dto.getTotalPriceMax())
				.bookingOrderTableOrder(dto.getBookingOrderTableOrder())
				.build();
	}

	@Override
	protected SearchParamDto inputToDtoImpl(SearchParam inputObj) {
		
		return SearchParamDto.builder()
				.page(inputObj.getPage())
				.idMin(inputObj.getIdMin())
				.idMax(inputObj.getIdMax())
				.clientName(inputObj.getClientName())
				.clientPhone(inputObj.getClientPhone())
				.roomType(inputObj.getRoomType())
				.roomNumMin(inputObj.getRoomNumMin())
				.roomNumMax(inputObj.getRoomNumMax())
				.priceMin(inputObj.getPriceMin())
				.priceMax(inputObj.getPriceMax())
				.payMethods(inputObj.getPayMethods())
				.checkinDateTimeFrom(inputObj.getCheckinDateTimeFrom())
				.checkinDateTimeTo(inputObj.getCheckinDateTimeTo())
				.checkoutDateFrom(inputObj.getCheckoutDateFrom())
				.checkoutDateTo(inputObj.getCheckoutDateTo())
				.useDayMin(inputObj.getUseDayMin())
				.useDayMax(inputObj.getUseDayMax())
				.totalPriceMin(inputObj.getTotalPriceMin())
				.totalPriceMax(inputObj.getTotalPriceMax())
				.bookingOrderTableOrder(inputObj.getBookingOrderTableOrder())
				.build();
	}
}
