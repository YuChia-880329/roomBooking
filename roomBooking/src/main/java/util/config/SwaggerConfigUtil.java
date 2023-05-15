package util.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfigUtil {

	public static final String SPLITOR = ";";
	
	public static Docket createDocket(String groupName, ApiInfo apiInfo, String basePackages) {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(groupName)
				.apiInfo(apiInfo)
				.select().apis(basePackage(basePackages)).paths(PathSelectors.any()).build();
	}
	private static Predicate<RequestHandler> basePackage(String basePackages){
		
		return handler -> declaringClass(handler).transform(handlerPackage(basePackages)).or(true);
	}
	private static Function<Class<?>, Boolean> handlerPackage(String basePackages){
		
		return cls -> {
			
			for(String basePackage : basePackages.split(SPLITOR)) {
				
				boolean isMatch = cls.getPackage().getName().startsWith(basePackage);
				if(isMatch)
					return true;
			}
			return false;
		};
	}
	@SuppressWarnings("deprecation")
	private static Optional<? extends Class<?>> declaringClass(RequestHandler handler){
		
		return Optional.fromNullable(handler.declaringClass());
	}
}
