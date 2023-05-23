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

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString(exclude = "room")
@Entity
@Table(name = "ROOM_IMG", schema = "ROOM_BOOKING")
public class RoomImg {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_IMG_SEQ_GEN")
	@SequenceGenerator(name = "ROOM_IMG_SEQ_GEN", sequenceName = "ROOM_IMG_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	@Column(name = "IMG_NAME")
	private String imageName;
	@Column(name = "IMG_ORDER")
	private int imageOrder;
	@Column(name = "ROOM_ID")
	private int roomId;
	
	@JsonIgnore
	@JoinColumn(name = "ROOM_ID", insertable = false, updatable = false)
	@ManyToOne
	private Room room;
}
