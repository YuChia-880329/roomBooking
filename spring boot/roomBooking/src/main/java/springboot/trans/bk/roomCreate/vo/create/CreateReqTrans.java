package springboot.trans.bk.roomCreate.vo.create;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomCreate.vo.create.CreateReqDto;
import springboot.bean.vo.bk.roomCreate.create.CreateReq;
import springboot.checker.bk.roomCreate.vo.create.CreateReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomCreate.vo.create.CreateReqTrans")
public class CreateReqTrans extends VoRiTransChecked<CreateReq, CreateReqDto, CreateReqChecker> {

	@Autowired
	@Qualifier("bk.roomCreate.vo.create.NewImgTrans")
	private NewImgTrans newImgTrans;
	
	
	@Override
	public CreateReqDto voToDtoImpl(CreateReq vo) {
		
		return CreateReqDto.builder()
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
				.newImgs(vo.getNewImgs()!=null ? 
						Arrays.stream(vo.getNewImgs())
						.sorted((ni1, ni2) -> ni1.getIdNumber()-ni2.getIdNumber())
						.map(ni -> newImgTrans.voToDto(ni))
						.collect(Collectors.toList()) :
							new ArrayList<>())
				.build();
	}

	@Autowired
	@Qualifier("bk.roomCreate.vo.create.UpdateReqChecker")
	@Override
	public void setChecker(CreateReqChecker checker) {
		
		this.checker = checker;
	}

}
