package springboot;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import util.LocalUtil;

@SpringBootApplication
public class Application {
	
	public static final String SERVER_IP = getServerIp();

	// http://localhost:8086/roomBooking/swagger-ui/index.html
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
	
	public static String getServerIp() {
		
		 try {
			 
			 return LocalUtil.getLocalIp();
		} catch (UnknownHostException ex) {
			
			throw new RuntimeException(ex);
		}
	}
}
