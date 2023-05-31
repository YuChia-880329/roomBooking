package springboot.bean.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "SECTION")
public class Section {

	@Id
	@Column(name = "CODE")
	private String code;
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "section")
	private List<Hotel> hotels;
}
