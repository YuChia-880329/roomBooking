package util;

import tmpl.exception.CheckerException;

public class CheckUtil {


	private static final String NOT_NULL_ERROR_MSG = "no %s";

	private static final String IS_INTEGER_NUMBER_ERROR_MSG = "%s is not an integer, %s : %s";
	private static final String IS_POSITIVE_NUMBER_ERROR_MSG = "%s is not positive, %s : %s";
	private static final String IS_NON_NEGATIVE_NUMBER_ERROR_MSG = "%s is negative, %s : %s";

	private static final String STRING_IS_ONE_OF_ERROR_MSG = "%s is not one of the options, %s : %s";
	private static final String IS_NUMBER_STRING_ERROR_MSG_STRING = "%s is not a number string, %s : %s";
		
	
	
	private static <I> boolean notNull(I input) {
		
		return (input != null);
	}

	private static <I extends Number> boolean isIntegerNumber(I input) {
		
		return ((input.doubleValue()-input.intValue()) == 0);
	}
	private static <I extends Number> boolean isPositiveNumber(I input) {
		
		return (input.doubleValue() > 0);
	}
	private static <I extends Number> boolean isNonNegativeNumber(I input) {
		
		return (input.doubleValue() >= 0);
	}
	
	private static boolean stringIsOneOf(String input, String... options) {
		
		for(int i=0; i<options.length; i++) {
			
			if(input.equals(options[i]))
				return true;
		}
		return false;
	}
	private static boolean isNumberString(String input) {
		
		try {
			
			double number = Double.parseDouble(input);
			return (number!=Double.NaN && number!=Double.POSITIVE_INFINITY && number!=Double.NEGATIVE_INFINITY);
		}catch(NumberFormatException ex) {
			
			return false;
		}
	}
	
	


	private static <I> void notNull(I input, String inputName) throws CheckerException {
		
		if(!notNull(input))
			throw new CheckerException(String.format(NOT_NULL_ERROR_MSG, inputName));
	}

	private static <I extends Number> void isIntegerNumber(I input, String inputName) throws CheckerException {
		
		if(!isIntegerNumber(input))
			throw new CheckerException(String.format(IS_INTEGER_NUMBER_ERROR_MSG, inputName, inputName, input));
	}
	private static <I extends Number> void isPositiveNumber(I input, String inputName) throws CheckerException {
		
		if(!isPositiveNumber(input))
			throw new CheckerException(String.format(IS_POSITIVE_NUMBER_ERROR_MSG, inputName, inputName, input));
	}
	private static <I extends Number> void isNonNegativeNumber(I input, String inputName) throws CheckerException {
		
		if(!isNonNegativeNumber(input))
			throw new CheckerException(String.format(IS_NON_NEGATIVE_NUMBER_ERROR_MSG, inputName, inputName, input));
	}

	private static void stringIsOneOf(String input, String inputName, String... options) throws CheckerException {
		
		if(!stringIsOneOf(input, options))
			throw new CheckerException(String.format(STRING_IS_ONE_OF_ERROR_MSG, inputName, inputName, input));
	}
	private static void isNumberString(String input, String inputName) throws CheckerException {
		
		if(!isNumberString(input))
			throw new CheckerException(String.format(IS_NUMBER_STRING_ERROR_MSG_STRING, inputName, inputName, input));
	}
	
	
	
	
	public static <N extends Number> boolean checkNumber(N number) {
		
		return notNull(number);
	}
	public static <N extends Number> boolean checkNumberIsInteger(N number) {
		
		return notNull(number)
				&& isIntegerNumber(number);
	}
	public static <N extends Number> boolean checkNumberIsPositive(N number) {
		
		return notNull(number)
				&& isPositiveNumber(number);
	}
	public static <N extends Number> boolean checkNumberIsNonNegative(N number) {
		
		return notNull(number)
				&& isNonNegativeNumber(number);
	}
	public static <N extends Number> boolean checkNumberIsPositiveInteger(N number) {
		
		return notNull(number)
				&& isIntegerNumber(number)
				&& isPositiveNumber(number);
	}
	public static <N extends Number> boolean checkNumberIsNonNegativeInteger(N number) {
		
		return notNull(number)
				&& isIntegerNumber(number)
				&& isNonNegativeNumber(number);
	}
	
