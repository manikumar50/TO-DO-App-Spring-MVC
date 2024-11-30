package com.example.ToDoApp_SpringMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ToDoApp_SpringMVC.model.Tasks;
import com.example.ToDoApp_SpringMVC.service.TaskServiceInterface;



@Controller
public class ToDoController 
{
	@Autowired
	private TaskServiceInterface service;
	
	@GetMapping("/")
	public String homePage() 
	{
		return "index";
	}
	
	@GetMapping()
	public String getHello()
	{
		return "HII ";
	}

	@GetMapping("/newTask")
	public String goToAddTask(Model model) 
	{
		return service.addTask(model);
	}
	
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("tasks") Tasks task)
	{
		return service.saveNewTask(task);
	}
	
	@GetMapping("/view")
	public String getViewPage(Model model) 
	{
		return service.showTask(model);
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) 
	{
		return service.editTask(id);
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute("mytask") Tasks task)
	{
		return service.updateTask(task);
	}
	
	
	@GetMapping("/delete/{id}")
	public ModelAndView confirmToDeletePage(@PathVariable("id") int id) 
	{
		return service.deletePage(id);
	}
	
	@PostMapping("/del/{id}")
	public String delete(@PathVariable int id) 
	{
		return service.deleteTask(id);
	}
	
}
