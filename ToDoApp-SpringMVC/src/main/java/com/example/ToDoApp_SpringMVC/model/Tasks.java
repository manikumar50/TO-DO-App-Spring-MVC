package com.example.ToDoApp_SpringMVC.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="todo_tasks")
public class Tasks 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length = 30,nullable = false)
	private String task;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getTask() 
	{
		return task;
	}
	
	public void setTask(String task) 
	{
		this.task = task;
	}
	
	public Tasks(int id, String task) 
	{
		super();
		this.id = id;
		this.task = task;
	}
	
	public Tasks() 
	{
		
	}
	
	
}
