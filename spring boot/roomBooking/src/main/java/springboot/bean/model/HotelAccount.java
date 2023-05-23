package springboot.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "HOTEL_ACCOUNT", schema = "ROOM_BOOKING")
public class HotelAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_ACCOUNT_SEQ_GEN")
	@SequenceGenerator(name = "HOTEL_ACCOUNT_SEQ_GEN", sequenceName = "HOTEL_ACCOUNT_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "ACCOUNT")
	private String account;
	@Column(name = "PASSWORD")
	private String password;
	
	@JsonIgnore
	@OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
	private Hotel hotel;
}
