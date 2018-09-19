package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping ("/viral")
	public String index() {
		return "viral";
	}
	
	/**@RequestMapping ("/challenge")
	public String challenge(@RequestParam(value = "name") String name,  Model model) {
		model.addAttribute("name", name);
		return "challenge";
		
	}
	**/
	
	@RequestMapping (value = {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping ("/generator")
	public String Generator (
			@RequestParam(value = "a", required = false, defaultValue = "0") String a, @RequestParam(value = "b", required = false, defaultValue = "0") String b, 
			Model model) {
		String result = "";
		if (a.equalsIgnoreCase("0") || a.equalsIgnoreCase("1")) {
			result += "hm";
		}else if (b.equalsIgnoreCase("0") || b.equalsIgnoreCase("1")){
			result += "hm";
		}else {
			result += "h";
			for (int i = 0; i < Integer.parseInt(a); i++) {
				result += "m";
			}
		}
		
		if (Integer.parseInt(b) > 1) {
			String newResult = "";
			for (int i = 0; i < Integer.parseInt(b); i++) {
				newResult += result;
				newResult += " ";
			}
			result = newResult;
		}
		
		model.addAttribute("result", result);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		return "generator";
	}
}
