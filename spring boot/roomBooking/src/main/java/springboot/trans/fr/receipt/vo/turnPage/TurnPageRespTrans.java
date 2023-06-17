package springboot.trans.fr.receipt.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.turnPage.TurnPageRespDto;
import springboot.bean.vo.fr.receipt.Item;
import springboot.bean.vo.fr.receipt.turnPage.TurnPageResp;
import springboot.trans.fr.receipt.vo.ItemTrans;
import springboot.trans.fr.receipt.vo.PayMethodTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.receipt.vo.turnPage.TurnPageRespTrans")
public class TurnPageRespTrans implements VoWoTrans<TurnPageResp, TurnPageRespDto> {

	@Autowired
	@Qualifier("fr.receipt.vo.ItemTrans")
	private ItemTrans itemTrans;
	@Autowired
	@Qualifier("fr.receipt.vo.PayMethodTrans")
	private PayMethodTrans payMethodTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public TurnPageResp dtoToVoImpl(TurnPageRespDto dto) {
		
		return TurnPageResp.builder()
				.items(itemTrans.dtoListToVoArray(dto.getItems(), size -> new Item[size]))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.totalPrice(dto.getTotalPrice())
				.payMethod(payMethodTrans.dtoToVo(dto.getPayMethod()))
				.build();
	}
}
