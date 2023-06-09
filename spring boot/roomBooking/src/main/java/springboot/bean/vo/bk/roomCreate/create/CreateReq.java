package springboot.bean.vo.bk.roomCreate.create;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CreateReq {

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
	private NewImg[] newImgs;
}
