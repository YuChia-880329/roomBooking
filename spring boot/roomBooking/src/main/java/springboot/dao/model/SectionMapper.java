package springboot.dao.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Section;

@Repository("model.SectionMapper")
@Mapper
public interface SectionMapper {
	
	public List<Section> queryAll();
}
