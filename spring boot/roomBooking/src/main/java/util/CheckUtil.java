package util;

import exception.check.NegativeNumberException;
import exception.check.NonIntegerNumberException;
import exception.check.NonNumberStringException;
import exception.check.NonPositiveNumberException;
import exception.check.NullException;
import exception.check.StringIsNotOneOfException;

public class CheckUtil {
	
	private static <I> void notNull(I input) {
		
		if(input == null)
			throw new NullException();
	}
	private static <I extends Number> void isIntegerNumber(I input) {
		
		if((input.doubleValue()-input.intValue()) != 0)
			throw new NonIntegerNumberException();
	}
	private static <I extends Number> void isPositiveNumber(I input) {
		
		if(input.doubleValue() <= 0)
			throw new NonPositiveNumberException();
	}
	private static <I extends Number> void isNonNegativeNumber(I input) {
		
		if(input.doubleValue() < 0)
			throw new NegativeNumberException();
	}
	
	private static void stringIsOneOf(String input, String... options) {
		
		for(int i=0; i<options.length; i++) {
			
			if(input.equals(options[i]))
				return;
		}
		throw new StringIsNotOneOfException();
	}
	private static void isNumberString(String input) {
		
		try {
			
			double number = Double.parseDouble(input);
			if(number==Double.NaN || number==Double.POSITIVE_INFINITY || number==Double.NEGATIVE_INFINITY)
				throw new NonNumberStringException();
		}catch(NumberFormatException ex) {
			
			throw new NonNumberStringException();
		}
	}
	
	
	
	public static <N extends Number> void checkNumber(N number) {
		
		notNull(number);
	}
	public static <N extends Number> void checkNumberIsInteger(N number) {
		
		notNull(number);
		isIntegerNumber(number);
	}
	public static <N extends Number> void checkNumberIsPositive(N number) {
		
		notNull(number);
		isPositiveNumber(number);
	}
	public static <N extends Number> void checkNumberIsNonNegative(N number) {
		
		notNull(number);
		isNonNegativeNumber(number);
	}
	public static <N extends Number> void checkNumberIsPositiveInteger(N number) {
		
		notNull(number);
		isIntegerNumber(number);
		isPositiveNumber(number);
	}
	public static <N extends Number> void checkNumberIsNonNegativeInteger(N number) {
		
		notNull(number);
		isIntegerNumber(number);
		isNonNegativeNumber(number);
	}
	
	public static void checkString(String str) {
		
		notNull(str);
	}
	public static void checkStringWithOptions(String str, String... options) {
		
		notNull(str);
		stringIsOneOf(str, options);
	}
	public static void checkStringIsNumberString(String str) {
		
		notNull(str);
		isNumberString(str);
	}
	public static void checkStringIsIntegerNumberString(String str) {
		
		notNull(str);
		isNumberString(str);

		double number = Double.parseDouble(str);
		isIntegerNumber(number);
	}
	public static void checkStringIsPositiveNumberString(String str) {
		
		notNull(str);
		isNumberString(str);

		double number = Double.parseDouble(str);
		isPositiveNumber(number);
	}
	public static void checkStringIsNonNegativeNumberString(String str) {
		
		notNull(str);
		isNumberString(str);

		double number = Double.parseDouble(str);
		isNonNegativeNumber(number);
	}
	public static void checkStringIsPositiveIntegerNumberString(String str) {
		
		notNull(str);
		isNumberString(str);

		double number = Double.parseDouble(str);
		isIntegerNumber(number);
		isPositiveNumber(number);
	}
	public static void checkStringIsNonNegativeIntegerNumberString(String str) {
		
		notNull(str);
		isNumberString(str);

		double number = Double.parseDouble(str);
		isIntegerNumber(number);
		isNonNegativeNumber(number);
	}
	
	public static void checkBoolean(Boolean b) {
		
		notNull(b);
	}
	
	public static <I> void checkOther(I input) {
		
		notNull(input);
	}
}
