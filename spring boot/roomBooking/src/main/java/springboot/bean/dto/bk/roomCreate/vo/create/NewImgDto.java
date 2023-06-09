package springboot.bean.dto.bk.roomCreate.vo.create;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class NewImgDto {

	private String imgName;
	private MultipartFile file;
}
