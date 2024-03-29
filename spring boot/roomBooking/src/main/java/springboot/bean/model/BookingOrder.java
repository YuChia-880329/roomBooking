package springboot.bean.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BOOKING_ORDER", schema = "ROOM_BOOKING")
public class BookingOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKING_ORDER_SEQ_GEN")
	@SequenceGenerator(name = "BOOKING_ORDER_SEQ_GEN", sequenceName = "BOOKING_ORDER_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "CLIENT_ID")
	private int clientId;
	@Column(name = "ROOM_ID")
	private int roomId;
	@Column(name = "ROOM_NUM")
	private int roomNum;
	@Column(name = "PAY_METHOD_ID")
	private int payMethodId;
	@Column(name = "CHECKIN_DATE")
	private Date checkinDate;
	@Column(name = "CHECKIN_TIME")
	private Time checkinTime;
	@Column(name = "CHECKOUT_DATE")
	private Date checkoutDate;
	@Column(name = "USE_DAY")
	private int useDay;
	@Column(name = "TOTAL_MONEY")
	private int totalMoney;
	
	
	@JoinColumn(name = "CLIENT_ID", insertable = false, updatable = false)
	@ManyToOne
	private Member member;
	
	@JoinColumn(name = "ROOM_ID", insertable = false, updatable = false)
	@ManyToOne
	private Room room;
	
	
	@JoinColumn(name = "PAY_METHOD_ID", insertable = false, updatable = false)
	@ManyToOne
	private PayMethod payMethod;
}
