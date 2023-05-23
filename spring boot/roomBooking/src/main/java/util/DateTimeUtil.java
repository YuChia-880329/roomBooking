package util;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeUtil {

	public static Timestamp toTimestamp(LocalDateTime localDateTime) {
		
		return Timestamp.valueOf(localDateTime);
	}
	public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
		
		return timestamp.toLocalDateTime();
	}
	
	public static Date toDate(LocalDate localDate) {
		
		return Date.valueOf(localDate);
	}
	public static LocalDate toLocalDate(Date date) {
		
		return date.toLocalDate();
	}
}
