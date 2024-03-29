package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	public static final String URL_PREFIX = "http://localhost:8086/roomBooking";
	public static final String IMAGE_DIRECTORY = "images";
	public static final String HOTEL_IMG_PREFIX = "HOTEL_IMG_";
	public static final String ROOM_IMG_PREFIX = "ROOM_IMG_";
	
	public static String getImgUrl(int hotelId, String imageName) {
		
		return StringConcatUtil.concate(URL_PREFIX, "/", 
				IMAGE_DIRECTORY, "/", String.valueOf(hotelId), "/", HOTEL_IMG_PREFIX, imageName);
	}
	public static String getImgUrl(int hotelId, int roomId, String imageName) {
		
		return StringConcatUtil.concate(URL_PREFIX, "/", IMAGE_DIRECTORY, 
				"/", String.valueOf(hotelId), "/", String.valueOf(roomId), "/", ROOM_IMG_PREFIX, imageName);
	}
	
	public static boolean saveImg(String imgDirPath, int hotelId, String imgName, MultipartFile file) throws IOException {
		
		createDirectory(imgDirPath, hotelId);
		
		Path path = getDirectoryPath(imgDirPath, hotelId).resolve(StringConcatUtil.concate(HOTEL_IMG_PREFIX, imgName));
		
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		return true;
	}
	public static boolean saveImg(String imgDirPath, int hotelId, int roomId, String imgName, MultipartFile file) throws IOException {
		
		createDirectory(imgDirPath, hotelId, roomId);
		
		Path path = getDirectoryPath(imgDirPath, hotelId, roomId).resolve(StringConcatUtil.concate(ROOM_IMG_PREFIX, imgName));
		
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		return true;
	}
	
	
	
	private static void createDirectory(String imgDirPath, int hotelId) throws IOException {
		
		Path path = getDirectoryPath(imgDirPath, hotelId);
		
		if(Files.notExists(path))
			Files.createDirectory(path);
	}
	private static void createDirectory(String imgDirPath, int hotelId, int roomId) throws IOException {
		
		Path pathRoot = getDirectoryPath(imgDirPath, hotelId);
		if(Files.notExists(pathRoot))
			Files.createDirectory(pathRoot);
		
		Path path = getDirectoryPath(imgDirPath, hotelId, roomId);
		if(Files.notExists(path))
			Files.createDirectory(path);
	}
	private static Path getDirectoryPath(String imgDirPath, int hotelId) {
		
		return Paths.get(imgDirPath, String.valueOf(hotelId));
	}
	private static Path getDirectoryPath(String imgDirPath, int hotelId, int roomId) {
		
		return Paths.get(imgDirPath, String.valueOf(hotelId), String.valueOf(roomId));
	}
}
