package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.ImageDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Image;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.ImageTrans")
public class ImageTrans extends RepoOutputTrans<Image, ImageDto> {

	@Override
	protected Image dtoToOutputImpl(ImageDto dto) {
		
		return Image.builder()
				.id(dto.getId())
				.imgName(dto.getImgName())
				.build();
	}

	@Override
	protected ImageDto outputToDtoImpl(Image output) {
		
		return ImageDto.builder()
				.id(output.getId())
				.imgName(output.getImgName())
				.build();
	}
}
