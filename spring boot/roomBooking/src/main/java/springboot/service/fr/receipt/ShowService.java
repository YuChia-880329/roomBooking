package springboot.service.fr.receipt;

import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.receipt.vo.show.ShowReqDto;
import springboot.bean.dto.fr.receipt.vo.show.ShowRespDto;

@Service("fr.receipt.ShowService")
public class ShowService {

	
	public ShowRespDto show(ShowReqDto showReq) {
		
		return ShowRespDto.builder()
				.build();
	}
}
