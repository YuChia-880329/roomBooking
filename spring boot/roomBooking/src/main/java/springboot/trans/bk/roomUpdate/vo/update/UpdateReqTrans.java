package springboot.trans.bk.roomUpdate.vo.update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.update.UpdateReqDto;
import springboot.bean.vo.bk.roomUpdate.update.UpdateReq;
import springboot.checker.bk.roomUpdate.vo.update.UpdateReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomUpdate.vo.update.UpdateReqTrans")
public class UpdateReqTrans extends VoRiTransChecked<UpdateReq, UpdateReqDto, UpdateReqChecker> {

	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.RoomImgTrans")
	private RoomImgTrans roomImgTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.NewImgTrans")
	private NewImgTrans newImgTrans;
	
	
	@Override
	public UpdateReqDto voToDtoImpl(UpdateReq vo) {
		
		return UpdateReqDto.builder()
				.id(vo.getId())
				.name(vo.getName())
				.totalNum(vo.getTotalNum())
				.invalidNum(vo.getInvalidNum())
				.price(vo.getPrice())
				.singleBedNum(vo.getSingleBedNum())
				.doubleBedNum(vo.getDoubleBedNum())
				.area(vo.getArea())
				.sceneId(vo.getSceneId())
				.showerIds(vo.getShowerIds()!=null ?
						Arrays.stream(vo.getShowerIds()).mapToObj(v -> v).collect(Collectors.toList()) : 
							new ArrayList<>())
				.statusId(vo.getStatusId())
				.roomImgs(vo.getRoomImgs()!=null ? 
						Arrays.stream(vo.getRoomImgs())
						.sorted((ri1, ri2) -> ri1.getOrder()-ri2.getOrder())
						.map(ri -> roomImgTrans.voToDto(ri))
						.collect(Collectors.toList()) : 
							new ArrayList<>())
				.newImgs(vo.getNewImgs()!=null ? 
						Arrays.stream(vo.getNewImgs())
						.sorted((ni1, ni2) -> ni1.getIdNumber()-ni2.getIdNumber())
						.map(ni -> newImgTrans.voToDto(ni))
						.collect(Collectors.toList()) :
							new ArrayList<>())
				.build();
	}

	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.UpdateReqChecker")
	@Override
	public void setChecker(UpdateReqChecker checker) {
		
		this.checker = checker;
	}

}
