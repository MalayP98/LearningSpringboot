package com.springwebapp.learningspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springwebapp.learningspring.services.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService loginService;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String login(ModelMap model){
		model.put("name", "Malay Pandey");
    	return "welcome";
    }
}
