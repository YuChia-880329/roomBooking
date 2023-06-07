package springboot.trans.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomInfoRespDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomImg;
import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomInfoResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.roomInfo.RoomInfoRespTrans")
public class RoomInfoRespTrans implements VoWoTrans<RoomInfoResp, RoomInfoRespDto> {

	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.RoomImgTrans")
	private RoomImgTrans roomImgTrans;
	
	
	@Override
	public RoomInfoResp dtoToVoImpl(RoomInfoRespDto dto) {
		
		return RoomInfoResp.builder()
				.totalNum(dto.getTotalNum())
				.usedNum(dto.getUsedNum())
				.invalidNum(dto.getInvalidNum())
				.price(dto.getPrice())
				.singleBedNum(dto.getSingleBedNum())
				.doubleBedNum(dto.getDoubleBedNum())
				.area(dto.getArea())
				.sceneId(dto.getSceneId())
				.showerIds(toShowerIdsVo(dto.getShowerIds()))
				.statusId(dto.getStatus().getCode())
				.imgs(roomImgTrans.dtoListToVoArray(dto.getImgs(), size -> new RoomImg[size]))
				.build();
	}
	
	private int[] toShowerIdsVo(List<Integer> showerIds) {
		
		int[] array = new int[showerIds.size()];
		
		for(int i=0; i<array.length; i++) {
			
			array[i] = showerIds.get(i);
		}
		
		return array;
	}
}
