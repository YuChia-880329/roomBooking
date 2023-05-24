package springboot.bean.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SCENE", schema = "ROOM_BOOKING")
public class Scene {

	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "scene")
	@OrderBy("id")
	private List<Room> rooms;
}
