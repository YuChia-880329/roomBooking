package springboot.trans.bk.hotelInfo.vo.allSections;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.hotelInfo.vo.allSections.SectionDto;
import springboot.bean.vo.bk.hotelInfo.allSections.Section;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.hotelInfo.vo.allSections.SectionTrans")
public class SectionTrans implements VoWoTrans<Section, SectionDto> {

	@Override
	public Section dtoToVoImpl(SectionDto dto) {
		
		return Section.builder()
				.code(dto.getCode())
				.name(dto.getName())
				.build();
	}
}
