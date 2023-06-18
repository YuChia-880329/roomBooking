package springboot.bean.dto.bk.roomUpdate.vo.update;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class UpdateReqDto {

	private int id;
	private String name;
	private int totalNum;
	private int invalidNum;
	private int price;
	private int singleBedNum;
	private int doubleBedNum;
	private int area;
	private int sceneId;
	private List<Integer> showerIds;
	private int statusId;
	private List<RoomImgDto> roomImgs;
	private List<NewImgDto> newImgs;
}
