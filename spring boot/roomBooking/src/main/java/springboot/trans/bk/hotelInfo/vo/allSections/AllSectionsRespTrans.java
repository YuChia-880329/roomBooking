package springboot.trans.bk.hotelInfo.vo.allSections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.hotelInfo.vo.allSections.AllSectionsRespDto;
import springboot.bean.vo.bk.hotelInfo.allSections.AllSectionsResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.hotelInfo.vo.allSections.AllSectionsRespTrans")
public class AllSectionsRespTrans implements VoWoTrans<AllSectionsResp, AllSectionsRespDto> {

	@Autowired
	@Qualifier("bk.hotelInfo.vo.allSections.SectionTrans")
	private SectionTrans sectionTrans;
	
	@Override
	public AllSectionsResp dtoToVoImpl(AllSectionsRespDto dto) {
		
		return AllSectionsResp.builder()
				.sections(sectionTrans.dtoListToVoList(dto.getSections()))
				.build();
	}

}
