package springboot.bean.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
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
	@OneToMany(mappedBy = "scene", fetch = FetchType.LAZY)
	@OrderBy("id")
	private List<Room> rooms;
}
