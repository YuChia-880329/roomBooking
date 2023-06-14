package springboot.service.fr.hotelPage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.InputDto;
import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.OutputDto;
import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.SearchParamDto;
import springboot.bean.dto.fr.hotelPage.vo.search.BedNumDto;
import springboot.bean.dto.fr.hotelPage.vo.search.DoubleBedNumDto;
import springboot.bean.dto.fr.hotelPage.vo.search.FeaturesDto;
import springboot.bean.dto.fr.hotelPage.vo.search.ImageDto;
import springboot.bean.dto.fr.hotelPage.vo.search.RoomDto;
import springboot.bean.dto.fr.hotelPage.vo.search.SearchReqDto;
import springboot.bean.dto.fr.hotelPage.vo.search.SearchRespDto;
import springboot.bean.dto.fr.hotelPage.vo.search.ShowerDto;
import springboot.bean.dto.fr.hotelPage.vo.search.SingleBedNumDto;
import springboot.dao.fr.hotelPage.memory.repo.RoomPagesDao;
import springboot.memory.repo.fr.hotelPage.RoomPagesRepo;
import springboot.service.PaginationService;
import util.ImageUtil;

@Service("fr.hotelPage.SearchService")
public class SearchService {

	@Autowired
	@Qualifier("fr.hotelPage.memory.repo.RoomPagesDao")
	private RoomPagesDao roomPagesDao;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	
	public SearchRespDto search(SearchReqDto searchReq) {
		
		OutputDto output = roomPagesDao.getObj(toInputObj(searchReq));
		return SearchRespDto.builder()
				.rooms(toRoomVos(output.getRoomPage().getRoomList().getRooms(), searchReq.getHotelId()))
				.pagination(paginationService.getPagination(output.getRoomPage().getPage(), 
						RoomPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
	
	private InputDto toInputObj(SearchReqDto searchReq) {
		
		return InputDto.builder()
				.searchParam(toSearchParamObj(searchReq))
				.build();
	}
	private SearchParamDto toSearchParamObj(SearchReqDto searchReq) {
		
		return SearchParamDto.builder()
				.page(1)
				.hotelId(searchReq.getHotelId())
				.checkinDate(searchReq.getCheckinDate())
				.checkoutDate(searchReq.getCheckoutDate())
				.num(searchReq.getNum())
				.build();
	}
	
	private List<RoomDto> toRoomVos(List<springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.RoomDto> rooms, int hotelId){
		
		return rooms.stream().map(room -> toRoomVo(room, hotelId)).collect(Collectors.toList());
	}
	private RoomDto toRoomVo(springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.RoomDto room, int hotelId) {
		
		return RoomDto.builder()
				.roomId(room.getRoomId())
				.name(room.getName())
				.validNum(room.getValidNum())
				.price(room.getPrice())
				.features(toFeaturesVo(room.getFeatures()))
				.images(toImageVos(room.getImages(), hotelId, room.getRoomId()))
				.build();
	}
	private FeaturesDto toFeaturesVo(springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.FeaturesDto features) {
		
		return FeaturesDto.builder()
				.bedNum(toBedNumVo(features.getBedNum()))
				.area(features.getArea())
				.sceneName(features.getSceneName())
				.showers(toShowerVo(features.getShowers()))
				.build();
	}
	private BedNumDto toBedNumVo(springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.BedNumDto bedNum) {
		
		return BedNumDto.builder()
				.singleBedNum(toSingleBedNumVo(bedNum.getSingleBedNum()))
				.doubleBedNum(toDoubleBedNumVo(bedNum.getDoubleBedNum()))
				.build();
	}
	private SingleBedNumDto toSingleBedNumVo(springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.SingleBedNumDto singleBedNum) {
		
		return SingleBedNumDto.builder()
				.show(singleBedNum.isShow())
				.num(singleBedNum.getNum())
				.build();
	}
	private DoubleBedNumDto toDoubleBedNumVo(springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.DoubleBedNumDto doubleBedNum) {
		
		return DoubleBedNumDto.builder()
				.show(doubleBedNum.isShow())
				.num(doubleBedNum.getNum())
				.build();
	}
	private List<ShowerDto> toShowerVo(List<springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.ShowerDto> showers) {
		
		return showers.stream()
				.map(shower -> toShowerVo(shower))
				.collect(Collectors.toList());
	}
	private ShowerDto toShowerVo(springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.ShowerDto shower) {
		
		return ShowerDto.builder()
				.id(shower.getId())
				.name(shower.getName())
				.build();
	}
	private List<ImageDto> toImageVos(List<springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.ImageDto> images, int hotelId, int roomId){
		
		return images.stream()
				.map(image -> toImageVo(image, hotelId, roomId))
				.collect(Collectors.toList());
	}
	private ImageDto toImageVo(springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.ImageDto image, int hotelId, int roomId) {
		
		return ImageDto.builder()
				.id(image.getId())
				.imgUrl(ImageUtil.getImgUrl(hotelId, roomId, image.getImgName()))
				.build();
	}
}
