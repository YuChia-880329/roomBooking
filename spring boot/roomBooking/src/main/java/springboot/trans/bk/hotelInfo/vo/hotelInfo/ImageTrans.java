package springboot.trans.bk.hotelInfo.vo.hotelInfo;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.hotelInfo.vo.hotelInfo.ImageDto;
import springboot.bean.vo.bk.hotelInfo.hotelInfo.Image;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.hotelInfo.vo.hotelInfo.UpdateImgTrans")
public class ImageTrans implements VoWoTrans<Image, ImageDto> {

	@Override
	public Image dtoToVoImpl(ImageDto dto) {
		
		return Image.builder()
				.imgName(dto.getImgName())
				.url(dto.getUrl())
				.build();
	}
}
