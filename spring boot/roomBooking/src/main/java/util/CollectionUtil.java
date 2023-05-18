package util;

import java.util.Collection;
import java.util.function.Supplier;

public class CollectionUtil {

	public static <E, R extends Collection<E>, C extends Collection<E>> C copy(R resource, Supplier<C> containerSupplier) {
		
		C container = containerSupplier.get();
		resource.forEach(element -> container.add(element));
		return container;
	}
}
