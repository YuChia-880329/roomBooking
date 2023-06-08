package springboot.trans.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.UsedNumDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.UsedNum;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomUpdate.vo.roomInfo.UsedNumTrans")
public class UsedNumTrans implements VoWoTrans<UsedNum, UsedNumDto> {

	@Override
	public UsedNum dtoToVoImpl(UsedNumDto dto) {
		
		return UsedNum.builder()
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
