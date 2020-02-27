package pe.com.claro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Rutas {

	@GetMapping("/WebConsultarStockOnlineClaroAvatar")
	public String redirect() {
		return "redirect:/stockonline";
	}

	@GetMapping("/stockonline")
	public String stockonline() {
		return "stockonline";
	}

}
