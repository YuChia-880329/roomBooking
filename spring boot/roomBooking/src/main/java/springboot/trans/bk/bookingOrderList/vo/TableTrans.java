package springboot.trans.bk.bookingOrderList.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOderList.vo.TableDto;
import springboot.bean.vo.bk.bookingOrderList.Table;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.bookingOrderList.vo.TableTrans")
public class TableTrans implements VoWoTrans<Table, TableDto> {

	@Autowired
	@Qualifier("bk.bookingOrderList.vo.TableRowTrans")
	private TableRowTrans tableRowTrans;

	@Override
	public Table dtoToVoImpl(TableDto dto) {
		
		return Table.builder()
				.tableRows(tableRowTrans.dtoListToVoList(dto.getTableRows()))
				.build();
	}
}
