package springboot.service.bk.hotelInfo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.allSections.AllSectionsRespDto;
import springboot.bean.dto.bk.hotelInfo.vo.allSections.SectionDto;
import springboot.dao.model.inner.SectionDaoInner;

@Service("bk.hotelInfo.AllSectionService")
public class AllSectionService {

	@Autowired
	@Qualifier("model.inner.SectionDaoInner")
	private SectionDaoInner sectionDaoInner;
	
	public AllSectionsRespDto allSections() {
		
		return AllSectionsRespDto.builder()
				.sections(toSectionsVo(sectionDaoInner.queryAll()))
				.build();
	}
	
	private List<SectionDto> toSectionsVo(List<springboot.bean.dto.model.SectionDto> sections){
		
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
