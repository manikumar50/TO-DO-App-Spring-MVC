package com.example.ToDoApp_SpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.ToDoApp_SpringMVC.model.Tasks;
import com.example.ToDoApp_SpringMVC.repository.DoToRepository;

@Service
public class DoToService implements TaskServiceInterface
{
	@Autowired
	private DoToRepository repository;

	public String addTask(Model model) 
	{
		Tasks tasks=new Tasks();
		model.addAttribute("tasks",tasks);
		return "/new-task";
	}

	public String saveNewTask(Tasks task) 
	{
		repository.save(task);
		return "redirect:/";
	}

	public String showTask(Model model) 
	{
		List<Tasks> allTasks=repository.findAll();
		
		model.addAttribute("allTasks",allTasks);
		
		return "/view-table";
	}

	public ModelAndView editTask(int id) 
	{
		ModelAndView mav=new ModelAndView("update-page");
		
		Tasks task=repository.findById(id).orElse(null);
		mav.addObject("mytask",task);
		
		return mav;
	}

	public String updateTask(Tasks task) 
	{
		repository.save(task);
		return "redirect:/";
	}

	public ModelAndView deletePage(int id) 
	{
		Tasks currenttask=repository.findById(id).orElse(null);
		ModelAndView mav=new ModelAndView("confirm-page");
		mav.addObject("tasks",currenttask);
		return mav;
	}

	public String deleteTask(int id)
	{
		repository.deleteById(id);
		return "redirect:/";
	}
	
}
