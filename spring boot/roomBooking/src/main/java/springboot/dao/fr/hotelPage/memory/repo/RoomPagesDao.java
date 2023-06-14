package springboot.dao.fr.hotelPage.memory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.InputDto;
import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.OutputDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Input;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Output;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.RoomPages;
import springboot.memory.repo.RepoDao;
import springboot.memory.repo.fr.hotelPage.RoomPagesRepo;
import springboot.trans.fr.hotelPage.obj.repo.roomPages.InputTrans;
import springboot.trans.fr.hotelPage.obj.repo.roomPages.OutputTrans;

@Repository("fr.hotelPage.memory.repo.RoomPagesDao")
@SessionScope
public class RoomPagesDao extends RepoDao<Input, RoomPages, Output, InputDto, OutputDto, 
		RoomPagesRepo, InputTrans, OutputTrans> {

	protected RoomPagesDao(RoomPagesRepo repo) {
		
		super(repo);
	}
	
	public void needUpdate() {
		
		repo.needUpdate();
	}

	
	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.InputTrans")
	@Override
	public void setInputTrans(InputTrans inputTrans) {
		
		this.inputTrans = inputTrans;
	}
	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.OutputTrans")
	@Override
	public void setOutputTrans(OutputTrans outputTrans) {
		
		this.outputTrans = outputTrans;
	}
}
