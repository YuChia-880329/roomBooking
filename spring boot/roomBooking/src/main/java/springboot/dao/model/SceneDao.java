package springboot.dao.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Scene;

@Repository("model.SceneDao")
public interface SceneDao extends JpaRepository<Scene, Integer> {

	public List<Scene> findAllByOrderByIdAsc();
}
