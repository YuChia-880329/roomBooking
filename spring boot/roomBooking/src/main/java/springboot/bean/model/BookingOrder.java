package springboot.bean.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "BOOKING_ORDER", schema = "ROOM_BOOKING")
public class BookingOrder {

	@Id
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
	@Column(name = "CHECKIN_DATETIME")
	private Timestamp checkinDatetime;
	@Column(name = "CHECKOUT_DATE")
	private Date checkoutDate;
	@Column(name = "USE_DAY")
	private int useDay;
	@Column(name = "TOTAL_MONEY")
	private int totalMoney;
	
	
	@JoinColumn(name = "CLIENT_ID", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Member member;
	
	@JoinColumn(name = "ROOM_ID", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Room room;
	
	
	@JoinColumn(name = "PAY_METHOD_ID", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private PayMethod payMethod;
}
