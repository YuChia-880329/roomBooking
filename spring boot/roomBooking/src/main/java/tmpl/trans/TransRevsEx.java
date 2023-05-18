package tmpl.trans;

import java.util.ArrayList;
import java.util.List;

public interface TransRevsEx<A, B, E extends Exception> {

	public default A bToA(B b) throws E{
		
		if(b == null)
			return null;
		return bToAImpl(b);
	}
	
	public default List<A> bListToAList(List<B> bList) throws E{
		
		if(bList == null)
			return new ArrayList<>();
		
		List<A> aList = new ArrayList<>();
		
		for(int i=0; i<bList.size(); i++) {
			
			aList.add(bToA(bList.get(i)));
		}
		
		return aList;
	}
	
	public A bToAImpl(B b) throws E;
}
