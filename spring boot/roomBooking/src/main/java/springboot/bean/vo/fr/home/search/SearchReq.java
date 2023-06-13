package springboot.bean.vo.fr.home.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchReq {

	private String checkinDate;
	private String checkoutDate;
	private String numCode;
	private String sectionCode;
}
