package springboot.dao.bk.bookingOrderList.memory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.OutputDto;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.Input;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.Output;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.TablePages;
import springboot.memory.repo.RepoDao;
import springboot.memory.repo.bk.bookingOrderList.TablePagesRepo;
import springboot.trans.bk.bookingOrderList.obj.repo.tablePages.InputTrans;
import springboot.trans.bk.bookingOrderList.obj.repo.tablePages.OutputTrans;

@Repository("bk.bookingOrderList.memory.repo.TablePagesRepoDao")
@SessionScope
public class TablePagesRepoDao extends RepoDao<Input, TablePages, Output, InputDto, OutputDto, 
		TablePagesRepo, InputTrans, OutputTrans> {


	public TablePagesRepoDao(TablePagesRepo repo) {
		
		super(repo);
	}
	
	public void needUpdate() {
		
		repo.needUpdate();
	}

	@Autowired
	@Qualifier("bk.bookingOrderList.obj.repo.tablePages.InputTrans")
	@Override
	public void setInputTrans(InputTrans inputTrans) {
		
		this.inputTrans = inputTrans;
	}
	@Autowired
	@Qualifier("bk.bookingOrderList.obj.repo.tablePages.OutputTrans")
	@Override
	public void setOutputTrans(OutputTrans outputTrans) {
		
		this.outputTrans = outputTrans;
	}
}
