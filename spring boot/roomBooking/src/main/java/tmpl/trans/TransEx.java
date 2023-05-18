package tmpl.trans;

import java.util.ArrayList;
import java.util.List;

public interface TransEx<A, B, E extends Exception> {

	public default B aToB(A a) throws E{
		
		if(a == null)
			return null;
		return aToBImpl(a);
	}
	
	public default List<B> aListToBList(List<A> aList) throws E{
		
		if(aList == null)
			return new ArrayList<>();
		
		List<B> bList = new ArrayList<>();
		
		for(int i=0; i<aList.size(); i++) {
			
			bList.add(aToB(aList.get(i)));
		}
		
		return bList;
	}
	
	public B aToBImpl(A a) throws E;
}
