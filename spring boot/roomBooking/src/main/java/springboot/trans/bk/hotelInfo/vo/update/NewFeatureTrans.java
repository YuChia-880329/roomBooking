package springboot.trans.bk.hotelInfo.vo.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.update.NewFeatureDto;
import springboot.bean.vo.bk.hotelInfo.update.NewFeature;
import springboot.checker.bk.hotelInfo.vo.update.NewFeatureChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.hotelInfo.vo.update.NewFeatureTrans")
public class NewFeatureTrans extends VoRiTransChecked<NewFeature, NewFeatureDto, NewFeatureChecker> {

	@Override
	public NewFeatureDto voToDtoImpl(NewFeature vo) {
		
		return NewFeatureDto.builder()
				.id(vo.getId())
				.name(vo.getName())
				.checked(vo.isChecked())
				.build();
	}

	@Autowired
	@Qualifier("bk.hotelInfo.vo.update.NewFeatureChecker")
	@Override
	public void setChecker(NewFeatureChecker checker) {
		
		this.checker = checker;
	}

}
