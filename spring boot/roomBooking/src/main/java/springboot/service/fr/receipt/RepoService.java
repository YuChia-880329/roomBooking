package springboot.service.fr.receipt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.receipt.vo.CreditCardDto;
import springboot.bean.dto.fr.receipt.vo.ItemDto;
import springboot.bean.dto.fr.receipt.vo.PayMethodDto;


@Service("fr.receipt.RepoService")
public class RepoService {


	public List<ItemDto> toItemVos(List<springboot.bean.dto.fr.receipt.obj.repo.receipt.ItemDto> items){
		
		return items.stream()
				.map(item -> toItemVo(item))
				.collect(Collectors.toList());
	}
	public PayMethodDto toPayMethodVo(springboot.bean.dto.fr.receipt.obj.repo.receipt.PayMethodDto payMethod) {
		
		return PayMethodDto.builder()
				.name(payMethod.getName())
				.needCreditCard(payMethod.isNeedCreditCard())
				.creditCard(toCreditCardVo(payMethod.getCreditCard()))
				.build();
	}
	
	
	private ItemDto toItemVo(springboot.bean.dto.fr.receipt.obj.repo.receipt.ItemDto item) {

		return ItemDto.builder()
				.itemId(item.getItemId())
				.hotelName(item.getHotelName())
				.roomName(item.getRoomName())
				.checkinDate(item.getCheckinDate())
				.checkoutDate(item.getCheckoutDate())
				.checkinTime(item.getCheckinTime())
				.num(item.getNum())
				.price(item.getPrice())
				.build();
	}
	private CreditCardDto toCreditCardVo(springboot.bean.dto.fr.receipt.obj.repo.receipt.CreditCardDto creditCard) {
		
		return CreditCardDto.builder()
				.cardNumber(creditCard.getCardNumber())
				.build();
	}
}
