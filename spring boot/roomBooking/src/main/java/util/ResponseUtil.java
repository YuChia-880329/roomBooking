package util;

import springboot.Application;
import springboot.bean.vo.Data;
import springboot.bean.vo.Response;
import springboot.bean.vo.ServerInfo;

public class ResponseUtil {

	
	public static Response response200(Data data) {
		
		ServerInfo serverInfo = ServerInfo.builder()
				.serverIp(Application.SERVER_IP)
				.statusCode(200)
				.msg("ok")
				.build();
		
		return response(serverInfo, data);
	}
	
	public static Response response400(Data data, String msg) {
		
		ServerInfo serverInfo = ServerInfo.builder()
				.serverIp(Application.SERVER_IP)
				.statusCode(400)
				.msg(msg)
				.build();
		
		return response(serverInfo, data);
	}
	
	public static Response response500(Data data, Throwable throwable) {
		
		ServerInfo serverInfo = ServerInfo.builder()
				.serverIp(Application.SERVER_IP)
				.statusCode(500)
				.msg(throwable.getMessage())
				.build();
		
		return response(serverInfo, data);
	}
	
	public static Response response500(Data data, String msg) {
		
		ServerInfo serverInfo = ServerInfo.builder()
				.serverIp(Application.SERVER_IP)
				.statusCode(500)
				.msg(msg)
				.build();
		
		return response(serverInfo, data);
	}
	
	
	private static Response response(ServerInfo serverInfo, Data data) {
		
		return Response.builder()
				.serverInfo(serverInfo)
				.data(data)
				.build();
	}
}
