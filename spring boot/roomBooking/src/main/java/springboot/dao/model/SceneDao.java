package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.Scene;

public interface SceneDao extends JpaRepository<Scene, Integer> {

}
