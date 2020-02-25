package pe.com.claro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ServiceRESTConsultarStockOnlineClaroAvatar extends SpringBootServletInitializer {

	private static Class<ServiceRESTConsultarStockOnlineClaroAvatar> applicationClass = ServiceRESTConsultarStockOnlineClaroAvatar.class;

	public static void main(String[] args) {
		SpringApplication.run(ServiceRESTConsultarStockOnlineClaroAvatar.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

}
