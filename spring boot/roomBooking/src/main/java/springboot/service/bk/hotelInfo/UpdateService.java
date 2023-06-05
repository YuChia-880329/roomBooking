package springboot.service.bk.hotelInfo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.update.NewFeatureDto;
import springboot.bean.dto.bk.hotelInfo.vo.update.UpdateImageDto;
import springboot.bean.dto.bk.hotelInfo.vo.update.UpdateReqDto;
import springboot.bean.dto.bk.hotelInfo.vo.update.UpdateRespDto;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.model.FeatureDto;
import springboot.bean.dto.model.HotelDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.FeatureDaoInner;
import springboot.dao.model.inner.HotelDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.hotelInfo.UpdateService")
public class UpdateService {
	
	public static final String SUCCESS_MSG = "更新成功";
	public static final String FAILURE_MSG = "更新失敗";

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.HotelDaoInner")
	private HotelDaoInner hotelDaoInner;
	@Autowired
	@Qualifier("model.inner.FeatureDaoInner")
	private FeatureDaoInner featureDaoInner;
	
	
	public UpdateRespDto update(UpdateReqDto updateReq) {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		HotelDto hotel = toHotel(updateReq, hotelDaoInner.findById(login.getHotelId()).get());
		hotel = hotelDaoInner.save(hotel);
		
		boolean success = false;
		if(hotel != null)
			success = true;
		
		return UpdateRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILURE_MSG)
				.build();
	}
	
	private HotelDto toHotel(UpdateReqDto updateReq, HotelDto oldHotel) {
		
		UpdateImageDto updateImage = updateReq.getUpdateImage();
		
		HotelDto hotel = HotelDto.builder()
				.id(oldHotel.getId())
				.name(updateReq.getName())
				.sectionCode(updateReq.getSectionCode())
				.address(updateReq.getAddress())
				.introduction(updateReq.getDescription())
				.imgName(updateImage.isNeedUpdate() ? updateImage.getImageName() : oldHotel.getImgName())
				.features(toFeatures(updateReq.getFeatureIds()))
				.newFeatures(toNewFeatures(updateReq.getNewFeatures(), oldHotel.getId()))
				.rooms(oldHotel.getRooms())
				.build();
		return hotel;
	}
	
	
	private List<FeatureDto> toFeatures(List<Integer> ids){
		
		return ids.stream()
				.map(id -> toFeature(id))
				.collect(Collectors.toList());
	}
	private FeatureDto toFeature(Integer id) {
		
		return featureDaoInner.findById(id).get();
	}
	
	private List<springboot.bean.dto.model.NewFeatureDto> toNewFeatures(List<NewFeatureDto> newFeatures, int hotelId){
		
		return newFeatures.stream()
				.map(nf -> toNewFeature(nf, hotelId))
				.collect(Collectors.toList());
	}
	private springboot.bean.dto.model.NewFeatureDto toNewFeature(NewFeatureDto newFeature, int hotelId){
		
		return springboot.bean.dto.model.NewFeatureDto.builder()
				.id(newFeature.getId())
				.name(newFeature.getName())
				.hotelId(hotelId)
				.checked(newFeature.isChecked())
				.build();
	}
}
