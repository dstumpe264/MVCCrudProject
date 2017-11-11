package com.skilldistillery.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.mvc.data.StumpicusDAO;
import com.skilldistillery.mvc.data.Warrior;

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
	
	@RequestMapping(path="general.do", method=RequestMethod.POST)
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
	
	@RequestMapping(path="buildArmy.do", method= RequestMethod.GET)
	public ModelAndView buildArmy() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("buildArmy");
		List<Warrior> army = dao.getAllWarriors();
		mv.addObject("army", army);
		return mv;
	}

}
