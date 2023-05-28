package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Scene;

@Repository("model.SceneDao")
public interface SceneDao extends JpaRepository<Scene, Integer> {

}
