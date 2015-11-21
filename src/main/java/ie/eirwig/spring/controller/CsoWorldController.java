package ie.eirwig.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CsoWorldController {

	@RequestMapping("/cso-world")
	public String csoWorld(Model model) {
		return "cso-world";
	}

}