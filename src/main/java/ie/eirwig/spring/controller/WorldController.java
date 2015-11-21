package ie.eirwig.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorldController {

	@RequestMapping("/world")
	public String world(Model model) {
		return "world";
	}

	@RequestMapping("/world-roulette")
	public String worldRoulette(Model modelroulette) {
		return "world-roulette";
	}

}