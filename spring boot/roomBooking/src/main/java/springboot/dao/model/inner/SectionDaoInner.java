package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.SectionDto;
import springboot.dao.model.SectionDao;
import springboot.trans.model.SectionTrans;

@Repository("model.inner.SectionDaoInner")
public class SectionDaoInner {

	@Autowired
	@Qualifier("model.SectionDao")
	private SectionDao dao;
	@Autowired
	@Qualifier("model.SectionTrans")
	private SectionTrans trans;
	
	
	public List<SectionDto> queryAll(){
		
		return trans.modelListToDtoList(dao.findAll());
	}
}
