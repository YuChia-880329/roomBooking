package springboot.trans.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

public abstract class ModelTrans<M, D>  implements ModelRiTrans<M, D>, ModelWoTrans<M, D> {

	@Override
	public M dtoToModelImpl(D dto) {
		
		ToModelRecrsCache cache = new ToModelRecrsCache();
		
		return toModelRecrs(dto, cache);
	}

	@Override
	public D modelToDtoImpl(M model) {
		
		ToDtoRecrsCache cache = new ToDtoRecrsCache();
		
		return toDtoRecrs(model, cache);
	}
	
	
	M toModelRecrs(D dto, Function<D, M> initFctn, Supplier<Map<D, M>> getter, Consumer<Map<D, M>> setter, Consumer<M> modelCsmr) {
		
		M model = initFctn.apply(dto);
		
		Map<D, M> map = getter.get();
		if(map == null) {
			
			map = new HashMap<>();
			setter.accept(map);
		}else if(map.containsKey(dto)) {
			
			return map.get(dto);
		}
		
		map.put(dto, model);
		modelCsmr.accept(model);
		
		return model;
	}
	D toDtoRecrs(M model, Function<M, D> initFctn, Supplier<Map<M, D>> getter, Consumer<Map<M, D>> setter, Consumer<D> dtoCsmr) {
		
		D dto = initFctn.apply(model);
		
		Map<M, D> map = getter.get();
		if(map == null) {
			
			map = new HashMap<>();
			setter.accept(map);
		}else if(map.containsKey(model)) {
			
			return map.get(model);
		}
		
		map.put(model, dto);
		dtoCsmr.accept(dto);
		
		return dto;
	}
	
	List<M> toModelRecrs(List<D> dtoList, ToModelRecrsCache cache){
		
		if(dtoList == null)
			return new ArrayList<>();
		
		return dtoList.stream()
				.map(dto -> toModelRecrs(dto, cache))
				.collect(Collectors.toList());
	}
	List<D> toDtoRecrs(List<M> modelList, ToDtoRecrsCache cache){
		
		if(modelList == null)
			return new ArrayList<>();
		
		return modelList.stream()
				.map(model -> toDtoRecrs(model, cache))
				.collect(Collectors.toList());
	}
	
	abstract M toModelRecrs(D dto, ToModelRecrsCache cache);
	abstract D toDtoRecrs(M model, ToDtoRecrsCache cache);
}
