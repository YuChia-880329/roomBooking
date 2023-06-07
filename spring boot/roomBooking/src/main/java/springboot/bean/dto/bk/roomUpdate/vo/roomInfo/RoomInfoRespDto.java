package springboot.bean.dto.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import enumeration.RoomStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomInfoRespDto {

	private int totalNum;
	private int usedNum;
	private int invalidNum;
	private int price;
	private int singleBedNum;
	private int doubleBedNum;
	private int area;
	private int sceneId;
	private List<Integer> showerIds;
	private RoomStatus status;
	private List<RoomImgDto> imgs;
}
