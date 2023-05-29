package springboot.bean.dto.bk.bookingOrderList.vo.searchTable;

import java.time.LocalDate;
import java.time.LocalDateTime;

import enumeration.PayMethod;
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
	private String roomName;
	private Integer roomNumMin;
	private Integer roomNumMax;
	private Integer priceMin;
	private Integer priceMax;
	private PayMethod[] payMethods;
	private LocalDateTime checkinDateTimeFrom;
	private LocalDateTime checkinDateTimeTo;
	private LocalDate checkoutDateFrom;
	private LocalDate checkoutDateTo;
	private Integer useDayMin;
	private Integer useDayMax;
	private Integer totalPriceMin;
	private Integer totalPriceMax;
}
