package tmpl.trans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface TransRevs<A, B> {

	public default A bToA(B b) {
		
		if(b == null)
			return null;
		return bToAImpl(b);
	}
	
	public default List<A> bListToAList(List<B> bList){
		
		if(bList == null)
			return new ArrayList<>();
		
		return bList.stream().map(b -> bToA(b)).collect(Collectors.toList());
	}
	

	public A bToAImpl(B b);
}
