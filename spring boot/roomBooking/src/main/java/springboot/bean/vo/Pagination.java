package springboot.bean.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Pagination {

	private PaginationItem first;
	private PaginationItem prev;
	private List<Integer> pages;
	private PaginationItem next;
	private PaginationItem last;
	private int currentPage;
}
