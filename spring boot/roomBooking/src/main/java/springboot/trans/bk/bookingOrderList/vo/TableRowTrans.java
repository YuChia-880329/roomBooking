package springboot.trans.bk.bookingOrderList.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.vo.TableRowDto;
import springboot.bean.vo.bk.bookingOrderList.TableRow;
import tmpl.trans.bean.vo.VoWoTrans;
import util.DateTimeUtil;

@Component("bk.bookingOrderList.vo.TableRowTrans")
public class TableRowTrans implements VoWoTrans<TableRow, TableRowDto> {

	@Override
	public TableRow dtoToVoImpl(TableRowDto dto) {
		
		return TableRow.builder()
				.id(dto.getId())
				.clientName(dto.getClientName())
				.clientPhone(dto.getClientPhone())
				.roomName(dto.getRoomName())
				.roomNum(dto.getRoomNum())
				.price(dto.getPrice())
				.payMethod(dto.getPayMethod())
				.checkinDate(DateTimeUtil.toString(dto.getCheckinDate()))
				.checkoutDate(DateTimeUtil.toString(dto.getCheckoutDate()))
				.useDay(dto.getUseDay())
				.totalPrice(dto.getTotalPrice())
				.build();
	}
}
