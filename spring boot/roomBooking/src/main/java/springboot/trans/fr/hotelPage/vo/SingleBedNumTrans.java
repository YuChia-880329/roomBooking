package springboot.trans.fr.hotelPage.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.SingleBedNumDto;
import springboot.bean.vo.fr.hotelPage.SingleBedNum;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.search.SingleBedNumTrans")
public class SingleBedNumTrans implements VoWoTrans<SingleBedNum, SingleBedNumDto> {

	@Override
	public SingleBedNum dtoToVoImpl(SingleBedNumDto dto) {
		
		return SingleBedNum.builder()
				.show(dto.isShow())
				.num(dto.getNum())
				.build();
	}
}
