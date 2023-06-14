package springboot.trans.fr.hotelPage.vo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.search.FeaturesDto;
import springboot.bean.vo.fr.hotelPage.search.Features;
import springboot.bean.vo.fr.hotelPage.search.Shower;
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
