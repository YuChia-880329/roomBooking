package springboot.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "NEW_FEATURE", schema = "ROOM_BOOKING")
public class NewFeature {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_FEATURE_SEQ_GEN")
	@SequenceGenerator(name = "NEW_FEATURE_SEQ_GEN", sequenceName = "NEW_FEATURE_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "HOTEL_ID")
	private int hotelId;
	@Column(name = "CHECKED")
	private String checked;
	
	@JsonIgnore
	@JoinColumn(name = "HOTEL_ID", insertable = false, updatable = false)
	@ManyToOne
	private Hotel hotel;
}
