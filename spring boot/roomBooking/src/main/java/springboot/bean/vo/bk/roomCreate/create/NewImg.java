package springboot.bean.vo.bk.roomCreate.create;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class NewImg {

	private int idNumber;
	private String imgName;
	private MultipartFile file;
}
