package springboot.service.bk.roomList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.roomList.vo.TableDto;
import springboot.bean.dto.bk.roomList.vo.TableRowDto;

@Service("bk.roomList.RepoService")
public class RepoService {

	public TableDto toTableVo(springboot.bean.dto.bk.roomList.obj.repo.tablePages.TableDto table) {
		
		return TableDto.builder()
				.tableRows(toTableRowVoList(table.getTableRows()))
				.build();
	}
	private List<TableRowDto> toTableRowVoList(List<springboot.bean.dto.bk.roomList.obj.repo.tablePages.TableRowDto> tableRows) {
		
		List<TableRowDto> list = new ArrayList<>();
		for(int i=0; i<tableRows.size(); i++) {
			
			list.add(toTableRowVo(tableRows.get(i), i));
		}
		return list;
	}
	private TableRowDto toTableRowVo(springboot.bean.dto.bk.roomList.obj.repo.tablePages.TableRowDto tableRow, int index) {
		
		return TableRowDto.builder()
				.index(index)
				.name(tableRow.getName())
				.totalNum(tableRow.getTotalNum())
				.invalidNum(tableRow.getInvalidNum())
				.price(tableRow.getPrice())
				.status(tableRow.getStatus())
				.build();
	}
}
