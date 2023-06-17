package springboot.bean.dto.fr.receipt.vo.turnPage;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.dto.fr.receipt.vo.ItemDto;
import springboot.bean.dto.fr.receipt.vo.PayMethodDto;
import springboot.bean.dto.vo.PaginationDto;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TurnPageRespDto {

	private List<ItemDto> items;
	private PaginationDto pagination;
	private int totalPrice;
	private PayMethodDto payMethod;
}
