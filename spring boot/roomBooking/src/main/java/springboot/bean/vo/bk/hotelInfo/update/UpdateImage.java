package springboot.bean.vo.bk.hotelInfo.update;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class UpdateImage {

	private boolean needUpdate;
	private String imageName;
	private MultipartFile file;
}
