package springboot.dao.bk.roomList.memory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.InputDto;
import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.RoomTableRowsDto;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.Input;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.RoomTableRows;
import springboot.memory.repo.RepoDao;
import springboot.memory.repo.bk.roomList.RoomTableRowsRepo;
import springboot.trans.bk.roomList.obj.repo.roomTableRows.InputTrans;
import springboot.trans.bk.roomList.obj.repo.roomTableRows.RoomTableRowsTrans;

@Repository
@SessionScope
public class RoomTableRowsRepoDAO extends RepoDao<Input, RoomTableRows, InputDto, RoomTableRowsDto, 
		RoomTableRowsRepo, InputTrans, RoomTableRowsTrans> {

	public RoomTableRowsRepoDAO(RoomTableRowsRepo repo) {
		
		super(repo);
	}

	@Autowired
	@Override
	public void setInputTrans(InputTrans inputTrans) {
		
		this.inputTrans = inputTrans;
	}
	@Autowired
	@Override
	public void setObjTrans(RoomTableRowsTrans objTrans) {
		
		this.objTrans = objTrans;
	}
}
