package springboot.bean.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "SHOWER", schema = "ROOM_BOOKING")
public class Shower {

	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "showers", fetch = FetchType.LAZY)
	private List<Room> rooms;
}
