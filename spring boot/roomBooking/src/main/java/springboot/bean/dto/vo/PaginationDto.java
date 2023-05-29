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

	private PaginationItemDto first;
	private PaginationItemDto prev;
	private List<Integer> pages;
	private PaginationItemDto next;
	private PaginationItemDto last;
	private int currentPage;
}