	public static boolean checkString(String str) {
		
		return notNull(str);
	}
	public static boolean checkStringWithOptions(String str, String... options) {
		
		return notNull(str)
				&& stringIsOneOf(str, options);
	}
	public static boolean checkStringIsNumberString(String str) {
		
		return notNull(str)
				&& isNumberString(str);
	}
	public static boolean checkStringIsIntegerNumberString(String str) {
		
		if(notNull(str) && isNumberString(str))
			return false;
		double number = Double.parseDouble(str);
		return isIntegerNumber(number);
	}
	public static boolean checkStringIsPositiveNumberString(String str) {
		
		if(notNull(str) && isNumberString(str))
			return false;
		double number = Double.parseDouble(str);
		return isPositiveNumber(number);
	}
	public static boolean checkStringIsNonNegativeNumberString(String str) {
		
		if(notNull(str) && isNumberString(str))
			return false;
		double number = Double.parseDouble(str);
		return isNonNegativeNumber(number);
	}
	public static boolean checkStringIsPositiveIntegerNumberString(String str) {
		
		if(notNull(str) && isNumberString(str))
			return false;
		double number = Double.parseDouble(str);
		return isIntegerNumber(number)
				&& isPositiveNumber(number);
	}
	public static boolean checkStringIsNonNegativeIntegerNumberString(String str) {
		
		if(notNull(str) && isNumberString(str))
			return false;
		double number = Double.parseDouble(str);
		return isIntegerNumber(number)
				&& isNonNegativeNumber(number);
	}
	
	public static boolean checkBoolean(Boolean b) {
		
		return notNull(b);
	}
	
	public static <I> boolean checkOther(I input) {
		
		return notNull(input);
	}
	
	
	
	
	public static <N extends Number> void checkNumber(N number, String numberName) throws CheckerException {
		
		notNull(number, numberName);
	}
	public static <N extends Number> void checkNumberIsInteger(N number, String numberName) throws CheckerException {
		
		notNull(number, numberName);
		isIntegerNumber(number, numberName);
	}
	public static <N extends Number> void checkNumberIsPositive(N number, String numberName) throws CheckerException {
		
		notNull(number, numberName);
		isPositiveNumber(number, numberName);
	}
	public static <N extends Number> void checkNumberIsNonNegative(N number, String numberName) throws CheckerException {
		
		notNull(number, numberName);
		isNonNegativeNumber(number, numberName);
	}
	public static <N extends Number> void checkNumberIsPositiveInteger(N number, String numberName) throws CheckerException {
		
		notNull(number, numberName);
		isIntegerNumber(number, numberName);
		isPositiveNumber(number, numberName);
	}
	public static <N extends Number> void checkNumberIsNonNegativeInteger(N number, String numberName) throws CheckerException {
		
		notNull(number, numberName);
		isIntegerNumber(number, numberName);
		isNonNegativeNumber(number, numberName);
	}
	
	public static void checkString(String str, String stringName) throws CheckerException {
		
		notNull(str, stringName);
	}
	public static void checkStringWithOptions(String str, String stringName, String... options) throws CheckerException {
		
		notNull(str, stringName);
		stringIsOneOf(str, stringName, options);
	}
	public static void checkStringIsNumberString(String str, String stringName) throws CheckerException {
		
		notNull(str, stringName);
		isNumberString(str, stringName);
	}
	public static void checkStringIsIntegerNumberString(String str, String stringName) throws CheckerException {
		
		notNull(str, stringName);
		isNumberString(str, stringName);

		double number = Double.parseDouble(str);
		isIntegerNumber(number, stringName);
	}
	public static void checkStringIsPositiveNumberString(String str, String stringName) throws CheckerException {
		
		notNull(str, stringName);
		isNumberString(str, stringName);

		double number = Double.parseDouble(str);
		isPositiveNumber(number, stringName);
	}
	public static void checkStringIsNonNegativeNumberString(String str, String stringName) throws CheckerException {
		
		notNull(str, stringName);
		isNumberString(str, stringName);

		double number = Double.parseDouble(str);
		isNonNegativeNumber(number, stringName);
	}
	public static void checkStringIsPositiveIntegerNumberString(String str, String stringName) throws CheckerException {
		
		notNull(str, stringName);
		isNumberString(str, stringName);

		double number = Double.parseDouble(str);
		isIntegerNumber(number, stringName);
		isPositiveNumber(number, stringName);
	}
	public static void checkStringIsNonNegativeIntegerNumberString(String str, String stringName) throws CheckerException {
		
		notNull(str, stringName);
		isNumberString(str, stringName);

		double number = Double.parseDouble(str);
		isIntegerNumber(number, stringName);
		isNonNegativeNumber(number, stringName);
	}
	
	public static void checkBoolean(Boolean b, String bName) throws CheckerException {
		
		notNull(b, bName);
	}
	
	public static <I> void checkOther(I input, String bName) throws CheckerException {
		
		notNull(input, bName);
	}
}
