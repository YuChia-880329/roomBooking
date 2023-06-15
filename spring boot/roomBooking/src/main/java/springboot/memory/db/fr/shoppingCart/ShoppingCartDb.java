package springboot.memory.db.fr.shoppingCart;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.obj.fr.db.shoppingCart.Item;
import springboot.memory.db.MemoryDb;

@Component("fr.shoppingCart.ShoppingCartDb")
@SessionScope
public class ShoppingCartDb extends MemoryDb<Integer, Item> {
}
