package ie.eirwig.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CsoPopulationController {

	@RequestMapping("/cso-population")
	public String csoPopulation(Model model) {
		return "cso-population";
	}

	@RequestMapping(value = "/cso", method = RequestMethod.GET)
	public String getResponse(final HttpServletRequest request) {
		return "cso-population";
	}

}