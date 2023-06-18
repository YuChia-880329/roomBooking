package springboot.bean.vo.bk.bookingOrderList.searchTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchTableReq {

	private String idMin;
	private String idMax;
	private String clientName;
	private String clientPhone;
	private String roomType;
	private String roomNumMin;
	private String roomNumMax;
	private String priceMin;
	private String priceMax;
	private String[] payMethodIds;
	private String checkinDateFrom;
	private String checkinDateTo;
	private String checkoutDateFrom;
	private String checkoutDateTo;
	private String useDayMin;
	private String useDayMax;
	private String totalPriceMin;
	private String totalPriceMax;
}
