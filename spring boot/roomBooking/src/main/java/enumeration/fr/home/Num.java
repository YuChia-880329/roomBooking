package enumeration.fr.home;

public enum Num {

	P1(1, 1), P2(2, 2), P3(3, 3), P4(4, 4), 
	P5(5, 5), P6(6, 6), P7(7, 7), P8(8, 8);
	
	private int code;
	private int number;
	
	private Num(int code, int number) {
		
		this.code = code;
		this.number = number;
	}
	
	
	public int getCode() {
		return code;
	}
	public int getNumber() {
		return number;
	}


	public static Num getByCode(int code) {
		
		for(Num num : Num.values()) {
			
			if(num.getCode() == code)
				return num;
		}
		return null;
	}
}
