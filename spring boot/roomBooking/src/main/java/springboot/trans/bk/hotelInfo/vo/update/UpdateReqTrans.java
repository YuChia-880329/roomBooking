package springboot.trans.bk.hotelInfo.vo.update;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.update.UpdateReqDto;
import springboot.bean.vo.bk.hotelInfo.update.UpdateReq;
import springboot.checker.bk.hotelInfo.vo.update.UpdateReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.hotelInfo.vo.update.UpdateReqTrans")
public class UpdateReqTrans extends VoRiTransChecked<UpdateReq, UpdateReqDto, UpdateReqChecker> {

	@Autowired
	@Qualifier("bk.hotelInfo.vo.update.NewFeatureTrans")
	private NewFeatureTrans newFeatureTrans;
	@Autowired
	@Qualifier("bk.hotelInfo.vo.update.UpdateImageTrans")
	private UpdateImageTrans updateImageTrans;
	
	@Override
	public UpdateReqDto voToDtoImpl(UpdateReq vo) {
		
		return UpdateReqDto.builder()
				.name(vo.getName())
				.sectionCode(vo.getSectionCode())
				.address(vo.getAddress())
				.description(vo.getDescription())
				.featureIds(Arrays.stream(vo.getFeatureIds()).mapToObj(fi -> fi).collect(Collectors.toList()))
				.newFeatures(newFeatureTrans.voArrayToDtoList(vo.getNewFeatures()))
				.updateImage(updateImageTrans.voToDto(vo.getUpdateImage()))
				.build();
	}

	@Autowired
	@Qualifier("bk.hotelInfo.vo.update.UpdateReqChecker")
	@Override
	public void setChecker(UpdateReqChecker checker) {
		
		this.checker = checker;
	}

}
