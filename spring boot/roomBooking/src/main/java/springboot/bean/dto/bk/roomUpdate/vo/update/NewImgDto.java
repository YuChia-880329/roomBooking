package springboot.bean.dto.bk.roomUpdate.vo.update;

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
