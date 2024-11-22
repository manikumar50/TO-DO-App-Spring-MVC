package com.example.ToDoApp_SpringMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDoApp_SpringMVC.model.Tasks;

@Repository
public interface DoToRepository extends JpaRepository<Tasks, Integer>
{
	
}
