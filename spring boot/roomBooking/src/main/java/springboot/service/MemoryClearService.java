package springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto;
import springboot.bean.dto.fr.receipt.obj.db.receipts.ReceiptDto;
import springboot.dao.bk.bookingOrderList.memory.repo.TablePagesRepoDao;
import springboot.dao.fr.home.memory.repo.HotelRoomPagesDao;
import springboot.dao.fr.hotelPage.memory.repo.RoomPagesDao;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;
import springboot.dao.fr.receipt.memory.db.ReceiptsDbDao;
import springboot.dao.fr.shoppingCart.memory.repo.ItemPagesRepoDao;

@Component("MemoryClearService")
public class MemoryClearService {

	@Autowired
	@Qualifier("fr.receipt.memory.db.ReceiptsDbDao")
	private ReceiptsDbDao frReceiptReceiptsDbDao;
	@Autowired
	@Qualifier("fr.memory.db.ShoppingCartDbDao")
	private ShoppingCartDbDao frShoppingCartDbDao;
	@Autowired
	@Qualifier("bk.bookingOrderList.memory.repo.TablePagesRepoDao")
	private TablePagesRepoDao bkBookingOrderListTablePagesRepoDao;
	@Autowired
	@Qualifier("bk.roomList.memory.repo.TablePagesRepoDao")
	private springboot.dao.bk.roomList.memory.repo.TablePagesRepoDao bkRoomListTablePagesRepoDao;
	@Autowired
	@Qualifier("fr.home.memory.repo.HotelRoomPagesDao")
	private HotelRoomPagesDao frHomeHotelRoomPagesRepoDao;
	@Autowired
	@Qualifier("fr.hotelPage.memory.repo.RoomPagesDao")
	private RoomPagesDao frHotelPageRoomPagesRepoDao;
	@Autowired
	@Qualifier("fr.shoppingCart.memory.repo.ItemPagesRepoDao")
	private ItemPagesRepoDao frShoppingCartItemPagesRepoDao;
	
	
	
	public void clearFrReceiptReceiptsDb() {
		
		List<ReceiptDto> receipts = frReceiptReceiptsDbDao.searchAll();
		receipts.stream()
			.forEach(receipt -> frReceiptReceiptsDbDao.delete(receipt.getReceiptId()));
	}
	public void clearFrShoppingCartDb() {
		
		List<ItemDto> items = frShoppingCartDbDao.searchAll();
		items.stream()
			.forEach(item -> frShoppingCartDbDao.delete(item.getItemId()));
	}
	public void clearBkBookingOrderListTablePagesRepo() {
		
		bkBookingOrderListTablePagesRepoDao.needUpdate();
	}
	public void clearBkRoomListTablePagesRepo() {
		
		bkRoomListTablePagesRepoDao.needUpdate();
	}
	public void clearFrHomeHotelRoomPagesRepo() {
		
		frHomeHotelRoomPagesRepoDao.needUpdate();
	}
	public void clearFrHotelPageRoomPagesRepo() {
		
		frHotelPageRoomPagesRepoDao.needUpdate();
	}
	public void clearFrShoppingCartItemPagesRepoDao() {
		
		frShoppingCartItemPagesRepoDao.needUpdate();
	}
}
