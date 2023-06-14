package springboot.trans.fr.hotelPage.vo.search;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.search.SingleBedNumDto;
import springboot.bean.vo.fr.hotelPage.search.SingleBedNum;
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
