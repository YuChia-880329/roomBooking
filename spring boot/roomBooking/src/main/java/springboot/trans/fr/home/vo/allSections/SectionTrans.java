package springboot.trans.fr.home.vo.allSections;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.vo.allSections.SectionDto;
import springboot.bean.vo.fr.home.allSections.Section;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.home.vo.allSections.SectionTrans")
public class SectionTrans implements VoWoTrans<Section, SectionDto> {

	@Override
	public Section dtoToVoImpl(SectionDto dto) {
		
		return Section.builder()
				.code(dto.getCode())
				.name(dto.getName())
				.build();
	}
}
