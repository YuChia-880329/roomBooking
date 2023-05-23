package springboot.bean.model;

import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "ROOM", schema = "ROOM_BOOKING")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ_GEN")
	@SequenceGenerator(name = "ROOM_SEQ_GEN", sequenceName = "ROOM_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TOTAL_NUM")
	private int totalNum;
	@Column(name = "INVALID_NUM")
	private int invalidNum;
	@Column(name = "USED_NUM")
	private int usedNum;
	@Column(name = "PRICE")
	private int price;
	@Column(name = "SINGLE_BED_NUM")
	private int singleBedNum;
	@Column(name = "DOUBLE_BED_NUM")
	private int doubleBedNum;
	@Column(name = "AREA")
	private int area;
	@Column(name = "SCENE_ID")
	private int sceneId;
	@Column(name = "HOTEL_ID")
	private int hotelId;
	
	
	@JoinColumn(name = "SCENE_ID", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Scene scene;
	
	
	@JsonIgnore
	@JoinColumn(name = "HOTEL_ID", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Hotel hotel;
	
	
	@JoinTable(name = "ROOM_SHOWER_JOIN", joinColumns = @JoinColumn(name = "SHOWER_ID"), 
			inverseJoinColumns = @JoinColumn(name = "ROOM_ID"))
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Shower> showers;
	
	
	@OneToMany(mappedBy = "room", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RoomImg> roomImgs;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private List<BookingOrder> bookingOrders;
}
