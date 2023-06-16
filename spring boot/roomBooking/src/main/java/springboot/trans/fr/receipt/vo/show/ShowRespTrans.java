package springboot.trans.fr.receipt.vo.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.show.ShowRespDto;
import springboot.bean.vo.fr.receipt.show.Item;
import springboot.bean.vo.fr.receipt.show.ShowResp;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.receipt.vo.show.ShowResp")
public class ShowRespTrans implements VoWoTrans<ShowResp, ShowRespDto> {

	@Autowired
	@Qualifier("fr.receipt.vo.show.ItemTrans")
	private ItemTrans itemTrans;
	@Autowired
	@Qualifier("fr.receipt.vo.show.PayMethodTrans")
	private PayMethodTrans payMethodTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	
	@Override
	public ShowResp dtoToVoImpl(ShowRespDto dto) {
		
		return ShowResp.builder()
				.items(itemTrans.dtoListToVoArray(dto.getItems(), size -> new Item[size]))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.totalPrice(dto.getTotalPrice())
				.payMethod(payMethodTrans.dtoToVo(dto.getPayMethod()))
				.build();
	}
}
