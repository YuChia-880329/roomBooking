package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.SectionDto;
import springboot.dao.model.SectionMapper;
import springboot.trans.model.SectionTrans;

@Repository("model.inner.SectionDaoInner")
public class SectionDaoInner {

	@Autowired
	@Qualifier("model.SectionMapper")
	private SectionMapper mapper;
	@Autowired
	@Qualifier("model.SectionTrans")
	private SectionTrans trans;
	
	
	public List<SectionDto> queryAll(){
		
		return trans.modelListToDtoList(mapper.queryAll());
	}
}
