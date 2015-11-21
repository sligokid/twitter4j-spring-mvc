package ie.eirwig.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IrelandController {

	@RequestMapping("/ireland")
	public String hello(Model model) {
		return "ireland";
	}

	@RequestMapping("/ireland-roulette")
	public String irelandroulette(Model irelandroulette) {
		return "ireland-roulette";
	}

	@RequestMapping("/developers")
	public String developers(Model developers) {
		return "developers";
	}

	@RequestMapping("/sitemap")
	public String sitemap(Model sitemap) {
		return "sitemap";
	}

	@RequestMapping("/android")
	public String android(Model android) {
		return "android";
	}

}