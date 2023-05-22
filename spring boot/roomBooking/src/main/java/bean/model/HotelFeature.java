package bean.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HOTEL_FEATURE", schema = "ROOM_BOOKING")
public class HotelFeature {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_FEATURE_SEQ_GEN")
	@SequenceGenerator(name = "HOTEL_FEATURE_SEQ_GEN", sequenceName = "HOTEL_FEATURE_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "TEXT")
	private String text;
	
	@ManyToMany(mappedBy = "features", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Hotel> hotels;
}
