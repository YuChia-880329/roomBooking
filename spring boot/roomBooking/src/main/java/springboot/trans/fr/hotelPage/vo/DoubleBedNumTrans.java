package springboot.trans.fr.hotelPage.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.DoubleBedNumDto;
import springboot.bean.vo.fr.hotelPage.DoubleBedNum;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.search.DoubleBedNumTrans")
public class DoubleBedNumTrans implements VoWoTrans<DoubleBedNum, DoubleBedNumDto> {

	@Override
	public DoubleBedNum dtoToVoImpl(DoubleBedNumDto dto) {
		
		return DoubleBedNum.builder()
				.show(dto.isShow())
				.num(dto.getNum())
				.build();
	}
}
