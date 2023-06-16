package springboot.trans.fr.shoppingCart.vo.delete;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.delete.DeleteRespDto;
import springboot.bean.vo.fr.shoppingCart.delete.DeleteResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.delete.DeleteRespTrans")
public class DeleteRespTrans implements VoWoTrans<DeleteResp, DeleteRespDto> {

	@Override
	public DeleteResp dtoToVoImpl(DeleteRespDto dto) {
		
		return DeleteResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}
