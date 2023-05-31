package springboot.bean.obj.bk.bookingOrderList.repo.tablePages;

import java.time.LocalDate;
import java.time.LocalDateTime;

import enumeration.PayMethod;
import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchParam {

	private int page;
	private Integer idMin;
	private Integer idMax;
	private String clientName;
	private String clientPhone;
	private Integer roomType;
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
	private BookingOrderTableOrder bookingOrderTableOrder;
}
