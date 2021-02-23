package com.springwebapp.learningspring.controller;

import java.util.Date;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springwebapp.learningspring.models.Todo;
import com.springwebapp.learningspring.services.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/todo-list", method=RequestMethod.GET)
	public String showList(ModelMap model){
		model.put("todoList", todoService.showTodos("Malay Pandey"));
		return "todo-list";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String addTodoPage(ModelMap model) {
		model.addAttribute("bean", new Todo(0, (String)model.get("name"), "", "", (new Date()).toString(), (new Time()).toString(), false));
		return "add-todo";
	}

	@RequestMapping(value="/delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoService.delete(id);
		return "redirect:/todo-list";
	}
	
	// @RequestMapping(value="/add-todo", method=RequestMethod.POST)
	// public String addTodo(ModelMap model, @RequestParam String todo, @RequestParam String description) {
	// 	todoService.addTodo((String)model.get("name"), todo, description, (new Date()).toString(), (new Time()).toString());
	// 	return "redirect:/todo-list";
	// }

	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, Todo todo) {
		todoService.addTodo((String)model.get("name"), todo.getTodo(), todo.getDesc(), todo.getCurr_date(), todo.getCurr_time());
		return "redirect:/todo-list";
	}
	
}
