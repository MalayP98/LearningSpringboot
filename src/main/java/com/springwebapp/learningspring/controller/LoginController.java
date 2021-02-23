package com.springwebapp.learningspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springwebapp.learningspring.services.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService loginService;

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(){
    	return "login";
    }
    
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String welcome(ModelMap model, @RequestParam String name, @RequestParam String password){
    	
    	boolean validate = loginService.validateUser(name, password);
    	
    	if(!validate) {
    		model.put("errorMessage", "Invalid Credentials"); 
    		return "login";
    	}
    	
    	model.put("name", name);
    	model.put("password", password);
    	return "welcome";
    }
}
