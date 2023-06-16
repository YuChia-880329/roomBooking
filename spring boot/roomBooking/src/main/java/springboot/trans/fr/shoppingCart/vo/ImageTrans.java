package springboot.trans.fr.shoppingCart.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.ImageDto;
import springboot.bean.vo.fr.shoppingCart.Image;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.ImageTrans")
public class ImageTrans implements VoWoTrans<Image, ImageDto> {

	@Override
	public Image dtoToVoImpl(ImageDto dto) {
		
		return Image.builder()
				.id(dto.getId())
				.imgUrl(dto.getImgUrl())
				.build();
	}
}
