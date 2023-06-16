package springboot.trans.fr.shoppingCart.vo.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.delete.DeleteReqDto;
import springboot.bean.vo.fr.shoppingCart.delete.DeleteReq;
import springboot.checker.fr.shoppingCart.vo.delete.DeleteReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.shoppingCart.vo.delete.DeleteReqTrans")
public class DeleteReqTrans extends VoRiTransChecked<DeleteReq, DeleteReqDto, DeleteReqChecker> {

	@Override
	public DeleteReqDto voToDtoImpl(DeleteReq vo) {
		
		return DeleteReqDto.builder()
				.itemId(vo.getItemId())
				.build();
	}

	@Autowired
	@Qualifier("fr.shoppingCart.vo.delete.DeleteReqChecker")
	@Override
	public void setChecker(DeleteReqChecker checker) {
		
		this.checker = checker;
	}

}
