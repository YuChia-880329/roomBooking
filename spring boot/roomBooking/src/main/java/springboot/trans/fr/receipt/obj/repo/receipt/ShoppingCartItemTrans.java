package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.ShoppingCartItemDto;
import springboot.bean.obj.fr.receipt.repo.receipt.ShoppingCartItem;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.receipt.obj.repo.receipt.ShoppingCartItemTrans")
public class ShoppingCartItemTrans extends RepoInputTrans<ShoppingCartItem, ShoppingCartItemDto> {

	@Override
	protected ShoppingCartItem dtoToInputImpl(ShoppingCartItemDto dto) {
		
		return ShoppingCartItem.builder()
				.itemId(dto.getItemId())
				.roomId(dto.getRoomId())
				.checkinDate(dto.getCheckinDate())
				.checkoutDate(dto.getCheckoutDate())
				.checkinTime(dto.getCheckinTime())
				.num(dto.getNum())
				.price(dto.getPrice())
				.build();
	}

	@Override
	protected ShoppingCartItemDto inputToDtoImpl(ShoppingCartItem input) {
		
		return ShoppingCartItemDto.builder()
				.itemId(input.getItemId())
				.roomId(input.getRoomId())
				.checkinDate(input.getCheckinDate())
				.checkoutDate(input.getCheckoutDate())
				.checkinTime(input.getCheckinTime())
				.num(input.getNum())
				.price(input.getPrice())
				.build();
	}
}
