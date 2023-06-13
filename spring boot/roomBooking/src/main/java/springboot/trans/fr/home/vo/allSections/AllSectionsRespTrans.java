package springboot.trans.fr.home.vo.allSections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.vo.allSections.AllSectionsRespDto;
import springboot.bean.vo.fr.home.allSections.AllSectionsResp;
import springboot.bean.vo.fr.home.allSections.Section;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.home.vo.allSections.AllSectionsRespTrans")
public class AllSectionsRespTrans implements VoWoTrans<AllSectionsResp, AllSectionsRespDto> {

	@Autowired
	@Qualifier("fr.home.vo.allSections.SectionTrans")
	private SectionTrans sectionTrans;
	
	@Override
	public AllSectionsResp dtoToVoImpl(AllSectionsRespDto dto) {
		
		return AllSectionsResp.builder()
				.sections(sectionTrans.dtoListToVoArray(dto.getSections(), size -> new Section[size]))
				.build();
	}
}
