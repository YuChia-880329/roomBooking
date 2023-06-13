package springboot.bean.dto.fr.home.vo.allSections;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllSectionsRespDto {

	private List<SectionDto> sections;
}
