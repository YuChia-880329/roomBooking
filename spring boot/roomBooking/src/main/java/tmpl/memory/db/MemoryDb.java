package tmpl.memory.db;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import util.CollectionUtil;

public abstract class MemoryDb<P, O> {

	protected Map<P, O> memory;
	
	protected MemoryDb() {
		
		memory = new HashMap<>();
	}
	
	public Map<P, O> getAll(){
		
		return CollectionUtil.copy(memory.entrySet(), () -> new HashSet<>()).stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(), 
						entry -> entry.getValue())) ;
	}
	
	public O getByPK(P pk) {
		
		return memory.get(pk);
	}
	
	public O add(P pk, O obj) {
		
		O o = getByPK(pk);
		
		if(o == null) {
			
			memory.put(pk, obj);
			return obj;
		}else {
			
			return null;
		}
	}
	
	public O update(P pk, O obj) {
		
		return memory.put(pk, obj);
	}
	
	public O delete(P pk) {
		
		return memory.remove(pk);
	}
}
