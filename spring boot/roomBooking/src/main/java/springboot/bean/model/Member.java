package springboot.bean.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "MEMBER", schema = "ROOM_BOOKING")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GEN")
	@SequenceGenerator(name = "MEMBER_SEQ_GEN", sequenceName = "MEMBER_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "ACCOUNT")
	private String account;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PHONE")
	private String phone;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<BookingOrder> bookingOrders;
}
