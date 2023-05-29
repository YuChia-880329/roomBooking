package util;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	
	private static final String JAVA_DATE_FORMAT = "yyyy/MM/dd";
	private static final String JAVA_TIME_FORMAT = "HH:mm";
	private static final String JAVA_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm";
	
	private static final DateTimeFormatter JAVA_DATE_FORMATTER = DateTimeFormatter.ofPattern(JAVA_DATE_FORMAT);
	private static final DateTimeFormatter JAVA_TIME_FORMATTER = DateTimeFormatter.ofPattern(JAVA_TIME_FORMAT);
	private static final DateTimeFormatter JAVA_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(JAVA_DATE_TIME_FORMAT);
	
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
	
	public static String toString(LocalDate localDate) {
		
		return localDate.format(JAVA_DATE_FORMATTER);
	}
	public static String toStringDate(LocalDateTime localDateTime) {
		
		return localDateTime.format(JAVA_DATE_FORMATTER);
	}
	public static String toStringTime(LocalDateTime localDateTime) {
		
		return localDateTime.format(JAVA_TIME_FORMATTER);
	}
	
	public static LocalDateTime toLocalDateTime(String str) {
		
		return LocalDateTime.parse(str, JAVA_DATE_TIME_FORMATTER);
	}
	public static LocalDate toLocalDate(String str) {
		
		return LocalDate.parse(str, JAVA_DATE_FORMATTER);
	}
}
