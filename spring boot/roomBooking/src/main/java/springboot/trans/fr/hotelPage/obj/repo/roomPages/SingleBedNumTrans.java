package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.SingleBedNumDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.SingleBedNum;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.SingleBedNumTrans")
public class SingleBedNumTrans extends RepoOutputTrans<SingleBedNum, SingleBedNumDto> {

	@Override
	protected SingleBedNum dtoToOutputImpl(SingleBedNumDto dto) {
		
		return SingleBedNum.builder()
				.show(dto.isShow())
				.num(dto.getNum())
				.build();
	}

	@Override
	protected SingleBedNumDto outputToDtoImpl(SingleBedNum output) {
		
		return SingleBedNumDto.builder()
				.show(output.isShow())
				.num(output.getNum())
				.build();
	}
}
