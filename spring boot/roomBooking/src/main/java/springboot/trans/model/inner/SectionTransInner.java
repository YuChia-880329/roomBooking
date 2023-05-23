package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.SectionDto;
import springboot.bean.model.Section;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class SectionTransInner implements ModelRiTrans<Section, SectionDto>, ModelWoTrans<Section, SectionDto> {

	@Override
	public Section dtoToModelImpl(SectionDto dto) {
		
		return Section.builder()
				.code(dto.getCode())
				.name(dto.getName())
				.hotels(null)
				.build();
	}

	@Override
	public SectionDto modelToDtoImpl(Section model) {
		
		return SectionDto.builder()
				.code(model.getCode())
				.name(model.getName())
				.hotels(null)
				.build();
	}

}
