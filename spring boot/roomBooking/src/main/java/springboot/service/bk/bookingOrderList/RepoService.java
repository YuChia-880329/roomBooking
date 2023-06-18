package springboot.service.bk.bookingOrderList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.bookingOrderList.vo.TableDto;
import springboot.bean.dto.bk.bookingOrderList.vo.TableRowDto;

@Service("bk.bookingOrderList.RepoService")
public class RepoService {

	public TableDto toTableVo(springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.TableDto table) {
		
		return TableDto.builder()
				.tableRows(toTableRowVoList(table.getTableRows()))
				.build();
	}
	private List<TableRowDto> toTableRowVoList(List<springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.TableRowDto> tableRows) {
		
		return tableRows.stream()
				.map(tableRow -> toTableRowVo(tableRow))
				.collect(Collectors.toList());
	}
	private TableRowDto toTableRowVo(springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.TableRowDto tableRow) {
		
		return TableRowDto.builder()
				.id(tableRow.getId())
				.clientName(tableRow.getClientName())
				.clientPhone(tableRow.getClientPhone())
				.roomName(tableRow.getRoomName())
				.roomNum(tableRow.getRoomNum())
				.price(tableRow.getPrice())
				.payMethod(tableRow.getPayMethod())
				.checkinDate(tableRow.getCheckinDate())
				.checkoutDate(tableRow.getCheckoutDate())
				.useDay(tableRow.getUseDay())
				.totalPrice(tableRow.getTotalPrice())
				.build();
	}
}
