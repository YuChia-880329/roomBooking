package enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PayMethod {

	CASH(1, "現金"), CREDIT_CARD(2, "信用卡");
	
	private int id;
	private String name;
	
	
	private PayMethod(int id, String name) {
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public static PayMethod getById(int id) {
		
		PayMethod[] payMethods = PayMethod.values();
		for(PayMethod payMethod : payMethods) {
			
			if(payMethod.id == id)
				return payMethod;
		}
		return null;
	}
	public static String[] getCodeStrs() {
		
		List<String> list = Arrays.stream(PayMethod.values())
				.map(pm -> String.valueOf(pm.getId()))
				.collect(Collectors.toList());
		
		return list.toArray(new String[list.size()]);
	}
}
