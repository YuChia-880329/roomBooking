package springboot.trans.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.ShowerDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.Shower;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomUpdate.vo.roomInfo.ShowerTrans")
public class ShowerTrans implements VoWoTrans<Shower, ShowerDto> {

	@Override
	public Shower dtoToVoImpl(ShowerDto dto) {
		
		return Shower.builder()
				.able(dto.isAble())
				.showerIds(toShowerIdsVo(dto.getShowerIds()))
				.build();
	}

	private int[] toShowerIdsVo(List<Integer> showerIds) {
		
		int[] array = new int[showerIds.size()];
		
		for(int i=0; i<showerIds.size(); i++) {
			
			array[i] = showerIds.get(i);
		}
		
		return array;
	}
}
