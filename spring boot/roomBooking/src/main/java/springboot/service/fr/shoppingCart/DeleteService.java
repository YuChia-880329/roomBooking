package springboot.service.fr.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto;
import springboot.bean.dto.fr.shoppingCart.vo.delete.DeleteReqDto;
import springboot.bean.dto.fr.shoppingCart.vo.delete.DeleteRespDto;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;

@Service("fr.shoppingCart.DeleteService")
public class DeleteService {

	public static final String SUCCESS_DELETE_MSG = "刪除成功";
	public static final String SUCCESS_NOT_DELETE_MSG = "未能刪除，選項不存在於購物車內";
	public static final String FAILURE_MSG = "刪除失敗";
	
	@Autowired
	@Qualifier("fr.memory.db.ShoppingCartDbDao")
	private ShoppingCartDbDao shoppingCartDbDao;
	
	
	public DeleteRespDto delete(DeleteReqDto deleteReq) {
		
		ItemDto item = shoppingCartDbDao.delete(deleteReq.getItemId());
		
		boolean success = true;
		String msg = SUCCESS_DELETE_MSG;
		if(item == null)
			msg = SUCCESS_NOT_DELETE_MSG;
		
		return DeleteRespDto.builder()
				.success(success)
				.msg(success ? msg : FAILURE_MSG)
				.build();
	}
}
