package util;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	
	private static final String JAVA_DATE_FORMAT = "yyyy/MM/dd";
	private static final String JAVA_TIME_FORMAT = "HH:mm";
	private static final String JAVA_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm";
	private static final String JAVA_DATE_FORMAT_FRONT = "yyyy-MM-dd";
	private static final String JAVA_DATE_TIME_FORMAT_FRONT = "yyyy-MM-dd'T'HH:mm";
	
	private static final DateTimeFormatter JAVA_DATE_FORMATTER = DateTimeFormatter.ofPattern(JAVA_DATE_FORMAT);
	private static final DateTimeFormatter JAVA_TIME_FORMATTER = DateTimeFormatter.ofPattern(JAVA_TIME_FORMAT);
	private static final DateTimeFormatter JAVA_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(JAVA_DATE_TIME_FORMAT);
	private static final DateTimeFormatter JAVA_DATE_FORMATTER_FRONT = DateTimeFormatter.ofPattern(JAVA_DATE_FORMAT_FRONT);
	private static final DateTimeFormatter JAVA_DATE_TIME_FORMATTER_FRONT = DateTimeFormatter.ofPattern(JAVA_DATE_TIME_FORMAT_FRONT);
	
	
	// java to sql
	public static Date toDate(LocalDate localDate) {
		
		return Date.valueOf(localDate);
	}
	public static Time toTime(LocalTime localTime) {
		
		return Time.valueOf(localTime);
	}
	public static Timestamp toTimestamp(LocalDateTime localDateTime) {
		
		return Timestamp.valueOf(localDateTime);
	}
	
	
	
	// sql to java
	public static LocalDate toLocalDate(Date date) {
		
		return date.toLocalDate();
	}
	public static LocalTime toLocalTime(Time time) {
		
		return time.toLocalTime();
	}
	public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
		
		return timestamp.toLocalDateTime();
	}
	

	// java to string
	public static String toString(LocalDate localDate) {
		
		return localDate.format(JAVA_DATE_FORMATTER);
	}
	public static String toStringFront(LocalDate localDate) {
		
		return localDate.format(JAVA_DATE_FORMATTER_FRONT);
	}
	public static String toString(LocalTime localTime) {
		
		return localTime.format(JAVA_TIME_FORMATTER);
	}
	public static String toString(LocalDateTime localDateTime) {
		
		return localDateTime.format(JAVA_DATE_TIME_FORMATTER);
	}
	public static String toStringFront(LocalDateTime localDateTime) {
		
		return localDateTime.format(JAVA_DATE_TIME_FORMATTER_FRONT);
	}
	
	
	// string to java
	public static LocalDate toLocalDate(String str) {
		
		return LocalDate.parse(str, JAVA_DATE_FORMATTER);
	}
	public static LocalDate toLocalDateFront(String str) {
		
		return LocalDate.parse(str, JAVA_DATE_FORMATTER_FRONT);
	}
	public static LocalTime toLocalTime(String str) {
		
		return LocalTime.parse(str, JAVA_TIME_FORMATTER);
	}
	public static LocalDateTime toLocalDateTime(String str) {
		
		return LocalDateTime.parse(str, JAVA_DATE_TIME_FORMATTER);
	}
	public static LocalDateTime toLocalDateTimeFront(String str) {
		
		return LocalDateTime.parse(str, JAVA_DATE_TIME_FORMATTER_FRONT);
	}
}
