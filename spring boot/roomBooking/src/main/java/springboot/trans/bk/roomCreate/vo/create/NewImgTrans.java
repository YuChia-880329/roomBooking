package springboot.trans.bk.roomCreate.vo.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomCreate.vo.create.NewImgDto;
import springboot.bean.vo.bk.roomCreate.create.NewImg;
import springboot.checker.bk.roomCreate.vo.create.NewImgChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomCreate.vo.create.NewImgTrans")
public class NewImgTrans extends VoRiTransChecked<NewImg, NewImgDto, NewImgChecker> {

	@Override
	public NewImgDto voToDtoImpl(NewImg vo) {
		
		return NewImgDto.builder()
				.imgName(vo.getImgName())
				.file(vo.getFile())
				.build();
	}

	@Autowired
	@Qualifier("bk.roomCreate.vo.create.NewImgChecker")
	@Override
	public void setChecker(NewImgChecker checker) {
		
		this.checker = checker;
	}
}
