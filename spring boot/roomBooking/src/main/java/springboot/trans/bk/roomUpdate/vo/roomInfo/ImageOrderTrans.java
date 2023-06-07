package springboot.trans.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.ImageOrderDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.ImageOrder;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomUpdate.vo.roomInfo.ImageOrderTrans")
public class ImageOrderTrans implements VoWoTrans<ImageOrder, ImageOrderDto> {

	@Override
	public ImageOrder dtoToVoImpl(ImageOrderDto dto) {
		
		return ImageOrder.builder()
				.hasImg(dto.isHasImg())
				.orders(toOrdersVo(dto.getOrders()))
				.value(dto.getValue())
				.build();
	}
	
	private int[] toOrdersVo(List<Integer> orders) {
		
		int[] array = new int[orders.size()];
		
		for(int i=0; i<orders.size(); i++) {
			
			array[i] = orders.get(i);
		}
		
		return array;
	}
}
