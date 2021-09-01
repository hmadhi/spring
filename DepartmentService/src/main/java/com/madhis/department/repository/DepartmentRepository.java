package com.madhis.department.repository;

import com.madhis.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

	public Department getByDepartmentId(Long departmentId);

	
}
