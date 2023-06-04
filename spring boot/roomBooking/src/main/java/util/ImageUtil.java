package util;

public class ImageUtil {

	public static final String URL_PREFIX = "http://localhost:8086/roomBooking";
	public static final String IMAGE_DIRECTORY = "images";
	
	public static String getUrl(int hotelId, String imageName) {
		
		return StringConcatUtil.concate(URL_PREFIX, "/", 
				IMAGE_DIRECTORY, "/", String.valueOf(hotelId), "/", imageName);
	}
}
