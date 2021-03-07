package com.springwebapp.learningspring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	SimpleDateFormat sdf = new SimpleDateFormat("E, MMMM yyyy");
	
	@RequestMapping(value="/todo-list", method=RequestMethod.GET)
	public String showList(ModelMap model){
		List<Todo> todoList = todoService.showTodos(getUsername());
		model.addAttribute("todoList", todoList);
		return "todo-list";
	}

	private String getUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails){
			return ((UserDetails)principal).getUsername();
		}
		return principal.toString();
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String addTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getUsername(), "", "", "" , "", false));
		return "add-todo";
	}

	@RequestMapping(value="/delete-todo")
	public String deleteTodo(@RequestParam int id){
		if(id == 1) throw new RuntimeException();
		todoService.delete(id);
		return "redirect:/todo-list";
	}

	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) return "redirect:/add-todo";
		todoService.addTodo(getUsername(), todo.getTodo(), todo.getDesc(), sdf.format(new Date()), (new Time()).toString());
		return "redirect:/todo-list";
	}

	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String update(ModelMap model, int id){
		Todo todo = todoService.updateTodo(id);
		model.addAttribute("todo", todo);
		return "add-todo";
	}

	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
		if(result.hasErrors()) return "redirect:/add-todo";
		Date date = new Date();
		todo.setUser(getUsername());
		todo.setCurr_date(sdf.format(date));
		System.out.println(sdf.format(date));
		todo.setCurr_time((new Time()).toString());
		todoService.updateTodo(todo);
		return "redirect:/todo-list";
	}
	
}
