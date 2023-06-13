package springboot.bean.dto.fr.home.obj.repo.hotelRoomPages;

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
	private LocalDate checkinDate;
	private LocalDate checkoutDate;
	private Num num;
	private String sectionCode;
}
