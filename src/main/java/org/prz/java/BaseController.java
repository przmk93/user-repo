package main.java.org.prz.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
	Integer counter = null;

	private Integer userCounter(){
		if (counter != null)
			return ++counter;
		else
			return counter = 1;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("userCounter", userCounter());
		model.addAttribute("message", "Welcome");
		return "index";
	}
	
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String welcomeName(ModelMap model, @PathVariable String name) {
		model.addAttribute("message", name);
		model.addAttribute("userCounter", userCounter());
		return "index";
	}
}
