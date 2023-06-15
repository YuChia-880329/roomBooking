package springboot.service.fr.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.home.search.SearchReq;
import springboot.bean.vo.fr.home.turnPage.TurnPageReq;
import springboot.trans.fr.home.vo.allSections.AllSectionsRespTrans;
import springboot.trans.fr.home.vo.search.SearchReqTrans;
import springboot.trans.fr.home.vo.search.SearchRespTrans;
import springboot.trans.fr.home.vo.turnPage.TurnPageReqTrans;
import springboot.trans.fr.home.vo.turnPage.TurnPageRespTrans;
import util.ResponseUtil;

@Service("fr.home.HomeControllerService")
public class HomeControllerService {

	@Autowired
	@Qualifier("fr.home.AllSectionsService")
	private AllSectionsService allSectionsService;
	@Autowired
	@Qualifier("fr.home.SearchService")
	private SearchService searchService;
	@Autowired
	@Qualifier("fr.home.TurnPageService")
	private TurnPageService turnPageService;
	
	
	@Autowired
	@Qualifier("fr.home.vo.allSections.AllSectionsRespTrans")
	private AllSectionsRespTrans allSectionsRespTrans;
	@Autowired
	@Qualifier("fr.home.vo.search.SearchReqTrans")
	private SearchReqTrans searchReqTrans;
	@Autowired
	@Qualifier("fr.home.vo.search.SearchRespTrans")
	private SearchRespTrans searchRespTrans;
	@Autowired
	@Qualifier("fr.home.vo.turnPage.TurnPageReqTrans")
	private TurnPageReqTrans turnPageReqTrans;
	@Autowired
	@Qualifier("fr.home.vo.turnPage.TurnPageRespTrans")
	private TurnPageRespTrans turnPageRespTrans;
	
	
	
	public Response allSections() {
		
		return ResponseUtil.response200(
				allSectionsRespTrans.dtoToVo(
						allSectionsService.allSections()));
	}
	
	public Response search(String checkinDate, String checkoutDate, String numCode, String sectionCode) {
		
		SearchReq searchReq = SearchReq.builder()
			.checkinDate(checkinDate)
			.checkoutDate(checkoutDate)
			.numCode(numCode)
			.sectionCode(sectionCode)
			.build();

		return ResponseUtil.response200(
			searchRespTrans.dtoToVo(
					searchService.search(
							searchReqTrans.voToDto(searchReq))));
	}
	public Response turnPage(String page) {
		
		TurnPageReq turnPageReq = TurnPageReq.builder()
				.page(page)
				.build();
		return ResponseUtil.response200(
				turnPageRespTrans.dtoToVo(
						turnPageService.turnPage(
								turnPageReqTrans.voToDto(turnPageReq))));
	}

}
