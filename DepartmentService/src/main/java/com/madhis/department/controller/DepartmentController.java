package com.madhis.department.controller;

import com.madhis.department.entity.Department;
import com.madhis.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired	
	private DepartmentService departmentService;
	
		
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department){
		log.info("inside saveDepartment of DepartmentController");
		System.out.println("department = " + department);
		return departmentService.saveDepartment(department);
	}


	
	@GetMapping("{id}")
	public Department finDepartmentById(@PathVariable("id")Long departmentId){
		log.info("inside findDepartmentById of DepartmentController");
		return departmentService.findDepartmentById(departmentId);
	}


}
