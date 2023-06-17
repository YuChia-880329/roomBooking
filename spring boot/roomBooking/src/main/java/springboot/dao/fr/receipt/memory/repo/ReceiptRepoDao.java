package springboot.dao.fr.receipt.memory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.InputDto;
import springboot.bean.dto.fr.receipt.obj.repo.receipt.OutputDto;
import springboot.bean.obj.fr.receipt.repo.receipt.Input;
import springboot.bean.obj.fr.receipt.repo.receipt.Output;
import springboot.bean.obj.fr.receipt.repo.receipt.Receipt;
import springboot.memory.repo.RepoDao;
import springboot.memory.repo.fr.receipt.ReceiptRepo;
import springboot.trans.fr.receipt.obj.repo.receipt.InputTrans;
import springboot.trans.fr.receipt.obj.repo.receipt.OutputTrans;

@Component("fr.receipt.memory.repo.ReceiptRepoDao")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReceiptRepoDao extends RepoDao<Input, Receipt, Output, InputDto, OutputDto, ReceiptRepo, InputTrans, OutputTrans> {

	protected ReceiptRepoDao(ReceiptRepo repo) {
		
		super(repo);
	}

	
	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.InputTrans")
	@Override
	public void setInputTrans(InputTrans inputTrans) {
		
		this.inputTrans = inputTrans;
	}
	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.OutputTrans")
	@Override
	public void setOutputTrans(OutputTrans outputTrans) {
		
		this.outputTrans = outputTrans;
	}
}
