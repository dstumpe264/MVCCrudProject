package com.skilldistillery.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
	
	@RequestMapping(path="add.do", method=RequestMethod.GET)
	public String addWarrior(Model m) {
		Warrior w = new Warrior();
		m.addAttribute("warrior", w);
		return "add";
	}
	
//	@RequestMapping(path="get.do", method=RequestMethod.POST)
//	public ModelAndView displayWarrior(@RequestParam("id") Integer id) {
//		ModelAndView mv = new ModelAndView();
//		Warrior w = null;
//		w = dao.getWarriorById(id);
//		mv.addObject("warrior", w);
//		mv.setViewName("displayWarrior");
//	
//		return mv;
//	}
	
	@RequestMapping(path="addWarrior.do", method=RequestMethod.POST)
	public ModelAndView doAdd(@Valid Warrior warrior, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("add");
			return mv;
		}
		dao.addWarrior(warrior);
		mv.setViewName("added");
		return mv;
	}
	
	@RequestMapping(path="update.do", params="id")
	public ModelAndView update(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		Warrior w = dao.getWarriorById(id);
		mv.addObject("warrior", w);
		mv.setViewName("update");
		return mv;
	}
	@RequestMapping(path="updateWarrior.do", method=RequestMethod.POST)
	public ModelAndView doUpdate(@Valid Warrior warrior, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("update");
			return mv;
		}
		Warrior w = dao.updateWarrior(warrior);
		mv.addObject("warrior", w);
		mv.setViewName("updated");
		return mv;
	}
	
	@RequestMapping(path="delete.do")
	public ModelAndView delete(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("deleted");
		Warrior w = dao.getWarriorById(id);
		mv.addObject("name", w.getName());
		dao.deleteWarrior(w);
		return mv;
	}
	

}
