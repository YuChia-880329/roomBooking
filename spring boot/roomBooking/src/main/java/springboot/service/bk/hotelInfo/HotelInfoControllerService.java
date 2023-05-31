package springboot.service.bk.hotelInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.trans.bk.hotelInfo.vo.allSections.AllSectionsRespTrans;
import util.ResponseUtil;

@Service("bk.hotelInfo.HotelInfoControllerService")
public class HotelInfoControllerService {

	@Autowired
	@Qualifier("bk.hotelInfo.AllSectionService")
	private AllSectionService allSectionService;
	
	@Autowired
	@Qualifier("bk.hotelInfo.vo.allSections.AllSectionsRespTrans")
	private AllSectionsRespTrans allSectionsRespTrans;
	
	
	public Response allSections() {
		
		return ResponseUtil.response200(
				allSectionsRespTrans.dtoToVo(
						allSectionService.allSections()));
	}
}
