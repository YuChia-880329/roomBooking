package springboot.bean.vo.bk.roomUpdate.roomInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomInfoResp extends Data {

	private boolean hasValue;
	private String roomName;
	private int totalNum;
	private InvalidNum invalidNum;
	private int price;
	private int singleBedNum;
	private int doubleBedNum;
	private int area;
	private int sceneId;
	private int[] showerIds;
	private int statusId;
	private RoomImgs roomImgs;
	private ImageOrder imageOrder;
}
