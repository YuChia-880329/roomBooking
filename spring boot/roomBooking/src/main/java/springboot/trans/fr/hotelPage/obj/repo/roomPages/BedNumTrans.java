package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.BedNumDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.BedNum;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.BedNumTrans")
public class BedNumTrans extends RepoOutputTrans<BedNum, BedNumDto> {

	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.SingleBedNumTrans")
	private SingleBedNumTrans singleBedNumTrans;
	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.DoubleBedNumTrans")
	private DoubleBedNumTrans doubleBedNumTrans;
	
	@Override
	protected BedNum dtoToOutputImpl(BedNumDto dto) {
		
		return BedNum.builder()
				.singleBedNum(singleBedNumTrans.dtoToObj(dto.getSingleBedNum()))
				.doubleBedNum(doubleBedNumTrans.dtoToObj(dto.getDoubleBedNum()))
				.build();
	}

	@Override
	protected BedNumDto outputToDtoImpl(BedNum output) {
		
		return BedNumDto.builder()
				.singleBedNum(singleBedNumTrans.objToDto(output.getSingleBedNum()))
				.doubleBedNum(doubleBedNumTrans.objToDto(output.getDoubleBedNum()))
				.build();
	}
}
