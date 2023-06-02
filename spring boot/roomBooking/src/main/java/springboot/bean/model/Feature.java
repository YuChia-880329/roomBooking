package springboot.bean.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
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
@Table(name = "HOTEL_FEATURE", schema = "ROOM_BOOKING")
public class Feature {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_FEATURE_SEQ_GEN")
	@SequenceGenerator(name = "HOTEL_FEATURE_SEQ_GEN", sequenceName = "HOTEL_FEATURE_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "features")
	@OrderBy("id")
	private List<Hotel> hotels;
}
