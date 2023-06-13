package springboot.service.fr.home;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.home.vo.allSections.AllSectionsRespDto;
import springboot.bean.dto.fr.home.vo.allSections.SectionDto;
import springboot.dao.model.inner.SectionDaoInner;

@Service("fr.home.AllSectionsService")
public class AllSectionsService {

	@Autowired
	@Qualifier("model.inner.SectionDaoInner")
	private SectionDaoInner sectionDaoInner;
	
	public AllSectionsRespDto allSections() {
		
		List<springboot.bean.dto.model.SectionDto> sections = sectionDaoInner.findAll();
		
		return AllSectionsRespDto.builder()
				.sections(toSectionVos(sections))
				.build();
	}
	
	private List<SectionDto> toSectionVos(List<springboot.bean.dto.model.SectionDto> sections){
		
		return sections.stream()
				.map(section -> toSectionVo(section))
				.collect(Collectors.toList());
	}
	private SectionDto toSectionVo(springboot.bean.dto.model.SectionDto section) {
		
		return SectionDto.builder()
				.code(section.getCode())
				.name(section.getName())
				.build();
	}
}
