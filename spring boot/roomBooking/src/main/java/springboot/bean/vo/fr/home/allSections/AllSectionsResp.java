package springboot.bean.vo.fr.home.allSections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllSectionsResp extends Data {

	private Section[] sections;
}
