package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.SectionDto;
import springboot.bean.model.Section;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class SectionTrans implements ModelRiTrans<Section, SectionDto>, ModelWoTrans<Section, SectionDto> {

	@Override
	public Section dtoToModelImpl(SectionDto dto) {
		
		return null;
	}

	@Override
	public SectionDto modelToDtoImpl(Section model) {
		
		return null;
	}

}
