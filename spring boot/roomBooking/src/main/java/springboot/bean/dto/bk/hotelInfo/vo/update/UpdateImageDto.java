package springboot.bean.dto.bk.hotelInfo.vo.update;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class UpdateImageDto {

	private boolean needUpdate;
	private String imageName;
	private MultipartFile file;
}
