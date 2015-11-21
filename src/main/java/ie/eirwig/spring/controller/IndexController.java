package ie.eirwig.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		return "world";
	}

	@RequestMapping("/index-middle-pane")
	public String indexmiddlepane(Model indexmiddlepane) {
		return "/index-middle-pane";
	}

	@RequestMapping("/developers-middle-pane")
	public String developersmiddlepane(Model developersmiddlepane) {
		return "/developers-middle-pane";
	}

}