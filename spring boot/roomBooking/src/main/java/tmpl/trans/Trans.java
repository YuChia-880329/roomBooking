package tmpl.trans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface Trans<A, B> {

	public default B aToB(A a) {
		
		if(a == null)
			return null;
		return aToBImpl(a);
	}
	
	public default List<B> aListToBList(List<A> aList){
		
		if(aList == null)
			return new ArrayList<>();
		
		return aList.stream().map(a -> aToB(a)).collect(Collectors.toList());
	}
	

	public B aToBImpl(A a);
}
