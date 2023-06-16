package springboot.dao.fr.shoppingCart.memory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.InputDto;
import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.OutputDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Input;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemPages;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Output;
import springboot.memory.repo.RepoDao;
import springboot.memory.repo.fr.shoppingCart.ItemPagesRepo;
import springboot.trans.fr.shoppingCart.obj.repo.itemPages.InputTrans;
import springboot.trans.fr.shoppingCart.obj.repo.itemPages.OutputTrans;

@Repository("fr.shoppingCart.memory.repo.ItemPagesRepoDao")
@SessionScope
public class ItemPagesRepoDao extends RepoDao<Input, ItemPages, Output, InputDto, OutputDto, ItemPagesRepo, InputTrans, OutputTrans> {

	protected ItemPagesRepoDao(ItemPagesRepo repo) {
		
		super(repo);
	}
	public void needUpdate() {
		
		repo.needUpdate();
	}

	
	@Autowired
	@Qualifier("fr.shoppingCart.obj.repo.itemPages.InputTrans")
	@Override
	public void setInputTrans(InputTrans inputTrans) {
		
		this.inputTrans = inputTrans;
	}
	@Autowired
	@Qualifier("fr.shoppingCart.obj.repo.itemPages.OutputTrans")
	@Override
	public void setOutputTrans(OutputTrans outputTrans) {
		
		this.outputTrans = outputTrans;
	}
}
