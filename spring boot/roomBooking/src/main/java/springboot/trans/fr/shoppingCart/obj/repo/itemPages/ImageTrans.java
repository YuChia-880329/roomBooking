package springboot.trans.fr.shoppingCart.obj.repo.itemPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ImageDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Image;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.shoppingCart.obj.repo.itemPages.ImageTrans")
public class ImageTrans extends RepoOutputTrans<Image, ImageDto> {

	@Override
	protected Image dtoToOutputImpl(ImageDto dto) {
		
		return Image.builder()
				.imgName(dto.getImgName())
				.build();
	}

	@Override
	protected ImageDto outputToDtoImpl(Image output) {
		
		return ImageDto.builder()
				.imgName(output.getImgName())
				.build();
	}
}
