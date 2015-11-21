package ie.eirwig.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TweeterController {

	@RequestMapping("/tweeter-single")
	public String tweeterSingle(Model model) {
		return "tweeter-single";
	}

	@RequestMapping("/tweeter-all")
	public String tweeterAll(Model model) {
		return "tweeter-all";
	}

}