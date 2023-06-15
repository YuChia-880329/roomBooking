package springboot.trans.fr.hotelPage.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.ImageDto;
import springboot.bean.vo.fr.hotelPage.Image;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.search.ImageTrans")
public class ImageTrans implements VoWoTrans<Image, ImageDto> {

	@Override
	public Image dtoToVoImpl(ImageDto dto) {
		
		return Image.builder()
				.id(dto.getId())
				.imgUrl(dto.getImgUrl())
				.build();
	}
}
