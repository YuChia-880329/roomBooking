package tmpl.memory.db;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tmpl.trans.Trans;
import tmpl.trans.TransRevs;

public abstract class MemoryDbTrans<P, O, D> implements Trans<PkAndObj<P, O>, D>, TransRevs<PkAndObj<P, O>, D> {

	
	public PkAndObj<P, O> dtoToPao(D dto){
		
		return bToA(dto);
	}
	public D paoToDto(PkAndObj<P, O> pao) {
		
		return aToB(pao);
	}
	public List<D> paoListToDtoList(List<PkAndObj<P, O>> paoList){
		
		return aListToBList(paoList);
	}
	public List<PkAndObj<P, O>> dtoListToPaoList(List<D> dtoList){
		
		return bListToAList(dtoList);
	}
	public List<D> paoMapToDtoList(Map<P, O> paoMap){
		
		return aListToBList(paoMap.keySet().stream()
				.map(pk -> new PkAndObj<>(pk, paoMap.get(pk)))
				.collect(Collectors.toList()));
	}
	public Map<P, O> dtoListToPaoMap(List<D> dtoList){
		
		return bListToAList(dtoList).stream()
			.collect(Collectors.toMap(pao -> pao.getPk(), pao -> pao.getObj()));
	}
	
	
	@Override
	public D aToBImpl(PkAndObj<P, O> pao) {
		
		return paoToDtoImpl(pao);
	}
	@Override
	public PkAndObj<P, O> bToAImpl(D dto) {
		
		return new PkAndObj<>(dtoToPkImpl(dto), dtoToObjImpl(dto));
	}

	
	protected abstract P dtoToPkImpl(D dto);
	protected abstract O dtoToObjImpl(D dto);
	protected abstract D paoToDtoImpl(PkAndObj<P, O> pao);
}
