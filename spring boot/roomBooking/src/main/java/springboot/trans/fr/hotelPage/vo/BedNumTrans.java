package springboot.trans.fr.hotelPage.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.BedNumDto;
import springboot.bean.vo.fr.hotelPage.BedNum;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.search.BedNumTrans")
public class BedNumTrans implements VoWoTrans<BedNum, BedNumDto> {

	@Autowired
	@Qualifier("fr.hotelPage.vo.search.SingleBedNumTrans")
	private SingleBedNumTrans singleBedNumTrans;
	@Autowired
	@Qualifier("fr.hotelPage.vo.search.DoubleBedNumTrans")
	private DoubleBedNumTrans doubleBedNumTrans;
	
	@Override
	public BedNum dtoToVoImpl(BedNumDto dto) {
		
		return BedNum.builder()
				.singleBedNum(singleBedNumTrans.dtoToVo(dto.getSingleBedNum()))
				.doubleBedNum(doubleBedNumTrans.dtoToVo(dto.getDoubleBedNum()))
				.build();
	}
}
