package springboot.trans.fr.shoppingCart.vo.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.show.ShowRespDto;
import springboot.bean.vo.fr.shoppingCart.show.ShowResp;
import springboot.trans.fr.shoppingCart.vo.ItemListTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.show.ShowRespTrans")
public class ShowRespTrans implements VoWoTrans<ShowResp, ShowRespDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.ItemListTrans")
	private ItemListTrans itemListTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	

	@Override
	public ShowResp dtoToVoImpl(ShowRespDto dto) {
		
		return ShowResp.builder()
				.itemList(itemListTrans.dtoToVo(dto.getItemList()))
				.totalPrice(dto.getTotalPrice())
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}
}
