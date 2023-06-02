package springboot.service.bk.hotelInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.hotelInfo.checkNewHotelFeature.CheckNewHotelFeatureReq;
import springboot.trans.bk.hotelInfo.vo.allFeatures.AllFeaturesRespTrans;
import springboot.trans.bk.hotelInfo.vo.allNewFeatures.AllNewFeaturesRespTrans;
import springboot.trans.bk.hotelInfo.vo.allSections.AllSectionsRespTrans;
import springboot.trans.bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureReqTrans;
import springboot.trans.bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureRespTrans;
import util.ResponseUtil;

@Service("bk.hotelInfo.HotelInfoControllerService")
public class HotelInfoControllerService {

	@Autowired
	@Qualifier("bk.hotelInfo.AllSectionService")
	private AllSectionService allSectionService;
	@Autowired
	@Qualifier("bk.hotelInfo.AllFeaturesService")
	private AllFeaturesService allFeaturesService;
	@Autowired
	@Qualifier("bk.hotelInfo.AllNewFeaturesService")
	private AllNewFeaturesService allNewFeaturesService;
	@Autowired
	@Qualifier("bk.hotelInfo.CheckNewHotelFeatureService")
	private CheckNewHotelFeatureService checkNewHotelFeatureService;
	
	
	@Autowired
	@Qualifier("bk.hotelInfo.vo.allSections.AllSectionsRespTrans")
	private AllSectionsRespTrans allSectionsRespTrans;
	@Autowired
	@Qualifier("bk.hotelInfo.vo.allHotelFeatures.AllFeaturesRespTrans")
	private AllFeaturesRespTrans allHotelFeaturesRespTrans;
	@Autowired
	@Qualifier("bk.hotelInfo.vo.allNewFeatures.AllNewFeaturesRespTrans")
	private AllNewFeaturesRespTrans allNewFeaturesRespTrans;
	@Autowired
	@Qualifier("bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureReqTrans")
	private CheckNewHotelFeatureReqTrans checkNewHotelFeatureReqTrans;
	@Autowired
	@Qualifier("bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureRespTrans")
	private CheckNewHotelFeatureRespTrans checkNewHotelFeatureRespTrans;
	
	
	public Response allSections() {
		
		return ResponseUtil.response200(
				allSectionsRespTrans.dtoToVo(
						allSectionService.allSections()));
	}
	public Response allFeatures() {
		
		return ResponseUtil.response200(
				allHotelFeaturesRespTrans.dtoToVo(
						allFeaturesService.allFeatures()));
	}
	public Response allNewFeatures() {
		
		return ResponseUtil.response200(
				allNewFeaturesRespTrans.dtoToVo(
						allNewFeaturesService.allNewFeatures()));
	}
	public Response checkNewHotelFeature(String name) {
		
		CheckNewHotelFeatureReq checkNewHotelFeatureReq = CheckNewHotelFeatureReq.builder()
				.name(name)
				.build();
		return ResponseUtil.response200(
				checkNewHotelFeatureRespTrans.dtoToVo(
						checkNewHotelFeatureService.checkNewHotelFeature(
								checkNewHotelFeatureReqTrans.voToDto(checkNewHotelFeatureReq))));
	}
}
