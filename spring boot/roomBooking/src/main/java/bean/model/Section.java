package bean.model;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "SECTION", schema = "ROOM_BOOKING")
public class Section {

	@Id
	@Column(name = "CODE")
	private String code;
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "section", fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL, orphanRemoval = false)
	@OrderBy(value = "id")
	private List<Hotel> hotels;
}
