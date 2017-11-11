package com.skilldistillery.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.mvc.data.StumpicusDAO;

@SessionAttributes("general")
@Controller
public class StumpicusController {
	@Autowired
	StumpicusDAO dao;
	
	@ModelAttribute("general")
	public String initSessionObject() {
		String general = "";
		return general;
	}
	
	@RequestMapping("home.do")
	public String home() {
		return "index";
	}
	
	@RequestMapping("general.do")
	public ModelAndView getGeneralsName(@RequestParam("userName") String name,
										@ModelAttribute("general") String generalsName) {
		ModelAndView mv = new ModelAndView("index");
		mv.setViewName("intro");
		generalsName = name;
		mv.addObject(generalsName);
		// Here I want to be able to take the user by his session
		//and use his name through out the website.
		//Also i would like to be able to set his army specifically to that user.
		return mv;
	}
	
	@RequestMapping(path="buildArmy.do")
	public ModelAndView buildArmy(ModelAndView mv) {
		
		return mv;
	}

}
