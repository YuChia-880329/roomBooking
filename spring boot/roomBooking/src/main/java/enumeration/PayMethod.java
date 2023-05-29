package enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PayMethod {

	CASH(1, "現金"), CREDIT_CARD(2, "信用卡");
	
	private int code;
	private String name;
	
	
	private PayMethod(int code, String name) {
		this.code = code;
		this.name = name;
	}


	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
	public static PayMethod getByCode(int code) {
		
		PayMethod[] payMethods = PayMethod.values();
		for(PayMethod payMethod : payMethods) {
			
			if(payMethod.code == code)
				return payMethod;
		}
		return null;
	}
	public static String[] getCodeStrs() {
		
		List<String> list = Arrays.stream(PayMethod.values())
				.map(pm -> String.valueOf(pm.getCode()))
				.collect(Collectors.toList());
		
		return list.toArray(new String[list.size()]);
	}
}
