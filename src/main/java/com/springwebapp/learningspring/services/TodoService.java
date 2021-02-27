package com.springwebapp.learningspring.services;

import com.springwebapp.learningspring.models.Todo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	public static List<Todo> todoList = new ArrayList<Todo>();
	static int curr_todo = 0;
	
	public void addTodo(String user, String todo,  String desc, String date, String time) {
		Todo newTodo;
		newTodo = new Todo();
		newTodo.setId(++curr_todo);
		newTodo.setUser(user);
		newTodo.setTodo(todo);
		newTodo.setDesc(desc);
		newTodo.setCurr_date(date);
		newTodo.setCurr_time(time);
		newTodo.setIsComplete(false);
		todoList.add(newTodo);
	}
	
	public List<Todo> showTodos(String user) {
		List<Todo> userTodo = new ArrayList<>();
		if(!todoList.isEmpty()){
			for(Todo todo : todoList) {
				if(todo.getUser().equals(user)) userTodo.add(todo);
			}
		}
		return userTodo;
	}
	
	public void delete(int id) {
		Iterator<Todo> itr = todoList.iterator();
		while(itr.hasNext()){
			Todo todo = itr.next();
			if(todo.getId() == id){
				itr.remove();
				return;
			}
		}
	}

	public Todo updateTodo(int id) {
		Iterator<Todo> itr = todoList.iterator();
		while(itr.hasNext()){
			Todo todo = itr.next();
			if(todo.getId() == id) return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		int index = -1;
		for(Todo obj : todoList){
			index++;
			if(obj.getId() == todo.getId()){
				todoList.set(index, todo);
				return;
			}
		}
	}
}
