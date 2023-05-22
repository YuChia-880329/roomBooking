package bean.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "HOTEL", schema = "ROOM_BOOKING")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_SEQ_GEN")
	@SequenceGenerator(name = "HOTEL_SEQ_GEN", sequenceName = "HOTEL_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SECTION_CODE")
	private String sectionCode;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "INTRODUCTION")
	private String introduction;
	@Column(name = "IMG_NAME")
	private String imgName;
	@Column(name = "ACCOUNT_ID")
	private int accountId;
	
	@JoinColumn(name = "SECTION_CODE", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Section section;
	@JoinColumn(name = "ACCOUNT_ID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private HotelAccount account;
	@JoinTable(name = "HOTEL_FEATURE_JOIN", joinColumns = @JoinColumn(name = "HOTEL_ID"), 
			inverseJoinColumns = @JoinColumn(name = "FEATURE_ID"))
	@ManyToMany(fetch = FetchType.EAGER)
	private List<HotelFeature> features;
	
}
