package springboot.bean.dto.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomInfoRespDto {

	private boolean hasValue;
	private String roomName;
	private int totalNum;
	private InvalidNumDto invalidNum;
	private int price;
	private int singleBedNum;
	private int doubleBedNum;
	private int area;
	private int sceneId;
	private List<Integer> showerIds;
	private int statusId;
	private RoomImgsDto roomImgs;
	private ImageOrderDto imageOrder;
}
