package springboot.bean.vo.bk.roomUpdate.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class UpdateReq {

	private int id;
	private String name;
	private int totalNum;
	private int invalidNum;
	private int price;
	private int singleBedNum;
	private int doubleBedNum;
	private int area;
	private int sceneId;
	private int[] showerIds;
	private int statusId;
	private RoomImg[] roomImgs;
	private NewImg[] newImgs;
}
