package enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RoomStatus {

	ON(1, "公開"), OFF(0, "不公開");
	
	private int code;
	private String description;
	
	private RoomStatus(int code, String description) {
		
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	public static RoomStatus getByCode(int code) {
		
		if(code == 1)
			return ON;
		else if(code == 0)
			return OFF;
		else
			return null;
	}
	
	public static String[] getCodeStrsArray() {
		
		List<String> strList = Arrays.stream(RoomStatus.values())
				.map(rto -> String.valueOf(rto.getCode()))
				.collect(Collectors.toList());
		
		return strList.toArray(new String[strList.size()]);
	}
}
