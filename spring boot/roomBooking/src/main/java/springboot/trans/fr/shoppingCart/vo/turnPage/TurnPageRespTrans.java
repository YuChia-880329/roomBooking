package springboot.trans.fr.shoppingCart.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.turnPage.TurnPageRespDto;
import springboot.bean.vo.fr.shoppingCart.turnPage.TurnPageResp;
import springboot.trans.fr.shoppingCart.vo.ItemListTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.turnPage.TurnPageRespTrans")
public class TurnPageRespTrans implements VoWoTrans<TurnPageResp, TurnPageRespDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.ItemListTrans")
	private ItemListTrans itemListTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public TurnPageResp dtoToVoImpl(TurnPageRespDto dto) {
		
		return TurnPageResp.builder()
				.itemList(itemListTrans.dtoToVo(dto.getItemList()))
				.totalPrice(dto.getTotalPrice())
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}
}
