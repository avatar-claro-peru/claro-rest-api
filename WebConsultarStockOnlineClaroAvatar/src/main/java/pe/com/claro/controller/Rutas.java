package pe.com.claro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Rutas {

	@GetMapping("/")
	public String redirect() {
		return "redirect:/trackingstock";
	}

	@GetMapping("/trackingstock")
	public String trackingstock() {
		return "trackingstock";
	}

}
