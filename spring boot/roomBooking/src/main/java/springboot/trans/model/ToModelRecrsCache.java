package springboot.trans.model;

import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.dto.model.HotelDto;
import springboot.bean.dto.model.HotelFeatureDto;
import springboot.bean.dto.model.MemberDto;
import springboot.bean.dto.model.PayMethodDto;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.dto.model.SceneDto;
import springboot.bean.dto.model.SectionDto;
import springboot.bean.dto.model.ShowerDto;
import springboot.bean.model.BookingOrder;
import springboot.bean.model.Hotel;
import springboot.bean.model.HotelAccount;
import springboot.bean.model.HotelFeature;
import springboot.bean.model.Member;
import springboot.bean.model.PayMethod;
import springboot.bean.model.Room;
import springboot.bean.model.RoomImg;
import springboot.bean.model.Scene;
import springboot.bean.model.Section;
import springboot.bean.model.Shower;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
class ToModelRecrsCache {

	private Map<BookingOrderDto, BookingOrder> bookingOrderCache;
	private Map<HotelAccountDto, HotelAccount> hotelAccountCache;
	private Map<HotelFeatureDto, HotelFeature> hotelFeatureCache;
	private Map<HotelDto, Hotel> hotelCache;
	private Map<MemberDto, Member> memberCache;
	private Map<PayMethodDto, PayMethod> payMethodCache;
	private Map<RoomImgDto, RoomImg> roomImgCache;
	private Map<RoomDto, Room> roomCache;
	private Map<SceneDto, Scene> sceneCache;
	private Map<SectionDto, Section> sectionCache;
	private Map<ShowerDto, Shower> showerCache;
}
