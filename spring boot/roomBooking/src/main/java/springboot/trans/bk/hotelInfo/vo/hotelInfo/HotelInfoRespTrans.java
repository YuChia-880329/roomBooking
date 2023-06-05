package springboot.trans.bk.hotelInfo.vo.hotelInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.hotelInfo.vo.hotelInfo.HotelInfoRespDto;
import springboot.bean.vo.bk.hotelInfo.hotelInfo.HotelInfoResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.hotelInfo.vo.hotelInfo.HotelInfoRespTrans")
public class HotelInfoRespTrans implements VoWoTrans<HotelInfoResp, HotelInfoRespDto> {

	@Autowired
	@Qualifier("bk.hotelInfo.vo.hotelInfo.UpdateImgTrans")
	private ImageTrans updateImgTrans;
	
	@Override
	public HotelInfoResp dtoToVoImpl(HotelInfoRespDto dto) {
		
		List<Integer> featureIds = dto.getFeatureIds();
		int[] featureIdArray = new int[featureIds.size()];
		for(int i=0; i<featureIds.size(); i++) {
			
			featureIdArray[i] = featureIds.get(i);
		}
		
		return HotelInfoResp.builder()
				.name(dto.getName())
				.sectionCode(dto.getSectionCode())
				.address(dto.getAddress())
				.introduction(dto.getIntroduction())
				.featureIds(featureIdArray)
				.newFeatureNames(dto.getNewFeatureNames().toArray(new String[dto.getNewFeatureNames().size()]))
				.image(updateImgTrans.dtoToVo(dto.getImage()))
				.build();
	}
}
