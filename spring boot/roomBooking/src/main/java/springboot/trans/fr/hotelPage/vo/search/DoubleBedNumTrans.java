package springboot.trans.fr.hotelPage.vo.search;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.search.DoubleBedNumDto;
import springboot.bean.vo.fr.hotelPage.search.DoubleBedNum;
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
