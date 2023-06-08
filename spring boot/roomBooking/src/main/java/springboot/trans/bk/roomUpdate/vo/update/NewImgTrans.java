package springboot.trans.bk.roomUpdate.vo.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.update.NewImgDto;
import springboot.bean.vo.bk.roomUpdate.update.NewImg;
import springboot.checker.bk.roomUpdate.vo.update.NewImgChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomUpdate.vo.update.NewImgTrans")
public class NewImgTrans extends VoRiTransChecked<NewImg, NewImgDto, NewImgChecker> {

	@Override
	public NewImgDto voToDtoImpl(NewImg vo) {
		
		return NewImgDto.builder()
				.imgName(vo.getImgName())
				.file(vo.getFile())
				.build();
	}

	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.NewImgChecker")
	@Override
	public void setChecker(NewImgChecker checker) {
		
		this.checker = checker;
	}
}
