package com.skilldistillery.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.skilldistillery.mvc.data.StumpicusDAO;

@SessionAttributes("general")
@Controller
public class StumpicusController {
	@Autowired
	StumpicusDAO dao;
	
	@RequestMapping(path="home.do")
	public String home() {
		return "index";
	}

}
