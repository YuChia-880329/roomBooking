package springboot.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "NEW_FEATURE", schema = "ROOM_BOOKING")
public class NewFeature {

	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "HOTEL_ID")
	private int hotelId;
	
	@JsonIgnore
	@JoinColumn(name = "HOTEL_ID", insertable = false, updatable = false)
	@ManyToOne
	private Hotel hotel;
}
