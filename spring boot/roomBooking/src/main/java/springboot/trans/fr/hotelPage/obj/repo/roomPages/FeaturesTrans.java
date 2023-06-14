package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.FeaturesDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Features;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.FeaturesTrans")
public class FeaturesTrans extends RepoOutputTrans<Features, FeaturesDto> {

	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.BedNumTrans")
	private BedNumTrans bedNumTrans;
	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.ShowerTrans")
	private ShowerTrans showerTrans;


	@Override
	protected Features dtoToOutputImpl(FeaturesDto dto) {
		
		return Features.builder()
				.bedNum(bedNumTrans.dtoToObj(dto.getBedNum()))
				.area(dto.getArea())
				.sceneName(dto.getSceneName())
				.showers(showerTrans.dtoListToObjList(dto.getShowers()))
				.build();
	}


	@Override
	protected FeaturesDto outputToDtoImpl(Features output) {
		
		return FeaturesDto.builder()
				.bedNum(bedNumTrans.objToDto(output.getBedNum()))
				.area(output.getArea())
				.sceneName(output.getSceneName())
				.showers(showerTrans.objListToDtoList(output.getShowers()))
				.build();
	}
}
