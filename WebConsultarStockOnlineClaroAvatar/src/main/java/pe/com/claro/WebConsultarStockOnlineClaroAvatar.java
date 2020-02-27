package pe.com.claro;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebConsultarStockOnlineClaroAvatar extends SpringBootServletInitializer {

	private static Class<WebConsultarStockOnlineClaroAvatar> applicationClass = WebConsultarStockOnlineClaroAvatar.class;

	public static void main(String[] args) {
		SpringApplication.run(WebConsultarStockOnlineClaroAvatar.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}
	
}
