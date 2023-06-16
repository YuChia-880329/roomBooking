package springboot.dao.fr.memory.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto;
import springboot.bean.obj.fr.db.shoppingCart.Item;
import springboot.memory.db.MemoryDbDao;
import springboot.memory.db.fr.shoppingCart.ShoppingCartDb;
import springboot.trans.fr.obj.db.shoppingCart.ShoppingCartDbTrans;

@Repository("fr.memory.db.ShoppingCartDbDao")
@SessionScope
public class ShoppingCartDbDao extends MemoryDbDao<Integer, Item, ItemDto, ShoppingCartDb, ShoppingCartDbTrans> {

	protected ShoppingCartDbDao(ShoppingCartDb memory) {
		
		super(memory);
	}
	
	public List<ItemDto> searchByRoomId(int roomId){
		
		return trans.paoListToDtoList(memory.getPaosByRoomId(roomId));
	}

	@Autowired
	@Qualifier("fr.obj.db.shoppingCart.ShoppingCartDbTrans")
	@Override
	protected void setTrans(ShoppingCartDbTrans trans) {
		
		this.trans = trans;
	}
}
