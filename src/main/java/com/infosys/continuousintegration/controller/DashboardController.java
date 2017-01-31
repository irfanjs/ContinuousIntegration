package com.infosys.continuousintegration.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends ExceptionHandlingController{

	@RequestMapping(value = "",method = RequestMethod.GET)
	public ModelAndView list(HttpSession session,ModelMap model) {
		ModelAndView mav = new ModelAndView("/dashboard");
		return mav;
	}	
	
	@RequestMapping(value = "/error",method = RequestMethod.GET)
	public ModelAndView  details(HttpSession session,ModelMap model) {
		ModelAndView errormav = new ModelAndView("redirect:/errorPage");
		return errormav;		
	}
}
