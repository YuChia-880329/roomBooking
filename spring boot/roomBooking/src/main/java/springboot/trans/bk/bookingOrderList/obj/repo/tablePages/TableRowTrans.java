package springboot.trans.bk.bookingOrderList.obj.repo.tablePages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.TableRowDto;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.TableRow;
import springboot.memory.repo.RepoOutputTrans;

@Component("bk.bookingOrderList.obj.repo.tablePages.TableRowTrans")
public class TableRowTrans extends RepoOutputTrans<TableRow, TableRowDto> {

	@Override
	protected TableRow dtoToOutputImpl(TableRowDto dto) {
		
		return TableRow.builder()
				.id(dto.getId())
				.clientName(dto.getClientName())
				.clientPhone(dto.getClientPhone())
				.roomName(dto.getRoomName())
				.roomNum(dto.getRoomNum())
				.price(dto.getPrice())
				.payMethod(dto.getPayMethod())
				.checkinDateTime(dto.getCheckinDateTime())
				.checkoutDate(dto.getCheckoutDate())
				.useDay(dto.getUseDay())
				.totalPrice(dto.getTotalPrice())
				.build();
	}

	@Override
	protected TableRowDto outputToDtoImpl(TableRow output) {
		
		return TableRowDto.builder()
				.id(output.getId())
				.clientName(output.getClientName())
				.clientPhone(output.getClientPhone())
				.roomName(output.getRoomName())
				.roomNum(output.getRoomNum())
				.price(output.getPrice())
				.payMethod(output.getPayMethod())
				.checkinDateTime(output.getCheckinDateTime())
				.checkoutDate(output.getCheckoutDate())
				.useDay(output.getUseDay())
				.totalPrice(output.getTotalPrice())
				.build();
	}
}
