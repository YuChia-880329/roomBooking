package springboot.bean.dto.bk.roomUpdate.vo.roomInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomInfoRespDto {

	private String roomName;
	private int totalNum;
	private UsedNumDto usedNum;
	private InvalidNumDto invalidNum;
	private int price;
	private int singleBedNum;
	private int doubleBedNum;
	private int area;
	private SceneDto scene;
	private ShowerDto shower;
	private StatusDto status;
	private RoomImgsDto roomImgs;
	private ImageOrderDto imageOrder;
}
