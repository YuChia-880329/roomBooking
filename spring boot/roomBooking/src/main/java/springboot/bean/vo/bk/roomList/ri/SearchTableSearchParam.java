package springboot.bean.vo.bk.roomList.ri;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchTableSearchParam {

	private String page;
	private String name;
	private String totalNumMin;
	private String totalNumMax;
	private String usedNumMin;
	private String usedNumMax;
	private String invalidNumMin;
	private String invalidNumMax;
	private String priceMin;
	private String priceMax;
	private String order;
}
