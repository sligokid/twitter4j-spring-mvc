package ie.eirwig.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorldKeywordController {

	@RequestMapping("/world-keyword")
	public String worldKeyword(Model model) {
		return "world-keyword";
	}

}