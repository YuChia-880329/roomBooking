package springboot.bean.dto.bk.bookingOrderList.vo.searchTable;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchTableReqDto {

	private Integer idMin;
	private Integer idMax;
	private String clientName;
	private String clientPhone;
	private Integer roomType;
	private Integer roomNumMin;
	private Integer roomNumMax;
	private Integer priceMin;
	private Integer priceMax;
	private List<Integer> payMethodIds;
	private LocalDate checkinDateFrom;
	private LocalDate checkinDateTo;
	private LocalDate checkoutDateFrom;
	private LocalDate checkoutDateTo;
	private Integer useDayMin;
	private Integer useDayMax;
	private Integer totalPriceMin;
	private Integer totalPriceMax;
}
