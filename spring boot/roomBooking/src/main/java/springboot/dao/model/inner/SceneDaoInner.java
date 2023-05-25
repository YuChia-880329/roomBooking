package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.SceneDto;
import springboot.bean.model.Scene;
import springboot.dao.model.SceneDao;
import springboot.trans.model.SceneTrans;

@Repository
public class SceneDaoInner extends DaoInner<Scene, Integer, SceneDto, SceneTrans, SceneDao> {

	@Autowired
	@Override
	public void setDao(SceneDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(SceneTrans trans) {

		this.trans = trans;
	}
}
