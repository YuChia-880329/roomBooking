package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.ShowerDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Shower;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.ShowerTrans")
public class ShowerTrans extends RepoOutputTrans<Shower, ShowerDto> {

	@Override
	protected Shower dtoToOutputImpl(ShowerDto dto) {
		
		return Shower.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}

	@Override
	protected ShowerDto outputToDtoImpl(Shower output) {
		
		return ShowerDto.builder()
				.id(output.getId())
				.name(output.getName())
				.build();
	}
}
