package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.SceneDto;
import springboot.bean.model.Scene;
import springboot.dao.model.SceneDao;
import springboot.trans.model.SceneTrans;

@Repository("model.inner.SceneDaoInner")
public class SceneDaoInner extends DaoInner<Scene, Integer, SceneDto, SceneTrans, SceneDao> {

	
	public List<SceneDto> findAllByOrderByIdAsc(){
		
		return trans.modelListToDtoList(dao.findAllByOrderByIdAsc());
	}
	
	@Autowired
	@Qualifier("model.SceneDao")
	@Override
	public void setDao(SceneDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.SceneTrans")
	@Override
	public void setTrans(SceneTrans trans) {

		this.trans = trans;
	}
}
