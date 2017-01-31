package com.infosys.continuousintegration.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}
	
	@RequestMapping(value = "/staticPage",method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {
		if(null == session.getAttribute("sessionid")){
			ModelAndView mav = new ModelAndView("redirect:/bookmark/list");
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/pages/index.html");
		
		return mav;
	}
	
	@RequestMapping(value = "/errorPage",method = RequestMethod.GET)
	public String error(ModelMap model) {

		return "redirect:/pages/error.html";
	}
	
	
	@RequestMapping(value = "/donothing", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void donothing() {
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView homepage(ModelMap model) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
}