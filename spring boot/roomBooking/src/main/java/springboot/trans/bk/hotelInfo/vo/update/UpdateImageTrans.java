package springboot.trans.bk.hotelInfo.vo.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.update.UpdateImageDto;
import springboot.bean.vo.bk.hotelInfo.update.UpdateImage;
import springboot.checker.bk.hotelInfo.vo.update.UpdateImageChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.hotelInfo.vo.update.UpdateImageTrans")
public class UpdateImageTrans extends VoRiTransChecked<UpdateImage, UpdateImageDto, UpdateImageChecker> {

	@Override
	public UpdateImageDto voToDtoImpl(UpdateImage vo) {
		
		return UpdateImageDto.builder()
				.needUpdate(vo.isNeedUpdate())
				.imageName(vo.getImageName())
				.file(vo.getFile())
				.build();
	}

	@Autowired
	@Qualifier("bk.hotelInfo.vo.update.UpdateImageChecker")
	@Override
	public void setChecker(UpdateImageChecker checker) {
		
		this.checker = checker;
	}
}
