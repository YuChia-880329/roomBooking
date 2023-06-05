package springboot.checker.bk.hotelInfo.vo.update;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import exception.check.NullException;
import springboot.bean.vo.bk.hotelInfo.update.NewFeature;
import springboot.bean.vo.bk.hotelInfo.update.UpdateImage;
import springboot.bean.vo.bk.hotelInfo.update.UpdateReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("bk.hotelInfo.vo.update.UpdateReqChecker")
public class UpdateReqChecker implements Checker<UpdateReq> {

	public static final String NAME_FIELD_NAME = "飯店名稱";
	public static final String SECTION_FIELD_NAME = "飯店地址區域";
	public static final String ADDRESS_FIELD_NAME = "飯店地址";
	public static final String DESCRIPTION_FIELD_NAME = "飯店介紹";
	public static final String FEATURE_FIELD_NAME = "飯店特色";
	
	@Autowired
	@Qualifier("bk.hotelInfo.vo.update.NewFeatureChecker")
	private NewFeatureChecker newFeatureChecker;
	@Autowired
	@Qualifier("bk.hotelInfo.vo.update.UpdateImageChecker")
	private UpdateImageChecker updateImageChecker;
	
	@Override
	public void check(UpdateReq vo) {
		
		checkVo(vo);
		
		checkName(vo);
		checkSectionCode(vo);
		checkAddress(vo);
		checkDescription(vo);
		checkFeatureIds(vo);
		checkNewFeatures(vo);
		checkUpdateImage(vo);
	}
	
	private void checkVo(UpdateReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkName(UpdateReq vo) {
		
		String name = vo.getName();
		
		try {
			
			CheckUtil.checkString(name);
		}catch(NullException ex) {
			
			throw new RiCheckerException(NullException.getMsgStr(NAME_FIELD_NAME));
		}
	}
	private void checkSectionCode(UpdateReq vo) {
	}
	private void checkAddress(UpdateReq vo) {
		
		String address = vo.getAddress();
		
		try {
			
			CheckUtil.checkString(address);
		}catch(NullException ex) {
			
			throw new RiCheckerException(NullException.getMsgStr(ADDRESS_FIELD_NAME));
		}
	}
	private void checkDescription(UpdateReq vo) {
		
		String description = vo.getDescription();
		
		try {
			
			CheckUtil.checkString(description);
		}catch(NullException ex) {
			
			throw new RiCheckerException(NullException.getMsgStr(DESCRIPTION_FIELD_NAME));
		}
	}
	private void checkFeatureIds(UpdateReq vo) {
	}
	private void checkNewFeatures(UpdateReq vo) {
		
		NewFeature[] newFeatures = vo.getNewFeatures();
		
		Arrays.stream(newFeatures).forEach(nf -> newFeatureChecker.check(nf));
	}
	private void checkUpdateImage(UpdateReq vo) {
		
		UpdateImage updateImage = vo.getUpdateImage();
		
		updateImageChecker.check(updateImage);
	}
}
