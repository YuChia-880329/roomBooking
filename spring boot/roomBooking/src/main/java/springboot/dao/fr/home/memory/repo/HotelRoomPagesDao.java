package springboot.dao.fr.home.memory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.InputDto;
import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.OutputDto;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomPages;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.Input;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.Output;
import springboot.memory.repo.RepoDao;
import springboot.memory.repo.fr.home.HotelRoomPagesRepo;
import springboot.trans.fr.home.obj.repo.hotelRoomPages.InputTrans;
import springboot.trans.fr.home.obj.repo.hotelRoomPages.OutputTrans;

@Repository("fr.home.memory.repo.HotelRoomPagesDao")
@SessionScope
public class HotelRoomPagesDao extends RepoDao<Input, HotelRoomPages, Output, InputDto, OutputDto, 
		HotelRoomPagesRepo, InputTrans, OutputTrans> {

	protected HotelRoomPagesDao(HotelRoomPagesRepo repo) {
		
		super(repo);
	}
	
	public void needUpdate() {
		
		repo.needUpdate();
	}

	
	@Autowired
	@Qualifier("fr.home.obj.repo.homeRooms.InputTrans")
	@Override
	public void setInputTrans(InputTrans inputTrans) {
		
		this.inputTrans = inputTrans;
	}
	@Autowired
	@Qualifier("fr.home.obj.repo.homeRooms.OutputTrans")
	@Override
	public void setOutputTrans(OutputTrans outputTrans) {
		
		this.outputTrans = outputTrans;
	}
}
