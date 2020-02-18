package pe.com.claro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceRESTPinPortabilidadClaroAvatar extends SpringBootServletInitializer {

	private static Class<ServiceRESTPinPortabilidadClaroAvatar> applicationClass = ServiceRESTPinPortabilidadClaroAvatar.class;

	public static void main(String[] args) {
		SpringApplication.run(ServiceRESTPinPortabilidadClaroAvatar.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	@GetMapping(value = "/")
	public String init() {
		return "Services REST SISACT Avatar: ServiceRESTPinPortabilidadClaroAvatar";
	}

}
