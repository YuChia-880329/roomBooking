package springboot.service.bk.roomCreate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.roomCreate.vo.allShowers.AllShowersRespDto;
import springboot.bean.dto.bk.roomCreate.vo.allShowers.ShowerDto;
import springboot.dao.model.inner.ShowerDaoInner;

@Service("bk.roomCreate.AllShowersService")
public class AllShowersService {

	@Autowired
	@Qualifier("model.inner.ShowerDaoInner")
	private ShowerDaoInner showerDaoInner;
	
	public AllShowersRespDto allShowers() {
		
		List<springboot.bean.dto.model.ShowerDto> showers = showerDaoInner.findAllByOrderByIdAsc();
		return AllShowersRespDto.builder()
				.showers(toShowersVo(showers))
				.build();
	}
	
	private List<ShowerDto> toShowersVo(List<springboot.bean.dto.model.ShowerDto> showers){
		
		return showers.stream()
				.map(shower -> toShowerVo(shower))
				.collect(Collectors.toList());
	}
	private ShowerDto toShowerVo(springboot.bean.dto.model.ShowerDto shower) {
		
		return ShowerDto.builder()
				.id(shower.getId())
				.name(shower.getName())
				.build();
	}
}
