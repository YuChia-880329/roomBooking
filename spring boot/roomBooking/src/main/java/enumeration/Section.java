package enumeration;

public enum Section {
	
	KLU(0, "基隆市"), TPH(1, "新北市"), TPE(2, "臺北市"), TYC(3, "桃園市"), HSH(4, "新竹縣"), 
	HSC(5, "新竹市"), MAC(6, "苗栗市"), MAL(7, "苗栗縣"), TXG(8, "臺中市"), CWH(9, "彰化縣"), 
	CWS(10, "彰化市"), NTC(11, "南投市"), NTO(12, "南投縣"), YLH(13, "雲林縣"), CHY(14, "嘉義縣"), 
	CYI(15, "嘉義市"), TNN(16, "臺南市"), KHH(17, "高雄市"), IUH(18, "屏東縣"), PTS(19, "屏東市"), 
	ILN(20, "宜蘭縣"), ILC(21, "宜蘭市"), HWA(22, "花蓮縣"), HWC(23, "花蓮市"), TTC(24, "臺東市"), 
	TTT(25, "臺東縣"), PEH(26, "澎湖縣"), GNI(27, "綠島"), KYD(28, "蘭嶼"), KMN(29, "金門縣"), 
	MZW(30, "馬祖"), LNN(31, "連江縣");
	
	private int code;
	private String desc;
	
	private Section(int code, String desc) {
		
		this.code = code;
		this.desc = desc;
	}

	public static Section getByCode(int code) {
		
		if(code < 0)
			return null;
		
		Section[] sections = Section.values();
		if(code >= sections.length)
			return null;
		
		return sections[code];
	}
	
	public int getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
}
