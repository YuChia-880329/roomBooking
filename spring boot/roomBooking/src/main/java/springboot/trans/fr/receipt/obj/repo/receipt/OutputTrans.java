package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.OutputDto;
import springboot.bean.obj.fr.receipt.repo.receipt.Output;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.receipt.obj.repo.receipt.OutputTrans")
public class OutputTrans extends RepoOutputTrans<Output, OutputDto> {

	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.ItemPageTrans")
	private ItemPageTrans itemPageTrans;
	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.PayMethodOutputTrans")
	private PayMethodOutputTrans payMethodOutputTrans;
	
	
	@Override
	protected Output dtoToOutputImpl(OutputDto dto) {
		
		return Output.builder()
				.maxPage(dto.getMaxPage())
				.itemPage(itemPageTrans.dtoToObj(dto.getItemPage()))
				.totalPrice(dto.getTotalPrice())
				.payMethod(payMethodOutputTrans.dtoToObj(dto.getPayMethod()))
				.build();
	}
	@Override
	protected OutputDto outputToDtoImpl(Output output) {
		
		return OutputDto.builder()
				.maxPage(output.getMaxPage())
				.itemPage(itemPageTrans.objToDto(output.getItemPage()))
				.totalPrice(output.getTotalPrice())
				.payMethod(payMethodOutputTrans.objToDto(output.getPayMethod()))
				.build();
	}
}
