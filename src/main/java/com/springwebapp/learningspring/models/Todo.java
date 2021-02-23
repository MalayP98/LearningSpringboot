package com.springwebapp.learningspring.models;

import org.springframework.stereotype.Component;

@Component
public class Todo {
	
	private int id;
	private String user;
	private String todo;
	private String desc;
	private String curr_time;
	private String curr_date;
	private boolean isComplete;
	
	public Todo() {}

	public Todo(int id, String user, String todo, String desc, String curr_time, String curr_date, boolean isComplete) {
		super();
		this.id = id;
		this.user = user;
		this.todo = todo;
		this.desc = desc;
		this.curr_time = curr_time;
		this.curr_date = curr_date;
		this.isComplete = isComplete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCurr_time() {
		return curr_time;
	}

	public void setCurr_time(String curr_time) {
		this.curr_time = curr_time;
	}

	public String getCurr_date() {
		return curr_date;
	}

	public void setCurr_date(String curr_date) {
		this.curr_date = curr_date;
	}

	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	@Override
	public String toString() {
		return "Todo [id = " + id + "user = " + user + ", todo=" + todo + ", desc=" + desc + ", curr_time=" + curr_time + ", curr_date=" + curr_date
				+ ", isComplete=" + isComplete + "]";
	}
}
