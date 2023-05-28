package springboot.dao.bk.roomList.memory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.bk.roomList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.OutputDto;
import springboot.bean.obj.bk.roomList.repo.tablePages.Input;
import springboot.bean.obj.bk.roomList.repo.tablePages.Output;
import springboot.bean.obj.bk.roomList.repo.tablePages.TablePages;
import springboot.memory.repo.RepoDao;
import springboot.memory.repo.bk.roomList.RoomTableRowsRepo;
import springboot.trans.bk.roomList.obj.repo.tablePages.InputTrans;
import springboot.trans.bk.roomList.obj.repo.tablePages.OutputTrans;

@Repository("bk.roomList.memory.repo.RoomTableRowsRepoDAO")
@SessionScope
public class RoomTableRowsRepoDAO extends RepoDao<Input, TablePages, Output, InputDto, OutputDto, 
		RoomTableRowsRepo, InputTrans, OutputTrans> {

	public RoomTableRowsRepoDAO(RoomTableRowsRepo repo) {
		
		super(repo);
	}

	@Autowired
	@Qualifier("bk.roomList.obj.repo.tablePages.InputTrans")
	@Override
	public void setInputTrans(InputTrans inputTrans) {
		
		this.inputTrans = inputTrans;
	}
	@Autowired
	@Qualifier("bk.roomList.obj.repo.tablePages.OutputTrans")
	@Override
	public void setOutputTrans(OutputTrans outputTrans) {
		
		this.outputTrans = outputTrans;
	}
}
