package springboot.trans.fr.hotelPage.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.FeaturesDto;
import springboot.bean.vo.fr.hotelPage.Features;
import springboot.bean.vo.fr.hotelPage.Shower;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.search.FeaturesTrans")
public class FeaturesTrans implements VoWoTrans<Features, FeaturesDto> {

	@Autowired
	@Qualifier("fr.hotelPage.vo.search.BedNumTrans")
	private BedNumTrans bedNumTrans;
	@Autowired
	@Qualifier("fr.hotelPage.vo.search.ShowerTrans")
	private ShowerTrans showerTrans;
	
	
	@Override
	public Features dtoToVoImpl(FeaturesDto dto) {
		
		return Features.builder()
				.bedNum(bedNumTrans.dtoToVo(dto.getBedNum()))
				.area(dto.getArea())
				.sceneName(dto.getSceneName())
				.showers(showerTrans.dtoListToVoArray(dto.getShowers(), size -> new Shower[size]))
				.build();
	}
}
