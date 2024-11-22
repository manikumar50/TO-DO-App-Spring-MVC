package com.example.ToDoApp_SpringMVC.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.ToDoApp_SpringMVC.model.Tasks;

public interface TaskServiceInterface 
{
	public String addTask(Model model);
	public String saveNewTask(Tasks task);
	public String showTask(Model model);
	public ModelAndView editTask(int id);
	public String updateTask(Tasks task);
	public ModelAndView deletePage(int id);
	public String deleteTask(int id);
}
