package springboot.bean.dto.fr.hotelPage.obj.repo.roomPages;

import java.time.LocalDate;

import enumeration.fr.home.Num;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchParamDto {

	private int page;
	private int hotelId;
	private LocalDate checkinDate;
	private LocalDate checkoutDate;
	private Num num;
}
