package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.DoubleBedNumDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.DoubleBedNum;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.DoubleBedNumTrans")
public class DoubleBedNumTrans extends RepoOutputTrans<DoubleBedNum, DoubleBedNumDto> {

	@Override
	protected DoubleBedNum dtoToOutputImpl(DoubleBedNumDto dto) {
		
		return DoubleBedNum.builder()
				.show(dto.isShow())
				.num(dto.getNum())
				.build();
	}

	@Override
	protected DoubleBedNumDto outputToDtoImpl(DoubleBedNum output) {
		
		return DoubleBedNumDto.builder()
				.show(output.isShow())
				.num(output.getNum())
				.build();
	}
}
