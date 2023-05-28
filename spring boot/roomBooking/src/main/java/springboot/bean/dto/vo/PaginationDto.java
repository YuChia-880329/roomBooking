package springboot.bean.dto.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PaginationDto {

	private boolean showFirst;
	private boolean showPrev;
	private List<Integer> pages;
	private boolean showNext;
	private boolean showLast;
	private int currentPage;
}
