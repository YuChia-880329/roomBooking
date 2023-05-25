package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalUtil {

	public static String getLocalIp() throws UnknownHostException {
		
		String hostName = InetAddress.getLocalHost().getHostName();
		InetAddress[] addresses =  InetAddress.getAllByName(hostName);
		return addresses[0].getHostAddress();
	}
}
