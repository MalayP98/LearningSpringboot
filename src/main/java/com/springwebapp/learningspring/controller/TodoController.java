package com.springwebapp.learningspring.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
		List<Todo> todoList = todoService.showTodos((String)model.get("name"));
		model.addAttribute("todoList", todoList);
		return "todo-list";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String addTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, (String)model.get("name"), "", "", (new Date()).toString(), (new Time()).toString(), false));
		return "add-todo";
	}

	@RequestMapping(value="/delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoService.delete(id);
		return "redirect:/todo-list";
	}

	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) return "redirect:/add-todo";
		todoService.addTodo((String)model.get("name"), todo.getTodo(), todo.getDesc(), todo.getCurr_date(), todo.getCurr_time());
		return "redirect:/todo-list";
	}

	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String update(ModelMap model, int id){
		Todo todo = todoService.updateTodo(id);
		System.out.println("Todo being sent to the form is = " + todo);
		model.addAttribute("todo", todo);
		return "add-todo";
	}

	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
		if(result.hasErrors()) return "redirect:/add-todo";
		todo.setUser((String) model.get("name"));
		todoService.updateTodo(todo);
		return "redirect:/todo-list";
	}
	
}
