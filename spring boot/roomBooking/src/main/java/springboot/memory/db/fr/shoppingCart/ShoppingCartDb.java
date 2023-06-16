package springboot.memory.db.fr.shoppingCart;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.obj.fr.db.shoppingCart.Item;
import springboot.memory.db.MemoryDb;
import springboot.memory.db.PkAndObj;

@Component("fr.shoppingCart.ShoppingCartDb")
@SessionScope
public class ShoppingCartDb extends MemoryDb<Integer, Item> {
	
	public List<PkAndObj<Integer, Item>> getPaosByRoomId(int roomId){
		
		return memory.entrySet().stream()
				.filter(entry -> entry.getValue().getRoomId()==roomId)
				.map(entry -> new PkAndObj<>(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());
	}
}
