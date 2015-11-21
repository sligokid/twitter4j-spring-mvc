package ie.eirwig.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TickerController {

	@RequestMapping("/ticker")
	public String hello(Model model) {
		return "ticker";
	}

}