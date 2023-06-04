package springboot.service.bk.hotelInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.hotelInfo.checkNewFeature.CheckNewFeatureReq;
import springboot.trans.bk.hotelInfo.vo.allFeatures.AllFeaturesRespTrans;
import springboot.trans.bk.hotelInfo.vo.allNewFeatures.AllNewFeaturesRespTrans;
import springboot.trans.bk.hotelInfo.vo.allSections.AllSectionsRespTrans;
import springboot.trans.bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureReqTrans;
import springboot.trans.bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureRespTrans;
import springboot.trans.bk.hotelInfo.vo.hotelInfo.HotelInfoRespTrans;
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
	@Qualifier("bk.hotelInfo.CheckNewFeatureService")
	private CheckNewFeatureService checkNewFeatureService;
	@Autowired
	@Qualifier("bk.hotelInfo.HotelInfoService")
	private HotelInfoService hotelInfoService;
	
	
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
	@Qualifier("bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureReqTrans")
	private CheckNewFeatureReqTrans checkNewFeatureReqTrans;
	@Autowired
	@Qualifier("bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureRespTrans")
	private CheckNewFeatureRespTrans checkNewFeatureRespTrans;
	@Autowired
	@Qualifier("bk.hotelInfo.vo.hotelInfo.HotelInfoRespTrans")
	private HotelInfoRespTrans hotelInfoRespTrans;
	
	
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
	public Response checkNewFeature(String name) {
		
		CheckNewFeatureReq checkNewFeatureReq = CheckNewFeatureReq.builder()
				.name(name)
				.build();
		return ResponseUtil.response200(
				checkNewFeatureRespTrans.dtoToVo(
						checkNewFeatureService.checkNewFeature(
								checkNewFeatureReqTrans.voToDto(checkNewFeatureReq))));
	}
	public Response hotelInfo() {
		
		return ResponseUtil.response200(
				hotelInfoRespTrans.dtoToVo(
						hotelInfoService.hotelInfo()));
	}
}
