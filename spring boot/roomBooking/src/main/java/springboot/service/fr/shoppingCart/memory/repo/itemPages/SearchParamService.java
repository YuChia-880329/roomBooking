package springboot.service.fr.shoppingCart.memory.repo.itemPages;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemIndex;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.SearchParam;

@Service("fr.shoppingCart.memory.repo.itemPages.SearchParamService")
public class SearchParamService {

	public boolean equals(SearchParam searchParam1, SearchParam searchParam2) {
		
		return itemIndicesEquals(searchParam1.getItemIndices(), searchParam2.getItemIndices());
	}
	
	private boolean itemIndicesEquals(List<ItemIndex> itemIndices1, List<ItemIndex> itemIndices2) {
		
		for(int i=0; i<itemIndices1.size(); i++) {
			
			if(!itemIndices2.contains(itemIndices1.get(i)))
				return false;
		}
		for(int i=0; i<itemIndices2.size(); i++) {
			
			if(!itemIndices1.contains(itemIndices2.get(i)))
				return false;
		}
		return true;
	}
}
