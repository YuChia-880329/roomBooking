package springboot.trans.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import org.springframework.stereotype.Component;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.InvalidNumDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.InvalidNum;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomUpdate.vo.roomInfo.InvalidNumTrans")
public class InvalidNumTrans implements VoWoTrans<InvalidNum, InvalidNumDto> {

	@Override
	public InvalidNum dtoToVoImpl(InvalidNumDto dto) {
		
		return InvalidNum.builder()
				.hasValue(dto.isHasValue())
				.options(toOptionsVo(dto.getOptions()))
				.value(dto.getValue())
				.build();
	}
	
	private int[] toOptionsVo(List<Integer> options) {
		
		int[] array = new int[options.size()];
		
		for(int i=0; i<options.size(); i++) {
			
			array[i] = options.get(i);
		}
		
		return array;
	}
}
