package tmpl.memory.repo;

import java.util.List;

import tmpl.trans.TransRevs;

public abstract class RepoInputTrans<I, P> implements TransRevs<I, P> {

	public I dtoToInput(P dto) {
		
		return bToA(dto);
	}
	
	public List<I> dtoListToInputList(List<P> dtoList){
		
		return bListToAList(dtoList);
	}

	
	
	@Override
	public I bToAImpl(P dto) {
		
		return dtoToInputImpl(dto);
	}
	
	protected abstract I dtoToInputImpl(P dto);
}
