package springboot.bean.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString(exclude = "hotels")
@Entity
@Table(name = "SECTION", schema = "ROOM_BOOKING")
public class Section {

	@Id
	@Column(name = "CODE")
	private String code;
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "section")
	@OrderBy("id")
	private List<Hotel> hotels;
}
